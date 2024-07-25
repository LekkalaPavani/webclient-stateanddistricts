package com.ust.DisrtrictService.controller;

import com.ust.DisrtrictService.model.District;
import com.ust.DisrtrictService.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @PostMapping("/adddistrict")
    public ResponseEntity<District> addDistrict(@RequestBody District district) {
        return ResponseEntity.ok(districtService.addDistrict(district));
    }
    @GetMapping("/getDistrict")
    public ResponseEntity<List<District>>getDistrict() {
        return ResponseEntity.ok(districtService.getDistrict());
    }
//    @GetMapping("/{dId}")
//    public ResponseEntity<District> getDistrictById(@PathVariable String dId){
//        return ResponseEntity.ok(districtService.getDistrictById(dId));
//    }
    @GetMapping("{stateId}")
    public ResponseEntity<List<District> >getstateById(@PathVariable String stateId){
        return ResponseEntity.ok(districtService.getStateById(stateId));
    }
}
