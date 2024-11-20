package com.aspiro.profile.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Node
public class Profile {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;  // The ID linking to the User in `service-user`
    private String username;
    private String bio;
    private String location;
    private String profilePictureUrl;

    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private Set<Profile> following = new HashSet<>();

    @Relationship(type = "FRIEND_WITH", direction = Relationship.Direction.OUTGOING)
    private Set<Profile> friends = new HashSet<>();

    // Friend request relationships
    @Relationship(type = "SENT_REQUEST", direction = Relationship.Direction.OUTGOING)
    private Set<Profile> sentRequests = new HashSet<>();

    @Relationship(type = "RECEIVED_REQUEST", direction = Relationship.Direction.INCOMING)
    private Set<Profile> receivedRequests = new HashSet<>();

    @Relationship(type = "MEMBER_OF", direction = Relationship.Direction.OUTGOING)
    @JsonManagedReference
    private Set<Community> communities = new HashSet<>();

    @Relationship(type = "HAS_INTEREST", direction = Relationship.Direction.OUTGOING)
    private Set<Interest> interests = new HashSet<>();

    // Method to add a community relationship
    public void joinCommunity(Community community) {
        this.communities.add(community);
    }

    // Method to remove a community relationship
    public void leaveCommunity(Community community) {
        this.communities.remove(community);
    }

    // Add a friend
    public void addFriend(Profile friend) {
        this.friends.add(friend);
    }

    // Remove a friend
    public void removeFriend(Profile friend) {
        this.friends.remove(friend);
    }

    // Add a sent friend request
    public void sendFriendRequest(Profile friend) {
        this.sentRequests.add(friend);
    }

    // Add a received friend request
    public void receiveFriendRequest(Profile friend) {
        this.receivedRequests.add(friend);
    }

    // Remove a sent friend request
    public void cancelFriendRequest(Profile friend) {
        this.sentRequests.remove(friend);
    }

    // Remove a received friend request
    public void rejectFriendRequest(Profile friend) {
        this.receivedRequests.remove(friend);
    }

}
