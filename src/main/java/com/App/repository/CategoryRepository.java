package com.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
