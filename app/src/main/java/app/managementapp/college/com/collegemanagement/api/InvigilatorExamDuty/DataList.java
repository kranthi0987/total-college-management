
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.InvigilatorExamDuty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList {

    @SerializedName("ExamDate")
    @Expose
    private String examDate;
    @SerializedName("ExamName")
    @Expose
    private String examName;
    @SerializedName("ExamSession")
    @Expose
    private String examSession;
    @SerializedName("RoomID")
    @Expose
    private Integer roomID;
    @SerializedName("RoomNo")
    @Expose
    private String roomNo;
    @SerializedName("SessionID")
    @Expose
    private Integer sessionID;
    @SerializedName("StaffName")
    @Expose
    private String staffName;
    @SerializedName("SubCode")
    @Expose
    private Object subCode;
    @SerializedName("Subjects")
    @Expose
    private String subjects;

    /**
     * @return The examDate
     */
    public String getExamDate() {
        return examDate;
    }

    /**
     * @param examDate The ExamDate
     */
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    /**
     * @return The examName
     */
    public String getExamName() {
        return examName;
    }

    /**
     * @param examName The ExamName
     */
    public void setExamName(String examName) {
        this.examName = examName;
    }

    /**
     * @return The examSession
     */
    public String getExamSession() {
        return examSession;
    }

    /**
     * @param examSession The ExamSession
     */
    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    /**
     * @return The roomID
     */
    public Integer getRoomID() {
        return roomID;
    }

    /**
     * @param roomID The RoomID
     */
    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    /**
     * @return The roomNo
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo The RoomNo
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * @return The sessionID
     */
    public Integer getSessionID() {
        return sessionID;
    }

    /**
     * @param sessionID The SessionID
     */
    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }

    /**
     * @return The staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName The StaffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * @return The subCode
     */
    public Object getSubCode() {
        return subCode;
    }

    /**
     * @param subCode The SubCode
     */
    public void setSubCode(Object subCode) {
        this.subCode = subCode;
    }

    /**
     * @return The subjects
     */
    public String getSubjects() {
        return subjects;
    }

    /**
     * @param subjects The Subjects
     */
    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

}
