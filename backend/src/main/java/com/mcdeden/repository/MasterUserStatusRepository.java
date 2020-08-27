package com.mcdeden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcdeden.entity.MasterUserStatus;

@Repository
public interface MasterUserStatusRepository extends JpaRepository<MasterUserStatus, String>{

}
