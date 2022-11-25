package com.apps.censusapp.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "users")
@Proxy(lazy = false)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "user_entity_seq_generator")
    @SequenceGenerator(name = "user_entity_seq_generator", sequenceName = "USER_ENTITY_GENERATOR")
    @JsonIncludeProperties("parent")
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @JsonIgnoreProperties("id")
    private UserEntity parent;

    @Column(nullable = false)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    @JsonIgnoreProperties("userEntity")
    private UserAlter user;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AddressEntity> addresses;

    @JsonIgnore
    private Integer categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public UserAlter getUser() {
        return user;
    }

    public void setUser(UserAlter user) {
        this.user = user;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public UserEntity getParent() {
        return parent;
    }

    public void setParent(UserEntity parent) {
        this.parent = parent;
    }
}
