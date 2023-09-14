package com.tipperoo.springbootInfrastructure.controller;

import com.tipperoo.springbootInfrastructure.dao.Address;
import com.tipperoo.springbootInfrastructure.enums.Countries;
import com.tipperoo.springbootInfrastructure.enums.States;
import com.tipperoo.springbootInfrastructure.repos.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewAddress (@RequestParam String streetAddress, @RequestParam String streetAddress2,
                          @RequestParam String city, @RequestParam String state, @RequestParam String country,
                          @RequestParam String zipcode, @RequestParam Integer userId) {
        Address newAddress = new Address();
        newAddress.setStreetAddress(streetAddress);
        newAddress.setStreetAddress2(streetAddress2);
        newAddress.setCity(city);
        newAddress.setState(States.valueOf(state));
        newAddress.setCountry(Countries.valueOf(country));
        newAddress.setZipcode(zipcode);
        newAddress.setUserId(userId);
        newAddress.setDateCreated(new Timestamp(System.currentTimeMillis()));
        Address newCreatedAddress = addressRepository.save(newAddress);
        return "Saved with AddressId: " + newCreatedAddress.getAddressId();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAddress(@RequestBody Address address, @PathVariable Integer id) {
        Optional<Address> studentOptional = addressRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        address.setAddressId(id);
        address.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        addressRepository.save(address);
        return ResponseEntity.ok("Updated address: " + id + "\nwith new details:\n" + address);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable Integer id) {
        try {
            addressRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed: address entity not found");
        }
        return ResponseEntity.ok("Deleted address: " + id);
    }

    @GetMapping(path="/get/all")
    public @ResponseBody Iterable<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody
    Optional<Address> getAddress(@PathVariable Integer id) {
        return addressRepository.findById(id);
    }

}
