package org.example.dto;

public class Information extends Dto {
    public int id;
    public String regDate;
    public String name;
    public String sex;
    public String age;
    public String major;
    public String phoneNumber;
    public String mbti;
    public String snsId;
    public String appeal;

    public Information(int id, String regDate, String name, String sex, String age, String major, String phoneNumber, String mbti, String snsId, String appeal) {
        this.id = id;
        this.regDate = regDate;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.mbti = mbti;
        this.snsId = snsId;
        this.appeal = appeal;
    }
}