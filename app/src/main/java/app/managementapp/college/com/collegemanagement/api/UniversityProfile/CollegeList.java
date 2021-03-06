
package app.managementapp.college.com.collegemanagement.api.UniversityProfile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class CollegeList implements Parcelable {

    public static final Creator<CollegeList> CREATOR = new Creator<CollegeList>() {
        @Override
        public CollegeList createFromParcel(Parcel in) {
            return new CollegeList(in);
        }

        @Override
        public CollegeList[] newArray(int size) {
            return new CollegeList[size];
        }
    };
    @SerializedName("Address")
    @Expose
    private Address address;
    @SerializedName("Base64Image")
    @Expose
    private String base64Image;
    @SerializedName("UniversityName")
    @Expose
    private String universityName;
    @SerializedName("UniversityShortName")
    @Expose
    private String universityShortName;
    @SerializedName("CollegeID")
    @Expose
    private Integer collegeID;
    @SerializedName("CollegeName")
    @Expose
    private String collegeName;
    @SerializedName("Department")
    @Expose
    private List<Object> departmentList = new ArrayList<Object>();
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Fax")
    @Expose
    private String fax;
    @SerializedName("WebSite")
    @Expose
    private String webSite;

    protected CollegeList(Parcel in) {
        base64Image = in.readString();
        universityName = in.readString();
        universityShortName = in.readString();
        collegeName = in.readString();
        email = in.readString();
        fax = in.readString();
        webSite = in.readString();
    }

    /**
     * @return The address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address The Address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return The base64Image
     */
    public String getBase64Image() {
        return base64Image;
    }

    /**
     * @param base64Image The Base64Image
     */
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    /**
     * @return The universityName
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * @param universityName The UniversityName
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /**
     * @return The universityShortName
     */
    public String getUniversityShortName() {
        return universityShortName;
    }

    /**
     * @param universityShortName The UniversityShortName
     */
    public void setUniversityShortName(String universityShortName) {
        this.universityShortName = universityShortName;
    }

    /**
     * @return The collegeID
     */
    public Integer getCollegeID() {
        return collegeID;
    }

    /**
     * @param collegeID The CollegeID
     */
    public void setCollegeID(Integer collegeID) {
        this.collegeID = collegeID;
    }

    /**
     * @return The collegeName
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * @param collegeName The CollegeName
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * @return The departmentList
     */
    public List<Object> getDepartmentList() {
        return departmentList;
    }

    /**
     * @param departmentList The Department
     */
    public void setDepartmentList(List<Object> departmentList) {
        this.departmentList = departmentList;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax The Fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return The webSite
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * @param webSite The WebSite
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(base64Image);
        dest.writeString(universityName);
        dest.writeString(universityShortName);
        dest.writeString(collegeName);
        dest.writeString(email);
        dest.writeString(fax);
        dest.writeString(webSite);
    }
}
