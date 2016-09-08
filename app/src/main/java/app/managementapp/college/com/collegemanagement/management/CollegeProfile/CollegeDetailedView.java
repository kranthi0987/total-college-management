package app.managementapp.college.com.collegemanagement.management.CollegeProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;

public class CollegeDetailedView extends AppCompatActivity {

    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Student details", "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_profile_detailed);
        ((ImageView) findViewById(R.id.backTimeTable)).setOnClickListener(onFilterbackclickListener);

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
