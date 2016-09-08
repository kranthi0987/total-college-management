
package app.managementapp.college.com.collegemanagement.api.FeedbackList;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DataList {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("FeedbackPerson")
    @Expose
    private String feedbackPerson;
    @SerializedName("FileContent")
    @Expose
    private Object fileContent;
    @SerializedName("FileName")
    @Expose
    private String fileName;
    @SerializedName("FilePath")
    @Expose
    private String filePath;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("MessageTitle")
    @Expose
    private String messageTitle;
    @SerializedName("MessageType")
    @Expose
    private Integer messageType;
    @SerializedName("RefID")
    @Expose
    private Integer refID;
    @SerializedName("Reply")
    @Expose
    private String reply;
    @SerializedName("StudentID")
    @Expose
    private Integer studentID;
    @SerializedName("UserType")
    @Expose
    private String userType;

    /**
     *
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     *     The Date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     *     The feedbackPerson
     */
    public String getFeedbackPerson() {
        return feedbackPerson;
    }

    /**
     *
     * @param feedbackPerson
     *     The FeedbackPerson
     */
    public void setFeedbackPerson(String feedbackPerson) {
        this.feedbackPerson = feedbackPerson;
    }

    /**
     *
     * @return
     *     The fileContent
     */
    public Object getFileContent() {
        return fileContent;
    }

    /**
     *
     * @param fileContent
     *     The FileContent
     */
    public void setFileContent(Object fileContent) {
        this.fileContent = fileContent;
    }

    /**
     *
     * @return
     *     The fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName
     *     The FileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return
     *     The filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     *
     * @param filePath
     *     The FilePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     *
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     *     The Message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     *     The messageTitle
     */
    public String getMessageTitle() {
        return messageTitle;
    }

    /**
     *
     * @param messageTitle
     *     The MessageTitle
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    /**
     *
     * @return
     *     The messageType
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     *
     * @param messageType
     *     The MessageType
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     *
     * @return
     *     The refID
     */
    public Integer getRefID() {
        return refID;
    }

    /**
     *
     * @param refID
     *     The RefID
     */
    public void setRefID(Integer refID) {
        this.refID = refID;
    }

    /**
     *
     * @return
     *     The reply
     */
    public String getReply() {
        return reply;
    }

    /**
     *
     * @param reply
     *     The Reply
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     *
     * @return
     *     The studentID
     */
    public Integer getStudentID() {
        return studentID;
    }

    /**
     *
     * @param studentID
     *     The StudentID
     */
    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    /**
     *
     * @return
     *     The userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType
     *     The UserType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

}
