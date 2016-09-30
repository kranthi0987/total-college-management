/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentExternalMarks.summary;

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

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.ServiceGenerator;
import app.managementapp.college.com.collegemanagement.api.StudentExternalExam.StudentExternalMarksSummaryResponse;
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
public class CollegeListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private Call<RegularLoginResponse> loginCall;
    private CollegeRecyclerViewAdapter collegeRecyclerViewAdapter;
    private List<app.managementapp.college.com.collegemanagement.api.StudentExternalExam.DataList> mItems;
    private FrameLayout progressBarHolder;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CollegeListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CollegeListFragment newInstance(int columnCount) {
        CollegeListFragment fragment = new CollegeListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        fetchData();
    }

    public void fetchData() {
        CredentialManager credentialManager;
        final CollegeManagementApiService collegeManagementApiService = ServiceGenerator.createService(CollegeManagementApiService.class);
        credentialManager = new CredentialManager(getContext());
        loginCall = collegeManagementApiService.doRegularLogin(credentialManager.getUserName(), credentialManager.getPassword());
        loginCall.enqueue(new Callback<RegularLoginResponse>() {
            @Override
            public void onResponse(Call<RegularLoginResponse> call, Response<RegularLoginResponse> response) {
                final Call<StudentExternalMarksSummaryResponse> collegeListResponseCall = collegeManagementApiService.getStudentExternalMarkSummary(response.body().getToken(), "0", "1", "1", "14");
                collegeListResponseCall.enqueue(new Callback<StudentExternalMarksSummaryResponse>() {
                    @Override
                    public void onResponse(Call<StudentExternalMarksSummaryResponse> call, Response<StudentExternalMarksSummaryResponse> response) {
                        collegeRecyclerViewAdapter.mValues = response.body().getDataList();
                        collegeRecyclerViewAdapter.notifyDataSetChanged();
                        progressBarHolder.setVisibility(View.GONE);
                        Log.e("success", "Succesfully fetched");
                        Toast.makeText(getContext(), "Succesfully fetched", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<StudentExternalMarksSummaryResponse> call, Throwable t) {
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
        progressBarHolder = (FrameLayout) getActivity().findViewById(R.id.progressBarHolder);
        progressBarHolder.setVisibility(View.VISIBLE);
        View view = inflater.inflate(R.layout.fragment_int_ext_mark_summary, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            collegeRecyclerViewAdapter = new CollegeRecyclerViewAdapter(mItems, mListener);
            recyclerView.setAdapter(collegeRecyclerViewAdapter);
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
        void onListFragmentInteraction(app.managementapp.college.com.collegemanagement.api.StudentExternalExam.DataList item);
    }
}
