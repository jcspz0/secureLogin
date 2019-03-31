/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : usrsecurity

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-03-31 16:50:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `parametros`
-- ----------------------------
DROP TABLE IF EXISTS `parametros`;
CREATE TABLE `parametros` (
`ID_Prm`  int(11) NOT NULL AUTO_INCREMENT ,
`ParamPrm`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`ValPrm`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`ID_Prm`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=11

;

-- ----------------------------
-- Records of parametros
-- ----------------------------
BEGIN;
INSERT INTO `parametros` VALUES ('1', 'LongitudMinPWD', '8'), ('2', 'LongitudMaxPWD', '15'), ('3', 'DiferenciaMinusculas', 'NO'), ('4', 'CaducidadDiasPWD', '45'), ('5', 'IncluyeDigitos', 'NO'), ('6', 'IncluyeEspeciales', 'NO'), ('7', 'IncluyeMayusculas', 'NO'), ('8', 'ReservarUltimosPWD', '2'), ('9', 'RegistraUltimoIngreso', 'SI'), ('10', 'PermiteConfedarionCtas', 'SI');
COMMIT;

-- ----------------------------
-- Table structure for `pwdhistory`
-- ----------------------------
DROP TABLE IF EXISTS `pwdhistory`;
CREATE TABLE `pwdhistory` (
`Id_PwdH`  int(11) NOT NULL ,
`LoginPwdH`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`DateChangePwdH`  datetime NOT NULL ,
`PwdPwdH`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
PRIMARY KEY (`Id_PwdH`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of pwdhistory
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `tipousuario`
-- ----------------------------
DROP TABLE IF EXISTS `tipousuario`;
CREATE TABLE `tipousuario` (
`Id_TipoUsr`  int(11) NOT NULL ,
`TipoUsr`  varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`DescTipoUsr`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
PRIMARY KEY (`Id_TipoUsr`),
INDEX `TipoUsr` (`TipoUsr`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of tipousuario
-- ----------------------------
BEGIN;
INSERT INTO `tipousuario` VALUES ('1', '1', 'Admin'), ('2', '2', 'Operador');
COMMIT;

-- ----------------------------
-- Table structure for `usuarios`
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
`LoginUsr`  varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`NamesUsr`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`PwdUsr`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`StatusUsr`  varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`DeletedUsr`  datetime NULL DEFAULT NULL ,
`CreatedUsr`  datetime NOT NULL ,
`LastChangePwdUsr`  datetime NULL DEFAULT NULL ,
`LastLoginUsr`  datetime NULL DEFAULT NULL ,
`TypeUsr`  varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
PRIMARY KEY (`LoginUsr`),
FOREIGN KEY (`TypeUsr`) REFERENCES `tipousuario` (`TipoUsr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
INDEX `FK_Usuarios_TipoUsuario` (`TypeUsr`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
BEGIN;
INSERT INTO `usuarios` VALUES ('jc', 'juan carlos', '123123', '1', null, '2019-03-31 13:39:32', null, '2019-03-31 13:40:07', '1'), ('jc3', 'juan carlosa', 'm7REXvBM6XnvEoGBvpNxSw==', '1', null, '2019-03-31 16:15:59', null, null, '1'), ('jc4', 'juan carlosa', 'm7REXvBM6XnvEoGBvpNxSw==', '1', null, '2019-03-31 16:18:00', null, null, '1');
COMMIT;

-- ----------------------------
-- Auto increment value for `parametros`
-- ----------------------------
ALTER TABLE `parametros` AUTO_INCREMENT=11;
