package com.activitiesBackend.activitiesBackend.model.Notifications;

import jakarta.annotation.Nonnull;
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
public class Assign {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String event;

    @Nonnull
    @Column
    private String coordinator;

    @Nonnull
    @Column
    private String info;

}
