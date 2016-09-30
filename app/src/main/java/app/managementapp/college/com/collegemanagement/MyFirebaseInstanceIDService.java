/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import app.managementapp.college.com.collegemanagement.api.Authentication.RegularAuth.RegularLoginResponse;
import app.managementapp.college.com.collegemanagement.api.CollegeManagementApiService;
import app.managementapp.college.com.collegemanagement.api.FacultyProfile.FacultyProfileResult;
import app.managementapp.college.com.collegemanagement.api.Fcm.FcmTokenUpdateRequest;
import app.managementapp.college.com.collegemanagement.api.Fcm.FcmTokenUpdateResponse;
import app.managementapp.college.com.collegemanagement.api.ServiceGenerator;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sri Harrsha on 05-Aug-16.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "TokenRegistration";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "Refreshed token: " + refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(final String refreshedFcmToken) {
        ServiceGenerator.changeApiBaseUrl(new CredentialManager(getApplicationContext()).getUniversityUrl());
        final CollegeManagementApiService collegeManagementService = ServiceGenerator.createService(CollegeManagementApiService.class);
        final TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        CredentialManager credentialManager = new CredentialManager(getApplicationContext());
        Call<RegularLoginResponse> loginCall = collegeManagementService.doRegularLogin(credentialManager.getUserName(), credentialManager.getPassword());
        loginCall.enqueue(new Callback<RegularLoginResponse>() {
            @Override
            public void onResponse(Call<RegularLoginResponse> call, Response<RegularLoginResponse> response) {
                final Call<FacultyProfileResult> staffProfileCall = collegeManagementService.getProfileData(response.body().getToken());
                final String loginToken = response.body().getToken();
                staffProfileCall.enqueue(new Callback<FacultyProfileResult>() {
                    @Override
                    public void onResponse(Call<FacultyProfileResult> call, Response<FacultyProfileResult> response) {
                        FcmTokenUpdateRequest request = new FcmTokenUpdateRequest();
                        request.setIMEI(tm.getDeviceId());
                        request.setUserID(response.body().getDataList().get(0).getMGUID());
                        request.setToken(refreshedFcmToken);
                        Call<FcmTokenUpdateResponse> callFcmUpdate = collegeManagementService.updateFirebaseToken(loginToken, request);
                        callFcmUpdate.enqueue(new Callback<FcmTokenUpdateResponse>() {
                            @Override
                            public void onResponse(Call<FcmTokenUpdateResponse> call, Response<FcmTokenUpdateResponse> response) {
                                Log.e(TAG, "updated fcm token");
                            }

                            @Override
                            public void onFailure(Call<FcmTokenUpdateResponse> call, Throwable t) {
                                Log.e(TAG, "unable updated fcm token");
                            }
                        });

                        Log.e("success", "Succesfully fetched");
                        Toast.makeText(getApplicationContext(), "Succesfully fetched", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<FacultyProfileResult> call, Throwable t) {
                        Log.e("ERROR", t.toString());
                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<RegularLoginResponse> call, Throwable t) {
                Log.e("ERROR", t.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
