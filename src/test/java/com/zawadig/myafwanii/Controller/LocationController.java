package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.House;
import com.zawadig.myafwanii.Repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

    @Autowired
    private HouseRepository houseRepository;

    @GetMapping("/wards")
    public List<String> getAllWards() {
        return houseRepository.findDistinctWards();
    }

    @GetMapping("/streets/by-ward/{ward}")
    public List<String> getStreetsByWard(@PathVariable String ward) {
        return houseRepository.findDistinctStreetsByWard(ward);
    }

    @GetMapping("/houses/by-street/{street}")
    public List<House> getHousesByStreet(@PathVariable String street) {
        return houseRepository.findByStreetNameAndDeletedFalse(street);
    }
}
