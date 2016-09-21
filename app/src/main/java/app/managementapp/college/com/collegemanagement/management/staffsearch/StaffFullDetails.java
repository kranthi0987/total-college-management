/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Staff.StaffList.DataList;
import app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails.StaffCommonOtherDetails;
import app.managementapp.college.com.collegemanagement.model.util.Converter;

/**
 * Created by Sanjay on 9/7/2016.
 * total
 */
public class StaffFullDetails extends AppCompatActivity {
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
        setContentView(R.layout.staff_full_details);
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        data = getIntent().getParcelableExtra("data");
        TextView textView = (TextView) this.findViewById(R.id.aboutdetails);
        textView.setText(data.getFullName() + "\n" + Converter.retroDateConvert(data.getDOJ()) + "\n" + "DOB:" + Converter.retroDateConvert(data.getDateOfBirth()) + "\n" + data.getEmail() + "\n" + data.getCode());
        TextView addressTextView = (TextView) this.findViewById(R.id.addressdetails);
        addressTextView.setText(data.getAddress().toString());

    }

    @Override
    public void onBackPressed() {
        moveToLanding();
    }

    private void moveToLanding() {
        Intent i = new Intent(this, StaffDetailListActivity.class);
        startActivity(i);
        finish();
    }

    public void otherDetails(View view) {
        switch (view.getId()) {
            case R.id.StaffAttendanceDetailsButton:
                Intent i = new Intent(this, StaffCommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 1);
                startActivity(i);
                break;
            case R.id.StaffFeedbackDetailsButton:
                i = new Intent(this, StaffCommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 2);
                startActivity(i);
                break;
            case R.id.StaffLeaveDetailsButton:
                i = new Intent(this, StaffCommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 3);
                startActivity(i);
                break;
            case R.id.StaffMemoEntryDetailsButton:
                i = new Intent(this, StaffCommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 4);
                startActivity(i);
                break;
            case R.id.StaffMovementRegisterDetailsButton:
                i = new Intent(this, StaffCommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 5);
                startActivity(i);
                break;
            case R.id.StaffSeminarDetailsButton:
                i = new Intent(this, StaffCommonOtherDetails.class);
                i.putExtra("data", data);
                i.putExtra("case1", 6);
                startActivity(i);
                break;
            default:

                break;

        }
    }
}
