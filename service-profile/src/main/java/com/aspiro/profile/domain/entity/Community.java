package com.aspiro.profile.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Node
public class Community {

    @Id
    @GeneratedValue
    private Long id;

    private String name;          // Community name
    private String description;   // Description of the community
    private String category;      // Category or type of the community, e.g., "Fitness", "Programming"
    private LocalDateTime createdAt;

    // Relationship: Profiles that join this community
    @Relationship(type = "MEMBER_OF", direction = Relationship.Direction.INCOMING)
    @JsonBackReference
    private Set<Profile> members = new HashSet<>();

    // Additional relationships can be defined if needed
}
