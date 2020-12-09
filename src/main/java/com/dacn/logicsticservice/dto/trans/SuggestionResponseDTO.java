package com.dacn.logicsticservice.dto.trans;

import com.dacn.logicsticservice.model.Company;
import com.dacn.logicsticservice.model.RulRate;

import java.util.List;

public class SuggestionResponseDTO {

    private int rulRateId;
    private String companyName;
    private String coDescription;
    private float transitTime;
    private float amount;
    private String amountCurrency;
    private List<SurchargeDTO> surcharges;

    public int getRulRateId() {
        return rulRateId;
    }

    public void setRulRateId(int rulRateId) {
        this.rulRateId = rulRateId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(float transitTime) {
        this.transitTime = transitTime;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getAmountCurrency() {
        return amountCurrency;
    }

    public void setAmountCurrency(String amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    public String getCoDescription() {
        return coDescription;
    }

    public void setCoDescription(String coDescription) {
        this.coDescription = coDescription;
    }

    public List<SurchargeDTO> getSurcharges() {
        return surcharges;
    }

    public void setSurcharges(List<SurchargeDTO> surcharges) {
        this.surcharges = surcharges;
    }

    public void doMappingEntityToDTO(RulRate rulRate, Company company, float routTransitTime, List<SurchargeDTO> surchargeDTOS) {
        this.rulRateId = rulRate.getId();
        this.companyName = company.getCoName();
        this.coDescription = company.getCoDescription();
        this.transitTime = routTransitTime;
        this.surcharges = surchargeDTOS;

        if (!surchargeDTOS.isEmpty()) {
            float totalAmount = 0;
            for (SurchargeDTO surchargeDTO : surchargeDTOS) {
                totalAmount = totalAmount + surchargeDTO.getAmount();
            }
            this.amount = totalAmount;
            this.amountCurrency = surchargeDTOS.get(0).getCurrencyName();
        }
    }
}
