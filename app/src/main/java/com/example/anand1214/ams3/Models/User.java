package com.example.anand1214.ams3.Models;

public class User {

    String profilepic, uName, umail, uContact,upassword,uId,lastMessage;

    public User(String profilepic, String uName, String umail, String uContact, String upassword, String uId, String lastMessage) {
        this.profilepic = profilepic;
        this.uName = uName;
        this.umail = umail;
        this.uContact = uContact;
        this.upassword = upassword;
        this.uId = uId;
        this.lastMessage = lastMessage;
    }
    public User(){}

    //signup constructor

    public User(String uName, String umail, String uContact, String upassword) {
        this.uName = uName;
        this.umail = umail;
        this.uContact = uContact;
        this.upassword = upassword;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail;
    }

    public String getuContact() {
        return uContact;
    }

    public void setuContact(String uContact) {
        this.uContact = uContact;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

}
