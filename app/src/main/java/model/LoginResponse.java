package model;

public class LoginResponse {
//  status
//    access token
//    message
//    userid
    private String email;
    private String accessToken;
    private String mesasge;
    private boolean status;
    private int userId;
    private String type;

    public String getUsertype() {
        return type;
    }

    public void setUsertype(String usertype) {
        this.type = usertype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMesasge() {
        return mesasge;
    }

    public void setMesasge(String mesasge) {
        this.mesasge = mesasge;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
