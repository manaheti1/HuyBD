package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

}
