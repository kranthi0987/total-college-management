package app.managementapp.college.com.collegemanagement.model;

/**
 * Created by Sanjay on 9/6/2016.
 * total
 */
public class UniversityProfileItem {


    String Address;
    String AddressType;
    String City;
    String Country;
    String Mobile;
    String Phone;
    String State;
    String Base64Image;
    //            String UniversityName;
    String UniversityShortName;
    String CollegeID;
    String CollegeName;
    String DepartmentList;
    String Email;
    String Fax;
    String WebSite;
    String UniversityID;
    String UniversityName;
    String DepartmentHODID;
    String DepartmentID;
    String DepartmentName;
    String HODName;
    String HODPhone;
    String MGUID;
    String Qualification;


    public UniversityProfileItem(

            String Base64Image,
            String UniversityName,
            String UniversityShortName,
            String CollegeID,
            String CollegeName,
            String DepartmentList,
            String Email,
            String Fax,
            String WebSite,
            String UniversityID,
//            String UniversityName
            String DepartmentHODID,
            String DepartmentID,
            String DepartmentName,
            String HODName,
            String HODPhone,
            String MGUID,
            String Qualification

    ) {

        this.Base64Image = Base64Image;
        this.UniversityName = UniversityName;
        this.UniversityShortName = UniversityShortName;
        this.CollegeID = CollegeID;
        this.CollegeName = CollegeName;
        this.DepartmentList = DepartmentList;
        this.Email = Email;
        this.Fax = Fax;
        this.WebSite = WebSite;
        this.UniversityID = UniversityID;
        this.UniversityName = UniversityName;
        this.DepartmentHODID = DepartmentHODID;
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
        this.HODName = HODName;
        this.HODPhone = HODPhone;
        this.MGUID = MGUID;
        this.Qualification = Qualification;

    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddressType() {
        return AddressType;
    }

    public void setAddressType(String addressType) {
        AddressType = addressType;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getBase64Image() {
        return Base64Image;
    }

    public void setBase64Image(String base64Image) {
        Base64Image = base64Image;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    public String getUniversityShortName() {
        return UniversityShortName;
    }

    public void setUniversityShortName(String universityShortName) {
        UniversityShortName = universityShortName;
    }

    public String getCollegeID() {
        return CollegeID;
    }

    public void setCollegeID(String collegeID) {
        CollegeID = collegeID;
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getDepartmentList() {
        return DepartmentList;
    }

    public void setDepartmentList(String departmentList) {
        DepartmentList = departmentList;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String webSite) {
        WebSite = webSite;
    }

    public String getUniversityID() {
        return UniversityID;
    }

    public void setUniversityID(String universityID) {
        UniversityID = universityID;
    }

    public String getDepartmentHODID() {
        return DepartmentHODID;
    }

    public void setDepartmentHODID(String departmentHODID) {
        DepartmentHODID = departmentHODID;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getHODName() {
        return HODName;
    }

    public void setHODName(String HODName) {
        this.HODName = HODName;
    }

    public String getHODPhone() {
        return HODPhone;
    }

    public void setHODPhone(String HODPhone) {
        this.HODPhone = HODPhone;
    }

    public String getMGUID() {
        return MGUID;
    }

    public void setMGUID(String MGUID) {
        this.MGUID = MGUID;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }


}


