package com.example.vikasojha.quizbee;

public class UserHelperClass {

    String name, username, email, phoneNo, password, cScore, quiz_taken, cTscore;

    public UserHelperClass() {}

//    public UserHelperClass(String name, String username, String email, String phoneNo, String password, String cScore, String quiz_taken) {
//        this.name = name;
//        this.username = username;
//        this.email = email;
//        this.phoneNo = phoneNo;
//        this.password = password;
//        this.cScore = cScore;
//        this.quiz_taken = quiz_taken;
//    }

    public UserHelperClass(String name, String username, String email, String phoneNo, String password, String cScore, String quiz_taken, String cTscore) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.cScore = cScore;
        this.quiz_taken = quiz_taken;
        this.cTscore = cTscore;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setcScore(String cScore) {
        this.cScore = cScore;
    }

    public String getcScore() {
        return cScore;
    }

    public String getQuiz_taken() {
        return quiz_taken;
    }

    public void setQuiz_taken(String quiz_taken) {
        this.quiz_taken = quiz_taken;
    }

    public String getcTscore() {
        return cTscore;
    }

    public void setcTscore(String cTscore) {
        this.cTscore = cTscore;
    }
}
