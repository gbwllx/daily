一、出发点
1. 基于0851e9ff 2021/3/30 at 8:31 分支开始阅读源码
2. 当前579个TODO可以优化

二、tidb实现主流程图

![tidb主流程](https://github.com/gbwllx/daily/blob/master/docs/tidb-server%E4%B8%BB%E6%B5%81%E7%A8%8B.png)


TODO：
1. 主流程中只是关键节点串联，并没有体现实现细节，关键函数实现需要再学习
2. 几个主要的结构体server，clientConn，TiDBContext，session，ExecStmt，SelectionExec需要展开学习一下
3. 特定的枚举学习一下
4. 特定概念学习一下
5. 分module学习一下


絮絮叨叨：
开始的时候一无所知，不能预估一个准确的时间，读完第一个模块后，有可能预估一下时间吧;为了防止自己版图而废，暂时立个flag关于tidb至少写20篇吧

参考：
https://pingcap.com/blog-cn/#TiDB-%E6%BA%90%E7%A0%81%E9%98%85%E8%AF%BB


