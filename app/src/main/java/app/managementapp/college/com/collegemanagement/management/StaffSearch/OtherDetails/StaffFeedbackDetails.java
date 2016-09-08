package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.Staff.OtherStaffFeedbackDetailsItem;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffFeedbackDetails extends StaffAbstractOtherDetails {


    private static final String DEBUG_TAG = "StafffeedbackDetails";
    List<OtherStaffFeedbackDetailsItem> StaffFeedbackDetailsList;

    public StaffFeedbackDetails() {
        super();
    }


    @Override
    public void init(String body) {
        try {
            JSONObject resultJSON = new JSONObject(body);
//            JSONObject getAttendanceDetailsListResult = resultJSON.getJSONObject("GetAttendanceDetails");
                    /*LinearLayout linearLayout = (LinearLayout) findViewById(R.id.studentCont);
                    LayoutInflater inflater = LayoutInflater.from(mContext);*/

            Log.d("resultJSON ", body + "");
            if (resultJSON.getInt("ServiceResult") == 0) {

                List<OtherStaffFeedbackDetailsItem> StaffFeedbackDetailsList = StaffFeedbackDetailsList(resultJSON.getJSONArray("DataList"));


//                "AppraisalDate": "/Date(1451759400000+0530)/",
//                        "Department": "Dept - CSE",
//                        "EmpCode": "CS001",
//                        "EmpName": "Dr. K.Ramesh",
//                        "MaxPoint": 100,
//                        "Percentage": 80,
//                        "SubName": "DATA STRUCTURES AND ALGORITHMS",
//                        "TotalPoint": 80


                for (int i = 0; i < StaffFeedbackDetailsList.size(); i++) {
                    OtherStaffFeedbackDetailsItem item = StaffFeedbackDetailsList.get(i);

                    keys.add("AppraisalDate");
                    keys.add("Department");
                    keys.add("EmpCode");
                    keys.add("EmpName");
                    keys.add("MaxPoint");
                    keys.add("Percentage");
                    keys.add("SubName");
                    keys.add("TotalPoint");

                    values.add(item.getAppraisalDate());
                    values.add(item.getDepartment());
                    values.add(item.getEmpCode());
                    values.add(item.getEmpName());
                    values.add(String.valueOf(item.getMaxPoint()));
                    values.add(String.valueOf(item.getPercentage()));
                    values.add(item.getSubName());
                    values.add(String.valueOf(item.getTotalPoint()));


                    Log.d(DEBUG_TAG, "init: doing here");
                }


            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//
    }


    private List<OtherStaffFeedbackDetailsItem> StaffFeedbackDetailsList(JSONArray body) {
        List<OtherStaffFeedbackDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherStaffFeedbackDetailsItem OtherStaffFeedbackDetailsItem = new OtherStaffFeedbackDetailsItem
                        (
                                objectInArray.getString("AppraisalDate"),
                                objectInArray.getString("Department"),
                                objectInArray.getString("EmpCode"),
                                objectInArray.getString("EmpName"),
                                objectInArray.getInt("MaxPoint"),
                                objectInArray.getInt("Percentage"),
                                objectInArray.getString("SubName"),
                                objectInArray.getInt("TotalPoint")

                        );
                data.add(OtherStaffFeedbackDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getfeedbackList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetStaffFeedback?StaffId=01B5A3AC-3274-44AF-A06F-03D085AB57F7\n";
    }


}
