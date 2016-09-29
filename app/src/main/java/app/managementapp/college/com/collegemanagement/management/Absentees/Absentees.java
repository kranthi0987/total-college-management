/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.Absentees;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Time;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import app.managementapp.college.com.collegemanagement.LoginActivity;
import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;
import app.managementapp.college.com.collegemanagement.model.GlobalData;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import app.managementapp.college.com.collegemanagement.util.ErrorToaster;

public class Absentees extends AppCompatActivity {
    private static final String DEBUG_TAG = "Absentees";
    FrameLayout progressBarHolder;
    String loginURL = "";
    Context ctx;
    Exception error;
    DateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
    DateFormat keyFormatter = new SimpleDateFormat("dd-MMMM-yyyy");
    Calendar showingCalander = Calendar.getInstance(Locale.getDefault());
    LinearLayout layoutOfPopup;
    LinearLayout layoutInnerOfPopup;
    PopupWindow popupMessage;
    Button popupButton, insidePopupButton;
    TextView popupText;
    TextView toText;
    DatePicker fromDatePicker;
    DatePicker toDatePicker;
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    List<AbsenteesItem> absenteeslist;
    View.OnClickListener onFilterbackTimeTableclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: onFilterbackTimeTableclickListener");
            onBackPressed();
        }
    };
    View.OnClickListener onFilterclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: onFilterclickListener");
//                popupMessage.showAsDropDown(insidePopupButton, 0, 0);
            popupMessage.showAtLocation(insidePopupButton, Gravity.CENTER, 0, 0);
        }
    };
    private CredentialManager credentialManager;
    View.OnClickListener onFilterOkclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: onFilterOkclickListener");
            if (popupMessage.isShowing()) {
                popupMessage.dismiss();
                try {
                    String date = (fromDatePicker.getDayOfMonth() + "-" + months[fromDatePicker.getMonth()] + "-" + fromDatePicker.getYear());
                    Toast.makeText(Absentees.this, "working." + date.toString(), Toast.LENGTH_SHORT).show();
                    // Make network call
                    makeNetworkCall();
                } catch (Exception e) {
                    Toast.makeText(Absentees.this, "error." + e.toString(), Toast.LENGTH_SHORT).show();
                }
            } else {
//                Toast.makeText(this, "From ", Toast.LENGTH_SHORT).show();
            }

        }
    };
    private RecyclerView recyclerView;

    private void moveToLanding() {
        Intent i = new Intent(Absentees.this, ManagementHome.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absentees);
        credentialManager = new CredentialManager(this);
        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);
        loginURL = credentialManager.getUniversityUrl() + "/AuthenticationService.svc/AuthenticateRequest?username=" + credentialManager.getUserName() + "&Password=" + credentialManager.getPassword();
        this.ctx = getApplicationContext();
