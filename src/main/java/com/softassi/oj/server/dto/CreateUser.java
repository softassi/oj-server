package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CreateUser {

    private String name;

    @JsonProperty(value = "create_time")
    private String createTime = new Date().toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CreateUser{");
        sb.append("name='").append(name).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
