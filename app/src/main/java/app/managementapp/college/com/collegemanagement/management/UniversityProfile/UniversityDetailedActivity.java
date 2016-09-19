package app.managementapp.college.com.collegemanagement.management.UniversityProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.UniversityProfile.DataList;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;

public class UniversityDetailedActivity extends AppCompatActivity {
    DataList data;
    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("university", "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_detailed);
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        data = getIntent().getParcelableExtra("data");
        Log.d("university", "onCreate: " + data);
//        TextView about = (TextView) findViewById(R.id.aboutdetails);
//        about.setText(data.getUniversityID());



    }

    @Override
    public void onBackPressed() {

        moveToLanding();

    }

    private void moveToLanding() {
        Intent i = new Intent(this, ManagementHome.class);
        startActivity(i);
        finish();
    }
}
