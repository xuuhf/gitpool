use four;
drop table product;
-- ��Ʒ��
create table product(
id        int     primary key   auto_increment,
pname     varchar(20)  not null,
cid       int, -- ����� ������cate���е�cid
pno       varchar(30), -- ����
pic       varchar(100), -- ��ƷͼƬ
price     double,
online    int, -- 1:����  0������
pdetail    text   -- ��Ʒ����

);

--  ����
drop table Cate;
 create table Cate(
 cid        int           primary  key   auto_increment,
 cname      varchar(20)    not null,
 pid        int
 
 );
 --  ����
drop table rule;
 create table rule(
 id         int            primary key    auto_increment,
 pid         int           , --  ��Ʒid,������Ʒ���id
 size        varchar(20)    --  �ߴ�

 );
 
 --  ��Ա��
 --  ����˺���Ϣ
drop table account_consumer;
 create table account_consumer(
    id             int      primary key  auto_increment,
    loginname      varchar(50)   not null,
    password       varchar(50),
    registertime   bigint,    --  ע��ʱ��
    lastlogintime  bigint,   --  �ߺ��¼ʱ��
    IP             varchar(20)  --  ip��ַ
 
 ); 
 --  ��ҹ�����Ϣ
 drop table shoppinginfo_consumer;
 create table shoppinginfo_consumer(
 	id			 int	 	primary key   auto_increment,
 	aid 	 	 int 	 	 ,  --  ����˺�
 	nickname 	 varchar(20) ,   --  �û��ǳ�
 	money  	  	 double    ,   --  �� �������
 	lasttime     bigint       --  �������
 );
 
 --  ����
   --  �����˺���Ϣ
   drop table account_product;
 create table account_product(
    id           int         primary key   auto_increment,
    loginname    varchar(50)   not null,
    password     varchar(50) ,
    registertime    bigint  , --  ע��ʱ��
    lastlogintime   bigint  , --  ����¼ʱ��
    ip            varchar(20) --  ip��ַ

 );
 drop table address;
 -- ��ַ�����ͻ�ѡ��
 create table address(
     id            int      primary key   auto_increment,
     province      varchar(20)  not null,
     city          varchar(40)  not null,
     area          varchar(40)  not null
 
 );
  --  ����ջ���Ϣ��
  drop table consumer_addr;
  create table  consumer_addr(
      id            int        primary key  auto_increment,
      name          varchar(20)   not null , --  �ջ�������
      addr          varchar(200)  not null,  --   �ջ��˵�ַ
      phone         varchar(20)   not null,  --  ��ϵ��ʽ
      provice       varchar(20)   ,--  ʡ��
      city          varchar(20)   ,--  ��
      area          varchar(40)    --  ��
  
  );
 
  --   ������
  drop table orderinfo;
  create  table  orderinfo(
    id       int        primary key  auto_increment,
    orderno  varchar(50)  not null,  --  �������
    orderstatus   int    , --  ����״̬ 1��δ���� 2���Ѹ��� 3���ѷ���  4�������
    paystatus     int   ,  --  1������֧��   2����������
    ordertime     bigint  , --  �µ�ʱ��
    paytime       bigint  ,  --  ����ʱ��
    addrinto      int     ,  --  �ջ�����Ϣ�������� cosumer_addr�е�id
    mask          varchar(200)  --  ��ע��Ϣ
  );
  
  --  ��Զ��ϵ ������Ʒ
  drop table product_orderinfor;
  create  table   product_orderinfor(
    orderid        int    , -- ����id ֵ ������orderinfo���е�id
    productid      int    , -- ��Ʒid, ������  product���е�id
    primary    key(orderid,productid) -- ��������
 
  );
  
  insert into Cate (cname,pid) value("�·�",0);
   insert into Cate (cname,pid) value("�ҵ�",0);
    insert into Cate (cname,pid) value("������Ʒ",0);
  
  insert into Cate (cname,pid) value("����",2);
  insert into shoppinginfo_consumer(aid,nickname,money,lasttime) value(1,'ss',12,null);
  
  insert into orderinfo( orderno,orderstatus,paystatus, ordertime, paytime ,addrinto,mask) value(11,1,2,null,null,2,null);
  insert into consumer_addr(name,addr, phone, provice,city, area) value('xx','z','c','p','c','a');
  
  
  
  
  
  