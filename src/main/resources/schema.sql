/**
  用户表
 */
CREATE TABLE IF NOT EXISTS `user`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `username`     VARCHAR(50) NOT NULL COMMENT "用户名",
    `password` VARCHAR(100) NOT NULL COMMENT "密码",
    `phone`      VARCHAR(20)       NOT NULL COMMENT "手机号",
    `role`      VARCHAR(50)       NOT NULL COMMENT "角色",
    `email`    VARCHAR(50) DEFAULT NULL COMMENT "邮箱",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  简历表
 */
CREATE TABLE IF NOT EXISTS `biographical`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `user_id`       INT(11)  NOT NULL COMMENT "用户ID",
    `name`     VARCHAR(50) NOT NULL COMMENT "姓名",
    `sex`      VARCHAR(10) NOT NULL COMMENT "性别",
    `email`    VARCHAR(50) NOT NULL COMMENT "邮箱",
    `phone`      VARCHAR(20)       NOT NULL COMMENT "电话",
    `city`      VARCHAR(20)       NOT NULL COMMENT "所在城市",
    `native_place`    VARCHAR(100) NOT NULL COMMENT "籍贯",
    `edu`    VARCHAR(10) NOT NULL COMMENT "学历",
    `edu_back`    TEXT NOT NULL COMMENT "教育背景",
    `internship_experience`    TEXT NOT NULL COMMENT "实习经历",
    `certificate_skills`    TEXT NOT NULL COMMENT "证书技能",
    `self_evaluation`    TEXT NOT NULL COMMENT "自我评价",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    `major`    VARCHAR(50) NOT NULL COMMENT "专业",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


/**
  职位表
 */
CREATE TABLE IF NOT EXISTS `position`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `name`     VARCHAR(50) NOT NULL COMMENT "职位名称",
    `category`     VARCHAR(50) NOT NULL COMMENT "职位类型",
    `company_id`     INT(11) NOT NULL COMMENT "企业id",
    `position_code`     VARCHAR(50) NOT NULL COMMENT "职位编号",
    `recruitment_type`    VARCHAR(50) DEFAULT NULL COMMENT "招聘类型",
    `country`    VARCHAR(20) DEFAULT NULL DEFAULT '中国' COMMENT "国家",
    `money`    VARCHAR(20) DEFAULT NULL COMMENT "薪资",
    `work_location`      VARCHAR(50)  DEFAULT NULL COMMENT "工作地点",
    `job_description`     TEXT  DEFAULT NULL COMMENT "职位介绍",
    `job_requirements`    TEXT DEFAULT NULL COMMENT "职位要求",
    `degree`    VARCHAR(10) DEFAULT NULL COMMENT "紧急程度",
    `state`    VARCHAR(10) DEFAULT '待审核' COMMENT "审核状态",
    `msg`    VARCHAR(100) COMMENT "审核信息",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  职位申请表
 */
CREATE TABLE IF NOT EXISTS `position_request`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `biographical_id`       INT(11)  NOT NULL COMMENT "简历id",
    `position_id`       INT(11)  NOT NULL COMMENT "职位id",
    `company_id`       INT(11)  NOT NULL COMMENT "企业id",
    `user_id`       INT(11)  NOT NULL COMMENT "用户id",
    `state`    VARCHAR(10) DEFAULT '待审核' COMMENT "审核状态",
    `mes`    VARCHAR(100) COMMENT "审核评价",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  经验分享表
 */
CREATE TABLE IF NOT EXISTS `lv_share`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `user_id`       INT(11)  NOT NULL COMMENT "用户id",
    `title`       VARCHAR(50) NOT NULL COMMENT "标题",
    `context`       TEXT  NOT NULL COMMENT "分享内容",
    `create_time`    DATETIME NOT NULL COMMENT "发布时间",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  企业信息表
 */
CREATE TABLE IF NOT EXISTS `company`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `name`       VARCHAR(100)  NOT NULL COMMENT "企业名称",
    `address`       VARCHAR(100)  COMMENT "地址",
    `phone`       VARCHAR(50)  NOT NULL COMMENT "联系电话",
    `qualification`    VARCHAR(20) COMMENT "企业资质",
    `capital`    BIGINT(20)  COMMENT "注册资本",
    `legal_person`    VARCHAR(50) NOT NULL COMMENT "法人",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;



/**
  角色表
 */
CREATE TABLE IF NOT EXISTS `role`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `name`       VARCHAR(50)  NOT NULL COMMENT "角色名称",
    `state`       INT(3) NOT NULL COMMENT "启停状态",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    `des`       TEXT  NOT NULL COMMENT "角色权限介绍",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


/**
  系统操作日志表
 */
CREATE TABLE IF NOT EXISTS `log_system`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `username`    VARCHAR(30) NOT NULL COMMENT "用户名称",
    `phone`       VARCHAR(20) NOT NULL COMMENT "用户电话",
    `role_name`   VARCHAR(50) NOT NULL COMMENT "所属角色",
    `edit_des`    VARCHAR(100) DEFAULT NULL COMMENT "操作记录",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/**
  用户企业关联表
 */
CREATE TABLE IF NOT EXISTS `user_company`
(
    `id`       INT(11)  NOT NULL AUTO_INCREMENT COMMENT "主键自增",
    `user_id`    INT(11) NOT NULL COMMENT "用户id",
    `company_id`     INT(11) NOT NULL COMMENT "企业id",
    `create_time`    DATETIME NOT NULL COMMENT "创建时间",
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;