package edu.service.signin.bean;

public class StudentBean {

    private int id;

    private String scode;

    private String sname;

    private String spwd;

    private String sclass;

    public StudentBean(int id, String scode, String sname, String spwd, String sclass) {
        this.id = id;
        this.scode = scode;
        this.sname = sname;
        this.spwd = spwd;
        this.sclass = sclass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }


}
