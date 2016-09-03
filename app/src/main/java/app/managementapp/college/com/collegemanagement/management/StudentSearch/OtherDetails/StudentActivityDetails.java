package app.managementapp.college.com.collegemanagement.management.StudentSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.OtherStudentActivityDetailsItem;

/**
 * Created by Sanjay on 8/30/2016.
 */
public class StudentActivityDetails extends AbstractOtherDetails {

    private static final String DEBUG_TAG = "studentDetails";
    List<OtherStudentActivityDetailsItem> studentActivityDetailsList;

    public StudentActivityDetails() {
        super();
    }


    @Override
    public void init(String body) {
        try {
            JSONObject resultJSON = new JSONObject(body);
//            JSONObject getStudentActivityDetailsListResult = resultJSON.getJSONObject("GetStudentActivities");
                    /*LinearLayout linearLayout = (LinearLayout) findViewById(R.id.studentCont);
                    LayoutInflater inflater = LayoutInflater.from(mContext);*/

            Log.d("resultJSON ", body + "");
            if (resultJSON.getInt("ServiceResult") == 0) {

                List<OtherStudentActivityDetailsItem> studentActivityDetailList = studentActivityDetailsList(resultJSON.getJSONArray("DataList"));
                for (int i = 0; i < studentActivityDetailList.size(); i++) {
                    OtherStudentActivityDetailsItem item = studentActivityDetailList.get(i);


//            "Action": "",
//            "Activity": "Extra Curicular Activity",
//            "Description": "Got Best Student Award",
//            "MemoDate": "/Date(1463682600000+0530)/",
//            "ReportedBy": "Meera"


                    keys.add("Action");
                    keys.add("Activity");
                    keys.add("Description");
                    keys.add("MemoDate");
                    keys.add("ReportedBy");

                    values.add(item.getAction());
                    values.add(item.getActivity());
                    values.add(item.getDescription());
                    values.add(item.getMemoDate());
                    values.add(item.getReportedBy());

                    Log.d(DEBUG_TAG, "init: doing here");
                }
            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//


    }


    private List<OtherStudentActivityDetailsItem> studentActivityDetailsList(JSONArray body) {
        List<OtherStudentActivityDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherStudentActivityDetailsItem studentActivityDetailsItem = new OtherStudentActivityDetailsItem
                        (
                                objectInArray.getString("Action"),
                                objectInArray.getString("Activity"),
                                objectInArray.getString("Description"),
                                objectInArray.getString("MemoDate"),
                                objectInArray.getString("ReportedBy")
                        );
                data.add(studentActivityDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getattendanceList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetStudentActivities?StudentID=10";
    }

}