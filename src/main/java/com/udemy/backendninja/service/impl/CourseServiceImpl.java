package com.udemy.backendninja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJPARepository;
import com.udemy.backendninja.service.CourseService;

public class CourseServiceImpl implements CourseService{

    @Autowired
    @Qualifier("courseJPARepository")
    private CourseJPARepository courseJPARepository;

    @Override
    public List<Course> listAllCourses() {
        return courseJPARepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseJPARepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
        courseJPARepository.deleteById(id);
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        courseJPARepository.save(course);
        return null;
    }

}
