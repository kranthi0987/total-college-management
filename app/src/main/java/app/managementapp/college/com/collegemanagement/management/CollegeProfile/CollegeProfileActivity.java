package app.managementapp.college.com.collegemanagement.management.CollegeProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.CollegeProfile.DataList;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;

public class CollegeProfileActivity extends AppCompatActivity implements CollegeListFragment.OnListFragmentInteractionListener {

    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("College profile", "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_profile);
        ((ImageView) findViewById(R.id.backTimeTable)).setOnClickListener(onFilterbackclickListener);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CollegeListFragment fragment = CollegeListFragment.newInstance(0);
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();

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


    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, CollegeDetailedView.class);
        i.putExtra("data", item);
        startActivity(i);

    }
}
