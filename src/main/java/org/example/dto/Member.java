package org.example.dto;

public class Member extends Dto {
    public String loginId;
    public String loginPw;
    public String name;
    public String email;

    public Member(int id, String regDate, String loginId, String loginPw, String name, String email) {
        this.id = id;
        this.regDate = regDate;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
        this.email = email;
    }
}