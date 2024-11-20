package com.aspiro.profile.api.repository;

import com.aspiro.profile.domain.entity.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepository extends Neo4jRepository<Profile, Long> {

    // Create a following relationship
    @Query("MATCH (a:Profile {userId: $followerId}), (b:Profile {userId: $followedId}) " +
            "MERGE (a)-[:FOLLOWS]->(b)")
    void follow(Long followerId, Long followedId);

    // Remove a following relationship
    @Query("MATCH (a:Profile {userId: $followerId})-[r:FOLLOWS]->(b:Profile {userId: $followedId}) " +
            "DELETE r")
    void unfollow(Long followerId, Long followedId);

    // Find all followers of a specific profile
    @Query("MATCH (a:Profile)-[:FOLLOWS]->(b:Profile {userId: $userId}) RETURN a")
    List<Profile> findFollowers(Long userId);

    // Find all profiles followed by a specific profile
    @Query("MATCH (a:Profile {userId: $userId})-[:FOLLOWS]->(b:Profile) RETURN b")
    List<Profile> findFollowing(Long userId);
}
