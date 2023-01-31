package com.maru.socialnetwork4.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name="name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    @JsonBackReference(value = "role_grantedRole")
    private List<GrantedRole> grantedRoles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GrantedRole> getGrantedRoles() {
        return grantedRoles;
    }

    public void setGrantedRoles(List<GrantedRole> grantedRoles) {
        this.grantedRoles = grantedRoles;
    }
}
