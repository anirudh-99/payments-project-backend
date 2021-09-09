package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.data.entities.MessageCode;

public interface MessageCodeRepo extends JpaRepository<MessageCode, String> {

}
