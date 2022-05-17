--ADMINS
INSERT INTO user(dtype, userName, password, email, avatar, banned, registrationDate, userType, community)
	VALUES('admin', 'a', 'a', 'pera@gmail.com', 'awdwa', false, '2021-05-10', 'ADMIN', null);

--REDDITORS
INSERT INTO user(dtype, userName, password, email, avatar, banned, registrationDate, userType, community)
	VALUES('redditor', 'b', 'b', 'milan@gmail.com', 'awdwa', false, '2022-04-05', 'REDDITOR', null);
INSERT INTO user(dtype, userName, password, email, avatar, banned, registrationDate, userType, community)
	VALUES('redditor', 'c', 'c', 'milos@gmail.com', 'awdwa', false, '2019-11-15', 'REDDITOR', null);
INSERT INTO user(dtype, userName, password, email, avatar, banned, registrationDate, userType, community)
	VALUES('redditor', 'd', 'd', 'zoran@gmail.com', 'awdwa', false, '2020-07-20', 'REDDITOR', null);
	
--MODERATORS
INSERT INTO user(dtype, userName, password, email, avatar, banned, registrationDate, userType, community)
	VALUES('moderator', 'e', 'e', 'ivan@gmail.com', 'awdwa', false, '2022-02-07', 'MODERATOR', 1);
INSERT INTO user(dtype, userName, password, email, avatar, banned, registrationDate, userType, community)
	VALUES('moderator', 'f', 'f', 'dario@gmail.com', 'awdwa', false, '2018-10-19', 'MODERATOR', 2);
INSERT INTO user(dtype, userName, password, email, avatar, banned, registrationDate, userType, community)
	VALUES('moderator', 'g', 'g', 'dragan@gmail.com', 'awdwa', false, '2020-09-25', 'MODERATOR', 3);

--POSTS
INSERT INTO post(title, text, creationDate, imagePath, community, user) VALUES('Sumo news', 'Yokozuna Hakuho retirement after several records beaten', '2020-09-25', 'neka putanja', 1, 2);
INSERT INTO post(title, text, creationDate, imagePath, community, user) VALUES('Serbia wins gold', 'Serbia wins gold in shooting at olympic games in Rio', '2021-07-04', 'neka putanja', 1, 1);
INSERT INTO post(title, text, creationDate, imagePath, community, user) VALUES('New spieces found', 'Scientists found new spieces of fish under 4000m in Pacific', '2022-03-21', 'neka putanja', 2, 3);

--COMMUNITIES
INSERT INTO community(name, description, creationDate, rules, isSuspended, suspendedReason) VALUES('Reddit 1', 'News on this reddit are old','2020-01-26', 'Be kind, dont threaten, no bad language', false, 'none');
INSERT INTO community(name, description, creationDate, rules, isSuspended, suspendedReason) VALUES('Reddit 2', 'News on this reddit are up to date','2018-05-14', 'Be kind, dont threaten, no bad language', false, 'none');
INSERT INTO community(name, description, creationDate, rules, isSuspended, suspendedReason) VALUES('Reddit 3', 'News on this reddit are new','2017-06-23','Be kind, dont threaten, no bad language', false, 'none');


DROP SCHEMA IF EXISTS svt;
CREATE SCHEMA svt;
USE svt;