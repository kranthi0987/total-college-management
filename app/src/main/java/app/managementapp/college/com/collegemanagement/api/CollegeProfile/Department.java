
package app.managementapp.college.com.collegemanagement.api.CollegeProfile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Department implements Parcelable {

    public static final Parcelable.Creator<Department> CREATOR = new Parcelable.Creator<Department>() {
        @Override
        public Department createFromParcel(Parcel source) {
            return new Department(source);
        }

        @Override
        public Department[] newArray(int size) {
            return new Department[size];
        }
    };
    @SerializedName("DepartmentHODID")
    @Expose
    private Integer departmentHODID;
    @SerializedName("DepartmentID")
    @Expose
    private Integer departmentID;
    @SerializedName("DepartmentName")
    @Expose
    private String departmentName;
    @SerializedName("HODName")
    @Expose
    private String hODName;
    @SerializedName("HODPhone")
    @Expose
    private String hODPhone;
    @SerializedName("MGUID")
    @Expose
    private String mGUID;
    @SerializedName("Qualification")
    @Expose
    private String qualification;

    public Department() {
    }

    protected Department(Parcel in) {
        this.departmentHODID = (Integer) in.readValue(Integer.class.getClassLoader());
        this.departmentID = (Integer) in.readValue(Integer.class.getClassLoader());
        this.departmentName = in.readString();
        this.hODName = in.readString();
        this.hODPhone = in.readString();
        this.mGUID = in.readString();
        this.qualification = in.readString();
    }

    /**
     *
     * @return
     *     The departmentHODID
     */
    public Integer getDepartmentHODID() {
        return departmentHODID;
    }

    /**
     *
     * @param departmentHODID
     *     The DepartmentHODID
     */
    public void setDepartmentHODID(Integer departmentHODID) {
        this.departmentHODID = departmentHODID;
    }

    /**
     *
     * @return
     *     The departmentID
     */
    public Integer getDepartmentID() {
        return departmentID;
    }

    /**
     *
     * @param departmentID
     *     The DepartmentID
     */
    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    /**
     *
     * @return
     *     The departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     *
     * @param departmentName
     *     The DepartmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     *
     * @return
     *     The hODName
     */
    public String getHODName() {
        return hODName;
    }

    /**
     *
     * @param hODName
     *     The HODName
     */
    public void setHODName(String hODName) {
        this.hODName = hODName;
    }

    /**
     *
     * @return
     *     The hODPhone
     */
    public String getHODPhone() {
        return hODPhone;
    }

    /**
     *
     * @param hODPhone
     *     The HODPhone
     */
    public void setHODPhone(String hODPhone) {
        this.hODPhone = hODPhone;
    }

    /**
     *
     * @return
     *     The mGUID
     */
    public String getMGUID() {
        return mGUID;
    }

    /**
     *
     * @param mGUID
     *     The MGUID
     */
    public void setMGUID(String mGUID) {
        this.mGUID = mGUID;
    }

    /**
     *
     * @return
     *     The qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     *
     * @param qualification
     *     The Qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.departmentHODID);
        dest.writeValue(this.departmentID);
        dest.writeString(this.departmentName);
        dest.writeString(this.hODName);
        dest.writeString(this.hODPhone);
        dest.writeString(this.mGUID);
        dest.writeString(this.qualification);
    }
}
