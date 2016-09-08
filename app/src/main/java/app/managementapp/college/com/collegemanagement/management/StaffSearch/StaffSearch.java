package app.managementapp.college.com.collegemanagement.management.StaffSearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.ServiceGenerator;
import app.managementapp.college.com.collegemanagement.api.Staff.Department.DataList;
import app.managementapp.college.com.collegemanagement.api.Staff.Department.DepartmentResponse;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StaffSearch extends AppCompatActivity {


    EditText staffId;
    EditText staffName;
    app.managementapp.college.com.collegemanagement.api.Staff.Department.DataList defaultdepartment=new DataList();
    private CredentialManager credentialManager;
    private Call<RegularLoginResponse> loginCall;
    private DepartmentAdapter departmentDropDownAdapter;
    private Spinner departmentSpinner;
    private List<app.managementapp.college.com.collegemanagement.api.Staff.Department.DataList> departmentList= Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_search);
        defaultdepartment.setDrpID("0");
        defaultdepartment.setDrpName("Pick Department");

        departmentSpinner = (Spinner) this.findViewById(R.id.department_spinner);
        departmentDropDownAdapter = new DepartmentAdapter(getApplicationContext(), departmentList);
        departmentDropDownAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(departmentDropDownAdapter);

        departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                departmentDropDownAdapter.deptId=departmentDropDownAdapter.departments.get(position).getDrpID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final CollegeManagementApiService collegeManagementApiService = ServiceGenerator.createService(CollegeManagementApiService.class);
        credentialManager = new CredentialManager(this);
        loginCall = collegeManagementApiService.doRegularLogin(credentialManager.getUserName(), credentialManager.getPassword());
        loginCall.enqueue(new Callback<RegularLoginResponse>() {
            @Override
            public void onResponse(Call<RegularLoginResponse> call, Response<RegularLoginResponse> response) {
                Call<DepartmentResponse> courseListResponseCall = collegeManagementApiService.getDepartment(response.body().getToken());


                courseListResponseCall.enqueue(new Callback<DepartmentResponse>() {
                    @Override
                    public void onResponse(Call<DepartmentResponse> call, Response<DepartmentResponse> response) {
                        departmentDropDownAdapter.departments=response.body().getDataList();
                        departmentDropDownAdapter.departments.add(0,defaultdepartment);
                        departmentDropDownAdapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Course List Fetched " + response.body().getErrorMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DepartmentResponse> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<RegularLoginResponse> call, Throwable t) {
                Log.e("ERROR", t.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });


        staffId = (EditText)this.findViewById(R.id.staffId);
        staffName = (EditText)this.findViewById(R.id.staffName);
    }


    public void searchIntent(View view) {
        Intent i=new Intent(this,StaffDetailListActivity.class);
        ArrayList<String> params=new ArrayList<>(2);
        params.add(staffId.getText().toString());
        params.add(staffName.getText().toString());
        i.putStringArrayListExtra("parameters", params);
        startActivity(i);
    }
}
