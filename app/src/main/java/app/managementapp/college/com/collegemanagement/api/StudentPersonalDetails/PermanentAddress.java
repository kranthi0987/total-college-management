
package app.managementapp.college.com.collegemanagement.api.StudentPersonalDetails;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PermanentAddress {

    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("AddressType")
    @Expose
    private Object addressType;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("Country")
    @Expose
    private Object country;
    @SerializedName("Mobile")
    @Expose
    private Object mobile;
    @SerializedName("Phone")
    @Expose
    private Object phone;
    @SerializedName("State")
    @Expose
    private String state;

    /**
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The addressType
     */
    public Object getAddressType() {
        return addressType;
    }

    /**
     * @param addressType The AddressType
     */
    public void setAddressType(Object addressType) {
        this.addressType = addressType;
    }

    /**
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The country
     */
    public Object getCountry() {
        return country;
    }

    /**
     * @param country The Country
     */
    public void setCountry(Object country) {
        this.country = country;
    }

    /**
     * @return The mobile
     */
    public Object getMobile() {
        return mobile;
    }

    /**
     * @param mobile The Mobile
     */
    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    /**
     * @return The phone
     */
    public Object getPhone() {
        return phone;
    }

    /**
     * @param phone The Phone
     */
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    /**
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The State
     */
    public void setState(String state) {
        this.state = state;
    }

}
