package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName : Tag
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-23 15:36
 */

public class TagDto implements Serializable {

    private String id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime test = LocalDateTime.now();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TagDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", test=").append(test);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTest() {
        return test;
    }

    public void setTest(LocalDateTime test) {
        this.test = test;
    }
}
