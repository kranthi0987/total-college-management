/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch.Item;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class OtherStaffAttendanceDetailsItem {


//            "Date": "/Date(1433874600000+0530)/",
//            "InTime": "10:04AM",
//            "IsLateSanctioned": false,
//            "LateRemark": "Personal",
//            "LateSanctionedBy": null,
//            "OutTime": null

    String Date;
    String InTime;
    String IsLateSanctioned;
    String LateRemark;
    String LateSanctionedBy;
    String OutTime;

    public OtherStaffAttendanceDetailsItem(
            String Date,
            String InTime,
            String IsLateSanctioned,
            String LateRemark,
            String LateSanctionedBy,
            String OutTime

    ) {
        this.Date = Date;
        this.InTime = InTime;
        this.IsLateSanctioned = IsLateSanctioned;
        this.LateRemark = LateRemark;
        this.LateSanctionedBy = LateSanctionedBy;
        this.OutTime = OutTime;

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getInTime() {
        return InTime;
    }

    public void setInTime(String inTime) {
        InTime = inTime;
    }

    public String getIsLateSanctioned() {
        return IsLateSanctioned;
    }

    public void setIsLateSanctioned(String isLateSanctioned) {
        IsLateSanctioned = isLateSanctioned;
    }

    public String getLateRemark() {
        return LateRemark;
    }

    public void setLateRemark(String lateRemark) {
        LateRemark = lateRemark;
    }

    public String getLateSanctionedBy() {
        return LateSanctionedBy;
    }

    public void setLateSanctionedBy(String lateSanctionedBy) {
        LateSanctionedBy = lateSanctionedBy;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String outTime) {
        OutTime = outTime;
    }

}
