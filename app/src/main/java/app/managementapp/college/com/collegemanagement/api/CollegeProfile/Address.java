
package app.managementapp.college.com.collegemanagement.api.CollegeProfile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Address implements Parcelable {

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("AddressType")
    @Expose
    private String addressType;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("State")
    @Expose
    private String state;

    public Address() {
    }

    protected Address(Parcel in) {
        this.address = in.readString();
        this.addressType = in.readString();
        this.city = in.readString();
        this.country = in.readString();
        this.mobile = in.readString();
        this.phone = in.readString();
        this.state = in.readString();
    }

    /**
     *
     * @return
     *     The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     *     The Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     *     The addressType
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     *
     * @param addressType
     *     The AddressType
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     *
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     *     The City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     *     The Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     *     The mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile
     *     The Mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     *     The Phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     *     The State
     */
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.addressType);
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeString(this.mobile);
        dest.writeString(this.phone);
        dest.writeString(this.state);
    }

    @Override
    public String toString() {
        return getAddress() + "\n" + getCity() + "\n" + getState() + "\n" + getState() + "\n";
    }
}
