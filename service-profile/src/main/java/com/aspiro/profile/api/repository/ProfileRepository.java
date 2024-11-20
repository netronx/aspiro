package com.aspiro.profile.api.repository;

import com.aspiro.profile.domain.entity.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends Neo4jRepository<Profile, Long> {

    // Find a profile by its user ID
    Optional<Profile> findByUserId(Long userId);

    // Custom query to delete by userId directly
    @Query("MATCH (p:Profile {userId: $userId}) DETACH DELETE p")
    void deleteByUserId(Long userId);

    // Find profiles by location (example custom query)
    List<Profile> findByLocation(String location);
}