/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentSearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.StudentSearch.StudentList.DataList;
import app.managementapp.college.com.collegemanagement.management.StudentSearch.OtherDetails.CommonOtherDetails;
import app.managementapp.college.com.collegemanagement.model.util.Converter;

/**
 * Created by Sri Harrsha on 29-Aug-16.
 */
public class StudentDetails extends AppCompatActivity {
    DataList data;
    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Student details", "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        data = getIntent().getParcelableExtra("data");
        TextView textView = (TextView) this.findViewById(R.id.aboutdetails);
        textView.setText(data.getBranchName() + "\n" + Converter.retroDateConvert(data.getDateOfBirth()) + "\n" + data.getEmail() + "\n" + data.getMobile());
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        TextView addressTextView = (TextView) this.findViewById(R.id.addressdetails);
        addressTextView.setText(data.getAddressal());

    }

    @Override
    public void onBackPressed() {
        moveToLanding();
    }

    private void moveToLanding() {
        Intent i = new Intent(this, StudentSearchList.class);
        startActivity(i);
        finish();
    }

    public void otherDetails(View view) {
        switch (view.getId()) {
            case R.id.admissionDetailsButton:
                Intent i = new Intent(this, CommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 1);
                startActivity(i);
                break;
            case R.id.qualificationDetailsButton:
                i = new Intent(this, CommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 5);
                startActivity(i);
                break;
            case R.id.attendanceDetailsButton:
                i = new Intent(this, CommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 2);
                startActivity(i);
                break;
            case R.id.examMarkDetailsButton:
                i = new Intent(this, CommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 3);
                startActivity(i);
                break;
            case R.id.studentActivityDetailsButton:
                i = new Intent(this, CommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 6);
                startActivity(i);
                break;
            case R.id.paymentDetailsButton:
                i = new Intent(this, CommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 4);
                startActivity(i);
                break;
            default:
                break;

        }
    }
}
