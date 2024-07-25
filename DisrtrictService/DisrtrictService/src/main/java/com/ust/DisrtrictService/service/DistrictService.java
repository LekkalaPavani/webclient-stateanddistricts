package com.ust.DisrtrictService.service;

import com.ust.DisrtrictService.model.District;
import com.ust.DisrtrictService.repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepo districtRepo;

    public District addDistrict(District district) {
        return districtRepo.save(district);

    }

    public List<District> getDistrict() {
        return  districtRepo.findAll();
    }



    public List<District> getStateById(String stateId) {
        return districtRepo.findByStateId(stateId);
    }
}
