# j2eestudy

#SQlServer2012

	create database jinryu
	go
	use jinryu
	go
	create table t_user 
	(id int primary key identity(1,1), 
	username varchar(50) not null, 
	password varchar(100) not null)
	go

# Oracle12C

	create sequence t_user_id_seq increment by 1 start with 1 maxvalue 9999999999 cycle;
	create table t_user 
	(id number(11) primary key, 
	username varchar(50) not null, 
	password varchar(100) not null);
	create or replace trigger t_user_trigger 
	before insert on t_user
	for each row
	when(new.id is null)
	begin
	    select t_user_id_seq.nextval into:NEW.ID from dual;
	end;
	/

# MySQL

	create database mydb default character set utf8 collate utf8_bin;
	grant all on mydb.* to 'cloud'@'%' identified by 'passwd' with grant option;
	or
	CREATE USER 'cloud'@'%' IDENTIFIED BY 'passwd';
	grant all on mydb.* to 'cloud'@'%' with grant option;
	flush privileges;
	use mydb
	create table t_employee 
	(id int primary key auto_increment, 
	name varchar(50) not null, 
	address varchar(100) not null,
	age int not null);
	insert into t_employee values(1, '张三', '吉林', 23);
	insert into t_employee values(2, '李四', '北京', 30);
	insert into t_employee values(3, '王五', '上海', 25);
	

