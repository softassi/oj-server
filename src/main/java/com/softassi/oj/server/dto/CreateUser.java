package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    @JsonProperty(value = "create_time")
    private String createTime = new Date().toString();
}
