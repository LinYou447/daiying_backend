/**
  用户表
 */
CREATE TABLE IF NOT EXISTS `user`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT, #主键自增
    `username`     VARCHAR(50) NOT NULL, #用户名
    `password` VARCHAR(50) NOT NULL, #密码
    `phone`      VARCHAR(20)       NOT NULL, #手机号
    `email`    VARCHAR(50) DEFAULT NULL,  #邮箱
    `cretate_time`    DATETIME NOT NULL,      #创建时间
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  简历表
 */
CREATE TABLE IF NOT EXISTS `biographical`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(50) NOT NULL, #姓名
    `sex`      INT(2) NOT NULL, #性别
    `email`    VARCHAR(50) NOT NULL, #邮箱
    `phone`      VARCHAR(20)       NOT NULL, #电话
    `city`      VARCHAR(20)       NOT NULL, #所在城市
    `native_place`    VARCHAR(100) NOT NULL, #籍贯
    `edu`    VARCHAR(10) NOT NULL,      #学历
    `edu_back`    TEXT NOT NULL,      #教育背景
    `Internship_experience`    TEXT NOT NULL,      #实习经历
    `Certificate_skills`    TEXT NOT NULL,      #证书技能
    `self_evaluation`    TEXT NOT NULL,      #自我评价
    `cretate_time`    DATETIME NOT NULL,      #创建时间
    `major`    VARCHAR(50) NOT NULL,    #专业
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


/**
  职位表
 */
CREATE TABLE IF NOT EXISTS `position`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT,
    `type`     VARCHAR(50) NOT NULL, #职位类型
    `company_id`     INT(11) NOT NULL, #企业id
    `position_code`     VARCHAR(50) NOT NULL, #职位编号
    `recruitment_type`    VARCHAR(50) DEFAULT NULL, #招聘类型
    `country`    VARCHAR(20) DEFAULT NULL, #国家
    `money`    VARCHAR(20) DEFAULT NULL, #薪资
    `work_location`      VARCHAR(50)  DEFAULT NULL, #工作地点
    `job_description`     TEXT  DEFAULT NULL, #职位介绍
    `job_requirements`    TEXT DEFAULT NULL, #职位要求
    `degree`    VARCHAR(10) DEFAULT NULL,      #紧急程度
    `state`    VARCHAR(10) DEFAULT '待审核',      #审核状态
    `cretate_time`    DATETIME NOT NULL,      #创建时间
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  职位申请表
 */
CREATE TABLE IF NOT EXISTS `position_request`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT,
    `biographical_id`       INT(11)  NOT NULL, #简历id
    `position_id`       INT(11)  NOT NULL, #职位id
    `company`       INT(11)  NOT NULL, #企业id
    `state`    VARCHAR(10) DEFAULT '待审核',     #审核状态
    `cretate_time`    DATETIME NOT NULL,      #创建时间
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  经验分享表
 */
CREATE TABLE IF NOT EXISTS `lv_share`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT,
    `user_id`       INT(11)  NOT NULL, #用户id
    `title`       VARCHAR(50) NOT NULL,  #标题
    `context`       TEXT  NOT NULL, #分享内容
    `cretate_time`    DATETIME NOT NULL,      #发布时间
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  企业信息表
 */
CREATE TABLE IF NOT EXISTS `lv_share`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(100)  NOT NULL, #企业名称
    `address`       VARCHAR(100) NOT NULL,  #地址
    `phone`       VARCHAR(50)  NOT NULL, #联系电话
    `qualification`    VARCHAR(20) NOT NULL,      #企业资质
    `capital`    BIGINT(20) NOT NULL,      #注册资本
    `legal_person`    VARCHAR(50) NOT NULL,      #法人
    `cretate_time`    DATETIME NOT NULL,      #创建时间
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;



/**
  角色表
 */
CREATE TABLE IF NOT EXISTS `role`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(50)  NOT NULL, #角色名称
    `state`       INT(3) NOT NULL,  #启停状态
    `cretate_time`    DATETIME NOT NULL,      #创建时间
    `des`       TEXT  NOT NULL, #角色权限介绍
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


/**
  系统操作日志表
 */
CREATE TABLE IF NOT EXISTS `log_system`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT,
    `username`    VARCHAR(30) NOT NULL, #用户名称
    `phone`       VARCHAR(20) NOT NULL,  #用户电话
    `role_name`   VARCHAR(50) NOT NULL,      #所属角色
    `edit_des`    VARCHAR(100) DEFAULT NULL,      #操作记录
    `cretate_time`    DATETIME NOT NULL,      #创建时间
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;