/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.management.StaffSearch.Item.OtherStaffMovementRegisterItem;
import app.managementapp.college.com.collegemanagement.model.util.Converter;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffMovementRegisterDetails extends StaffAbstractOtherDetails {
    private static final String DEBUG_TAG = "StaffmoveRegDetails";
    List<OtherStaffMovementRegisterItem> StaffMovementRegisterDetailsList;

    public StaffMovementRegisterDetails() {
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

                List<OtherStaffMovementRegisterItem> StaffMovementRegisterDetailsList = StaffMovementRegisterDetailsList(resultJSON.getJSONArray("DataList"));
//
//                "Date": "/Date(1433874600000+0530)/",
//                        "Time": "10:04AM
//

                for (int i = 0; i < StaffMovementRegisterDetailsList.size(); i++) {
                    OtherStaffMovementRegisterItem item = StaffMovementRegisterDetailsList.get(i);

                    keys.add("Date");
                    keys.add("Time");


                    values.add(item.getDate());
                    values.add(item.getTime());


                    Log.d(DEBUG_TAG, "init: doing here");
                }


            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//
    }


    private List<OtherStaffMovementRegisterItem> StaffMovementRegisterDetailsList(JSONArray body) {
        List<OtherStaffMovementRegisterItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherStaffMovementRegisterItem OtherStaffMovementRegisterDetailsItem = new OtherStaffMovementRegisterItem
                        (
                                Converter.retroDateConvert(objectInArray.getString("Date")),
                                objectInArray.getString("Time")

                        );
                data.add(OtherStaffMovementRegisterDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getStaffMovenemtList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetStaffMovementRegister?StaffID=01B5A3AC-3274-44AF-A06F-03D085AB57F7&FromDate=1-1-2015&ToDate=12-12-2015";
    }


}
