package com.aspiro.profile.api.repository;

import com.aspiro.profile.domain.entity.Community;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommunityRepository extends Neo4jRepository<Community, Long> {

    Optional<Community> findByName(String name);

    // Find communities by category for discovery
    List<Community> findByCategory(String category);

    // Add a profile as a member of a community
    @Query("MATCH (p:Profile {userId: $userId}), (c:Community {id: $communityId}) " +
            "MERGE (p)-[:MEMBER_OF]->(c)")
    void addMemberToCommunity(Long userId, Long communityId);

    // Remove a profile from a community
    @Query("MATCH (p:Profile {userId: $userId})-[r:MEMBER_OF]->(c:Community {id: $communityId}) " +
            "DELETE r")
    void removeMemberFromCommunity(Long userId, Long communityId);
}
