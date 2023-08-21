package com.example.hw21.Repos;

import com.example.hw21.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}
