
use four;
create table account(
 id int(4)	  primary key auto_increment,
 username	  varchar(10) not null,
 password	  varchar(10) not null,
 loginDate    bigInt(10)
);
insert into account(username ,password) values("amy","18");

    