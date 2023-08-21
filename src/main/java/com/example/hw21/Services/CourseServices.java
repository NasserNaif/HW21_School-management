package com.example.hw21.Services;


import com.example.hw21.APIs.ApiException;
import com.example.hw21.APIs.ApiResponse;
import com.example.hw21.Models.Course;
import com.example.hw21.Repos.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServices {

    private final CourseRepo courseRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public void updateCourse(Integer id, Course newCourse) {
        Course course = courseRepo.findCourseById(id);

        if (course != null) {
            course.setName(newCourse.getName());
            courseRepo.save(course);
        }
        throw new ApiException("wrong course ID");
    }


    public void deleteCourse(Integer id) {
        Course course = courseRepo.findCourseById(id);

        if (course != null) {
            courseRepo.delete(course);
        }
        throw new ApiException("wrong course ID");
    }

    public ApiResponse findTeacherName(Integer id) {
        Course course = courseRepo.findCourseById(id);

        if (course != null) {
            return new ApiResponse("the teacher for this course : " + course.getName() + ", is :  " + course.getTeacher().getName());
        }
        throw new ApiException("wrong course Id");
    }

}
