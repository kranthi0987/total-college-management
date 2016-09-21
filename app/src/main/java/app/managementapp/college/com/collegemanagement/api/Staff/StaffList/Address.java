
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.Staff.StaffList;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Address implements Parcelable {

    public static final Creator<Address> CREATOR = new Creator<Address>() {
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
    private Object addressType;
    @SerializedName("City")
    @Expose
    private Object city;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Mobile")
    @Expose
    private Object mobile;
    @SerializedName("Phone")
    @Expose
    private Object phone;
    @SerializedName("State")
    @Expose
    private String state;

    public Address() {
    }

    protected Address(Parcel in) {
        this.address = in.readString();
        this.addressType = in.readParcelable(Object.class.getClassLoader());
        this.city = in.readParcelable(Object.class.getClassLoader());
        this.country = in.readString();
        this.mobile = in.readParcelable(Object.class.getClassLoader());
        this.phone = in.readParcelable(Object.class.getClassLoader());
        this.state = in.readString();
    }

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
    public Object getCity() {
        return city;
    }

    /**
     * @param city The City
     */
    public void setCity(Object city) {
        this.city = city;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The Country
     */
    public void setCountry(String country) {
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

    @Override
    public String toString() {
        return getAddress() + "\n" + getCity() + "\n" + getState() + "\n" + getCountry();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeParcelable((Parcelable) this.addressType, flags);
        dest.writeParcelable((Parcelable) this.city, flags);
        dest.writeString(this.country);
        dest.writeParcelable((Parcelable) this.mobile, flags);
        dest.writeParcelable((Parcelable) this.phone, flags);
        dest.writeString(this.state);
    }
}
