DROP TABLE IF EXISTS user_t;  
  
create table user_t (  
   uid  int primary key auto_increment,
   uname  varchar(40) NOT NULL,
   upwd  varchar(60) NOT NULL,
   uage  int NOT NULL
)engine=MYISAM character set utf8;
  
/*Data for the table  user_t  */  
  
insert  into  user_t (uname , upwd , uage ) values ('张三','zxc',22);  
commit;