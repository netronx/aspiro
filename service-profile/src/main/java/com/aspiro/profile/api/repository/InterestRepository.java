package com.aspiro.profile.api.repository;

import com.aspiro.profile.domain.entity.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends Neo4jRepository<Profile, Long> {

    // Add interest to a profile
    @Query("MATCH (p:Profile {userId: $userId}), (i:Interest {name: $interest}) " +
            "MERGE (p)-[:HAS_INTEREST]->(i)")
    void addInterest(Long userId, String interest);

    // Remove interest from a profile
    @Query("MATCH (p:Profile {userId: $userId})-[r:HAS_INTEREST]->(i:Interest {name: $interest}) " +
            "DELETE r")
    void removeInterest(Long userId, String interest);

    // Find profiles with a given interest
    @Query("MATCH (p:Profile)-[:HAS_INTEREST]->(i:Interest {name: $interest}) RETURN p")
    List<Profile> findProfilesByInterest(String interest);
}