package com.example.hw21.Controllers;


import com.example.hw21.APIs.ApiResponse;
import com.example.hw21.DTO.TeacherDTO;
import com.example.hw21.Models.Course;
import com.example.hw21.Models.Teacher;
import com.example.hw21.Services.CourseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course/")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServices courseServices;

    @GetMapping("get")
    public ResponseEntity getAllCourse() {
        return ResponseEntity.status(200).body(courseServices.getAllCourses());
    }

    @PostMapping("add")
    public ResponseEntity addCourse(@RequestBody Course newCourse) {
        courseServices.addCourse(newCourse);
        return ResponseEntity.status(201).body(new ApiResponse("course added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody Course newCourse) {
        courseServices.updateCourse(id, newCourse);
        return ResponseEntity.status(201).body(new ApiResponse("course updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseServices.deleteCourse(id);
        return ResponseEntity.status(201).body(new ApiResponse("course deletes"));
    }

    @GetMapping("teacher/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(courseServices.findTeacherName(id));
    }


}
