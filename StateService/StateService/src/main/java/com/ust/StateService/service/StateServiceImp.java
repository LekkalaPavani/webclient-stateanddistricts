package com.ust.StateService.service;

import com.ust.StateService.dto.Districtdto;
import com.ust.StateService.dto.Responsedto;
import com.ust.StateService.dto.Statedto;
import com.ust.StateService.model.State;
import com.ust.StateService.repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class StateServiceImp implements StateService{
@Autowired

    private StateRepo repo;
    @Autowired
    private WebClient  webClient;

    @Override

     public State addState(State state) {
          return repo.save(state);
}

    @Override
    public List<State> getAllStates() {
        return repo.findAll();
    }
    @Override
    public Responsedto getAllDistricts(String stateId) {
        Responsedto responseDto = new Responsedto();
        State state = repo.findById(stateId).orElseThrow(() -> new RuntimeException("state not found"));

         Statedto statedto=mapToState(state);
        List<Districtdto> district = webClient
                .get()
                .uri("http://localhost:9098/districts/" + state.getStateId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Districtdto>>() {})
                .block();
        responseDto.setState(statedto);
        responseDto.setDistrict(district);

        return responseDto;
    }

    private Statedto mapToState(State state) {
        Statedto dto = new Statedto();
        dto.setStateId(state.getStateId());
        dto.setStateName(state.getStateName());
        dto.setCountry(state.getCountry());
        return dto;
    }
}
