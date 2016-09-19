package app.managementapp.college.com.collegemanagement.management.CollegeProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.CollegeProfile.DataList;

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
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CollegeListFragment fragment = CollegeListFragment.newInstance(0);
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();

    }


    private void moveToLanding() {
        onBackPressed();


    }


    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, CollegeDetailedView.class);
        i.putExtra("data", item);
        startActivity(i);

    }
}
