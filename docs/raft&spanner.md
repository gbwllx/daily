## 问题
#### 心跳包多长时间发送一次？
#### 超时机制控制角色转换：超时时间多少？
  选举超时时间：从一个固定区间（例如150-300ms）随机选择，避免选票被无限的瓜分
#### 选票被瓜分时可以响应外部请求吗？
  选举期间不响应外部请求



## 关注点
#### 任期时int64，不会越界
#### 一个任期号只会投出一张选票（FIFO）
#### 领导者处理不一致的方式：强制跟随者直接复制自己的日志；
  ##### 是不是会导致数据洪流，有什么办法优化？基本不会发生，如果发生怎么办？
  ###### 选举限制机制


### 参考
https://raft.github.io/raft.pdf
https://static.googleusercontent.com/media/research.google.com/zh-CN//archive/spanner-osdi2012.pdf
http://www.vldb.org/pvldb/vol10/p1730-lin.pdf
