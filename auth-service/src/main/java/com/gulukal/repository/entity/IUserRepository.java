package com.gulukal.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    //   kullaninicin oturum acabilmesi icin email ve sifre  bilgisi alinir. kayitli bilgi var ise
    //   optional olarak cevap donulur.
    //   @param username - email bilgisi
    //   @param password - sifre bilgisi
    //   @return

    Optional<User> findByUsernameAndPassword(String username, String password);

    //   kullanici aktiflik durumunu belirtir
    //   @param status - email bilgisi
    //   @return

    List<User> findByStatus(int status);
}
