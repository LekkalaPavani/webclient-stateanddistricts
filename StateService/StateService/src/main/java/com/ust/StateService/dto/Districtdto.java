package com.ust.StateService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Districtdto {
    public String districtId;
    public String districtName;
    public String stateId;
    public int population;
}
