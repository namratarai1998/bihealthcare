package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorModel {
    private int doctor_id;
    private String doctor_name;
    private String doctor_contact;
    private String doctor_address;
    private String doctor_email;
    private String qualification;
    private String specification;

    public DoctorModel(int doctor_id,
                       String doctor_name,
                       String doctor_contact,
                       String doctor_address,
                       String doctor_email,
                       String qualification,
                       String specification) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_contact = doctor_contact;
        this.doctor_address = doctor_address;
        this.doctor_email = doctor_email;
        this.qualification = qualification;
        this.specification = specification;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_contact() {
        return doctor_contact;
    }

    public void setDoctor_contact(String doctor_contact) {
        this.doctor_contact = doctor_contact;
    }

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getDoctor_email() {
        return doctor_email;
    }

    public void setDoctor_email(String doctor_email) {
        this.doctor_email = doctor_email;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
