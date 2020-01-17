package model;

public class AppointmentModel {
    private int APPOINTID;
    private int APPOINTDATE;
    private int DOCTOR_ID;
    private int PATIENT_ID;

    public AppointmentModel(int APPOINTID, int APPOINTDATE, int DOCTOR_ID, int PATIENT_ID) {
        this.APPOINTID = APPOINTID;
        this.APPOINTDATE = APPOINTDATE;
        this.DOCTOR_ID = DOCTOR_ID;
        this.PATIENT_ID = PATIENT_ID;
    }

    public int getAPPOINTID() {
        return APPOINTID;
    }

    public void setAPPOINTID(int APPOINTID) {
        this.APPOINTID = APPOINTID;
    }

    public int getAPPOINTDATE() {
        return APPOINTDATE;
    }

    public void setAPPOINTDATE(int APPOINTDATE) {
        this.APPOINTDATE = APPOINTDATE;
    }

    public int getDOCTOR_ID() {
        return DOCTOR_ID;
    }

    public void setDOCTOR_ID(int DOCTOR_ID) {
        this.DOCTOR_ID = DOCTOR_ID;
    }

    public int getPATIENT_ID() {
        return PATIENT_ID;
    }

    public void setPATIENT_ID(int PATIENT_ID) {
        this.PATIENT_ID = PATIENT_ID;
    }
}
