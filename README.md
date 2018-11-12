Think much that the only reason to make this project more wonderful is to teach you to program.

As the developing for web is a easy way to pick up.I bring you this first.

And the Aim for the project is to pick up first in a quick way.

I do my best to introduce why it goes in that way.

一、数据库 操作
互联网公司：处理数据（直对用户的业务数据，以及用来维护这些业务数据而建立的数据）
数据来了，进了电脑里，我想你这个小财迷，一定不忍心，今天买了东西，电脑关机，你花钱的数据就没了。。。

这就涉及 存储。
虽然你没深学过计算机，但是我想你也是知道两个概念：内存条 和 硬盘的（对，类似你给你的老电脑换的固态硬盘）
硬盘可以持久化（断电再接电，数据还在）的记录数据，但是内存不能
硬盘操作 相对 内存 慢。
所以 用来描述你花钱的 数据 是记录在 可持久化存储的介质上的

至少有两个原因，导致有些电脑 是专门用来存储数据的：
1.一些人可以分过来 专门管理存储数据，对，只要和存储数据相关的事，就不需要找别人（我们往往管这个叫 解耦）
2.这些人更专注于存储数据，能做的更好

所以 就有了这么个产品：数据库
有一些人 专门开发了一些数据库产品 来满足各种不同场景 用户的需求，例如：Mysql，Oracle，HBase,sqlite...
开发以上软件的 对文件处理（含操作系统） 和一些算法、论文，掌握的6一些
还有一些人 是专门 更好的使用这些软件的，常称DBA，称起来也是蛮高大尚的。
（实际里 开发过程中用到的软件很多，每一款都算一个维度的话，如果所有维度使用的都不太6，那么这种就是 普通的开发人员了，
如果大多数软件 使用的都比较6，而且和人交流、工作时，能说出并利用 该软件的主要实现原理，就是大家说的大牛了，
而在某个维度，了解的实在太透了，可以运用该软件解决大多数该维度的问题，并向别人提供解决方案 或 说出不能的原因，就是大家说的专家了）

目前大多数互联网公司，用的是Mysql，具体原因TODO（这个在代码里 代表 以后再做）
直接来操作
mysql属于这种数据库:里面是像矩阵一样存储数据的 例如：
订单表（excel那种）：

订单编号  买家姓名  金额  商品名称

   1       刘晓颖    1    my heart
   
实际中 大家都写的英文。。。和java的驼峰命名（tuoFengTuoFeng）不同的是，数据库是（tuo_keng_tuo_feng）

order_id  buyer_name  cost  ware_name

1         刘晓颖      1     my heart

对于 copy过java代码的你来说，面向对象编程 这个概念应该是有的，就是我们始终操作的是一个抽象或实际的 存在，他对外提供了一些操作方法，这个存在就叫对象。
在程序内部，我们把数据，填进一个对象里，调用该对象提供的操作，对数据进行变化。然后我们再把我们想要的数据（原数据、部分原数据，该对象操作结果数据），
传给另一个对象继续操作，传了好几手，最终得到我们想要的数据。为什么这么操作那？（上文提到过的->解耦）
(实际上，我以为面向对象和面向过程编程的最大区别是：当复杂度上升到一定级别，人就处理不过来了。要分析一个图画，不可能没一笔都过一遍，
记得对象吗？你和我都是一种具备功能的存在（你我是两个对象个体），邻居会认为咱俩是一家，而别的楼的人会认为，咱们这一栋楼的人是7号楼的，而警察会记得，咱们这个小区是E区的，
对，以面向对象的方法来分析一个事物时，是有不同的层次的。在足够高的层次看的时候，只关乎那个层次，概括出来的对象所具备的操作，就少很多了。。。
某些程序员，利用软件程序的操作方法，解决几个bug。某些高管，利用企业管理的操作方法，解决几个问题，只不过，站的层级不一样，操作的对象不一样罢了，难度可能都不高，但是高管所解决问题的规模，就会大很多，意义也大很多)

既然我们操作的都是对象，怎么把这些对象 存储到表格里那。。。
这就有一种业界的学名： TODO
搞计算机的，你懂的，都很懒的，能机器干、量大，绝对不手干
所以就有一批 用来解决这个问题的 框架（框架是：对 工具，用来加快你编程效率的。而你也会常听到架构这个词，架构就类似，找好几个高管，各自负责不同的业务，划分业务的这个过程，就叫设计架构）
这里常用的 框架 有：Mybatis、hibernate...
互联网公司 常用的是 Mybatis 理由TODO
所以 接下来 我们要实现的就是 用Mybatis来把对象 存储在 Mysql里~

预先数据库里建立表
use mytest;
create table `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` varchar(64) NOT NULL COMMENT '订单Id',
  `buyer_name` varchar(64) NOT NULL COMMENT '购买人 姓名',
  `cost` int(11) NOT NULL COMMENT '金额',
  `ware_name` varchar(64) NOT NULL COMMENT '用户名',
  `create_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';
