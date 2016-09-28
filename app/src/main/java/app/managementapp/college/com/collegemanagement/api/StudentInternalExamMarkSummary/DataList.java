
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.StudentInternalExamMarkSummary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList {

    @SerializedName("Absent")
    @Expose
    private Integer absent;
    @SerializedName("CategoryID")
    @Expose
    private String categoryID;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("Fail")
    @Expose
    private Integer fail;
    @SerializedName("NotEntered")
    @Expose
    private Integer notEntered;
    @SerializedName("Pass")
    @Expose
    private Integer pass;

    /**
     * @return The absent
     */
    public Integer getAbsent() {
        return absent;
    }

    /**
     * @param absent The Absent
     */
    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    /**
     * @return The categoryID
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID The CategoryID
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return The categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName The CategoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return The fail
     */
    public Integer getFail() {
        return fail;
    }

    /**
     * @param fail The Fail
     */
    public void setFail(Integer fail) {
        this.fail = fail;
    }

    /**
     * @return The notEntered
     */
    public Integer getNotEntered() {
        return notEntered;
    }

    /**
     * @param notEntered The NotEntered
     */
    public void setNotEntered(Integer notEntered) {
        this.notEntered = notEntered;
    }

    /**
     * @return The pass
     */
    public Integer getPass() {
        return pass;
    }

    /**
     * @param pass The Pass
     */
    public void setPass(Integer pass) {
        this.pass = pass;
    }

}
