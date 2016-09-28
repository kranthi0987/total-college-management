/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.Feedback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.FeedbackList.DataList;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;

public class FeedbackList extends AppCompatActivity implements FeedbackFragment.OnListFragmentInteractionListener {

    FrameLayout progressBarHolder;
    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("University Profile", "onClick: onFilterbackTimeTableclickListener");
            onBackPressed();
        }
    };
    private CollegeManagementApiService collegeApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_list);
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        FeedbackFragment feedbackFragment = FeedbackFragment.newInstance(1);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list_container, feedbackFragment).commit();
//        getSupportActionBar().setTitle("Feedback");
        //      getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void onListFragmentInteraction(DataList item) {
        Intent gotoFeedbackReply = new Intent(this, FeedbackReply.class);
        gotoFeedbackReply.putExtra("data", item);
        startActivity(gotoFeedbackReply);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, ManagementHome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
