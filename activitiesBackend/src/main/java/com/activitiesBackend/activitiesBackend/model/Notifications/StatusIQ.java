package com.activitiesBackend.activitiesBackend.model.Notifications;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusIQ {

    @Id
    private String id;

    @Column
    private String event;

    @Column
    private String name;

    @Column
    private String info;

    @Column
    private String status;

    @Column
    private String coo;

}
