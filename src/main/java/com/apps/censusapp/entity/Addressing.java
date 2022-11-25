package com.apps.censusapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "addressings")
public class Addressing implements Serializable {

    @Id
    @GeneratedValue(generator = "addressing_entity_seq_generator")
    @SequenceGenerator(name = "addressing_entity_seq_generator", sequenceName = "ADDRESSING_ENTITY_GENERATOR")
    private Long id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Nullable
    @Column
    private Integer userId;


    @Nullable
    @Column
    private Integer supervisor_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "house_id", referencedColumnName = "house_code")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("addresses")
    private House house;

    @Column(nullable = false)
    private Integer regionId;
    @Column(nullable = false)
    private Integer municipalId;

    @Column
    private Integer cityId;

    @Column
    private Integer unityId;

    @Column
    private Integer villageId;

    @Column
    private String district;

    @Column
    private String mr;

    @Column
    private String quarter;

    @Column
    private String street;

    @Column
    private String building;

    @Column
    private String corpus;

    @Column
    private Integer buildingType;

    @Column
    private Integer flatNum;

    @Column
    private Integer livingStatus;

    @Column
    private String institutionName;

    @Column
    private Integer institutionSpaceNum;

    @Column
    private String comment;

    @Nullable
    @Column
    private String rollbackComment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressing", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Holder> holders =  new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "addressing")
    @JsonManagedReference
    @Nullable
    private SupervisionEntity supervision;

    @Column(name = "addressing_status_id", columnDefinition = "INT NOT NULL default 1")
    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Nullable private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Nullable private Date updatedAt;

    public void addHolder(Holder holder) {
        holders.add(holder);
        holder.setAddressing(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@Nullable Integer userId) {
        this.userId = userId;
    }


    @Nullable
    public Integer getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(@Nullable Integer supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
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

    @Nullable
    public String getRollbackComment() {
        return rollbackComment;
    }

    public void setRollbackComment(@Nullable String rollbackComment) {
        this.rollbackComment = rollbackComment;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Nullable
    public SupervisionEntity getSupervision() {
        return this.supervision;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Nullable
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@Nullable Date createdAt) {
        this.createdAt = createdAt;
    }

    @Nullable
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(@Nullable Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setSupervision(SupervisionEntity supervision) {
        this.supervision = supervision;
        if (this.supervision != null) {
            this.supervision.setAddressing(this);
        }
    }
}
