package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import java.util.List;

import app.managementapp.college.com.collegemanagement.LoginActivity;
import app.managementapp.college.com.collegemanagement.R;
import app.managementapp.college.com.collegemanagement.management.ManagementHome;
import app.managementapp.college.com.collegemanagement.model.GlobalData;
import app.managementapp.college.com.collegemanagement.util.CredentialManager;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffCommonOtherDetails extends AppCompatActivity {

    private static final String DEBUG_TAG = "CommonOtherDetails";
    public StaffAbstractOtherDetails commonClass;
    FrameLayout progressBarHolder;
    Exception error;
    Context ctx;
    String loginURL = "";
    private CredentialManager credentialManager;

    @Override
    public void onBackPressed() {
        Log.d("onBackPressed", "onBackPressed: ");
        moveToLanding();

    }

    private void moveToLanding() {
        Intent i = new Intent(StaffCommonOtherDetails.this, ManagementHome.class);
        startActivity(i);
        finish();
    }

    private void clickSetup() {
        View.OnClickListener onFilterbackTimeTableclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(DEBUG_TAG, "onClick: onFilterbackTimeTableclickListener");
                moveToLanding();
            }
        };
        ImageView backTimeTable = (ImageView) findViewById(R.id.backTimeTable);
        backTimeTable.setOnClickListener(onFilterbackTimeTableclickListener);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_common_other_details);
        credentialManager = new CredentialManager(this);
        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);

        Intent i2 = getIntent();
        Integer CommonClassCase = i2.getIntExtra("case1", 2);
// i.getExtras().getParcelable("data");
//                    = (Integer) i.getIntExtra("admission", 6);
//            Integer studentId = (Integer) i.getIntExtra("studentId", 0);
//            DataList datalist= i.getParcelableExtra("data");
//            Integer number=i.getIntExtra("case",0)
//            datalist.getID(i);


        switch (CommonClassCase) {
            case 1:
                commonClass = new StaffAttendanceDetails();
                break;
            case 2:
                commonClass = new StaffFeedbackDetails();
                break;
//            case 3:
//                commonClass = new StaffLeaveDetails();
//                break;
            case 4:
                commonClass = new StaffMemoEntryDetails();
                break;
            case 5:
                commonClass = new StaffMovementRegisterDetails();
                break;
            case 6:
                commonClass = new StaffSeminarDetails();
                break;
            default:
                commonClass = new StaffAbstractOtherDetails();
                break;
        }
        clickSetup();
        makeNetworkCall();
    }

    public void fillUpTheScreen(List<String> keys, List<String> values) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.otherstaffDetailsItemsCont);
        linearLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        try {
            if (keys.size() == values.size()) {
                for (int i = 0; i < keys.size(); i++) {
                    View view = inflater.inflate(R.layout.row_staff_other_details_item, linearLayout, false);
                    ((TextView) view.findViewById(R.id.otherstaffDetailKey)).setText(keys.get(i));
                    ((TextView) view.findViewById(R.id.otherstaffDetailValue)).setText(values.get(i));
                    // set item content in view
                    linearLayout.addView(view);
                    Log.d(DEBUG_TAG, "fillUpTheScreen: Adding");
                }
            } else {
                Log.d(DEBUG_TAG, "fillUpTheScreen: you are not adding keys n values correctly");
            }

        } catch (Exception ex) {

        }


    }

    private void makeNetworkCall() {
        // Make network call
        if (isNetworkAvailable()) {
//            String GetFeePaymentDetails = credentialManager.getUniversityUrl() + "/ManagementService.svc/GetFeePaymentDetails?StudentID=10";
//            Log.d(DEBUG_TAG, "makeNetworkCall: url: " + GetFeePaymentDetails);
            progressBarHolder.setVisibility(View.VISIBLE);
            new CommonOthersDetailsTask().execute(loginURL, credentialManager.getUniversityUrl() + commonClass.getURL(""));
        } else {
            Toast.makeText(this, "Network not available.", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connMgr = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) return true;
        return false;
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
            CredentialManager credentialManager = new CredentialManager(this);
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
            Log.d("", "error is --: " + e.toString());
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
        BufferedReader r = new BufferedReader(reader);
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line);
        }
        return total.toString();
    }

    // Network code
    private class CommonOthersDetailsTask extends AsyncTask<String, Void, String> {
        private JSONArray dataList;

        public void useLoginToken(String result) {
            try {
                JSONObject resultJSON = new JSONObject(result);
                Log.d("resultJSON ", result + "");
                Intent i;
                if (resultJSON.getInt("ServiceResult") == 0) {
                    Time requestInitiatedTime = new Time();
                    GlobalData globalData = new GlobalData();
                    globalData.setLastNetworkCall(requestInitiatedTime);
                    globalData.setToken(resultJSON.getString("Token"));
                    credentialManager.setToken(resultJSON.getString("Token"));
                    Log.d(DEBUG_TAG, "The token is: " + resultJSON.getString("Token"));
                } else {
                    Log.d(DEBUG_TAG, "onPostExecute: The user is not valid ==> used: " + credentialManager.getUserName() +
                            ", password: " + credentialManager.getPassword());
                    i = new Intent(StaffCommonOtherDetails.this, LoginActivity.class);

                    startActivity(i);
                    // kill current activity
                    finish();
                }
            } catch (Throwable t) {
                Log.e("JSON error", t.getMessage() + " Could not parse malformed JSON: \"" + result + "\"");
            }
        }

        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                GlobalData globalData = new GlobalData();
                useLoginToken(downloadUrl(urls[0]));
                return downloadUrl(urls[1]);
            } catch (Exception e) {
                Log.d(DEBUG_TAG, "The response is: " + e.toString());
//                return "Unable to retrieve web page. URL may be invalid.";
                return "yesss " + e.getMessage();
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            progressBarHolder.setVisibility(View.GONE);
//            if(result.startsWith("yesss")) Toast.makeText(this, result, Toast.LENGTH_LONG).show();
//            credentialManager = new CredentialManager(this);
            try {
                JSONObject resultJSON = new JSONObject(result);
                if (resultJSON.getInt("ServiceResult") == 0) {
                    Log.d(DEBUG_TAG, "onPostExecute: " + result);

                    commonClass.init(result);
                    fillUpTheScreen(commonClass.getKeys(), commonClass.getValues());
                    Log.d(DEBUG_TAG, "onPostExecute: from network");
                } else {

                }
            } catch (Exception t) {
//                Toast.makeText(this, "JSON exception" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("JSON error", t + " Could not parse malformed JSON: \"" + result + "\"");
            }
            /*Intent i = new Intent(LoginActivity.this, LandingDrawer.class);
            startActivity(i);*/
        }
    }

}

