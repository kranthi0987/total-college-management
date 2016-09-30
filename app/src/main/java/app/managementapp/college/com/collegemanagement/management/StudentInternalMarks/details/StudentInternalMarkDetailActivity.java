/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentInternalMarks.details
        ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.StudentInternalExamMarkDetails.DataList;
import app.managementapp.college.com.collegemanagement.management.StudentInternalMarks.subjectdetails.StudentInternalMarkSubjectDetailActivity;

public class StudentInternalMarkDetailActivity extends AppCompatActivity implements StudentListFragment.OnListFragmentInteractionListener {

    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("", "onClick: onFilterbackTimeTableclickListener");
            onBackPressed();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_internal_mark);
        TextView header = (TextView) findViewById(R.id.title);
        header.setText("Internal Marks Details");
        FragmentManager fragmentManager = getSupportFragmentManager();
        StudentListFragment fragment = StudentListFragment.newInstance(0);
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);

    }

    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, StudentInternalMarkSubjectDetailActivity.class);
        ArrayList<String> data = new ArrayList<>();
        data.add((String) item.getGUID());
        i.putStringArrayListExtra("data", data);
        startActivity(i);
    }


}
