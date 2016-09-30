
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.StudentExternalExam;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StudentExternalMarksSummaryResponse implements Parcelable {

    public static final Parcelable.Creator<StudentExternalMarksSummaryResponse> CREATOR = new Parcelable.Creator<StudentExternalMarksSummaryResponse>() {
        @Override
        public StudentExternalMarksSummaryResponse createFromParcel(Parcel source) {
            return new StudentExternalMarksSummaryResponse(source);
        }

        @Override
        public StudentExternalMarksSummaryResponse[] newArray(int size) {
            return new StudentExternalMarksSummaryResponse[size];
        }
    };
    @SerializedName("DataList")
    @Expose
    private List<DataList> dataList = new ArrayList<DataList>();
    @SerializedName("ErrorMessage")
    @Expose
    private Object errorMessage;
    @SerializedName("ExtendedToken")
    @Expose
    private String extendedToken;
    @SerializedName("ServiceResult")
    @Expose
    private Integer serviceResult;

    public StudentExternalMarksSummaryResponse() {
    }

    protected StudentExternalMarksSummaryResponse(Parcel in) {
        this.dataList = in.createTypedArrayList(DataList.CREATOR);
        this.errorMessage = in.readParcelable(Object.class.getClassLoader());
        this.extendedToken = in.readString();
        this.serviceResult = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    /**
     * @return The dataList
     */
    public List<DataList> getDataList() {
        return dataList;
    }

    /**
     * @param dataList The DataList
     */
    public void setDataList(List<DataList> dataList) {
        this.dataList = dataList;
    }

    /**
     * @return The errorMessage
     */
    public Object getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage The ErrorMessage
     */
    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return The extendedToken
     */
    public String getExtendedToken() {
        return extendedToken;
    }

    /**
     * @param extendedToken The ExtendedToken
     */
    public void setExtendedToken(String extendedToken) {
        this.extendedToken = extendedToken;
    }

    /**
     * @return The serviceResult
     */
    public Integer getServiceResult() {
        return serviceResult;
    }

    /**
     * @param serviceResult The ServiceResult
     */
    public void setServiceResult(Integer serviceResult) {
        this.serviceResult = serviceResult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.dataList);
        dest.writeParcelable((Parcelable) this.errorMessage, flags);
        dest.writeString(this.extendedToken);
        dest.writeValue(this.serviceResult);
    }
}
