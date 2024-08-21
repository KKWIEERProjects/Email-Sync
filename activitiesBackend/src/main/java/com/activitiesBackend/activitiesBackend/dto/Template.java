package com.activitiesBackend.activitiesBackend.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "template")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column
    private String data;

    //what do join
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id")
    private User user;
}
