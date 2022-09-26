package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Roles;
@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer>{
	@Query("SELECT r FROM Roles r JOIN r.accounts acc WHERE acc.accountID = ?1")
	public Roles findRoles(String id);
}
