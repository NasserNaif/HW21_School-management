package com.example.hw21.Repos;


import com.example.hw21.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
}
