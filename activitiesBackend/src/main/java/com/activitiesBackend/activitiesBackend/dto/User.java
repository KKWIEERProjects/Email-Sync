package com.activitiesBackend.activitiesBackend.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase;

import java.util.List;

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

    @NonNull
    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @NonNull
    @Column
    private String roles;

    @NonNull
    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String admin_id;

    @Column
    private String token;

    /**
     * User ----> user----->template
     * if admin removed all templates also removed
     */
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Template> templates;

}
