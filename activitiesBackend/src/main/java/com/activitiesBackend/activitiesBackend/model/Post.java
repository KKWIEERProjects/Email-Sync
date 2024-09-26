package com.activitiesBackend.activitiesBackend.model;

import enums.Event;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long Id;

    private Event event;

    private String Information;
}


