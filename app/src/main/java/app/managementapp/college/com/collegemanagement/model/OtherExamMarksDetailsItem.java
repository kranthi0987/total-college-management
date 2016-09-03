package app.managementapp.college.com.collegemanagement.model;

/**
 * Created by Sanjay on 8/31/2016.
 */
public class OtherExamMarksDetailsItem {


    //    "Code": "MA101",
//            "ID": 0,
//            "Name": "Financial Accounting",
//            "Batch": 2013,
//            "Credit": 4,
//            "ExternalMark": 0,
//            "Grade": null,
//            "GradePoint": 0,
//            "InternalMark": 0,
//            "MaxMark": 0,
//            "Result": true,
//            "ResultDate": "/Date(1427805420000+0530)/",
//            "Sem": "Term I",
//            "TotalMark": 0
    String Code;
    int ID;
    int Batch;
    String Name;
    int Credit;
    int ExternalMark;
    String Grade;
    int GradePoint;
    int InternalMark;
    int MaxMark;
    String Result;
    int TotalMark;
    String ResultDate;
    String Sem;

    public OtherExamMarksDetailsItem(
            String Code,
            int ID,
            int Batch,
            String Name,
            int Credit,
            int ExternalMark,
            String Grade,
            int GradePoint,
            int InternalMark,
            int MaxMark,
            String Result,
            int TotalMark,
            String ResultDate,
            String Sem
    ) {

        this.Code = Code;
        this.ID = ID;
        this.Batch = Batch;
        this.Name = Name;
        this.Credit = Credit;
        this.ExternalMark = ExternalMark;
        this.Grade = Grade;
        this.GradePoint = GradePoint;
        this.InternalMark = InternalMark;
        this.MaxMark = MaxMark;
        this.Result = Result;
        this.TotalMark = TotalMark;
        this.ResultDate = ResultDate;
        this.Sem = Sem;
    }

    public int getExternalMark() {
        return ExternalMark;
    }

    public void setExternalMark(int externalMark) {
        ExternalMark = externalMark;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public int getGradePoint() {
        return GradePoint;
    }

    public void setGradePoint(int gradePoint) {
        GradePoint = gradePoint;
    }

    public int getInternalMark() {
        return InternalMark;
    }

    public void setInternalMark(int internalMark) {
        InternalMark = internalMark;
    }

    public int getMaxMark() {
        return MaxMark;
    }

    public void setMaxMark(int maxMark) {
        MaxMark = maxMark;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public int getTotalMark() {
        return TotalMark;
    }

    public void setTotalMark(int totalMark) {
        TotalMark = totalMark;
    }

    public String getResultDate() {
        return ResultDate;
    }

    public void setResultDate(String resultDate) {
        ResultDate = resultDate;
    }

    public String getSem() {
        return Sem;
    }

    public void setSem(String sem) {
        Sem = sem;
    }

    public int getCredit() {

        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBatch() {

        return Batch;
    }

    public void setBatch(int batch) {
        Batch = batch;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {

        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
