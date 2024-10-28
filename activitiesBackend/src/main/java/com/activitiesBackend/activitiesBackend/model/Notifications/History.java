package com.activitiesBackend.activitiesBackend.model.Notifications;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column
    private String event;

    @Column
    private String status;

    @Column
    private String coo;

    @Column
    private String date;

    @Column
    private String phone;

}
