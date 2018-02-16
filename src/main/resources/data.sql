insert into users(username,password,enabled) values('admin','admin',true);
insert into users(username,password,enabled) values('admin1','password',true);
insert into users(username,password,enabled) values('guest','guest',true);

insert into authorities(username,authority) values('admin','ADMIN');
insert into authorities(username,authority) values('admin1','USER');
insert into authorities(username,authority) values('admin1','ADMIN');
insert into authorities(username,authority) values('guest','USER');