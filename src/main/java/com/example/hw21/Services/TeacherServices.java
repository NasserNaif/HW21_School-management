package com.example.hw21.Services;

import com.example.hw21.APIs.ApiException;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.DTO.TeacherDTO;
import com.example.hw21.Models.Address;
import com.example.hw21.Models.Course;
import com.example.hw21.Models.Teacher;
import com.example.hw21.Repos.AddressRepo;
import com.example.hw21.Repos.CourseRepo;
import com.example.hw21.Repos.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServices {
    private final TeacherRepo teacherRepo;
    private final AddressRepo addressRepo;
    private final CourseRepo courseRepo;

    public List<Teacher> getAllTeacher() {
        return teacherRepo.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    public void updateTeacher(Integer id, TeacherDTO newTeacher) {
        Teacher teacher = teacherRepo.findTeacherById(id);

        if (teacher != null) {
            teacher.setName(newTeacher.getName());
            teacher.setAge(newTeacher.getAge());
            teacher.setEmail(newTeacher.getEmail());
            teacher.setSalary(newTeacher.getSalary());

            teacherRepo.save(teacher);
        } else
            throw new ApiException("wrong teacher ID");
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepo.findTeacherById(id);

        if (teacher != null) {
            addressRepo.delete(teacher.getAddress());
            teacherRepo.delete(teacher);
        } else
            throw new ApiException("wrong teacher ID");
    }

    public Teacher search(Integer id) {
        return teacherRepo.findTeacherById(id);
    }

    public void addAddress(AddressDTO address) {
        Teacher teacher = teacherRepo.findTeacherById(address.getTeacher_id());

        if (teacher != null) {
            Address address1 = new Address(null,
                    address.getArea(),
                    address.getStreet(),
                    address.getBuildingNumber(),
                    teacher
            );
            addressRepo.save(address1);
        } else
            throw new ApiException("wrong teacher ID");
    }

    public void updateAddress(Integer id, AddressDTO newAddress) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher != null) {
            Address address = teacher.getAddress();

            address.setArea(newAddress.getArea());
            address.setStreet(newAddress.getStreet());
            address.setBuildingNumber(newAddress.getBuildingNumber());

            teacher.setAddress(address);

            addressRepo.save(address);
            teacherRepo.save(teacher);
        } else
            throw new ApiException("wrong teacher ID");
    }


    public void deleteAddress(Integer id) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher != null) {
            addressRepo.deleteById(id);
        }
        throw new ApiException("wrong teacher ID");
    }

    public void assignTeacherToCourse(Integer teacherID, Integer courseID) {
        Teacher teacher = teacherRepo.findTeacherById(teacherID);
        Course course = courseRepo.findCourseById(courseID);

        if (teacher == null || course == null) {
            throw new ApiException("please check the IDs for merchant or branch");
        }
        course.setTeacher(teacher);
        courseRepo.save(course);
    }
}
