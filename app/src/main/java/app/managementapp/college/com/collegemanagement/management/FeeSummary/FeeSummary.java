package app.managementapp.college.com.collegemanagement.management.FeeSummary;

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
import android.widget.ImageView;
import android.widget.Toast;

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

import app.managementapp.college.com.collegemanagement.LoginActivity;
import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.adapters.FeeSummaryAdapter;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;
import app.managementapp.college.com.collegemanagement.model.FeeSummaryItem;
import app.managementapp.college.com.collegemanagement.model.GlobalData;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;
import app.managementapp.college.com.collegemanagement.util.ErrorToaster;

public class FeeSummary extends AppCompatActivity {


    private static final String DEBUG_TAG = "FeeSummary";
    public List<String> levelIds = new ArrayList<String>();
    public Integer level;
    public FrameLayout progressBarHolder;
    public CredentialManager credentialManager;
    public String loginURL;
    FeeSummaryAdapter feeSummaryAdapter;
    Context ctx;
    Exception error;
    View.OnClickListener onFilterbackTimeTableclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(DEBUG_TAG, "onClick: onFilterbackTimeTableclickListener");
            backNavigator();
        }
    };
    private RecyclerView recyclerView;

    @Override
    public void onBackPressed() {
        Log.d("onBackPressed", "onBackPressed: ");
        backNavigator();
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
        Intent i = new Intent(FeeSummary.this, ManagementHome.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_summary);

        ctx = this;
        credentialManager = new CredentialManager(ctx);

        level = 1;
        levelIds.add("0");

        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);
        loginURL = credentialManager.getUniversityUrl() + "/AuthenticationService.svc/AuthenticateRequest?username=" + credentialManager.getUserName() + "&Password=" + credentialManager.getPassword();

        makeNetworkCall();

        // Setup Controls
        ((ImageView) findViewById(R.id.backTimeTable)).setOnClickListener(onFilterbackTimeTableclickListener);


    }


    public boolean isNetworkAvailable() {
        ConnectivityManager connMgr = (ConnectivityManager)
                ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) return true;
        return false;
    }

    public void makeNetworkCall() {
        // Make network call
        if (isNetworkAvailable()) {
            String getFeeSummary = credentialManager.getUniversityUrl() + "/FinanceService.svc/GetFeeSummary?ItemId=" +
                    levelIds.get(levelIds.size() - 1) + "&levelId=" + level;
            Log.d(DEBUG_TAG, "makeNetworkCall: url: " + getFeeSummary);
            progressBarHolder.setVisibility(View.VISIBLE);
            new FeeSummaryTask().execute(loginURL, getFeeSummary);
        } else {
            Toast.makeText(ctx, "Network not available.", Toast.LENGTH_SHORT).show();

        }
    }


    private List<FeeSummaryItem> getFeeSummaryList(JSONArray dataList) {
        List<FeeSummaryItem> data = new ArrayList<>();
        for (int i = 0, size = dataList.length(); i < size; i++) {
            try {
                JSONObject objectInArray = dataList.getJSONObject(i);
                FeeSummaryItem feeSummaryItem = new FeeSummaryItem(objectInArray.getInt("CurrentLevel"), objectInArray.getString("FeeDemand"), objectInArray.getString("FeeDue"),
                        objectInArray.getString("FeePaid"), objectInArray.getString("ItemType"), objectInArray.getString("ItemTypeID"), objectInArray.getInt("isChildAvailable"));
                data.add(feeSummaryItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getFeeSummaryList: " + e.getMessage());
            }
        }
        return data;
    }


    public void setFeeSummary(List<FeeSummaryItem> feeSummaryList) {
        recyclerView = (RecyclerView) findViewById(R.id.studentCont);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        feeSummaryAdapter = new FeeSummaryAdapter(this.ctx, feeSummaryList);
        recyclerView.setAdapter(feeSummaryAdapter);
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

    // Network code
    private class FeeSummaryTask extends AsyncTask<String, Void, String> {
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
                    i = new Intent(FeeSummary.this, LoginActivity.class);

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

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            progressBarHolder.setVisibility(View.GONE);
            try {
                Log.e("result: ", result);
                JSONObject resultJSON = new JSONObject(result);
                if (resultJSON.getInt("ServiceResult") == 0) {
                    Log.d(DEBUG_TAG, "onPostExecute: from network");
                    List<FeeSummaryItem> studentsList = getFeeSummaryList(resultJSON.getJSONArray("DataList"));
                    Log.d(DEBUG_TAG, "studentsList: " + studentsList.size());
                    setFeeSummary(studentsList);
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
    }

}
