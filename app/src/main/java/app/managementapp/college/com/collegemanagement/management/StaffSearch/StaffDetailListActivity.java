package app.managementapp.college.com.collegemanagement.management.StaffSearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Staff.StaffList.DataList;

public class StaffDetailListActivity extends FragmentActivity implements StaffDetailsFragment.OnListFragmentInteractionListener {

    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Staff Search", "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail_list);
        ((ImageView) findViewById(R.id.backTimeTable)).setOnClickListener(onFilterbackclickListener);
        String staffCode = getIntent().getStringArrayListExtra("parameters").get(0);

        String staffName = getIntent().getStringArrayListExtra("parameters").get(1);


        FragmentManager fragmentManager = getSupportFragmentManager();
        StaffDetailsFragment fragment = StaffDetailsFragment.newInstance(0, staffCode, staffName);
        fragmentManager.beginTransaction().add(R.id.stafflistfrag, fragment).commit();
    }

    @Override
    public void onBackPressed() {


        moveToLanding();


    }

    private void moveToLanding() {
        Intent i = new Intent(this, StaffSearch.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, StaffFullDetails.class);
        i.putExtra("data", item);
        startActivity(i);

    }
}
