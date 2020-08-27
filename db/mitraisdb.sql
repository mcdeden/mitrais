/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : mitraisdb

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 27/08/2020 13:22:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for master_genders
-- ----------------------------
DROP TABLE IF EXISTS `master_genders`;
CREATE TABLE `master_genders`  (
  `id` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updated_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_genders
-- ----------------------------
INSERT INTO `master_genders` VALUES ('F', 'Female', '2020-08-24 17:05:04', '2020-08-24 17:05:04');
INSERT INTO `master_genders` VALUES ('M', 'Male', '2020-08-24 17:04:58', '2020-08-24 17:04:58');

-- ----------------------------
-- Table structure for master_user_status
-- ----------------------------
DROP TABLE IF EXISTS `master_user_status`;
CREATE TABLE `master_user_status`  (
  `id` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updated_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_user_status
-- ----------------------------
INSERT INTO `master_user_status` VALUES ('A', 'Active', '2020-08-24 17:05:04', '2020-08-24 18:03:48');
INSERT INTO `master_user_status` VALUES ('N', 'Non Active', '2020-08-24 17:04:58', '2020-08-24 18:03:53');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `registration_date` date NULL DEFAULT NULL,
  `registration_time` time(0) NULL DEFAULT NULL,
  `mobile_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `first_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth_day` int(11) NULL DEFAULT 0,
  `birth_month` int(11) NULL DEFAULT 0,
  `birth_year` int(11) NULL DEFAULT 0,
  `birth_date` date NULL DEFAULT NULL,
  `gender_id` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status_id` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `updated_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_unique_01`(`email`) USING BTREE,
  UNIQUE INDEX `idx_unique_02`(`mobile_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
