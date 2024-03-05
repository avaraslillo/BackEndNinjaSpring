package com.udemy.backendninja.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Course;

@Repository("courseJPARepository")
public interface CourseJPARepository extends JpaRepository<Course,Serializable>{
 
    public abstract Course findByPrice(int price);

    public abstract Course findByPriceAndName(int price, String name);

    public abstract List<Course> findByNameOrderByHours(String name);

    public abstract Course findByNameOrPrice(String name, int price);
}
