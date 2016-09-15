package app.managementapp.college.com.collegemanagement.management.StudentSearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.StudentSearch.StudentList.DataList;
import app.managementapp.college.com.collegemanagement.management.StudentSearch.StudentListFragment.OnListFragmentInteractionListener;
import retrofit2.Call;

public class StudentSearchList extends AppCompatActivity implements OnListFragmentInteractionListener {
    private static final String DEBUG_TAG = "StudentSearchList";
    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: onFilterbackTimeTableclickListener");
            moveToSearch();
        }
    };
    private Call<RegularLoginResponse> loginCall;


    @Override
    public void onBackPressed() {

        moveToSearch();

    }

    public void backNavigator() {
        if (level == 1) {
            moveToLanding();
        } else {
            level -= 1;
            levelIds.remove(levelIds.size() - 1);
            makeNetworkCall();
        }
    }

    void moveToLanding() {
        Intent i = new Intent(this, ManagementHome.class);
        startActivity(i);
        finish();
    }

    private void moveToSearch() {
        Intent i = new Intent(StudentSearchList.this, StudentSearch.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_search_list);
        ((ImageView) findViewById(R.id.backTimeTable)).setOnClickListener(onFilterbackclickListener);
    }

    @Override
    public void onListFragmentInteraction(DataList mItem) {
        Intent i = new Intent(this, StudentDetails.class);
        i.putExtra("data", mItem);

        startActivity(i);
    }
}
