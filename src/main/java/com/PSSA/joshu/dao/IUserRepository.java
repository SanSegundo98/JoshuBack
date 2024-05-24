package com.PSSA.joshu.dao;

import com.PSSA.joshu.modelos.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
	User fetchUser ( @Param("username") String username );

}

