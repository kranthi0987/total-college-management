/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentInternalMarks.summary
        ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.StudentInternalExamMarkSummary.DataList;
import app.managementapp.college.com.collegemanagement.management.StudentInternalMarks.details.StudentInternalMarkDetailActivity;

public class StudentInternalMarkActivity extends AppCompatActivity implements CollegeListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_internal_mark);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CollegeListFragment fragment = CollegeListFragment.newInstance(0);
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }


    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, StudentInternalMarkDetailActivity.class);
        i.putExtra("data", item);
        startActivity(i);
    }
}
