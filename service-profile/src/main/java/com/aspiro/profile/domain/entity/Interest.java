package com.aspiro.profile.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@Node
public class Interest {

    @Id
    private String name;  // Unique identifier for interests

    public Interest() {
    }

    public Interest(String name) {
        this.name = name;
    }

    // Getter and Setter
}
