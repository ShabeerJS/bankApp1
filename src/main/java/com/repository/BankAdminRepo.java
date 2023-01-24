package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.BankAdmin;
@Repository
public interface BankAdminRepo extends JpaRepository<BankAdmin, Integer> {

}
