package app.managementapp.college.com.collegemanagement.management.StudentSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.OtherAdmissionDetailsItem;

/**
 * Created by Sanjay on 8/30/2016.
 */
public class AdmissionDetails extends AbstractOtherDetails {

    private static final String DEBUG_TAG = "admissionDetails";
    List<OtherAdmissionDetailsItem> admissionDetailsList;

    public AdmissionDetails() {
        super();
    }


    @Override
    public void init(String body) {
        try {
            JSONObject resultJSON = new JSONObject(body);
//            JSONObject getAdmissionDetailsListResult = resultJSON.getJSONObject("GetAdmissionDetails");
                    /*LinearLayout linearLayout = (LinearLayout) findViewById(R.id.studentCont);
                    LayoutInflater inflater = LayoutInflater.from(mContext);*/

            Log.d("resultJSON ", body + "");
            if (resultJSON.getInt("ServiceResult") == 0) {

                List<OtherAdmissionDetailsItem> admissionDetailsList = admissionDetailsList(resultJSON.getJSONArray("DataList"));

                Log.d(DEBUG_TAG, "init: Admission size " + admissionDetailsList.size());


//                String AdmissionMonth;
//                int ApplicationNo;
//                int AdmissionYear;
//                String Branch;
//                String Category;
//                String ComedKNo;
//                int ComedKRank;
//                String Course;
//                String EntranceExam;
//                String Quota;
//                String Sem;

                for (int i = 0; i < admissionDetailsList.size(); i++) {
                    OtherAdmissionDetailsItem item = admissionDetailsList.get(i);

                    keys.add("AdmissionMonth");
                    keys.add("ApplicationNo");
                    keys.add("AdmissionYear");
                    keys.add("Branch");
                    keys.add("Category");
                    keys.add("ComedKNo");
                    keys.add("ComedKRank");
                    keys.add("Course");
                    keys.add("EntranceExam");
                    keys.add("Quota");
                    keys.add("Sem");

                    values.add(item.getAdmissionMonth());
                    values.add(String.valueOf(item.getApplicationNo()));
                    values.add(String.valueOf(item.getAdmissionYear()));
                    values.add(item.getBranch());
                    values.add(item.getCategory());
                    values.add(item.getComedKNo());
                    values.add(String.valueOf(item.getComedKRank()));
                    values.add(item.getCourse());
                    values.add(item.getEntranceExam());
                    values.add(item.getQuota());
                    values.add(item.getSem());

                    Log.d(DEBUG_TAG, "init: doing here");
                }

            } else {


            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//
    }


    private List<OtherAdmissionDetailsItem> admissionDetailsList(JSONArray body) {
        List<OtherAdmissionDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherAdmissionDetailsItem admissionDetailsItem = new OtherAdmissionDetailsItem
                        (
                                objectInArray.getString("AdmissionMonth"),
                                objectInArray.getInt("ApplicationNo"),
                                objectInArray.getInt("AdmissionYear"),
                                objectInArray.getString("Branch"),
                                objectInArray.getString("Category"),
                                objectInArray.getString("ComedKNo"),
                                objectInArray.getInt("ComedKRank"),
                                objectInArray.getString("Course"),
                                objectInArray.getString("EntranceExam"),
                                objectInArray.getString("Quota"),
                                objectInArray.getString("Sem")
                        );
                data.add(admissionDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getattendanceList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetAdmissionDetails?StudentID=10";
    }


}
