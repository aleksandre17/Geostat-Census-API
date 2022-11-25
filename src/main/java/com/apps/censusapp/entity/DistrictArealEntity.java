package com.apps.censusapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "district_areal")
public class DistrictArealEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "district_areal_entity_seq_generator")
    @SequenceGenerator(name = "district_areal_entity_seq_generator", sequenceName = "DISTRICT_AREAL_ENTITY_GENERATOR")
    private Long id;

    @Column(unique = true, nullable = false)
    private String distr_code;

    @Column(nullable = false)
    private String distr_id;

    @Column
    private String instr_id;

    @Column
    private String munic_id;

    @Column
    private String region_id;

    @Column(columnDefinition = "TEXT")
    private String geometry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distr", fetch = FetchType.LAZY, orphanRemoval = false)
    private final Set<House> houses =  new HashSet<>();

    public void addHouse(House house) {
        houses.add(house);
        house.setDistr(this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistr_code() {
        return distr_code;
    }

    public void setDistr_code(String distr_code) {
        this.distr_code = distr_code;
    }

    public String getDistr_id() {
        return distr_id;
    }

    public void setDistr_id(String distr_id) {
        this.distr_id = distr_id;
    }

    public String getInstr_id() {
        return instr_id;
    }

    public void setInstr_id(String instr_id) {
        this.instr_id = instr_id;
    }

    public String getMunic_id() {
        return munic_id;
    }

    public void setMunic_id(String munic_id) {
        this.munic_id = munic_id;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
}
