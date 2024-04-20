package org.example.dto;
import lombok.Getter;

public class Information extends Dto {
    @Getter public int id;
    @Getter public String regDate;
   @Getter public String name;
    @Getter public String sex;
   @Getter public String age;
    @Getter public String major;
    @Getter public String phoneNumber;
   @Getter public String mbti;
    @Getter public String snsId;
    @Getter public String appeal;
    @Getter public int memberId;

    public Information(int id, String regDate, int memberId, String name, String sex, String age, String major, String phoneNumber, String mbti, String snsId, String appeal) {
        this.id = id;
        this.regDate = regDate;
        this.memberId = memberId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
        this.phoneNumber = phoneNumber;
        this.mbti = mbti;
        this.snsId = snsId;
        this.appeal = appeal;
    }

    public String getInformation() {
        return "Name: " + name + "\n Sex: " + sex + "\n Age: " + age + "\n Major: " + major +
                "\n Phone Number: " + phoneNumber + "\n MBTI: " + mbti + "\n SNS ID: " + snsId + "\n Appeal: " + appeal;
    }

    public int getId() {
        return id;
    }
}