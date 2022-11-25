package com.apps.censusapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cla_user", schema = "CL")
@Proxy(lazy = false)
public class UserAlter implements Serializable {

    @Id
    @GeneratedValue(generator = "cla_user_seq_generator")
    @SequenceGenerator(name = "cla_user_seq_generator", sequenceName = "CLA_USER_ENTITY_GENERATOR")
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String LastName;

    @Column
    private String personId;

    @Column
    private Date inactive;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private UserEntity userEntity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getInactive() {
        return inactive;
    }

    public void setInactive(Date inactive) {
        this.inactive = inactive;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
