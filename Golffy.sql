drop database if exists golffy;

create database golffy character set utf8mb4 collate utf8mb4_general_ci;

use golffy;

create table if not exists user (
user_pid int auto_increment primary key,
user_id varchar(20) not null,
user_pw varchar(20) not null,
user_nick varchar(20) not null,
user_deleted tinyint default 0
)ENGINE=InnoDB;

create table if not exists board (
board_id int auto_increment primary key,
user_pid int not null,
user_nick varchar(20) not null,
board_title varchar(50) not null,
board_regdate timestamp default now(),
board_content varchar(10000) not null,
board_viewcnt int default 0,
board_like int default 0,
board_deleted tinyint default false
)ENGINE=InnoDB;

create table if not exists cmt (
cmt_id int auto_increment primary key,
board_id int not null,
user_pid int not null,
user_nick varchar(20) not null,
cmt varchar(100) not null,
cmt_regdate timestamp default now(),
cmt_deleted tinyint default 0
)ENGINE=InnoDB;

create table if not exists subcmt (
subcmt_id int auto_increment primary key,
cmt_id int not null,
user_pid int not null,
user_nick varchar(20) not null,
subcmt varchar(1000) not null,
subcmt_regdate timestamp default now(),
subcmt_deleted tinyint default 0
)ENGINE=InnoDB;

create table if not exists files (
file_id int auto_increment primary key,
board_id int not null,
save_folder varchar(50) not null,
origin_file varchar(50) not null,
save_file varchar(50) not null,
foreign key(board_id) references board(board_id)
)ENGINE=InnoDB;

create table if not exists user_like (
user_pid int primary key,
board_id int not null
)ENGINE=InnoDB;

create table if not exists follow (
user_pid int primary key,
target int not null
)ENGINE=InnoDB;

insert into board (user_pid, user_nick, board_title, board_content) values (1, "닉네임 1", "제목 1", "내용 1");

insert into cmt (board_id, user_pid, user_nick, cmt) values (1, 1, "닉네임 1", "1번 글 댓글 내용 1");
insert into cmt (board_id, user_pid, user_nick, cmt) values (1, 1, "닉네임 1", "1번 글 댓글 내용 1");
insert into cmt (board_id, user_pid, user_nick, cmt) values (2, 1, "닉네임 1", "2번 글 댓글 내용 1");
insert into cmt (board_id, user_pid, user_nick, cmt) values (2, 1, "닉네임 1", "2번 글 댓글 내용 2");


select * from board;
select * from cmt;
select * from subcmt;
select * from files;

delete from cmt;
