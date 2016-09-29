
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.ExamResult;

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
    @SerializedName("Addressal")
    @Expose
    private Object addressal;
    @SerializedName("CardNo")
    @Expose
    private Object cardNo;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("DateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("FirstName")
    @Expose
    private Object firstName;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("Gender")
    @Expose
    private Object gender;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("LastName")
    @Expose
    private Object lastName;
    @SerializedName("MGUID")
    @Expose
    private Object mGUID;
    @SerializedName("MiddleName")
    @Expose
    private Object middleName;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("SGPA")
    @Expose
    private Integer sGPA;
    @SerializedName("Sem")
    @Expose
    private String sem;

    public DataList() {
    }

    protected DataList(Parcel in) {
        this.addressal = in.readParcelable(Object.class.getClassLoader());
        this.cardNo = in.readParcelable(Object.class.getClassLoader());
        this.code = in.readString();
        this.dateOfBirth = in.readString();
        this.firstName = in.readParcelable(Object.class.getClassLoader());
        this.fullName = in.readString();
        this.gender = in.readParcelable(Object.class.getClassLoader());
        this.iD = (Integer) in.readValue(Integer.class.getClassLoader());
        this.lastName = in.readParcelable(Object.class.getClassLoader());
        this.mGUID = in.readParcelable(Object.class.getClassLoader());
        this.middleName = in.readParcelable(Object.class.getClassLoader());
        this.branch = in.readString();
        this.sGPA = (Integer) in.readValue(Integer.class.getClassLoader());
        this.sem = in.readString();
    }

    /**
     * @return The addressal
     */
    public Object getAddressal() {
        return addressal;
    }

    /**
     * @param addressal The Addressal
     */
    public void setAddressal(Object addressal) {
        this.addressal = addressal;
    }

    /**
     * @return The cardNo
     */
    public Object getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo The CardNo
     */
    public void setCardNo(Object cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth The DateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return The firstName
     */
    public Object getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The FirstName
     */
    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName The FullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return The gender
     */
    public Object getGender() {
        return gender;
    }

    /**
     * @param gender The Gender
     */
    public void setGender(Object gender) {
        this.gender = gender;
    }

    /**
     * @return The iD
     */
    public Integer getID() {
        return iD;
    }

    /**
     * @param iD The ID
     */
    public void setID(Integer iD) {
        this.iD = iD;
    }

    /**
     * @return The lastName
     */
    public Object getLastName() {
        return lastName;
    }

    /**
     * @param lastName The LastName
     */
    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The mGUID
     */
    public Object getMGUID() {
        return mGUID;
    }

    /**
     * @param mGUID The MGUID
     */
    public void setMGUID(Object mGUID) {
        this.mGUID = mGUID;
    }

    /**
     * @return The middleName
     */
    public Object getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName The MiddleName
     */
    public void setMiddleName(Object middleName) {
        this.middleName = middleName;
    }

    /**
     * @return The branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch The Branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return The sGPA
     */
    public Integer getSGPA() {
        return sGPA;
    }

    /**
     * @param sGPA The SGPA
     */
    public void setSGPA(Integer sGPA) {
        this.sGPA = sGPA;
    }

    /**
     * @return The sem
     */
    public String getSem() {
        return sem;
    }

    /**
     * @param sem The Sem
     */
    public void setSem(String sem) {
        this.sem = sem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) this.addressal, flags);
        dest.writeParcelable((Parcelable) this.cardNo, flags);
        dest.writeString(this.code);
        dest.writeString(this.dateOfBirth);
        dest.writeParcelable((Parcelable) this.firstName, flags);
        dest.writeString(this.fullName);
        dest.writeParcelable((Parcelable) this.gender, flags);
        dest.writeValue(this.iD);
        dest.writeParcelable((Parcelable) this.lastName, flags);
        dest.writeParcelable((Parcelable) this.mGUID, flags);
        dest.writeParcelable((Parcelable) this.middleName, flags);
        dest.writeString(this.branch);
        dest.writeValue(this.sGPA);
        dest.writeString(this.sem);
    }
}
