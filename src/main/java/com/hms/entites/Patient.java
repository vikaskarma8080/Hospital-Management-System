package com.hms.entites;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String age;
    private String blood;
    private String prescription;
    private String dose;
    private String fees;
    private String urgency;

    /*
    * aaaaaaaaaaaaaaaaaaaaaaaa
    * */
}
