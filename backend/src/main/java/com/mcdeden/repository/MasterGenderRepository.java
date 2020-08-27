package com.mcdeden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcdeden.entity.MasterGender;

@Repository
public interface MasterGenderRepository extends JpaRepository<MasterGender, String>{

}
