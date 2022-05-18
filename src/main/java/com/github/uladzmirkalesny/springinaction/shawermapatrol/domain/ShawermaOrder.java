package com.github.uladzmirkalesny.springinaction.shawermapatrol.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ShawermaOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Shawerma> shawermaList;

    public void addShawerma(Shawerma shawerma) {
        this.shawermaList.add(shawerma);
    }
}
