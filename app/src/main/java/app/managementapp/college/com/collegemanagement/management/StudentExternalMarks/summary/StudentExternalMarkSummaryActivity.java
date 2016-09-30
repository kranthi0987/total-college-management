/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentExternalMarks.summary
        ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.management.StudentExternalMarks.details.StudentExternalMarkDetailActivity;

public class StudentExternalMarkSummaryActivity extends AppCompatActivity implements CollegeListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_internal_mark);
        TextView header = (TextView) findViewById(R.id.title);
        header.setText("External Marks Summary");
        FragmentManager fragmentManager = getSupportFragmentManager();
        CollegeListFragment fragment = CollegeListFragment.newInstance(0);
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }


    @Override
    public void onListFragmentInteraction(app.managementapp.college.com.collegemanagement.api.StudentExternalExam.DataList item) {
        Intent i = new Intent(this, StudentExternalMarkDetailActivity.class);
        i.putExtra("data", item);
        startActivity(i);
    }
}
