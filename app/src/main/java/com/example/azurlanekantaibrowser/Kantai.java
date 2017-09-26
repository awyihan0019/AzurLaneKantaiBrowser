package com.example.azurlanekantaibrowser;

/**
 * Created by yihan on 26/9/2017.
 */

public class Kantai implements java.io.Serializable {

    private String name;
    private String No;
    private String type;
    private String camp;

    public Kantai(String name, String no, String type, String camp) {
        this.name = name;
        No = no;
        this.type = type;
        this.camp = camp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }
}
