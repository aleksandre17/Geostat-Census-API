package com.apps.censusapp.ui.model.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import java.util.Date;

public class AddressingRequest {

    private Integer id;

    private Integer mapId;

    private Integer supervisor_id;

    private String uuid;

    private Integer regionId;
    private Integer municipalId;

    private Integer cityId;

    private Integer unityId;

    private Integer villageId;

    private String district;

    private String mr;

    private String quarter;

    private String street;

    private String building;

    private String corpus;

    private Integer buildingType;

    private Integer flatNum;

    private Integer livingStatus;

    private String institutionName;

    private Integer institutionSpaceNum;

    private String comment;

    private String rollbackComment;

    private Integer status;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }


    public Integer getMunicipalId() {
        return municipalId;
    }

    public void setMunicipalId(Integer municipalId) {
        this.municipalId = municipalId;
    }


    public Integer getCityId() {
        return cityId;
    }

    public void setCityId( Integer cityId) {
        this.cityId = cityId;
    }


    public Integer getUnityId() {
        return unityId;
    }

    public void setUnityId(Integer unityId) {
        this.unityId = unityId;
    }


    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    public String getMr() {
        return mr;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }


    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }


    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }


    public Integer getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(Integer buildingType) {
        this.buildingType = buildingType;
    }


    public Integer getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(Integer flatNum) {
        this.flatNum = flatNum;
    }


    public Integer getLivingStatus() {
        return livingStatus;
    }

    public void setLivingStatus(Integer livingStatus) {
        this.livingStatus = livingStatus;
    }


    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }


    public Integer getInstitutionSpaceNum() {
        return institutionSpaceNum;
    }

    public void setInstitutionSpaceNum(Integer institutionSpaceNum) {
        this.institutionSpaceNum = institutionSpaceNum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRollbackComment() {
        return rollbackComment;
    }

    public void setRollbackComment(String rollbackComment) {
        this.rollbackComment = rollbackComment;
    }

    public Integer getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(Integer supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
