package com.softassi.oj.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto implements Serializable {

    private String id;

    private Integer ac;

    private Integer submit;

    private Integer score;

    private Integer rating;

    @JsonProperty("ac_exercise")
    private String acExercise;

}
