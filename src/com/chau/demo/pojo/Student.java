package com.chau.demo.pojo;

import java.util.Date;

/**
 * @author wilfred
 * 学生实体类
 */
public class Student implements java.io.Serializable {
    private static final long serialVersionUID = -61893657689063058L;
    private int sid; // 学号
    private String sname; // 学生姓名
    private String gender; // 性别
    private Date birth; // 生日
    private String email; // 邮箱
    private String remarks; // 备注

    private Klass klass;  // 学生所属的班级

    public Student() {
    }

    public Student(int sid, String sname, String gender, Date birth, String email, String remarks, Klass klass) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.remarks = remarks;
        this.klass = klass;
    }

    public Student(String sname, String gender, Date birth, String email, String remarks, Klass klass) {
        this.sname = sname;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.remarks = remarks;
        this.klass = klass;
    }

    public Student(int sid, String sname, String gender, Date birth, String email, String remarks) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.remarks = remarks;
    }

    public Student(String sname, String gender, Date birth, String email, String remarks) {
        this.sname = sname;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.remarks = remarks;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
