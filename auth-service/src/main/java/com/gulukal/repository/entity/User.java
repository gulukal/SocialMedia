package com.gulukal.repository.entity;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter

@Table(name="tbluser")
@Entity
public class User {

    //SequenceGenerator tum database ozelinde asla tekrar eden id numarasi olmayacak
    @SequenceGenerator(name = "sq_tbluser_id",sequenceName = "sq_tbluser_id",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "sq_tbluser_id")
    @Id
    long id;
    String username;
    String password;
    //Stattus kullaninicin aktiflik durumunu belirtir.

    // 0  --> pasif kullanici
    // 1 --> aktif kullanici
    // 2 --> engellenmis kullanici , hesabi askida
    // 3 --> V.S

    int status;
    long createDate;
    long updateDate;



}
