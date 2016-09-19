package app.managementapp.college.com.collegemanagement.management;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.LoginActivity;
import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.adapters.MenuGridAdapter;
import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.FacultyProfile.DataList;
import app.managementapp.college.com.collegemanagement.api.FacultyProfile.FacultyProfileResult;
import app.managementapp.college.com.collegemanagement.api.ServiceGenerator;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagementHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    RecyclerView recyclerView;
    app.managementapp.college.com.collegemanagement.api.Staff.StaffList.DataList datalist;
    private CredentialManager credentialManager;
    private View parent_view;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    public static List<app.managementapp.college.com.collegemanagement.model.MenuItem> getMenuData(Context ctx) {
        List<app.managementapp.college.com.collegemanagement.model.MenuItem> items = new ArrayList<>();
        String s_name[] = ctx.getResources().getStringArray(R.array.menu_name);
        String s_date[] = ctx.getResources().getStringArray(R.array.groups_date);
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.menu_photos);

        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(0, s_date[0], s_name[0], "", drw_arr.getResourceId(0, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(1, s_date[1], s_name[1], "", drw_arr.getResourceId(1, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(2, s_date[2], s_name[2], "", drw_arr.getResourceId(2, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[3], "", drw_arr.getResourceId(3, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[4], "", drw_arr.getResourceId(4, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[5], "", drw_arr.getResourceId(5, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[6], "", drw_arr.getResourceId(6, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[7], "", drw_arr.getResourceId(7, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[8], "", drw_arr.getResourceId(8, -1)));
        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[9], "", drw_arr.getResourceId(9, -1)));
//        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[10], "", drw_arr.getResourceId(10, -1)));
//        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[11], "", drw_arr.getResourceId(11, -1)));
//        items.add(new app.managementapp.college.com.collegemanagement.model.MenuItem(3, s_date[3], s_name[12], "", drw_arr.getResourceId(12, -1)));

        return items;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        parent_view = findViewById(R.id.main_content);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        credentialManager = new CredentialManager(this);
        //new profile <code></code>


        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        final View headerView = navView.inflateHeaderView(R.layout.nav_menu_header);
        ImageView avatar = (ImageView) headerView.findViewById(R.id.avatar);
        final TextView nameLabel = (TextView) headerView.findViewById(R.id.profile_name);
//        nameLabel.setText(datalist.getFullName());
        final TextView departmentLabel = (TextView) headerView.findViewById(R.id.profile_dept);
//        departmentLabel.setText(datalist.getDepartment());
        final TextView phoneLabel = (TextView) headerView.findViewById(R.id.profile_phone);
//        phoneLabel.setText(datalist.getPhone());
        final TextView emailLabel = (TextView) headerView.findViewById(R.id.profile_email);
//        emailLabel.setText(datalist.getEmail());
        byte[] decodedString = Base64.decode(credentialManager.getUniversityLogo(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        Palette.generateAsync(decodedByte, new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                // Do something with colors...
                headerView.setBackgroundColor(palette.getVibrantColor(Color.BLACK));
                nameLabel.setTextColor(palette.getMutedColor(Color.WHITE));
                departmentLabel.setTextColor(palette.getMutedColor(Color.BLACK));
                phoneLabel.setTextColor(palette.getMutedColor(Color.BLACK));
                emailLabel.setTextColor(palette.getMutedColor(Color.BLACK));
            }
        });


        final CollegeManagementApiService collegeApiService = ServiceGenerator.createService(CollegeManagementApiService.class);
        Call<RegularLoginResponse> firstcall = collegeApiService.doRegularLogin(credentialManager.getUserName(), credentialManager.getPassword());
        firstcall.enqueue(new Callback<RegularLoginResponse>() {

            public DataList data;

            @Override
            public void onResponse(Call<RegularLoginResponse> call, Response<RegularLoginResponse> response) {
                Log.i("token", response.body().toString());

                final Call<FacultyProfileResult> facultyProfileCall=collegeApiService.getProfileData(response.body().getToken());
                facultyProfileCall.enqueue(new Callback<FacultyProfileResult>() {
                    @Override
                    public void onResponse(Call<FacultyProfileResult> call, Response<FacultyProfileResult> response) {
                        try{
                            Log.i("feed",response.body().toString());
                            data=response.body().getDataList().get(0);
                            nameLabel.setText(data.getFirstName());
                            nameLabel.setTextColor(R.color.black);
                            emailLabel.setText(data.getEmail());
                            emailLabel.setTextColor(R.color.black);
                            departmentLabel.setText(data.getDepartment());
                            departmentLabel.setTextColor(R.color.black);
                            phoneLabel.setText(data.getPhone());
                            phoneLabel.setTextColor(R.color.black);
                        }
                        catch (NullPointerException e){
                            Toast.makeText(getApplicationContext(),"No Data from Server",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<FacultyProfileResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();

                    }

                });


            }

            @Override
            public void onFailure(Call<RegularLoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }


        });

        avatar.setImageBitmap(decodedByte);


        // setting the required menus
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        MenuGridAdapter mAdapter = new MenuGridAdapter(this, getMenuData(this));
        recyclerView.setAdapter(mAdapter);
    }

    public void clicked(String clickOn) {
        Log.d("yyy", "clicked: " + clickOn);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.management_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            Toast.makeText(getApplicationContext(),
                    "logged out", Toast.LENGTH_LONG).show();
            startActivity(intent);

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            Toast.makeText(getApplicationContext(),
                    "logged out", Toast.LENGTH_LONG).show();
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
