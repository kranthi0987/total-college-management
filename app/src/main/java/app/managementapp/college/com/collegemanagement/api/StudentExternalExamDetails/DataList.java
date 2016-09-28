
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.StudentExternalExamDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList {

    @SerializedName("Code")
    @Expose
    private Object code;
    @SerializedName("GUID")
    @Expose
    private Object gUID;
    @SerializedName("InTime")
    @Expose
    private Object inTime;
    @SerializedName("Name")
    @Expose
    private Object name;
    @SerializedName("OutTime")
    @Expose
    private Object outTime;

    /**
     * @return The code
     */
    public Object getCode() {
        return code;
    }

    /**
     * @param code The Code
     */
    public void setCode(Object code) {
        this.code = code;
    }

    /**
     * @return The gUID
     */
    public Object getGUID() {
        return gUID;
    }

    /**
     * @param gUID The GUID
     */
    public void setGUID(Object gUID) {
        this.gUID = gUID;
    }

    /**
     * @return The inTime
     */
    public Object getInTime() {
        return inTime;
    }

    /**
     * @param inTime The InTime
     */
    public void setInTime(Object inTime) {
        this.inTime = inTime;
    }

    /**
     * @return The name
     */
    public Object getName() {
        return name;
    }

    /**
     * @param name The Name
     */
    public void setName(Object name) {
        this.name = name;
    }

    /**
     * @return The outTime
     */
    public Object getOutTime() {
        return outTime;
    }

    /**
     * @param outTime The OutTime
     */
    public void setOutTime(Object outTime) {
        this.outTime = outTime;
    }

}
