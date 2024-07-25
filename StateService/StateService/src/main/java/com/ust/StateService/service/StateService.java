package com.ust.StateService.service;

import com.ust.StateService.dto.Responsedto;
import com.ust.StateService.model.State;

import java.util.List;

public interface StateService {
    State addState(State state);

    List<State> getAllStates();

    Responsedto getAllDistricts(String stateId);


    //Responsedto getAllDistricts(String stateId);
}
