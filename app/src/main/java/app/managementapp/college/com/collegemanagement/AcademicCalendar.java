package app.managementapp.college.com.collegemanagement;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.adapters.AcademicCalendarAdapter;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;
import app.managementapp.college.com.collegemanagement.model.AcademicCalendarItem;
import app.managementapp.college.com.collegemanagement.model.GlobalData;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import app.managementapp.college.com.collegemanagement.util.ErrorToaster;

/**
 * Created by Sanjay on 8/27/2016.
 */
public class AcademicCalendar extends AppCompatActivity {
    private static final String DEBUG_TAG = "AcademicCalendar";
    Context ctx;
    FrameLayout progressBarHolder;
    String loginURL = "";
    Exception error;
    List<AcademicCalendarItem> academiccalendarlist;
    View.OnClickListener onFilterbackclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: onFilterbackTimeTableclickListener");
            moveToLanding();
        }
    };
    private RecyclerView recyclerView;
    private CredentialManager credentialManager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onBackPressed() {


        moveToLanding();


    }

    private void moveToLanding() {
        Intent i = new Intent(AcademicCalendar.this, ManagementHome.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);
        ctx = this;
        credentialManager = new CredentialManager(ctx);
        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);
        loginURL = credentialManager.getUniversityUrl() + "/AuthenticationService.svc/AuthenticateRequest?username=" + credentialManager.getUserName() + "&Password=" + credentialManager.getPassword();
        ((ImageView) findViewById(R.id.backTimeTable)).setOnClickListener(onFilterbackclickListener);
        makeNetworkCall();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    private void makeNetworkCall() {
//         Make network call
        if (isNetworkAvailable()) {
            String getacademiccalendar = credentialManager.getUniversityUrl() + "/ManagementService.svc/GetAcademicCalendar";
//            String getLeavetype = credentialManager.getUniversityUrl() + "/StaffAttendanceService.svc/GetLeavetype";
            Log.d(DEBUG_TAG, "makeNetworkCall: url: " + getacademiccalendar);
            progressBarHolder.setVisibility(View.VISIBLE);
            new AcademicCalendarTask().execute(loginURL, getacademiccalendar);
        } else {
            Toast.makeText(ctx, "Network not available.", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connMgr = (ConnectivityManager)
                ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) return true;
        return false;
    }

    private List<AcademicCalendarItem> getAcademicCalendarList(JSONArray dataList) {
        List<AcademicCalendarItem> data = new ArrayList<>();
        for (int i = 0, size = dataList.length(); i < size; i++) {
            try {
                JSONObject objectInArray = dataList.getJSONObject(i);
                AcademicCalendarItem academicCalendarItem = new AcademicCalendarItem(objectInArray.getInt("AccademicYear"),
                        objectInArray.getString("Branch"),
                        objectInArray.getInt("BranchID"),
                        objectInArray.getString("Course"),
                        objectInArray.getInt("CourseID"),
                        objectInArray.getString("EndDate"),
                        objectInArray.getString("Event"),
                        objectInArray.getString("EventType"),
                        objectInArray.getString("Sem"),
                        objectInArray.getString("StartDate"));
                data.add(academicCalendarItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getFeeSummaryList: " + e.getMessage());
            }
        }
        return data;
    }

    public void setAcademicCalendar(List<AcademicCalendarItem> academiccalendarlist) {
        recyclerView = (RecyclerView) findViewById(R.id.academiccalendar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new AcademicCalendarAdapter(this.ctx, academiccalendarlist));

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AcademicCalendar Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://app.managementapp.college.com.collegemanagement/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AcademicCalendar Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://app.managementapp.college.com.collegemanagement/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private class AcademicCalendarTask extends AsyncTask<String, Void, String> {
        private JSONArray dataList;


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
                    i = new Intent(AcademicCalendar.this, LoginActivity.class);

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
        protected void onPostExecute(String result) {
            progressBarHolder.setVisibility(View.GONE);
            try {
                Log.e("result: ", result);
                JSONObject resultJSON = new JSONObject(result);
                if (resultJSON.getInt("ServiceResult") == 0) {
                    Log.d(DEBUG_TAG, "onPostExecute: from network");
                    academiccalendarlist = getAcademicCalendarList(resultJSON.getJSONArray("DataList"));
                    Log.d(DEBUG_TAG, "Academic Calendar: " + academiccalendarlist.size());
                    setAcademicCalendar(academiccalendarlist);
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
                CredentialManager credentialManager = new CredentialManager(ctx);
//            GlobalData globalData = new GlobalData();
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

        public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
        /*char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);*/
            BufferedReader r = new BufferedReader(reader);
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            return total.toString();
        }


    }
}
