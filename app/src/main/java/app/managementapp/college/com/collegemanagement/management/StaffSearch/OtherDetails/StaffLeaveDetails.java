/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.management.StaffSearch.Item.OtherStaffLeaveDetailsItem;
import app.managementapp.college.com.collegemanagement.model.util.Converter;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffLeaveDetails extends StaffAbstractOtherDetails {

    private static final String DEBUG_TAG = "StaffleaveDetails";
    List<OtherStaffLeaveDetailsItem> StaffLeaveDetailsList;

    public StaffLeaveDetails() {
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

                List<OtherStaffLeaveDetailsItem> StaffLeaveDetailList = StaffLeaveDetailsList(resultJSON.getJSONArray("DataList"));

                for (int i = 0; i < StaffLeaveDetailList.size(); i++) {
                    OtherStaffLeaveDetailsItem item = StaffLeaveDetailList.get(i);

                    keys.add("AvailableLeaves");
                    keys.add("IsHalfdayAllowed");
                    keys.add("LeaveID");
                    keys.add("LeaveName");
                    keys.add("MaximumNoOfDays");
                    keys.add("ShortName");
                    keys.add("ApplicationID");
                    keys.add("AppliedByID");
                    keys.add("AppliedByName");
                    keys.add("ApprovalStatus");
                    keys.add("Comment");
                    keys.add("LeaveAppliedDate");
                    keys.add("LeaveDateFrom");
                    keys.add("LeaveDateTo");
                    keys.add("LeaveRequestSentTo");
                    keys.add("LeaveStatusID");
                    keys.add("Reason");
                    keys.add("LateSanctionedBy");
                    keys.add("LeaveDateTo");


                    values.add(item.getAvailableLeaves());
                    values.add(item.getIsHalfdayAllowed());
                    values.add(item.getLeaveID());
                    values.add(item.getLeaveName());
                    values.add(item.getMaximumNoOfDays());
                    values.add(item.getMinimumNoOfDays());
                    values.add(item.getShortName());
                    values.add(String.valueOf(item.getAlternateStaffStatusDetails()));
                    values.add(item.getApplicationID());
                    values.add(item.getAppliedByName());
                    values.add(item.getApprovalStatus());
                    values.add(item.getComment());
                    values.add(item.getLeaveAppliedDate());
                    values.add(item.getLeaveDateFrom());
                    values.add(item.getLeaveDateTo());
                    values.add(item.getLeaveRequestSentTo());
                    values.add(item.getLeaveStatusID());
                    values.add(item.getReason());

                    Log.d(DEBUG_TAG, "init: doing here");
                }


            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//
    }


    private List<OtherStaffLeaveDetailsItem> StaffLeaveDetailsList(JSONArray body) {
        List<OtherStaffLeaveDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherStaffLeaveDetailsItem OtherStaffLeaveDetailsItem = new OtherStaffLeaveDetailsItem
                        (
                                objectInArray.getString("AvailableLeaves"),
                                objectInArray.getString("IsHalfdayAllowed"),
                                objectInArray.getString("LeaveID"),
                                objectInArray.getString("LeaveName"),
                                objectInArray.getString("MaximumNoOfDays"),
                                objectInArray.getString("MinimumNoOfDays"),
                                objectInArray.getString("ShortName"),
                                objectInArray.getString("ApplicationID"),
                                objectInArray.getString("AppliedByID"),
                                objectInArray.getString("AppliedByName"),
                                objectInArray.getString("ApprovalStatus"),
                                objectInArray.getString("Comment"),
                                Converter.retroDateConvert(objectInArray.getString("LeaveAppliedDate")),
                                Converter.retroDateConvert(objectInArray.getString("LeaveDateFrom")),
                                Converter.retroDateConvert(objectInArray.getString("LeaveDateTo")),
                                objectInArray.getString("LeaveRequestSentTo"),
                                objectInArray.getString("LeaveStatusID"),
                                objectInArray.getString("Reason")
                        );
                data.add(OtherStaffLeaveDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getastaffLeaveList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetStaffLeavesApplied?StaffID=87B435AA-DFFE-45F8-92FA-6B4249EFEBFC";
    }


}