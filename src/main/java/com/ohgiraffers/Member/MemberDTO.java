package com.ohgiraffers.Member;

import java.util.Date;

public class MemberDTO {

    private String name;
    private String id;
    private String password;
    private Date birth;
    private long index;

    public MemberDTO() {}

    public MemberDTO(String name, String id, String password, Date birth) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", birth=" + birth + "}";
    }
}
