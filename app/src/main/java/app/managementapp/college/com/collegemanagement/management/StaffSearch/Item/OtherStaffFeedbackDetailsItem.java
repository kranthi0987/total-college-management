/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StaffSearch.Item;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class OtherStaffFeedbackDetailsItem {

//            "AppraisalDate": "/Date(1451759400000+0530)/",
//            "Department": "Dept - CSE",
//            "EmpCode": "CS001",
//            "EmpName": "Dr. K.Ramesh",
//            "MaxPoint": 100,
//            "Percentage": 80,
//            "SubName": "DATA STRUCTURES AND ALGORITHMS",
//            "TotalPoint": 80

    String AppraisalDate;
    String Department;
    String EmpCode;
    String EmpName;
    int MaxPoint;
    int Percentage;
    String SubName;
    int TotalPoint;

    public OtherStaffFeedbackDetailsItem(
            String AppraisalDate,
            String Department,
            String EmpCode,
            String EmpName,
            int MaxPoint,
            int Percentage,
            String SubName,
            int TotalPoint

    ) {
        this.AppraisalDate = AppraisalDate;
        this.Department = Department;
        this.EmpCode = EmpCode;
        this.EmpName = EmpName;
        this.MaxPoint = MaxPoint;
        this.Percentage = Percentage;
        this.SubName = SubName;
        this.TotalPoint = TotalPoint;


    }

    public String getAppraisalDate() {
        return AppraisalDate;
    }

    public void setAppraisalDate(String appraisalDate) {
        AppraisalDate = appraisalDate;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getEmpCode() {
        return EmpCode;
    }

    public void setEmpCode(String empCode) {
        EmpCode = empCode;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public int getMaxPoint() {
        return MaxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        MaxPoint = maxPoint;
    }

    public int getPercentage() {
        return Percentage;
    }

    public void setPercentage(int percentage) {
        Percentage = percentage;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    public int getTotalPoint() {
        return TotalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        TotalPoint = totalPoint;
    }
 }
