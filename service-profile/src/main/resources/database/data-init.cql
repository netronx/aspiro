// Create Profile nodes
CREATE
(
p1:Profile {userId: 1, username: 'talel', bio: 'Tech Lead', location: 'Brussels'}),
       (p2:Profile {userId: 2, username: 'maria', bio: 'Data Scientist', location: 'Paris'}),
       (p3:Profile {userId: 3, username: 'john', bio: 'Software Engineer', location: 'Berlin'})

// Create Community nodes
CREATE
(
c1:Community {name: 'Motivation Network', description: 'Goal-oriented community'}),
       (c2:Community {name: 'Tech Enthusiasts', description: 'Community for tech lovers'})

// Establish relationships between Profiles and Communities
WITH
p1, p2, p3, c1, c2
MATCH (p1), (c1)
WHERE p1.userId = 1 AND c1.name = 'Motivation Network'
CREATE
(
p1)-[:MEMBER_OF]->(c1)

WITH
p1, p2, p3, c1, c2
MATCH (p2), (c2)
WHERE p2.userId = 2 AND c2.name = 'Tech Enthusiasts'
CREATE
(
p2)-[:MEMBER_OF]->(c2)

WITH
p1, p2, p3, c1, c2
MATCH (p3), (c1)
WHERE p3.userId = 3 AND c1.name = 'Motivation Network'
CREATE
(
p3)-[:MEMBER_OF]->(c1)