//        makeNetworkCall();
        ImageView filter = (ImageView) findViewById(R.id.filter);
        filter.setOnClickListener(onFilterclickListener);

        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackTimeTableclickListener);
        setupPopUp();
        insidePopupButton.setOnClickListener(onFilterOkclickListener);

    }

    private void setupPopUp() {

        popupText = new TextView(this);
        insidePopupButton = new Button(this);

        layoutOfPopup = new LinearLayout(this);
        layoutInnerOfPopup = new LinearLayout(this);
        insidePopupButton.setText("OK");
        insidePopupButton.setTextColor(Color.parseColor("#FFFFFF"));
        insidePopupButton.setBackgroundColor(Color.parseColor("#03A7E9"));
        popupText.setText("Month");
        popupText.setTextColor(Color.parseColor("#000000"));
        popupText.setTextSize(16);
        popupText.setPadding(0, 0, 0, 10);
        layoutOfPopup.setOrientation(LinearLayout.VERTICAL);
        fromDatePicker = new DatePicker(this);
        toDatePicker = new DatePicker(this);
        fromDatePicker.setCalendarViewShown(false);
        View dayId = fromDatePicker.findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
        if (dayId != null) dayId.setVisibility(View.GONE);
        toDatePicker.setCalendarViewShown(false);
        layoutOfPopup.addView(popupText);
        layoutOfPopup.addView(fromDatePicker);
//        layoutOfPopup.addView(toText);
        layoutOfPopup.addView(insidePopupButton);
        layoutOfPopup.setBackgroundColor(Color.parseColor("#ffffff"));
        layoutOfPopup.setPadding(40, 40, 40, 40);
        layoutOfPopup.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        layoutInnerOfPopup.setPadding(40, 40, 40, 40);
        layoutInnerOfPopup.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        layoutInnerOfPopup.setBackgroundColor(Color.parseColor("#80000000"));
        layoutInnerOfPopup.addView(layoutOfPopup);

        popupMessage = new PopupWindow(layoutInnerOfPopup, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        popupMessage.setContentView(layoutInnerOfPopup);

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
    private void makeNetworkCall() {
        // Make network call
        if (isNetworkAvailable()) {
            String getAbsenteesURL = credentialManager.getUniversityUrl() + "/ManagementService.svc/GetStaffLoginAbsenteesSummary?ItemID=1&LevelID=2&Date=" + (fromDatePicker.getDayOfMonth() + "-" + months[fromDatePicker.getMonth()] + "-" + fromDatePicker.getYear());
            Log.d(DEBUG_TAG, "makeNetworkCall: url: " + getAbsenteesURL);
            progressBarHolder.setVisibility(View.VISIBLE);
            new AbsenteesTask().execute(loginURL, getAbsenteesURL);
        } else {
            Toast.makeText(this, "Network not available.", Toast.LENGTH_SHORT).show();

        }
    }

    private List<AbsenteesItem> getAbsenteesList(JSONArray dataList) {
        List<AbsenteesItem> data = new ArrayList<>();
        for (int i = 0, size = dataList.length(); i < size; i++) {
            try {
                JSONObject objectInArray = dataList.getJSONObject(i);
                AbsenteesItem absenteesItem = new AbsenteesItem(
                        objectInArray.getString("Absentees"),
                        objectInArray.getString("Active"),
                        objectInArray.getString("Category"),
                        objectInArray.getString("CategoryID"),
                        objectInArray.getString("CurrentLevel"),
                        objectInArray.getString("IsChildAvailable"),
                        objectInArray.getString("OnLeave"),
                        objectInArray.getString("Present")
                );
                data.add(absenteesItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getFeeSummaryList: " + e.getMessage());
            }
        }
        return data;
    }

    public void setAbsentees(List<AbsenteesItem> absenteesItems) {
        recyclerView = (RecyclerView) findViewById(R.id.absentees);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new AbsenteesAdapter(this.ctx, absenteesItems));

    }


    private String downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        int len = 50000;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            if (myurl.contains("AuthenticateRequest")) conn.setRequestMethod("POST");
            conn.setRequestProperty("TOKEN", credentialManager.getToken());
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } catch (Exception e) {
            Log.d(DEBUG_TAG, "error is --: " + e.toString());
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return "";
    }

    // Reads an InputStream and converts it to a String.
    public String readIt(InputStream stream, int len) throws IOException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        BufferedReader r = new BufferedReader(reader);
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line);
        }
        return total.toString();
    }

    // Network code
    private class AbsenteesTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String result) {
            progressBarHolder.setVisibility(View.GONE);
            try {
                Log.e("result: ", result);
                JSONObject resultJSON = new JSONObject(result);
                if (resultJSON.getInt("ServiceResult") == 0) {
                    Log.d(DEBUG_TAG, "onPostExecute: from network");
                    absenteeslist = getAbsenteesList(resultJSON.getJSONArray("DataList"));
                    Log.d(DEBUG_TAG, "Academic Calendar: " + absenteeslist.size());
                    setAbsentees(absenteeslist);
                } else {

                }
            } catch (Exception t) {
                if (result.equals("Unable to retrieve web page. URL may be invalid.")) {

                } else {
                    error = t;
                    Log.e("JSON error", t + " Could not parse malformed JSON: \"" + result + "\"");
                }
            }
        }

        public void useLoginToken(String result) {
            if (new ErrorToaster().toastError(error, ctx)) return;
            try {
                JSONObject resultJSON = new JSONObject(result);
                Log.d("resultJSON ", result + "");
                Intent i;
                if (resultJSON.getInt("ServiceResult") == 0) {
                    Log.d(DEBUG_TAG, "onPostExecute: The user is logged in ==> use: " + credentialManager.getUserName() +
                            ", password: " + credentialManager.getPassword());
                    Time requestInitiatedTime = new Time();
                    GlobalData globalData = new GlobalData();
                    globalData.setLastNetworkCall(requestInitiatedTime);
                    globalData.setToken(resultJSON.getString("Token"));
                    credentialManager.setToken(resultJSON.getString("Token"));
                    Log.d(DEBUG_TAG, "The token is: " + resultJSON.getString("Token"));
                } else {
                    Log.d(DEBUG_TAG, "onPostExecute: The user is not valid ==> use: " + credentialManager.getUserName() +
                            ", password: " + credentialManager.getPassword());
                    i = new Intent(Absentees.this, LoginActivity.class);

                    startActivity(i);
                    // kill current activity
                    finish();
                }
            } catch (Exception t) {
                error = t;
                Log.e("useLoginToken", t.getMessage() + " Could not parse malformed JSON: \"" + result + "\"");
            }
        }

        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                String loginData = downloadUrl(urls[0]);
                Log.d(DEBUG_TAG, "doInBackground: " + loginData);
                useLoginToken(loginData);
                return downloadUrl(urls[1]);
            } catch (Exception e) {
                error = e;
                Log.d(DEBUG_TAG, "The response is: " + e.toString());
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

    }


}