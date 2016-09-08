package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.Staff.OtherStaffMemoEntryDetailsItem;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffMemoEntryDetails extends StaffAbstractOtherDetails {

    private static final String DEBUG_TAG = "StaffMemoEntryDetails";
    List<OtherStaffMemoEntryDetailsItem> StaffMemoEntryDetailsList;

    public StaffMemoEntryDetails() {
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

                List<OtherStaffMemoEntryDetailsItem> StaffMemoEntryDetailList = StaffMemoEntryDetailsList(resultJSON.getJSONArray("DataList"));


//
//                        "Action": "",
//                        "Activity": "Extra Curicular Activity",
//                        "Description": "Got Microsoft certificate",
//                        "MemoDate": "/Date(1425321000000+0530)/",
//                        "ReportedBy": ""


                for (int i = 0; i < StaffMemoEntryDetailList.size(); i++) {
                    OtherStaffMemoEntryDetailsItem item = StaffMemoEntryDetailList.get(i);

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


    private List<OtherStaffMemoEntryDetailsItem> StaffMemoEntryDetailsList(JSONArray body) {
        List<OtherStaffMemoEntryDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherStaffMemoEntryDetailsItem OtherStaffMemoEntryDetailsItem = new OtherStaffMemoEntryDetailsItem
                        (
                                objectInArray.getString("Action"),
                                objectInArray.getString("Activity"),
                                objectInArray.getString("Description"),
                                objectInArray.getString("MemoDate"),
                                objectInArray.getString("ReportedBy")
                        );
                data.add(OtherStaffMemoEntryDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getattendanceList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetStaffMemoEntry?StaffID=01B5A3AC-3274-44AF-A06F-03D085AB57F7";
    }


}
