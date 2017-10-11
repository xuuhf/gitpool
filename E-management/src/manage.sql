use four;
drop table product;
-- 商品表
create table product(
id        int     primary key   auto_increment,
pname     varchar(20)  not null,
cid       int, -- 外键， 引用自cate表中的cid
pno       varchar(30), -- 货号
pic       varchar(100), -- 商品图片
price     double,
online    int, -- 1:上线  0：下线
pdetail    text   -- 商品详情

);

--  类别表
drop table Cate;
 create table Cate(
 cid        int           primary  key   auto_increment,
 cname      varchar(20)    not null,
 pid        int
 
 );
 --  规格表
drop table rule;
 create table rule(
 id         int            primary key    auto_increment,
 pid         int           , --  商品id,引用商品表的id
 size        varchar(20)    --  尺寸

 );
 
 --  会员表
 --  买家账号信息
drop table account_consumer;
 create table account_consumer(
    id             int      primary key  auto_increment,
    loginname      varchar(50)   not null,
    password       varchar(50),
    registertime   bigint,    --  注册时间
    lastlogintime  bigint,   --  走后登录时间
    IP             varchar(20)  --  ip地址
 
 ); 
 --  买家购物信息
 drop table shoppinginfo_consumer;
 create table shoppinginfo_consumer(
 	id			 int	 	primary key   auto_increment,
 	aid 	 	 int 	 	 ,  --  买家账号
 	nickname 	 varchar(20) ,   --  用户昵称
 	money  	  	 double    ,   --  　 订单金额
 	lasttime     bigint       --  最近消费
 );
 
 --  卖家
   --  卖家账号信息
   drop table account_product;
 create table account_product(
    id           int         primary key   auto_increment,
    loginname    varchar(50)   not null,
    password     varchar(50) ,
    registertime    bigint  , --  注册时间
    lastlogintime   bigint  , --  最后登录时间
    ip            varchar(20) --  ip地址

 );
 drop table address;
 -- 地址表，供客户选择
 create table address(
     id            int      primary key   auto_increment,
     province      varchar(20)  not null,
     city          varchar(40)  not null,
     area          varchar(40)  not null
 
 );
  --  买家收货信息表
  drop table consumer_addr;
  create table  consumer_addr(
      id            int        primary key  auto_increment,
      name          varchar(20)   not null , --  收货人姓名
      addr          varchar(200)  not null,  --   收货人地址
      phone         varchar(20)   not null,  --  联系方式
      provice       varchar(20)   ,--  省份
      city          varchar(20)   ,--  市
      area          varchar(40)    --  区
  
  );
 
  --   订单表
  drop table orderinfo;
  create  table  orderinfo(
    id       int        primary key  auto_increment,
    orderno  varchar(50)  not null,  --  订单编号
    orderstatus   int    , --  订单状态 1：未付款 2：已付款 3：已发货  4：已完成
    paystatus     int   ,  --  1：线上支付   2：货到付款
    ordertime     bigint  , --  下单时间
    paytime       bigint  ,  --  付款时间
    addrinto      int     ,  --  收货人信息，引用自 cosumer_addr中的id
    mask          varchar(200)  --  备注信息
  );
  
  --  多对多关系 订单商品
  drop table product_orderinfor;
  create  table   product_orderinfor(
    orderid        int    , -- 订单id 值 引用自orderinfo表中的id
    productid      int    , -- 商品id, 引用自  product表中的id
    primary    key(orderid,productid) -- 联合主键
 
  );
  
  insert into Cate (cname,pid) value("衣服",0);
   insert into Cate (cname,pid) value("家电",0);
    insert into Cate (cname,pid) value("生活用品",0);
  
  insert into Cate (cname,pid) value("卫衣",2);
  insert into shoppinginfo_consumer(aid,nickname,money,lasttime) value(1,'ss',12,null);
  
  insert into orderinfo( orderno,orderstatus,paystatus, ordertime, paytime ,addrinto,mask) value(11,1,2,null,null,2,null);
  insert into consumer_addr(name,addr, phone, provice,city, area) value('xx','z','c','p','c','a');
  
  
  
  
  
  