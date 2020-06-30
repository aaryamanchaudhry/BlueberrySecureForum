INSERT INTO User(username, encrypted_Password, enabled)VALUES ('Simon', '$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1);
INSERT INTO User(username, encrypted_Password, enabled)VALUES ('Jon', '$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1);

INSERT INTO Role(rolename)VALUES('ROLE_ADMIN');
INSERT INTO Role(rolename)VALUES('ROLE_USER');
INSERT INTO User_Roles(users_id, roles_id)VALUES(1, 1);
INSERT INTO User_Roles(users_id, roles_id)VALUES(1, 2);
INSERT INTO User_Roles(users_id, roles_id)VALUES(2, 2);

INSERT INTO Post(posttopic,posttitle,postcontent,postdate,posttime)VALUES('r/Jeff Bezos','Alexa','Alexa Play Despacito','2020-04-08','05:00:01');
INSERT INTO Post(posttopic,posttitle,postcontent,postdate,posttime)VALUES('r/College','Sheridan','LOLLLL Nice Joke','2020-04-09','05:00:01');
INSERT INTO Post(posttopic,posttitle,postcontent,postdate,posttime)VALUES('r/Rip','Quarantine','Quarantine Day 10: I have eaten all my food including toilet papers','2020-04-09','05:00:01');


INSERT INTO User_Post_List(user_id, post_list_id)VALUES(1, 1);
INSERT INTO User_Post_List(user_id, post_list_id)VALUES(1, 2);
INSERT INTO User_Post_List(user_id, post_list_id)VALUES(2, 3);
