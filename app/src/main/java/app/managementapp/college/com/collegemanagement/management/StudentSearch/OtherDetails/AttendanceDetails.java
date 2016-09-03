package app.managementapp.college.com.collegemanagement.management.StudentSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.OtherAttendanceDetailsItem;

/**
 * Created by Sanjay on 8/30/2016.
 */
public class AttendanceDetails extends AbstractOtherDetails {

    private static final String DEBUG_TAG = "attendanceDetails";
    List<OtherAttendanceDetailsItem> attendanceDetailsList;

    public AttendanceDetails() {
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

                List<OtherAttendanceDetailsItem> attendanceDetailList = attendanceDetailsList(resultJSON.getJSONArray("DataList"));
                //                String Code;
                //                int ID;
                //                String Name;
                ////    String k__BackingField;
                ////    String k__BackingField;
                //                int Held;
                //                String Sem;
                for (int i = 0; i < attendanceDetailList.size(); i++) {
                    OtherAttendanceDetailsItem item = attendanceDetailList.get(i);

                    keys.add("Code");
                    keys.add("ID");
                    keys.add("Name");
                    keys.add("Held");
                    keys.add("Sem");

                    values.add(item.getCode());
                    values.add(String.valueOf(item.getID()));
                    values.add(item.getName());
                    values.add(String.valueOf(item.getHeld()));
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


    private List<OtherAttendanceDetailsItem> attendanceDetailsList(JSONArray body) {
        List<OtherAttendanceDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherAttendanceDetailsItem attendanceDetailsItem = new OtherAttendanceDetailsItem
                        (
                                objectInArray.getString("Code"),
                                objectInArray.getInt("ID"),
                                objectInArray.getString("Name"),
                                objectInArray.getInt("Held"),
                                objectInArray.getString("Sem")
                        );
                data.add(attendanceDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getattendanceList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetAttendanceDetails?StudentID=10";
    }


}