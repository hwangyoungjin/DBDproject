package com.mentoring.model;

public class User {
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String job;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "[ "
                +"id : "+ this.id
                +", name : "+ this.name
                +", gender : "+ this.gender
                +", job : "+ this.job
                +" ]";
    }
}
