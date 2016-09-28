
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.StudentInternalExamSubjectDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList {

    @SerializedName("Result")
    @Expose
    private Integer result;
    @SerializedName("ResultEntered")
    @Expose
    private Boolean resultEntered;
    @SerializedName("SubjectCode")
    @Expose
    private String subjectCode;
    @SerializedName("SubjectName")
    @Expose
    private String subjectName;

    /**
     * @return The result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * @param result The Result
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * @return The resultEntered
     */
    public Boolean getResultEntered() {
        return resultEntered;
    }

    /**
     * @param resultEntered The ResultEntered
     */
    public void setResultEntered(Boolean resultEntered) {
        this.resultEntered = resultEntered;
    }

    /**
     * @return The subjectCode
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * @param subjectCode The SubjectCode
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * @return The subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName The SubjectName
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
