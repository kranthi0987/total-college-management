/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.management.StaffSearch.Item.OtherStaffAttendanceDetailsItem;
import app.managementapp.college.com.collegemanagement.model.util.Converter;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffAttendanceDetails extends StaffAbstractOtherDetails {

    private static final String DEBUG_TAG = "StaffattendanceDetails";
    List<OtherStaffAttendanceDetailsItem> StaffattendanceDetailsList;

    public StaffAttendanceDetails() {
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

                List<OtherStaffAttendanceDetailsItem> StaffattendanceDetailList = StaffattendanceDetailsList(resultJSON.getJSONArray("DataList"));

//                        "Date": "/Date(1433874600000+0530)/",
//                        "InTime": "10:04AM",
//                        "IsLateSanctioned": false,
//                        "LateRemark": "Personal",
//                        "LateSanctionedBy": null,
//                        "OutTime": null

                for (int i = 0; i < StaffattendanceDetailList.size(); i++) {
                    OtherStaffAttendanceDetailsItem item = StaffattendanceDetailList.get(i);

                    keys.add("Date");
                    keys.add("InTime");
                    keys.add("IsLateSanctioned");
                    keys.add("LateRemark");
                    keys.add("LateSanctionedBy");
                    keys.add("OutTime");

                    values.add(item.getDate());
                    values.add(item.getInTime());
                    values.add(item.getIsLateSanctioned());
                    values.add(item.getLateRemark());
                    values.add(item.getLateSanctionedBy());
                    values.add(item.getOutTime());


                    Log.d(DEBUG_TAG, "init: doing here");
                }


            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//
    }


    private List<OtherStaffAttendanceDetailsItem> StaffattendanceDetailsList(JSONArray body) {
        List<OtherStaffAttendanceDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherStaffAttendanceDetailsItem OtherStaffattendanceDetailsItem = new OtherStaffAttendanceDetailsItem
                        (
                                Converter.retroDateConvert(objectInArray.getString("Date")),
                                objectInArray.getString("InTime"),
                                objectInArray.getString("IsLateSanctioned"),
                                objectInArray.getString("LateRemark"),
                                objectInArray.getString("LateSanctionedBy"),
                                objectInArray.getString("OutTime")
                        );
                data.add(OtherStaffattendanceDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getstaffattendanceList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetStaffAttendance?StaffID=01B5A3AC-3274-44AF-A06F-03D085AB57F7";
    }


}
