package model;

public class PatientModel {
    private int patient_id;
    private String name;
    private String address;
    private String age;
    private String gender;
    private String contact_no;
    private String ward_name;
    private String summary;
//    private String dates;


    public PatientModel(int patient_id,
                        String name,
                        String address,
                        String age,
                        String gender,
                        String contact_no,
                        String ward_name,
                        String summary) {
        this.name=name;
        this.patient_id = patient_id;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.contact_no = contact_no;
        this.ward_name = ward_name;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getWard_name() {
        return ward_name;
    }

    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
