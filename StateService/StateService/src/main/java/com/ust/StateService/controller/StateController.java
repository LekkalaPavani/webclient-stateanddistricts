package com.ust.StateService.controller;

import com.ust.StateService.dto.Responsedto;
import com.ust.StateService.model.State;
import com.ust.StateService.service.StateService;
import com.ust.StateService.service.StateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    StateServiceImp service;

    @PostMapping("/addstate")
    public ResponseEntity<State> addState(@RequestBody State state) {
        return ResponseEntity.ok(service.addState(state));
    }

    @GetMapping("/getAllStates")
    public ResponseEntity<List<State>> getAllStates() {
        return ResponseEntity.ok(service.getAllStates());
    }
    @GetMapping("/{stateId}")
    public ResponseEntity<Responsedto>getDistricts(@PathVariable String stateId){
        Responsedto responsedto=service.getAllDistricts(stateId);
        return ResponseEntity.ok(responsedto);
    }
}
