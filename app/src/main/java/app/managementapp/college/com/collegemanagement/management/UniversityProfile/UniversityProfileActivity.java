package app.managementapp.college.com.collegemanagement.management.UniversityProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.UniversityProfile.DataList;

public class UniversityProfileActivity extends AppCompatActivity implements UniversityFragment.OnListFragmentInteractionListener {

    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("University Profile", "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_profile2);
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        FragmentManager fragmentManager = getSupportFragmentManager();
        UniversityFragment fragment = UniversityFragment.newInstance(0);
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
    }



    private void moveToLanding() {
        onBackPressed();
    }


    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, UniversityDetailedActivity.class);
        i.putExtra("data", item);
        startActivity(i);
    }
}
