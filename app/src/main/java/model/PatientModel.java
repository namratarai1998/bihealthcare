package model;

public class PatientModel {
    private int PATIENT_ID;
    private String NAME;
    private String ADDRESS;
    private String AGE;
    private String GENDER;
    private String CONTACT_NO;
    private String WARD_NAME;
    private String PATIENT_TYPE;
    private String SUMMARY;
    private String DATES;
//    private String dates;
private String appointDoctor;
    private String discharge;
    private String treatmentby;

    public String getStayLength() {
        return stayLength;
    }

    public void setStayLength(String stayLength) {
        this.stayLength = stayLength;
    }

    private String stayLength;

    public String getAppointDoctor() {
        return appointDoctor;
    }

    public void setAppointDoctor(String appointDoctor) {
        this.appointDoctor = appointDoctor;
    }

    public String getDischarge() {
        return discharge;
    }

    public void setDischarge(String discharge) {
        this.discharge = discharge;
    }

    public String getTreatmentby() {
        return treatmentby;
    }

    public void setTreatmentby(String treatmentby) {
        this.treatmentby = treatmentby;
    }


    public PatientModel(String name,
                        String ADDRESS,
                        String age,
                        String GENDER,
                        String CONTACT_NO,
                        String ward_name,
                        String patient_type,
                        String summary) {
        this.NAME=name;
        this.PATIENT_ID = PATIENT_ID;
        this.ADDRESS = ADDRESS;
        this.AGE = age;
        this.GENDER = GENDER;
        this.CONTACT_NO = CONTACT_NO;
        this.WARD_NAME = ward_name;
        this.PATIENT_TYPE = patient_type;
        this.SUMMARY = summary;
    }

    public String getDATES() {
        return DATES;
    }

    public void setDATES(String DATES) {
        this.DATES = DATES;
    }

    public String getName() {
        return NAME;
    }

    public String getPatient_type() {
        return PATIENT_TYPE;
    }

    public void setPatient_type(String patient_type) {
        this.PATIENT_TYPE = patient_type;
    }

    public void setName(String name) {
        this.NAME = name;
    }

    public int getPatient_id() {
        return PATIENT_ID;
    }

    public void setPatient_id(int patient_id) {
        this.PATIENT_ID = patient_id;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getAge() {
        return AGE;
    }

    public void setAge(String age) {
        this.AGE = age;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getCONTACT_NO() {
        return CONTACT_NO;
    }

    public void setCONTACT_NO(String CONTACT_NO) {
        this.CONTACT_NO = CONTACT_NO;
    }

    public String getWard_name() {
        return WARD_NAME;
    }

    public void setWard_name(String ward_name) {
        this.WARD_NAME = ward_name;
    }

    public String getSummary() {
        return SUMMARY;
    }

    public void setSummary(String summary) {
        this.SUMMARY = summary;
    }
}
