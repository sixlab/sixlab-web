CREATE TABLE sixlab_meta
(
  id          INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  key_id      INT(11),
  meta_key    VARCHAR(255),
  meta_val    VARCHAR(2000),
  meta_flag   VARCHAR(255),
  meta_remark VARCHAR(2000)
);
CREATE TABLE sixlab_user
(
  id       INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username VARCHAR(50),
  password VARCHAR(50)
);
CREATE TABLE tools_code_line
(
  id         INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  check_date DATETIME,
  all_num    INT(11),
  code_num   INT(11),
  code_type  VARCHAR(10)
);
CREATE TABLE tools_his_event
(
  id           INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  event        VARCHAR(255),
  event_type   VARCHAR(255),
  key_id       INT(11),
  event_remark VARCHAR(255),
  event_date   DATE
);
CREATE TABLE tools_movie
(
  id           INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  movie_name   VARCHAR(200)        NOT NULL,
  produce_year VARCHAR(4),
  director     VARCHAR(200),
  remark       VARCHAR(2000),
  view_date    DATE                NOT NULL,
  douban_key   VARCHAR(255) COMMENT '豆瓣 Subject Key',
  douban_score DOUBLE(3, 2) COMMENT '豆瓣评分',
  douban_info  VARCHAR(2000) COMMENT '豆瓣信息栏信息',
  info_status  VARCHAR(4) COMMENT '信息爬虫状态'
);
CREATE TABLE tools_note
(
  id        INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title     VARCHAR(50),
  content   VARCHAR(50),
  time      DATETIME,
  begin     DATETIME,
  end       DATETIME,
  one_level VARCHAR(50),
  two_level VARCHAR(50)
);
CREATE TABLE tools_record_item
(
  id         INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  item_name  VARCHAR(50),
  item_order INT(32),
  is_del     VARCHAR(50),
  remark     VARCHAR(50)
);
CREATE TABLE tools_record_val
(
  id          INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  item_id     INT(32),
  record_date DATETIME,
  record_val  VARCHAR(50)
);
CREATE TABLE tools_show
(
  id           INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  show_name    VARCHAR(50),
  show_season  INT(32),
  show_episode INT(32),
  show_status  VARCHAR(50),
  view_status  VARCHAR(50),
  tv           VARCHAR(50),
  remark       VARCHAR(50),
  douban_key   VARCHAR(50),
  begin_date   DATETIME,
  finish_date  DATETIME,
  update_date  DATETIME
);