package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.Staff.OtherStaffLeaveDetailsItem;

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

                    keys.add("");
                    keys.add("");
                    keys.add("");
                    keys.add("");
                    keys.add("");
                    keys.add("");

                    values.add(item.getAlternateStaffName());


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
                                objectInArray.getString("LeaveAppliedDate"),
                                objectInArray.getString("LeaveDateFrom"),
                                objectInArray.getString("LeaveDateTo"),
                                objectInArray.getString("LeaveRequestSentTo"),
                                objectInArray.getString("LeaveStatusID"),
                                objectInArray.getString("Reason"),
                                objectInArray.getString("LateSanctionedBy"),
                                objectInArray.getString("LateSanctionedBy"),
                                objectInArray.getString("LateSanctionedBy")
                        );
                data.add(OtherStaffLeaveDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getattendanceList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetStaffAttendance?StaffID=01B5A3AC-3274-44AF-A06F-03D085AB57F7\n";
    }


}