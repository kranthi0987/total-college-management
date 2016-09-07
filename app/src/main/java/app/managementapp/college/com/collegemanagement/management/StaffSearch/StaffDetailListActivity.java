package app.managementapp.college.com.collegemanagement.management.staffsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Staff.StaffList.DataList;

public class StaffDetailListActivity extends FragmentActivity implements StaffDetailsFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail_list);
        String staffCode = getIntent().getStringArrayListExtra("parameters").get(0);

        String staffName = getIntent().getStringArrayListExtra("parameters").get(1);


        FragmentManager fragmentManager = getSupportFragmentManager();
        StaffDetailsFragment fragment = StaffDetailsFragment.newInstance(0, staffCode, staffName);
        fragmentManager.beginTransaction().add(R.id.stafflistfrag, fragment).commit();
    }

    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent i = new Intent(this, StaffFullDetails.class);
        i.putExtra("data", item);
        startActivity(i);

    }
}
