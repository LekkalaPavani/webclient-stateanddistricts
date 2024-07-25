package com.ust.DisrtrictService.repository;

import com.ust.DisrtrictService.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District,String> {
    List<District> findByStateId(String stateId);
}
