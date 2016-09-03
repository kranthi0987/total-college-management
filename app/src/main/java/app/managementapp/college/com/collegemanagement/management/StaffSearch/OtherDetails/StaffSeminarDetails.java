package app.managementapp.college.com.collegemanagement.management.StaffSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.Staff.OtherStaffSeminarDetailsItem;


/**
 * Created by Sanjay on 9/2/2016.
 */
public class StaffSeminarDetails extends StaffAbstractOtherDetails {


    private static final String DEBUG_TAG = "StaffSeminarDetails";
    List<OtherStaffSeminarDetailsItem> StaffSeminarDetailsList;

    public StaffSeminarDetails() {
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

                List<OtherStaffSeminarDetailsItem> StaffseminarDetailList = StaffseminarDetailsList(resultJSON.getJSONArray("DataList"));


//                "CertificateName": "Microsoft Certification",
//                        "CertifiedDate": "/Date(1453141800000+0530)/",
//                        "CertifiedFrom": "Microsoft",
//                        "Description": "Creating DB tables with the help of model class",
//                        "EndDateTime": "/Date(1458325800000+0530)/",
//                        "Name": "Code First Technology",
//                        "StartDateTime": "/Date(1458325800000+0530)/",
//                        "Type": "Book Published"


                for (int i = 0; i < StaffseminarDetailList.size(); i++) {
                    OtherStaffSeminarDetailsItem item = StaffseminarDetailList.get(i);

                    keys.add("CertificateName");
                    keys.add("CertifiedDate");
                    keys.add("CertifiedFrom");
                    keys.add("Description");
                    keys.add("EndDateTime");
                    keys.add("Name");
                    keys.add("StartDateTime");
                    keys.add("Type");


                    values.add(item.getCertificateName());
                    values.add(item.getCertifiedDate());
                    values.add(item.getCertifiedFrom());
                    values.add(item.getDescription());
                    values.add(item.getEndDateTime());
                    values.add(item.getName());
                    values.add(item.getStartDateTime());
                    values.add(item.getType());


                    Log.d(DEBUG_TAG, "init: doing here");
                }


            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//
    }


    private List<OtherStaffSeminarDetailsItem> StaffseminarDetailsList(JSONArray body) {
        List<OtherStaffSeminarDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherStaffSeminarDetailsItem OtherStaffseminarDetailsItem = new OtherStaffSeminarDetailsItem
                        (
                                objectInArray.getString("CertificateName"),
                                objectInArray.getString("CertifiedDate"),
                                objectInArray.getString("CertifiedFrom"),
                                objectInArray.getString("Description"),
                                objectInArray.getString("EndDateTime"),
                                objectInArray.getString("Name"),
                                objectInArray.getString("StartDateTime"),
                                objectInArray.getString("Type")
                        );
                data.add(OtherStaffseminarDetailsItem);
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
