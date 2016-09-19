
package app.managementapp.college.com.collegemanagement.api.StudentSearch.StudentList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class College implements Parcelable {

    public static final Creator<College> CREATOR = new Creator<College>() {
        @Override
        public College createFromParcel(Parcel in) {
            return new College(in);
        }

        @Override
        public College[] newArray(int size) {
            return new College[size];
        }
    };
    @SerializedName("AddressList")
    @Expose
    private List<Object> addressList = new ArrayList<Object>();
    @SerializedName("CollegeAddress")
    @Expose
    private CollegeAddress collegeAddress;
    @SerializedName("CollegeCode")
    @Expose
    private Object collegeCode;
    @SerializedName("CollegeID")
    @Expose
    private Object collegeID;
    @SerializedName("CollegeName")
    @Expose
    private Object collegeName;
    @SerializedName("CollegeShortName")
    @Expose
    private Object collegeShortName;
    @SerializedName("EMail")
    @Expose
    private Object eMail;
    @SerializedName("TelephoneNos")
    @Expose
    private Object telephoneNos;
    @SerializedName("TrustEMail")
    @Expose
    private Object trustEMail;
    @SerializedName("TrustName")
    @Expose
    private Object trustName;
    @SerializedName("TrustTelephoneNos")
    @Expose
    private Object trustTelephoneNos;
    @SerializedName("TrustWebsite")
    @Expose
    private Object trustWebsite;
    @SerializedName("Website")
    @Expose
    private Object website;

    protected College(Parcel in) {
        collegeAddress = in.readParcelable(CollegeAddress.class.getClassLoader());
    }

    /**
     * @return The addressList
     */
    public List<Object> getAddressList() {
        return addressList;
    }

    /**
     * @param addressList The AddressList
     */
    public void setAddressList(List<Object> addressList) {
        this.addressList = addressList;
    }

    /**
     * @return The collegeAddress
     */
    public CollegeAddress getCollegeAddress() {
        return collegeAddress;
    }

    /**
     * @param collegeAddress The CollegeAddress
     */
    public void setCollegeAddress(CollegeAddress collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    /**
     * @return The collegeCode
     */
    public Object getCollegeCode() {
        return collegeCode;
    }

    /**
     * @param collegeCode The CollegeCode
     */
    public void setCollegeCode(Object collegeCode) {
        this.collegeCode = collegeCode;
    }

    /**
     * @return The collegeID
     */
    public Object getCollegeID() {
        return collegeID;
    }

    /**
     * @param collegeID The CollegeID
     */
    public void setCollegeID(Object collegeID) {
        this.collegeID = collegeID;
    }

    /**
     * @return The collegeName
     */
    public Object getCollegeName() {
        return collegeName;
    }

    /**
     * @param collegeName The CollegeName
     */
    public void setCollegeName(Object collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * @return The collegeShortName
     */
    public Object getCollegeShortName() {
        return collegeShortName;
    }

    /**
     * @param collegeShortName The CollegeShortName
     */
    public void setCollegeShortName(Object collegeShortName) {
        this.collegeShortName = collegeShortName;
    }

    /**
     * @return The eMail
     */
    public Object getEMail() {
        return eMail;
    }

    /**
     * @param eMail The EMail
     */
    public void setEMail(Object eMail) {
        this.eMail = eMail;
    }

    /**
     * @return The telephoneNos
     */
    public Object getTelephoneNos() {
        return telephoneNos;
    }

    /**
     * @param telephoneNos The TelephoneNos
     */
    public void setTelephoneNos(Object telephoneNos) {
        this.telephoneNos = telephoneNos;
    }

    /**
     * @return The trustEMail
     */
    public Object getTrustEMail() {
        return trustEMail;
    }

    /**
     * @param trustEMail The TrustEMail
     */
    public void setTrustEMail(Object trustEMail) {
        this.trustEMail = trustEMail;
    }

    /**
     * @return The trustName
     */
    public Object getTrustName() {
        return trustName;
    }

    /**
     * @param trustName The TrustName
     */
    public void setTrustName(Object trustName) {
        this.trustName = trustName;
    }

    /**
     * @return The trustTelephoneNos
     */
    public Object getTrustTelephoneNos() {
        return trustTelephoneNos;
    }

    /**
     * @param trustTelephoneNos The TrustTelephoneNos
     */
    public void setTrustTelephoneNos(Object trustTelephoneNos) {
        this.trustTelephoneNos = trustTelephoneNos;
    }

    /**
     * @return The trustWebsite
     */
    public Object getTrustWebsite() {
        return trustWebsite;
    }

    /**
     * @param trustWebsite The TrustWebsite
     */
    public void setTrustWebsite(Object trustWebsite) {
        this.trustWebsite = trustWebsite;
    }

    /**
     * @return The website
     */
    public Object getWebsite() {
        return website;
    }

    /**
     * @param website The Website
     */
    public void setWebsite(Object website) {
        this.website = website;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(collegeAddress, flags);
    }
}
