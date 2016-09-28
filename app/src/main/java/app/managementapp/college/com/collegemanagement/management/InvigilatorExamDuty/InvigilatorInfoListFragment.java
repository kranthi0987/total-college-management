/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.InvigilatorExamDuty;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.InvigilatorExamDuty.DataList;
import app.managementapp.college.com.collegemanagement.api.InvigilatorExamDuty.InvigilatorExamDutyResponse;
import app.managementapp.college.com.collegemanagement.api.ServiceGenerator;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InvigilatorInfoListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    DateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
    FrameLayout progressBarHolder;
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private Call<RegularLoginResponse> loginCall;
    private InvigilatorInfoListRecyclerViewAdapter invigilatorInfoListRecyclerViewAdapter;
    private List<DataList> mItems = Collections.emptyList();
    private String date = "";
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InvigilatorInfoListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static InvigilatorInfoListFragment newInstance(int columnCount, String date) {
        InvigilatorInfoListFragment fragment = new InvigilatorInfoListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putString("date", date);
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
            this.date = getArguments().getString("date");
            if (this.date.equalsIgnoreCase("")) {
                this.date = formatter.format(new Date()).toString();
            }
        }
        fetchData(this.date);
    }


    public void fetchData(final String date) {
        CredentialManager credentialManager;
        final CollegeManagementApiService collegeManagementApiService = ServiceGenerator.createService(CollegeManagementApiService.class);
        credentialManager = new CredentialManager(getContext());
        loginCall = collegeManagementApiService.doRegularLogin(credentialManager.getUserName(), credentialManager.getPassword());
        loginCall.enqueue(new Callback<RegularLoginResponse>() {
            @Override
            public void onResponse(Call<RegularLoginResponse> call, Response<RegularLoginResponse> response) {
                final Call<InvigilatorExamDutyResponse> invigilatorExamDutyResponseCall = collegeManagementApiService.getInvigilatorExamDuty(response.body().getToken(), date);
                invigilatorExamDutyResponseCall.enqueue(new Callback<InvigilatorExamDutyResponse>() {
                    @Override
                    public void onResponse(Call<InvigilatorExamDutyResponse> call, Response<InvigilatorExamDutyResponse> response) {
                        invigilatorInfoListRecyclerViewAdapter.mValues = response.body().getDataList();
                        invigilatorInfoListRecyclerViewAdapter.notifyDataSetChanged();
                        Log.e("success", "Succesfully fetched");
                        progressBarHolder.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "Succesfully fetched", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<InvigilatorExamDutyResponse> call, Throwable t) {
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
        View view = inflater.inflate(R.layout.fragment_invigilator_info_card_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            invigilatorInfoListRecyclerViewAdapter = new InvigilatorInfoListRecyclerViewAdapter(mItems);
            recyclerView.setAdapter(invigilatorInfoListRecyclerViewAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
