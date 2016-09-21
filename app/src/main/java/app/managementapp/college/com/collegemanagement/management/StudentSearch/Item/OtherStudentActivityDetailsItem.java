/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentSearch.Item;

/**
 * Created by Sanjay on 8/31/2016.
 */
public class OtherStudentActivityDetailsItem {


    //            "Action": "",
//            "Activity": "Extra Curicular Activity",
//            "Description": "Got Best Student Award",
//            "MemoDate": "/Date(1463682600000+0530)/",
//            "ReportedBy": "Meera"
    String Action;
    String Activity;
    String Description;
    String MemoDate;
    String ReportedBy;

    public OtherStudentActivityDetailsItem(
            String Action,
            String Activity,
            String Description,
            String MemoDate,
            String ReportedBy
    ) {

        this.Action = Action;
        this.Activity = Activity;
        this.Description = Description;
        this.MemoDate = MemoDate;
        this.ReportedBy = ReportedBy;

    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMemoDate() {
        return MemoDate;
    }

    public void setMemoDate(String memoDate) {
        MemoDate = memoDate;
    }

    public String getReportedBy() {
        return ReportedBy;
    }

    public void setReportedBy(String reportedBy) {
        ReportedBy = reportedBy;
    }
}
