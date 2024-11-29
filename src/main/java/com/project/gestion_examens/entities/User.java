package com.project.gestion_examens.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Basic
    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    @ToString.Exclude
    @JsonIgnore
    @Basic
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public void assignRoleToUser(Role role) {
        this.role = role;
        role.getUsers().add(this);
    }

    public void removeRoleFromUser() {
        if (this.role != null) {
            getRole().getUsers().remove(this);
            this.role = null;
        }
    }
}
