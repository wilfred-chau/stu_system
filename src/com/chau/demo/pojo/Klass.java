package com.chau.demo.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wilfred
 * 班级实体类
 */
public class Klass implements java.io.Serializable {
    private static final long serialVersionUID = 9129993816359984267L;
    private int cid; // 班级编号
    private String cname; // 班级名称
    private String grade; // 年级
    private String tname; // 班主任名字
    private String slogan; // 口号
    private int numbers; // 班级人数

    private Student student; // 班级的所属学生

    private List<Student> studentList = new ArrayList<>(); // 班级学生集合

    public Klass() {
    }

    public Klass(int cid, String cname, String grade, String tname, String slogan, int numbers, Student student) {
        this.cid = cid;
        this.cname = cname;
        this.grade = grade;
        this.tname = tname;
        this.slogan = slogan;
        this.numbers = numbers;
        this.student = student;
    }

    public Klass(String cname, String grade, String tname, String slogan, int numbers, Student student) {
        this.cname = cname;
        this.grade = grade;
        this.tname = tname;
        this.slogan = slogan;
        this.numbers = numbers;
        this.student = student;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent() {
        this.student = student;
    }
}
