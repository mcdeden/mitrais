package com.mcdeden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mcdeden.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("select c from User c where c.email =:email or c.mobileNumber =:mop")
	Optional<User> findByEmailOrMobileNumber(@Param("email") String email, @Param("mop") String mop);
	
}
