/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.management.StudentSearch.Item;

/**
 * Created by Sanjay on 8/31/2016.
 */
public class OtherAdmissionDetailsItem {
//    "AdmissionMonth": 0,
//            "AdmissionYear": 2013,
//            "ApplicationNo": "107247",
//            "Branch": "Br - CSE",
//            "Category": "MQ/NRI",
//            "ComedKNo": "JEE-13-10019",
//            "ComedKRank": 0,
//            "Course": "Post Graduate Diploma in Management",
//            "EntranceExam": "Joint Entrance Examination",
//            "Quota": "DASA SAARC",
//            "Sem": "Term I"


    String AdmissionMonth;
    int ApplicationNo;
    int AdmissionYear;
    String Branch;
    String Category;
    String ComedKNo;
    int ComedKRank;
    String Course;
    String EntranceExam;
    String Quota;
    String Sem;

    public OtherAdmissionDetailsItem(
            String AdmissionMonth,
            int ApplicationNo,
            int AdmissionYear,
            String Branch,
            String Category,
            String ComedKNo,
            int ComedKRank,
            String Course,
            String EntranceExam,
            String Quota,
            String Sem
    ) {

        this.AdmissionMonth = AdmissionMonth;
        this.ApplicationNo = ApplicationNo;
        this.AdmissionYear = AdmissionYear;
        this.Branch = Branch;
        this.Category = Category;
        this.ComedKNo = ComedKNo;
        this.ComedKRank = ComedKRank;
        this.Course = Course;
        this.EntranceExam = EntranceExam;
        this.Quota = Quota;
        this.Sem = Sem;
    }

    public String getSem() {
        return Sem;
    }

    public void setSem(String sem) {
        Sem = sem;
    }

    public String getQuota() {

        return Quota;
    }

    public void setQuota(String quota) {
        Quota = quota;
    }

    public String getEntranceExam() {

        return EntranceExam;
    }

    public void setEntranceExam(String entranceExam) {
        EntranceExam = entranceExam;
    }

    public String getCourse() {

        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public int getComedKRank() {

        return ComedKRank;
    }

    public void setComedKRank(int comedKRank) {
        ComedKRank = comedKRank;
    }

    public String getComedKNo() {

        return ComedKNo;
    }

    public void setComedKNo(String comedKNo) {
        ComedKNo = comedKNo;
    }

    public String getCategory() {

        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getBranch() {

        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public int getAdmissionYear() {

        return AdmissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        AdmissionYear = admissionYear;
    }

    public int getApplicationNo() {

        return ApplicationNo;
    }

    public void setApplicationNo(int applicationNo) {
        ApplicationNo = applicationNo;
    }

    public String getAdmissionMonth() {
        return AdmissionMonth;
    }

    public void setAdmissionMonth(String admissionMonth) {
        AdmissionMonth = admissionMonth;
    }
}
