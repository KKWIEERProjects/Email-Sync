package com.activitiesBackend.activitiesBackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase;

@Entity
@Table(name="users")
@Data
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
