
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.StudentExternalExam;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList implements Parcelable {

    public static final Parcelable.Creator<DataList> CREATOR = new Parcelable.Creator<DataList>() {
        @Override
        public DataList createFromParcel(Parcel source) {
            return new DataList(source);
        }

        @Override
        public DataList[] newArray(int size) {
            return new DataList[size];
        }
    };
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

    public DataList() {
    }

    protected DataList(Parcel in) {
        this.absent = (Integer) in.readValue(Integer.class.getClassLoader());
        this.categoryID = in.readString();
        this.categoryName = in.readString();
        this.fail = (Integer) in.readValue(Integer.class.getClassLoader());
        this.notEntered = (Integer) in.readValue(Integer.class.getClassLoader());
        this.pass = (Integer) in.readValue(Integer.class.getClassLoader());
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.absent);
        dest.writeString(this.categoryID);
        dest.writeString(this.categoryName);
        dest.writeValue(this.fail);
        dest.writeValue(this.notEntered);
        dest.writeValue(this.pass);
    }
}
