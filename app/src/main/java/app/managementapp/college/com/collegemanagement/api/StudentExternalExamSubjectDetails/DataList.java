
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.StudentExternalExamSubjectDetails;

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

    public DataList() {
    }

    protected DataList(Parcel in) {
        this.result = (Integer) in.readValue(Integer.class.getClassLoader());
        this.resultEntered = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.subjectCode = in.readString();
        this.subjectName = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.result);
        dest.writeValue(this.resultEntered);
        dest.writeString(this.subjectCode);
        dest.writeString(this.subjectName);
    }
}
