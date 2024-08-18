package com.activitiesBackend.activitiesBackend.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase;

@Entity
@Table(name="users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String roles;


}
