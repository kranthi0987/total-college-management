/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentExternalMarks.subjectdetails
        ;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import app.managementapp.college.com.collegemanagement.R;

public class StudentExternalMarkSubjectDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView header = (TextView) findViewById(R.id.title);
        header.setText("External Marks Subject Details");
        setContentView(R.layout.activity_student_internal_mark);
        ArrayList<String> data = getIntent().getExtras().getStringArrayList("data");
        FragmentManager fragmentManager = getSupportFragmentManager();
        SubjectListFragment fragment = SubjectListFragment.newInstance(0, data);
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }

}
