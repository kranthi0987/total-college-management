/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.lusfold.spinnerloading.SpinnerLoading;

import java.util.Collections;
import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.ServiceGenerator;
import app.managementapp.college.com.collegemanagement.api.Staff.StaffList.DataList;
import app.managementapp.college.com.collegemanagement.api.Staff.StaffList.StaffListResponse;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class StaffDetailsFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String STAFF_CODE="staffCode";
    private static final String STAFF_NAME="staffName";
    public FrameLayout progressBarHolder;
    SpinnerLoading progressBarholder;
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<DataList> mData= Collections.emptyList();
    // TODO: Customize parameters;
    private Call<RegularLoginResponse> loginCall;
    private StaffDetailsRecyclerViewAdapter staffDetailsRecyclerViewAdapter;
    private String staffName="";
    private String staffCode="";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StaffDetailsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static StaffDetailsFragment newInstance(int columnCount,String staffCode,String staffName) {
        StaffDetailsFragment fragment = new StaffDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putString(STAFF_CODE,staffCode);
        args.putString(STAFF_NAME,staffName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBarHolder = (FrameLayout) getActivity().findViewById(R.id.progressBarHolder);
        progressBarHolder.setVisibility(View.VISIBLE);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            staffCode=getArguments().getString(STAFF_CODE);
            staffName=getArguments().getString(STAFF_NAME);

            progressBarHolder.setVisibility(View.VISIBLE);
        }

        fetchData();
    }


    public void fetchData(){
        CredentialManager credentialManager;
        final CollegeManagementApiService collegeManagementApiService = ServiceGenerator.createService(CollegeManagementApiService.class);
        credentialManager = new CredentialManager(getContext());
        loginCall = collegeManagementApiService.doRegularLogin(credentialManager.getUserName(), credentialManager.getPassword());
        loginCall.enqueue(new Callback<RegularLoginResponse>() {
            @Override
            public void onResponse(Call<RegularLoginResponse> call, Response<RegularLoginResponse> response) {
              final Call<StaffListResponse> studentListResponseCall = collegeManagementApiService.getStaffList(response.body().getToken(),DepartmentAdapter.deptId,staffCode,staffName);
                studentListResponseCall.enqueue(new Callback<StaffListResponse>() {
                    @Override
                    public void onResponse(Call<StaffListResponse> call, Response<StaffListResponse> response) {
                        staffDetailsRecyclerViewAdapter.mValues=response.body().getDataList();
                        staffDetailsRecyclerViewAdapter.notifyDataSetChanged();
                        Log.e("success","Succesfully fetched");
                        progressBarHolder.setVisibility(View.GONE);
                        Toast.makeText(getContext(),"Succesfully fetched", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<StaffListResponse> call, Throwable t) {
                        Log.e("ERROR", t.toString());
                        progressBarHolder.setVisibility(View.GONE);
                        Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();

                    }
                });
            }

            @Override
            public void onFailure(Call<RegularLoginResponse> call, Throwable t) {
                Log.e("ERROR", t.toString());
                progressBarHolder.setVisibility(View.GONE);
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_staffdetails_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            staffDetailsRecyclerViewAdapter=new StaffDetailsRecyclerViewAdapter(mData, mListener);
            recyclerView.setAdapter(staffDetailsRecyclerViewAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DataList item);
    }
}
