
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.StudentInternalExamMarkDetails;

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

    public DataList() {
    }

    protected DataList(Parcel in) {
        this.code = in.readParcelable(Object.class.getClassLoader());
        this.gUID = in.readParcelable(Object.class.getClassLoader());
        this.inTime = in.readParcelable(Object.class.getClassLoader());
        this.name = in.readParcelable(Object.class.getClassLoader());
        this.outTime = in.readParcelable(Object.class.getClassLoader());
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) this.code, flags);
        dest.writeParcelable((Parcelable) this.gUID, flags);
        dest.writeParcelable((Parcelable) this.inTime, flags);
        dest.writeParcelable((Parcelable) this.name, flags);
        dest.writeParcelable((Parcelable) this.outTime, flags);
    }
}
