package com.UST.librarymodule3test.reporitory;

import com.UST.librarymodule3test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.security.cert.CertPathBuilder;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
