package com.example.hw21.Controllers;


import com.example.hw21.APIs.ApiResponse;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.DTO.TeacherDTO;
import com.example.hw21.Models.Teacher;
import com.example.hw21.Services.TeacherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher/")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherServices teacherServices;


    @GetMapping("get")
    public ResponseEntity getAllTeacher() {
        return ResponseEntity.status(200).body(teacherServices.getAllTeacher());
    }

    @PostMapping("add")
    public ResponseEntity addTeacher(@RequestBody Teacher newTeacher) {
        teacherServices.addTeacher(newTeacher);
        return ResponseEntity.status(201).body(new ApiResponse("teacher added"));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody TeacherDTO newTeacher) {
        teacherServices.updateTeacher(id, newTeacher);
        return ResponseEntity.status(201).body(new ApiResponse("teacher updated"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherServices.deleteTeacher(id);
        return ResponseEntity.status(201).body(new ApiResponse("teacher deletes"));
    }


    @GetMapping("search/{id}")
    public ResponseEntity searchTeacher(@PathVariable Integer id) {
        return ResponseEntity.status(201).body(teacherServices.search(id));
    }


    // address

    @PostMapping("address/add")
    public ResponseEntity addAddress(@RequestBody AddressDTO address) {
        teacherServices.addAddress(address);
        return ResponseEntity.status(201).body(new ApiResponse("address added"));
    }

    @PutMapping("address/update/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id, @RequestBody AddressDTO address) {
        teacherServices.updateAddress(id, address);
        return ResponseEntity.status(201).body(new ApiResponse("address updated"));
    }

    @DeleteMapping("address/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id) {
        teacherServices.deleteAddress(id);
        return ResponseEntity.status(201).body(new ApiResponse("address delete"));
    }
}
