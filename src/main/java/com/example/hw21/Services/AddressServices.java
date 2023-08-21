package com.example.hw21.Services;


import com.example.hw21.APIs.ApiException;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Models.Address;
import com.example.hw21.Models.Teacher;
import com.example.hw21.Repos.AddressRepo;
import com.example.hw21.Repos.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServices {

    private final AddressRepo addressRepo;
    private final TeacherRepo teacherRepo;

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


            teacherRepo.save(teacher);

        } else
            throw new ApiException("wrong teacher ID");
    }

}
