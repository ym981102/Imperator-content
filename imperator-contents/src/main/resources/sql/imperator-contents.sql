CREATE TABLE article (
    id int NOT NULL AUTO_INCREMENT,
    tittle VARCHAR(1024) DEFAULT  NULL COMMENT '标题',
    content VARCHAR(1024) DEFAULT NULL COMMENT '内容',
    author VARCHAR (1024) DEFAULT NULL COMMENT '作者',
    category VARCHAR (1024) DEFAULT NULL COMMENT '类别',
    summary VARCHAR(1024) DEFAULT NULL COMMENT '总结',
    version VARCHAR (225) DEFAULT NULL COMMENT '版本',
    PRIMARY KEY(id)
)engine=innodb default charset = utf8mb4;