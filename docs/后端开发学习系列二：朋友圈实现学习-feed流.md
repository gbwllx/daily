一、原始数据：
1. 2019年1月：每日消息：450亿
2. 用户日活：10亿
3. 凌晨1分钟内：46TB数据
4. 34%的流量与30%的时间
5. 每24小时100亿次聊天点击
6. 每天10亿次微信支付
7. 8.2亿次红包点击
8. 早高峰每分钟25万次公交卡服务
9. 日4.1亿次音频和视频
10. 总QPS：1亿，3000多个服务提供，机器数量？2万台（应该是物理机，容器至少百万级别吧？）最高峰是平时10倍，比如说过年


二、二次数据：
1. 日450亿条消息预计占存储15T（音视频单独存储），不能使用mysql（3副本50T）
2. 平均每人每日4.5条消息
3. 平均消息QPS：52万 x 5 x 3（1000台docker足以？如果以类似redis的能力，20台物理机应该可以）(流量放大？)
4. 平均支付QPS: 11574 x 5 x 3（按2/8需乘以5）（30%比较安全，再乘以3）

三、分布式系统只是在单机系统上加了分布式协议；分布式存储也是在单机存储上加了分布式协议

四、存储选型，按以下TODO分析：
1. TiDB适合业务量是多少，为什么？（实现）
    TB级
2. TiDB与mysql的区别？
3. 腾讯paxosStore实现
4. mysql方案适合业务量是多少，为什么？（实现）
5. mysql分库分表也不行吗？为什么？
  部分回答：https://pingcap.com/blog-cn/how-do-we-build-tidb/
6. mysql分库分表的实现方案



feed流实现方案已经比较全了，不自己写了：
    https://www.alibabacloud.com/blog/feed-stream-system-design-general-principles_595900


问题按重要程度排序，提问题并不一定回答，因为随时会插入更重要的问题，永远做最重要的那件事





参考：没找到最新的数据，以19年数据为例：https://www.businessofapps.com/data/wechat-statistics/
