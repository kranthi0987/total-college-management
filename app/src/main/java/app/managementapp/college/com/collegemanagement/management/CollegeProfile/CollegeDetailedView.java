package app.managementapp.college.com.collegemanagement.management.CollegeProfile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.CollegeProfile.DataList;
import app.managementapp.college.com.collegemanagement.management.CollegeProfile.DepartmentList.DepartmentFragment;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;

public class CollegeDetailedView extends AppCompatActivity implements CollegeListFragment.OnListFragmentInteractionListener {
    DataList dataList;
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
        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackclickListener);
        dataList = getIntent().getParcelableExtra("data");
        Log.d("college", "onCreate: " + dataList);
        Log.d("college", "onCreate: " + dataList.getCollegeName());
        Log.d("college", "onCreate: " + dataList.getUniversityName());
        Log.d("college", "onCreate: " + dataList.getEmail());
        Log.d("college", "onCreate: " + dataList.getFax());

        Bitmap decodedBitmap = null;
        ImageView collegeimage = (ImageView) findViewById(R.id.college_profile_pic);
        try {
            byte[] decodedString = Base64.decode(dataList.getBase64Image(), Base64.DEFAULT);
            decodedBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            collegeimage.setImageBitmap(decodedBitmap);
        } catch (Exception e) {
            //// TODO: 9/19/2016 change this try catch
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                collegeimage.setImageDrawable(getDrawable(R.drawable.menu_icon_colege_profile));
            }
        }


        TextView collegeName = (TextView) findViewById(R.id.college_name);
        collegeName.setText(dataList.getCollegeName());
        TextView universityName = (TextView) findViewById(R.id.university_name);
        universityName.setText(dataList.getUniversityName());
        TextView email = (TextView) findViewById(R.id.email);
        email.setText(dataList.getEmail());
        TextView fax = (TextView) findViewById(R.id.fax);
        fax.setText(dataList.getFax());
        TextView website = (TextView) findViewById(R.id.website);
        website.setText(dataList.getWebSite());
        TextView address = (TextView) findViewById(R.id.addressHolder);
        address.setText(dataList.getAddress().toString());


        FragmentManager fragmentManager = getSupportFragmentManager();
        DepartmentFragment fragment = DepartmentFragment.newInstance(dataList.getDepartmentList());
        fragmentManager.beginTransaction().add(R.id.department_list_container, fragment).commit();


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
        Log.i("dept", "clicked");
    }
}
