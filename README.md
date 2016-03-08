# ThoughtWorks Homework

##  代码结构说明：

### discount包:  优惠策略相关接口&实现类。

     DiscountService：优惠策略的接口
      
     NoDiscountServiceImpl： 无优惠的策略实现类
      
     PercentDiscountServiceImpl： 打折优惠策略的实现类(95折)
      
     GiftDiscountServiceImpl：赠品优惠策略的实现类(买二赠一)
      
      
### entity包: 实体相关类。

     DiscountTypeEnum：优惠类型的枚举
      
     PayAmountDO：商品详细信息的DO类
      
      
### mockData包: mock数据类(mock了商品单价，名称，打折类型的信息)，相当于配置文件。

     MockData：Mock数据类
      
      
### printTicket包: 购物小票打印接口&实现类。

     PrintTicketService：购物小票打印模版抽象类
      
     PrintTicketServiceOne： 购物小票打印模版的一个实现类
      
      
### test包: 测试类。

     main: 测试小票打印，可以到MockData类中设置各个商品不同的优惠策略，单价等信息
      
     _DiscountServiceComponentTest：对应测试类。
      
     _GiftDiscountServiceImplTest：对应测试类。
      
     _NoDiscountServiceImplTest：对应测试类。
      
     _PercentDiscountServiceImplTest：对应测试类。
      
     _PrintTicketServiceTest：对应测试类。
      

## 存在的不足：

     1: 金额计算采用了double, 应该采用 BigDecimal。
      
     2: 打折优惠抽象的不好(例如：支持多种折扣)，赠品优惠抽象的不好(例如支持 买三增二等多种形式)。
      
 
## 备注说明：

     1: 代码使用Eclipse编写，上传到Git时只上传了src源代码。
      
     2: 测试框架采用了TestNG。
      
      
Best Regards,

Jiyuan Wang

2016-03-08
