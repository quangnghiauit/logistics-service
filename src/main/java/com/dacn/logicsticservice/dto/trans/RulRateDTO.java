package com.dacn.logicsticservice.dto.trans;

import com.dacn.logicsticservice.model.CMContainer;
import com.dacn.logicsticservice.model.CMRouting;
import com.dacn.logicsticservice.model.Company;

public class RulRateDTO {

    private int id;
    private CMRouting routing;
    private CMContainer container;
    private Company company;
    private String validDate;
    private String applyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CMRouting getRouting() {
        return routing;
    }

    public void setRouting(CMRouting routing) {
        this.routing = routing;
    }

    public CMContainer getContainer() {
        return container;
    }

    public void setContainer(CMContainer container) {
        this.container = container;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
}
