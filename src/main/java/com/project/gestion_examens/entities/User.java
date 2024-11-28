package com.project.gestion_examens.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public void assignRoleToUser(Role role) {
        this.role = role;
        role.setUser(this);
    }

    public void removeRoleFromUser() {
        if (this.role != null) {
            this.role.setUser(null);
            this.role = null;
        }
    }
}
