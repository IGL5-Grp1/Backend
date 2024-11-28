package com.project.gestion_examens.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id",nullable = false)
    private Long roleId ;

    @Basic
    @Column(name = "name",nullable = false,length = 45,unique = true)
    private String name ;


    @OneToOne(mappedBy = "role", fetch = FetchType.LAZY)
    private User user;

    public Role(String name) {
        this.name = name;
    }


}
