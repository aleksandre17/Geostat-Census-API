package com.apps.censusapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "addressing_supervision")
public class SupervisionEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "supervision_entity_seq_generator")
    @SequenceGenerator(name = "supervision_entity_seq_generator", sequenceName = "SUPERVISION_ENTITY_GENERATOR")
    private Long id;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(name = "start_time", nullable = true)
    private String startTime;

    @Column(name = "end_time", nullable = true)
    private String endTime;

    @Column(name = "addressing_uuid")
    private String addressing_uuid;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Addressing.class)
    @JoinColumn(name = "addressing_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Addressing addressing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressing_uuid() {
        return addressing_uuid;
    }

    public void setAddressing_uuid(String addressing_uuid) {
        this.addressing_uuid = addressing_uuid;
    }

    public Addressing getAddressing() {
        return addressing;
    }

    public void setAddressing(Addressing addressing) {
        this.addressing = addressing;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
