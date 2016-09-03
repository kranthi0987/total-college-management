package app.managementapp.college.com.collegemanagement.management.StudentSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.model.OtherQualificationDetailsItem;

/**
 * Created by Sanjay on 8/30/2016.
 */
public class QualificationDetails extends AbstractOtherDetails {

    private static final String DEBUG_TAG = "qualificationDetails";
    List<OtherQualificationDetailsItem> qualificationDetailsList;

    public QualificationDetails() {
        super();
    }


    @Override
    public void init(String body) {
        try {
            JSONObject resultJSON = new JSONObject(body);
//            JSONObject getQualificationDetailsListResult = resultJSON.getJSONObject("GetQualificationDetails");
                    /*LinearLayout linearLayout = (LinearLayout) findViewById(R.id.studentCont);
                    LayoutInflater inflater = LayoutInflater.from(mContext);*/

            Log.d("resultJSON ", body + "");
            if (resultJSON.getInt("ServiceResult") == 0) {

                List<OtherQualificationDetailsItem> qualificationDetailList = qualificationDetailsList(resultJSON.getJSONArray("DataList"));
                for (int i = 0; i < qualificationDetailList.size(); i++) {
                    OtherQualificationDetailsItem item = qualificationDetailList.get(i);
//                    String Board;
//                    int PCMPercent;
//                    int TotalPercent;
//                    String College;
//                    int SSLCorSSCPercent;
//                    int QualifyingCourse;
//                    int USN;

                    keys.add("Board");
                    keys.add("PCMPercent");
                    keys.add("TotalPercent");
                    keys.add("College");
                    keys.add("SSLCorSSCPercent");
                    keys.add("QualifyingCourse");
                    keys.add("USN");

                    values.add(item.getBoard());
                    values.add(String.valueOf(item.getPCMPercent()));
                    values.add(String.valueOf(item.getTotalPercent()));
                    values.add(item.getCollege());
                    values.add(String.valueOf(item.getSSLCorSSCPercent()));
                    values.add(String.valueOf(item.getQualifyingCourse()));
                    values.add(String.valueOf(item.getUSN()));


                    Log.d(DEBUG_TAG, "init: doing here");
                }

            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }
//

    }


    private List<OtherQualificationDetailsItem> qualificationDetailsList(JSONArray body) {
        List<OtherQualificationDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherQualificationDetailsItem qualificationDetailsItem = new OtherQualificationDetailsItem
                        (
                                objectInArray.getString("Board"),
                                objectInArray.getInt("PCMPercent"),
                                objectInArray.getInt("TotalPercent"),
                                objectInArray.getString("College"),
                                objectInArray.getInt("SSLCorSSCPercent"),
                                objectInArray.getInt("TotalPercent"),
                                objectInArray.getInt("USN")
                        );
                data.add(qualificationDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getQualificationdeatils: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetAttendanceDetails?StudentID=10";
    }


}