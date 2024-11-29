package com.project.gestion_examens.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Basic
    @Column(name = "name", nullable = false, length = 45, unique = true)
    private String name;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_hierarchy",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_role_id")
    )
    private List<Role> parentRoles = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "parentRoles", fetch = FetchType.EAGER)
    private List<Role> subRoles = new ArrayList<>();

    public void addParentRole(Role parentRole) {
        this.parentRoles.add(parentRole);
        parentRole.getSubRoles().add(this);
    }

    public List<String> getAllPermissions() {
        List<String> permissions = new ArrayList<>();
        permissions.add(this.name);

        // Recursively add permissions of subRoles
        for (Role subRole : subRoles) {
            permissions.addAll(subRole.getAllPermissions());
        }

        return permissions;
    }

    public enum RoleName {
        SuperAdmin,
        UniversityAdmin,
        EstablishmentAdmin,
        DepartmentAdmin,
    }
}
