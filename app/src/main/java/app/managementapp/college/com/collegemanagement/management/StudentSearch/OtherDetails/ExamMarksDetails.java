/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentSearch.OtherDetails;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.managementapp.college.com.collegemanagement.management.StudentSearch.Item.OtherExamMarksDetailsItem;
import app.managementapp.college.com.collegemanagement.model.util.Converter;

/**
 * Created by Sanjay on 8/30/2016.
 */
public class ExamMarksDetails extends AbstractOtherDetails {

    private static final String DEBUG_TAG = "attendanceDetails";
    List<OtherExamMarksDetailsItem> ExamMarksDetailsList;

    public ExamMarksDetails() {
        super();
    }


    @Override
    public void init(String body) {
        try {
            JSONObject resultJSON = new JSONObject(body);
//            JSONObject getExamMarksDetailsListResult = resultJSON.getJSONObject("GetExamMark");
                    /*LinearLayout linearLayout = (LinearLayout) findViewById(R.id.studentCont);
                    LayoutInflater inflater = LayoutInflater.from(mContext);*/

            Log.d("resultJSON ", body + "");
            if (resultJSON.getInt("ServiceResult") == 0) {

                List<OtherExamMarksDetailsItem> examMarksDetailsList = examMarksDetailsList(resultJSON.getJSONArray("DataList"));
                for (int i = 0; i < examMarksDetailsList.size(); i++) {
                    OtherExamMarksDetailsItem item = examMarksDetailsList.get(i);
                    //              "Code": "MA101",
                    ////            "ID": 0,
                    ////            "Name": "Financial Accounting",
                    ////            "Batch": 2013,
                    ////            "Credit": 4,
                    ////            "ExternalMark": 0,
                    ////            "Grade": null,
                    ////            "GradePoint": 0,
                    ////            "InternalMark": 0,
                    ////            "MaxMark": 0,
                    ////            "Result": true,
                    ////            "ResultDate": "/Date(1427805420000+0530)/",
                    ////            "Sem": "Term I",
                    ////            "TotalMark": 0

                    keys.add("Code");
                    keys.add("ID");
                    keys.add("Name");
                    keys.add("Batch");
                    keys.add("Credit");
                    keys.add("Grade");
                    keys.add("GradePoint");
                    keys.add("InternalMark");
                    keys.add("MaxMark");
                    keys.add("Result");
                    keys.add("ResultDate");
                    keys.add("Sem");
                    keys.add("TotalMark");

                    values.add(item.getCode());
                    values.add(String.valueOf(item.getID()));
                    values.add(item.getName());
                    values.add(String.valueOf(item.getBatch()));
                    values.add(String.valueOf(item.getCredit()));
                    values.add(item.getGrade());
                    values.add(String.valueOf(item.getGradePoint()));
                    values.add(String.valueOf(item.getInternalMark()));
                    values.add(String.valueOf(item.getMaxMark()));
                    values.add(item.getResult());
                    values.add(item.getResultDate());
                    values.add(item.getSem());
                    values.add(String.valueOf(item.getTotalMark()));

                    Log.d(DEBUG_TAG, "init: doing here");
                }
            } else {

            }
        } catch (Exception t) {
            Log.e("JSON error", t + "");
        }


    }


    private List<OtherExamMarksDetailsItem> examMarksDetailsList(JSONArray body) {
        List<OtherExamMarksDetailsItem> data = new ArrayList<>();
        for (int i = 0, size = body.length(); i < size; i++) {
            try {
                JSONObject objectInArray = body.getJSONObject(i);
                OtherExamMarksDetailsItem examMarksDetailsItem = new OtherExamMarksDetailsItem
                        (
                                objectInArray.getString("Code"),
                                objectInArray.getInt("ID"),
                                objectInArray.getInt("Batch"),
                                objectInArray.getString("Name"),
                                objectInArray.getInt("Credit"),
                                objectInArray.getInt("ExternalMark"),
                                objectInArray.getString("Grade"),
                                objectInArray.getInt("GradePoint"),
                                objectInArray.getInt("InternalMark"),
                                objectInArray.getInt("MaxMark"),
                                objectInArray.getString("Result"),
                                objectInArray.getInt("TotalMark"),
                                Converter.retroDateConvert(objectInArray.getString("ResultDate")),
                                objectInArray.getString("Sem")
                        );
                data.add(examMarksDetailsItem);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "getexammarksList: " + e.getMessage());
            }
        }
        return data;
    }

    public String getURL(String id) {
        return "/ManagementService.svc/GetExamMark?StudentID=10";
    }


}