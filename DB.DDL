-- auto-generated definition
create table table_student
(
    id     int auto_increment comment '学生id'
        primary key,
    scode  varchar(255) not null comment '学号',
    sname  varchar(255) not null comment '名字',
    spwd   varchar(255) not null comment '密码',
    sclass varchar(255) not null comment '班级'
)
    comment '学生表';



-- auto-generated definition
create table table_activity
(
    id         int auto_increment comment '活动主键'
        primary key,
    name       varchar(255) not null comment '活动名称',
    date       mediumtext   not null comment '活动时间',
    location   varchar(255) not null comment '活动位置。地点',
    createTime mediumtext   not null comment '活动创建时间'
)
    comment '活动表';


-- auto-generated definition
create table table_sign
(
    id         int auto_increment comment '活动签到表'
        primary key,
    userId     int        not null comment '用户id',
    activityId int        not null comment '活动id',
    createTime mediumtext not null comment '签到时间'
)
    comment '签到表';



