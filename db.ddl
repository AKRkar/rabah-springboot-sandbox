select VERSION();

SET @dbUsr='app-user';
SET @dbUsrPwd=@dbUsr;
DROP USER IF EXISTS @dbUsr@'localhost';
-- CREATE USER 'app-user'@'localhost' IDENTIFIED BY 'app-user';
-- GRANT ALL PRIVILEGES ON *.* TO 'app-user'@'localhost' WITH GRANT OPTION;

-- DROP DATABASE IF EXISTS react_app;
-- CREATE DATABASE react_app /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
--
-- CREATE TABLE Tasks (
--                        id INT auto_increment PRIMARY KEY,
--                        title varchar(100) NULL,
--                        notes varchar(500) NOT NULL
-- )
--     ENGINE=InnoDB
--     DEFAULT CHARSET=utf8mb4
--     COLLATE=utf8mb4_0900_ai_ci;



