package com.apps.censusapp.ui.model.request.wrapper;

import java.util.List;

public class HouseRequest {

    private String region_id;

    private String munic_id;

    private String instr_id;

    private String distr_id;

    private String house_id;

    private String house_code;

    private String distr_code;

    private Integer sacx_stat;

    private Integer status;

    private String geometry;

    private List<AddressingWithHolders> addressing;

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getMunic_id() {
        return munic_id;
    }

    public void setMunic_id(String munic_id) {
        this.munic_id = munic_id;
    }

    public String getInstr_id() {
        return instr_id;
    }

    public void setInstr_id(String instr_id) {
        this.instr_id = instr_id;
    }

    public String getDistr_id() {
        return distr_id;
    }

    public void setDistr_id(String distr_id) {
        this.distr_id = distr_id;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public String getHouse_code() {
        return house_code;
    }

    public void setHouse_code(String house_code) {
        this.house_code = house_code;
    }

    public String getDistr_code() {
        return distr_code;
    }

    public void setDistr_code(String distr_code) {
        this.distr_code = distr_code;
    }

    public Integer getSacx_stat() {
        return sacx_stat;
    }

    public void setSacx_stat(Integer sacx_stat) {
        this.sacx_stat = sacx_stat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getGeometry() {
        return geometry;
    }

    public List<AddressingWithHolders> getAddressing() {
        return addressing;
    }
}
