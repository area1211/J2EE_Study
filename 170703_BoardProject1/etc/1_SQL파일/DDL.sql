CREATE TABLE IF NOT EXISTS `board_tb` (
  `mb_id` int(10) unsigned NOT NULL,
  `mb_name` varchar(50) NOT NULL,
  `mb_intro` varchar(100) NOT NULL,
  PRIMARY KEY (`mb_id`),
  UNIQUE KEY `mb_name` (`mb_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists user_tb (
u_id varchar(20) not null primary key,
u_pwd varchar(20) not null,
u_nickname varchar(20) not null unique);

create table if not exists post_tb (
p_id integer not null primary key,
p_subject varchar(20),
p_title varchar(100) not null,
p_date timestamp not null,
p_body Text not null,
p_public bool not null,
p_pid integer unsigned not null,
mb_id integer unsigned not null,
u_id varchar(20) not null,
p_hits integer not null default 0, 
foreign  key (mb_id) references board_tb(mb_id)
on delete cascade on update cascade,
foreign key (u_id) references user_tb(u_id)
on delete cascade on update cascade)
engine=InnoDB default charset=utf8;
