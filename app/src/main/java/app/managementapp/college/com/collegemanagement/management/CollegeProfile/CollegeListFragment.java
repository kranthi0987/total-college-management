package app.managementapp.college.com.collegemanagement.management.CollegeProfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.CollegeProfile.CollegeProfileResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeProfile.DataList;
import app.managementapp.college.com.collegemanagement.api.ServiceGenerator;
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
    Intent i;
    CollegeListRecyclerViewAdapter collegeListRecyclerViewAdapter;
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<DataList> mItems;
    private Call<RegularLoginResponse> loginCall;

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

        i = new Intent(getActivity(), CollegeDetailedView.class);
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
                final Call<CollegeProfileResponse> collegeListResponseCall = collegeManagementApiService.getCollegeProfile(response.body().getToken(), 0);
                collegeListResponseCall.enqueue(new Callback<CollegeProfileResponse>() {
                    @Override
                    public void onResponse(Call<CollegeProfileResponse> call, Response<CollegeProfileResponse> response) {
                        collegeListRecyclerViewAdapter.mValues = response.body().getDataList();
                        if (response.body().getDataList().size() == 1) {
                            i.putExtra("data", response.body().getDataList().get(0));
                            startActivity(i);
                        }
                        collegeListRecyclerViewAdapter.notifyDataSetChanged();
                        Log.e("success", "Succesfully fetched");
                        Toast.makeText(getContext(), "Succesfully fetched", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<CollegeProfileResponse> call, Throwable t) {
                        Log.e("ERROR", t.toString());
                        Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();

                    }
                });
            }

            @Override
            public void onFailure(Call<RegularLoginResponse> call, Throwable t) {
                Log.e("ERROR", t.toString());
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_college_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            collegeListRecyclerViewAdapter = new CollegeListRecyclerViewAdapter(mItems, mListener);
            recyclerView.setAdapter(collegeListRecyclerViewAdapter);
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
