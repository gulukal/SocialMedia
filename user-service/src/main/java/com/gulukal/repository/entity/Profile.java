package com.gulukal.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class Profile implements Serializable {
    @Id
    //soz konusu string olunca id ye string verilir ve asla girilmez
    String id;
    long authid;
    String firstname;
    String lastname;
    String email;
    String birthdate;
    String country;
    String city;
    String gender;
    String about;
    List<Interest> interest;
    Education education;
    Work work;

    @Document
    @Data
    public class Education implements Serializable{
        String name;
        int from;
        int to;
        String about;

    }

    @Document
    @Data
    public class Work implements Serializable{
        String company;
        String designation;
        int from;
        int to;
        String town;
        String description;
    }


}
