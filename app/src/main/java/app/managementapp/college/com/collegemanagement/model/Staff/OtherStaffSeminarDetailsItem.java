package app.managementapp.college.com.collegemanagement.model.Staff;

/**
 * Created by Sanjay on 9/2/2016.
 */
public class OtherStaffSeminarDetailsItem {



//            "CertificateName": "Microsoft Certification",
//            "CertifiedDate": "/Date(1453141800000+0530)/",
//            "CertifiedFrom": "Microsoft",
//            "Description": "Creating DB tables with the help of model class",
//            "EndDateTime": "/Date(1458325800000+0530)/",
//            "Name": "Code First Technology",
//            "StartDateTime": "/Date(1458325800000+0530)/",
//            "Type": "Book Published"

                String CertificateName;
                String CertifiedDate;
                String CertifiedFrom;
                String Description;
                String EndDateTime;
                String Name;
                String StartDateTime;
                String Type;

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public String getCertifiedDate() {
        return CertifiedDate;
    }

    public void setCertifiedDate(String certifiedDate) {
        CertifiedDate = certifiedDate;
    }

    public String getCertifiedFrom() {
        return CertifiedFrom;
    }

    public void setCertifiedFrom(String certifiedFrom) {
        CertifiedFrom = certifiedFrom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEndDateTime() {
        return EndDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        EndDateTime = endDateTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartDateTime() {
        return StartDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        StartDateTime = startDateTime;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public OtherStaffSeminarDetailsItem(
            String CertificateName,
            String CertifiedDate,
            String CertifiedFrom,
            String Description,
            String EndDateTime,
            String Name,
            String StartDateTime,
            String Type
    ){
        this.CertificateName=CertificateName;
        this.CertifiedDate=CertifiedDate;
        this.CertifiedFrom=CertifiedFrom;
        this.Description=Description;
        this.EndDateTime=EndDateTime;
        this.Name=Name;
        this.StartDateTime=StartDateTime;
        this.Type=Type;

    }

}
