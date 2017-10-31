# Host: 192.168.3.110  (Version 5.6.28-log)
# Date: 2017-09-13 09:55:54
# Generator: MySQL-Front 6.0  (Build 2.2)

CREATE TABLE `permission` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(30) NOT NULL DEFAULT '',
  `createtime` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(10) NOT NULL DEFAULT '',
  `createtime` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `role` VALUES (1,'管理员',NULL);

CREATE TABLE `permission_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL DEFAULT '0',
  `permissionId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `role_permission` (`roleId`),
  KEY `permission_role` (`permissionId`),
  CONSTRAINT `permission_role` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission` FOREIGN KEY (`roleId`) REFERENCES `role` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(40) NOT NULL DEFAULT '',
  `createtime` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  `realname` varchar(20) DEFAULT '',
  `mobile` varchar(18) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `valid` tinyint(3) NOT NULL DEFAULT '0',
  `slot` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES (2,'cidic@cidic.cn','eff50ef9b8d6d71883626d7607f63f35','2017-09-13 09:16:45.334000','中意创新中心',NULL,NULL,0,'927d0a7f2303fae9e74533317bb01130');


CREATE TABLE `user_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `roleId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `user` (`userId`),
  KEY `role` (`roleId`),
  CONSTRAINT `role` FOREIGN KEY (`roleId`) REFERENCES `role` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`userId`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `user_role` VALUES (2,2,1);

