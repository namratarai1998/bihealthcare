package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    private String email;
    private int userid;
    private String password;
    private String usertype;



    public UserModel(int userid,String email, String password, String usertype) {
        this.email = email;
        this.userid = userid;
        this.password = password;
        this.usertype = usertype;
    }
    public String getUsertype() {
        return usertype;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
