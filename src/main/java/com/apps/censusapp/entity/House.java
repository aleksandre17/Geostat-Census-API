package com.apps.censusapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "houses")
public class House implements Serializable {

    @Id
    @GeneratedValue(generator = "house_entity_seq_generator")
    @SequenceGenerator(name = "house_entity_seq_generator", sequenceName = "HOUSE_ENTITY_GENERATOR")
    private Long id;

    @Column
    private String region_id;

    @Column
    private String munic_id;

    @Column
    private String instr_id;

    @Column
    private String house_id;

    @Column(unique = true, nullable = false)
    private String house_code;

    @Column(name = "is_housing", columnDefinition = "tinyint default 0 not null")
    private Integer sacx_stat;

    @Column(name = "status")
    private Integer status;

    @Column
    private String geometry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "house", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("house")
    private final Set<Addressing> addresses =  new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "distr_code", referencedColumnName = "distr_code")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DistrictArealEntity distr;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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


    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public String getHouse_code() {
        return house_code;
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

    public void setHouse_code(String house_code) {
        this.house_code = house_code;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public void addAddresses(Addressing addressing) {
        this.addresses.add(addressing);
        addressing.setHouse(this);
    }

    public Set<Addressing> getAddresses() {
        return addresses;
    }

    public DistrictArealEntity getDistr() {
        return distr;
    }

    public void setDistr(DistrictArealEntity distr) {
        this.distr = distr;
    }
}
