/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.Absentees;

import android.content.Context;
import android.content.Intent;
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
import android.view.View;
import android.widget.FrameLayout;
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
import java.util.ArrayList;
import java.util.List;

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
    List<AbsenteesItem> absenteeslist;
    View.OnClickListener onFilterbackTimeTableclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };
    private CredentialManager credentialManager;
    private RecyclerView recyclerView;
    private void moveToLanding() {
        Intent i = new Intent(Absentees.this, ManagementHome.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Log.d("onBackPressed", "onBackPressed: ");
        moveToLanding();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absentees);
        credentialManager = new CredentialManager(this);
        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);
        loginURL = credentialManager.getUniversityUrl() + "/AuthenticationService.svc/AuthenticateRequest?username=" + credentialManager.getUserName() + "&Password=" + credentialManager.getPassword();
        this.ctx = getApplicationContext();
        makeNetworkCall();

        findViewById(R.id.backTimeTable).setOnClickListener(onFilterbackTimeTableclickListener);
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
            String getAbsenteesURL = credentialManager.getUniversityUrl() + "/ManagementService.svc/GetStaffLoginAbsenteesSummary?ItemID=1&LevelID=2&Date=2009-03-02";
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

    //    private void setTheAbsenteesScreen(String result) {
////        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.absenteesOverViewItemsCont);
////        linearLayout.removeAllViews();
//        LayoutInflater inflater = LayoutInflater.from(this);
//        try {
//            JSONObject resultJSON = new JSONObject(result);
//            JSONArray dataList = resultJSON.getJSONArray("DataList");
//            for (int i = 0; i < dataList.length(); i++) {
//                JSONObject data = (JSONObject) dataList.get(i);
//                View view = inflater.inflate(R.layout.row_fee_summary_item, linearLayout, false);
////                ((TextView) view.findViewById(R.id.newsTitle)).setText(data.getString("NotificationTitle"));
////                ((TextView) view.findViewById(R.id.newsBody)).setText(data.getString("NotificationDescription"));
//                // set item content in view
//                linearLayout.addView(view);
//            }
//            if (dataList.length() == 0) {
//                ((TextView) findViewById(R.id.newsStatus)).setText("No News to show.");
//            }
//        } catch (Exception ex) {
//
//        }
//
//    }
    // Given a URL, establishes an HttpUrlConnection and retrieves
    // the web page content as a InputStream, which it returns as
    // a string.
    private String downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
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


        // onPostExecute displays the results of the AsyncTask.
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