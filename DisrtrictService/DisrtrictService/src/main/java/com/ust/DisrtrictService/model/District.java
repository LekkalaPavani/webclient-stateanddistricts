package com.ust.DisrtrictService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="disricts")
public class District {
    @Id
    public String districtId;
    public String districtName;
    public String stateId;
    public int population;
}
