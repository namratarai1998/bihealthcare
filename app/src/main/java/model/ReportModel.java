package model;

public class ReportModel {
    private int REPORT_ID;
    private int MAXBP;
    private int MINBP;
    private int GLUCOSE_LEVEL ;
    private int PATIENT_ID;

    public ReportModel(int REPORT_ID, int MAXBP, int MINBP, int GLUCOSE_LEVEL, int PATIENT_ID) {
        this.REPORT_ID = REPORT_ID;
        this.MAXBP = MAXBP;
        this.MINBP = MINBP;
        this.GLUCOSE_LEVEL = GLUCOSE_LEVEL;
        this.PATIENT_ID = PATIENT_ID;
    }
    public ReportModel(int MAXBP, int MINBP, int GLUCOSE_LEVEL, int PATIENT_ID) {
        this.REPORT_ID = REPORT_ID;
        this.MAXBP = MAXBP;
        this.MINBP = MINBP;
        this.GLUCOSE_LEVEL = GLUCOSE_LEVEL;
        this.PATIENT_ID = PATIENT_ID;
    }

    public int getREPORT_ID() {
        return REPORT_ID;
    }

    public void setREPORT_ID(int REPORT_ID) {
        this.REPORT_ID = REPORT_ID;
    }

    public int getMAXBP() {
        return MAXBP;
    }

    public void setMAXBP(int MAXBP) {
        this.MAXBP = MAXBP;
    }

    public int getMINBP() {
        return MINBP;
    }

    public void setMINBP(int MINBP) {
        this.MINBP = MINBP;
    }

    public int getGLUCOSE_LEVEL() {
        return GLUCOSE_LEVEL;
    }

    public void setGLUCOSE_LEVEL(int GLUCOSE_LEVEL) {
        this.GLUCOSE_LEVEL = GLUCOSE_LEVEL;
    }

    public int getPATIENT_ID() {
        return PATIENT_ID;
    }

    public void setPATIENT_ID(int PATIENT_ID) {
        this.PATIENT_ID = PATIENT_ID;
    }
}
