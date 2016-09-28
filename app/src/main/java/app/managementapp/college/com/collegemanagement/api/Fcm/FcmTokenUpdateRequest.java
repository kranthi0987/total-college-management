
/*
 * Copyright (c) 2016.
 */

package app.managementapp.college.com.collegemanagement.api.Fcm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FcmTokenUpdateRequest {

    @SerializedName("IMEI")
    @Expose
    private String iMEI;
    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("Token")
    @Expose
    private String token;

    /**
     * @return The iMEI
     */
    public String getIMEI() {
        return iMEI;
    }

    /**
     * @param iMEI The IMEI
     */
    public void setIMEI(String iMEI) {
        this.iMEI = iMEI;
    }

    /**
     * @return The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID The userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return The token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token The Token
     */
    public void setToken(String token) {
        this.token = token;
    }

}
