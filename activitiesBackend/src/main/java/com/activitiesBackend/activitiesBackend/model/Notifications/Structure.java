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
public class Structure {

    @Id
    private String id;

    @Column
    private String event;

    @Column
    private String name;

    /**
     * for dates
     */
    @Column
    private String estimate;

    @Column
    private String venue;

    @Column
    private String info;

    @Column
    private String coo;

    @Column
    private String mail;

}
