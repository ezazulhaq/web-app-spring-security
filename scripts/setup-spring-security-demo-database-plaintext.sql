--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Inserting data for table `users`
--
INSERT INTO
  `users`
VALUES
  ('john', '{noop}test123', 1),
  ('mary', '{noop}test123', 1),
  ('susan', '{noop}test123', 1);
--
  -- Table structure for table `authorities`
  --
  DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
    `user_roles_id` int(10) PRIMARY KEY,
    `username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
  ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
  -- Inserting data for table `authorities`
  --
INSERT INTO
  `authorities`
VALUES
  ('1', 'john', 'ROLE_EMPLOYEE'),
  ('2', 'mary', 'ROLE_EMPLOYEE'),
  ('3', 'mary', 'ROLE_MANAGER'),
  ('4', 'susan', 'ROLE_EMPLOYEE'),
  ('5', 'susan', 'ROLE_ADMIN');