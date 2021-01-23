package com.dacn.logicsticservice.dto.trans;

import com.dacn.logicsticservice.model.CMContainer;
import com.dacn.logicsticservice.model.CMLocation;
import com.dacn.logicsticservice.model.Company;
import com.dacn.logicsticservice.model.RulRate;

import java.util.List;

public class SuggestionDetailDTO {

    private int rulRateId;
    private int status;
    private String companyName;
    private String coDescription;
    private float transitTime;
    private float amount;
    private String amountCurrency;
    private String validDate;
    private String applyDate;
    private List<SurchargeDTO> surcharges;
    private CMLocation startLocation;
    private CMLocation endLocation;
    private CMContainer container;

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

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public List<SurchargeDTO> getSurcharges() {
        return surcharges;
    }

    public void setSurcharges(List<SurchargeDTO> surcharges) {
        this.surcharges = surcharges;
    }

    public CMLocation getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(CMLocation startLocation) {
        this.startLocation = startLocation;
    }

    public CMLocation getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(CMLocation endLocation) {
        this.endLocation = endLocation;
    }

    public CMContainer getContainer() {
        return container;
    }

    public void setContainer(CMContainer container) {
        this.container = container;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void doMappingEntityToDTO(RulRate rulRate, Company company, float routTransitTime, List<SurchargeDTO> surchargeDTOS) {
        this.rulRateId = rulRate.getId();
        this.companyName = company.getCoName();
        this.coDescription = company.getCoDescription();
        this.transitTime = routTransitTime;
        this.surcharges = surchargeDTOS;
        this.validDate = rulRate.getValidDate();
        this.applyDate = rulRate.getApplyDate();

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
