package com.softassi.oj.server.object;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_data")
public class UserData {

    @Id
    private String id;

    @Field
    private Integer ac;

    @Field
    private Integer submit;

    @Field
    private Integer score;

    @Field
    private Integer rating;

    @Field(name = "ac_exercise")
    private String acExercise;

}
