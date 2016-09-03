package app.managementapp.college.com.collegemanagement.model.Staff;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class OtherStaffMemoEntryDetailsItem {




//            "Action": "",
//            "Activity": "Extra Curicular Activity",
//            "Description": "Got Microsoft certificate",
//            "MemoDate": "/Date(1425321000000+0530)/",
//            "ReportedBy": ""
        String Action;
        String Activity;
        String Description;
        String MemoDate;
        String ReportedBy;

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

    public OtherStaffMemoEntryDetailsItem(
            String Action,
            String Activity,
            String Description,
            String MemoDate,
            String ReportedBy

    ){
        this.Action=Action;
        this.Activity=Activity;
        this.Description=Description;
        this.MemoDate=MemoDate;
        this.ReportedBy=ReportedBy;

    }

}
