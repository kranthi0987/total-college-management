package app.managementapp.college.com.collegemanagement.model.Staff;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class OtherStaffLeaveDetailsItem {
    //                "AvailableLeaves": 4,
//                "IsHalfdayAllowed": true,
//                "LeaveID": 3,
//                "LeaveName": "Sick Leave",
//                "MaximumNoOfDays": 8,
//                "MinimumNoOfDays": 1,
//                "ShortName": "SL",
//                "AlternateStaffStatusDetails": [
//        {
//            "AlternateStaffName": null,
//                "Comment": "Approved",
//                "GUID": "01B5A3AC-3274-44AF-A06F-03D085AB57F7",
//                "IsModified": false,
//                "ScheduleID": 7,
//                "Status": 1
//        }
//        ],
//                "ApplicationID": 12,
//                "AppliedByID": 0,
//                "AppliedByName": null,
//                "ApprovalStatus": 1,
//                "Comment": "Approved",
//                "LeaveAppliedDate": "/Date(1454610600000+0530)/",
//                "LeaveDateFrom": "/Date(1454610600000+0530)/",
//                "LeaveDateTo": "/Date(1454610600000+0530)/",
//                "LeaveRequestSentTo": "Ramesh",
//                "LeaveStatusID": 0,
//                "Reason": "Fever"
    int AvailableLeaves;
    String IsHalfdayAllowed;
    int LeaveID;
    String LeaveName;
    int MaximumNoOfDays;
    int MinimumNoOfDays;
    String ShortName;
    //        String AlternateStaffName;
//        String Comment;
    String GUID;
    String IsModified;
    int ScheduleID;
    int Status;
    int ApplicationID;
    int AppliedByID;
    //        String AppliedByName;
    int ApprovalStatus;
    String Comment;
    String LeaveAppliedDate;
    String LeaveDateFrom;
    String LeaveDateTo;
    String LeaveRequestSentTo;
    int LeaveStatusID;
    String Reason;


    public OtherStaffLeaveDetailsItem(
            int AvailableLeaves,
            String IsHalfdayAllowed,
            int LeaveID,
            String LeaveName,
            int MaximumNoOfDays,
            int MinimumNoOfDays,
            String ShortName,
//                String AlternateStaffName,
            String Comment,
            String GUID,
            String IsModified,
            int ScheduleID,
            int Status,
            int ApplicationID,
            int AppliedByID,
//                String AppliedByName,
            int ApprovalStatus,
//                String Comment,
            String LeaveAppliedDate,
            String LeaveDateFrom,
            String LeaveDateTo,
            String LeaveRequestSentTo,
            int LeaveStatusID,
            String Reason
    ) {
        this.AvailableLeaves = AvailableLeaves;
        this.IsHalfdayAllowed = IsHalfdayAllowed;
        this.LeaveID = LeaveID;
        this.LeaveName = LeaveName;
        this.MaximumNoOfDays = MaximumNoOfDays;
        this.MinimumNoOfDays = MinimumNoOfDays;
        this.ShortName = ShortName;
        this.Comment = Comment;
        this.GUID = GUID;
        this.IsModified = IsModified;
        this.ScheduleID = ScheduleID;
        this.Status = Status;
        this.ApplicationID = ApplicationID;
        this.AppliedByID = AppliedByID;
        this.ApprovalStatus = ApprovalStatus;
        this.LeaveAppliedDate = LeaveAppliedDate;
        this.LeaveDateFrom = LeaveDateFrom;
        this.LeaveDateTo = LeaveDateTo;
        this.LeaveRequestSentTo = LeaveRequestSentTo;
        this.LeaveStatusID = LeaveStatusID;
        this.Reason = Reason;

    }

    public int getAvailableLeaves() {
        return AvailableLeaves;
    }

    public void setAvailableLeaves(int availableLeaves) {
        AvailableLeaves = availableLeaves;
    }

    public String getIsHalfdayAllowed() {
        return IsHalfdayAllowed;
    }

    public void setIsHalfdayAllowed(String isHalfdayAllowed) {
        IsHalfdayAllowed = isHalfdayAllowed;
    }

    public int getLeaveID() {
        return LeaveID;
    }

    public void setLeaveID(int leaveID) {
        LeaveID = leaveID;
    }

    public String getLeaveName() {
        return LeaveName;
    }

    public void setLeaveName(String leaveName) {
        LeaveName = leaveName;
    }

    public int getMaximumNoOfDays() {
        return MaximumNoOfDays;
    }

    public void setMaximumNoOfDays(int maximumNoOfDays) {
        MaximumNoOfDays = maximumNoOfDays;
    }

    public int getMinimumNoOfDays() {
        return MinimumNoOfDays;
    }

    public void setMinimumNoOfDays(int minimumNoOfDays) {
        MinimumNoOfDays = minimumNoOfDays;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getLeaveAppliedDate() {
        return LeaveAppliedDate;
    }

    public void setLeaveAppliedDate(String leaveAppliedDate) {
        LeaveAppliedDate = leaveAppliedDate;
    }

    public String getLeaveDateFrom() {
        return LeaveDateFrom;
    }

    public void setLeaveDateFrom(String leaveDateFrom) {
        LeaveDateFrom = leaveDateFrom;
    }

    public String getLeaveDateTo() {
        return LeaveDateTo;
    }

    public void setLeaveDateTo(String leaveDateTo) {
        LeaveDateTo = leaveDateTo;
    }

    public String getLeaveRequestSentTo() {
        return LeaveRequestSentTo;
    }

    public void setLeaveRequestSentTo(String leaveRequestSentTo) {
        LeaveRequestSentTo = leaveRequestSentTo;
    }

    public int getLeaveStatusID() {
        return LeaveStatusID;
    }

    public void setLeaveStatusID(int leaveStatusID) {
        LeaveStatusID = leaveStatusID;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getIsModified() {
        return IsModified;
    }

    public void setIsModified(String isModified) {
        IsModified = isModified;
    }

    public int getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(int scheduleID) {
        ScheduleID = scheduleID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(int applicationID) {
        ApplicationID = applicationID;
    }

    public int getAppliedByID() {
        return AppliedByID;
    }

    public void setAppliedByID(int appliedByID) {
        AppliedByID = appliedByID;
    }

    public int getApprovalStatus() {
        return ApprovalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        ApprovalStatus = approvalStatus;
    }
}
