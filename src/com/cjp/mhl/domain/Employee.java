package com.cjp.mhl.domain;

/**
 * @author CJP
 * @version 1.0
 */
public class Employee {
    private Integer index_id;
    private String id;
    private String pwd;
    private String name;
    private String job;

    public Employee() {
    }

    public Employee(Integer index_id, String id, String pwd, String name, String job) {
        this.index_id = index_id;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public Integer getIndex_id() {
        return index_id;
    }

    public void setIndex_id(Integer index_id) {
        this.index_id = index_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
