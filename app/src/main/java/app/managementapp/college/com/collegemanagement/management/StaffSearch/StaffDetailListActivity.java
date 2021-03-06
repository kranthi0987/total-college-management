/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.lusfold.spinnerloading.SpinnerLoading;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Staff.StaffList.DataList;

public class StaffDetailListActivity extends FragmentActivity implements StaffDetailsFragment.OnListFragmentInteractionListener {

    public FrameLayout progressBarHolder;
    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Staff Search", "onClick: onFilterbackTimeTableclickListener");
            onBackPressed();
        }
    };
    SpinnerLoading progressBarholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail_list);
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);
        String staffCode = getIntent().getStringArrayListExtra("parameters").get(0);

        String staffName = getIntent().getStringArrayListExtra("parameters").get(1);


        FragmentManager fragmentManager = getSupportFragmentManager();
        StaffDetailsFragment fragment = StaffDetailsFragment.newInstance(0, staffCode, staffName);
        fragmentManager.beginTransaction().add(R.id.stafflistfrag, fragment).commit();
    }


    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, StaffFullDetails.class);
        i.putExtra("data", item);
        startActivity(i);

    }
}
