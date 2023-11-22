package com.example.RTH.entity;

import com.example.RTH.Enum.RoleType;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column
    private RoleType role;

    public void setRole(RoleType role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
