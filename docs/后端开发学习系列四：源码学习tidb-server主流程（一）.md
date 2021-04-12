一、出发点
1. 基于0851e9ff 2021/3/30 at 8:31 分支开始阅读源码
2. 当前579个TODO可以优化

二、tidb实现主流程图

![tidb主流程](https://github.com/gbwllx/daily/blob/master/docs/images/tidb-server%E4%B8%BB%E6%B5%81%E7%A8%8B.png)


三、主要结构体学习
```
// Server is the MySQL protocol server
type Server struct {
	cfg               *config.Config //https://github.com/gbwllx/daily/blob/master/docs/tidb%20Config%E5%AD%A6%E4%B9%A0.md
	tlsConfig         unsafe.Pointer // *tls.Config
	driver            IDriver        //TiDBDriver封装了一个storage，测试一般用unistore
	listener          net.Listener   //tidb server listener
	socket            net.Listener
	rwlock            sync.RWMutex
	concurrentLimiter *TokenLimiter          //session数量限流，依赖cfg.TokenLimit；写本地限流方法可以参考一下
	clients           map[uint64]*clientConn //每次请求都创建新的clientConn
	capability        uint32                 //初始化为defaultCapability
	dom               *domain.Domain         //TODO storage space??
	globalConnID      util.GlobalConnID      //connID

	statusAddr     string //statusAddr is the HTTP address for reporting the internal status of a TiDB server
	statusListener net.Listener
	statusServer   *http.Server
	grpcServer     *grpc.Server //used for SQL diagnose and Coprocessor service
	inShutdownMode bool         //shutdown
}
```
```
// clientConn represents a connection between server and client, it maintains connection specific state,
// handles client query.
type clientConn struct {
	pkt          *packetIO         // a helper to read and write data in packet format.
	bufReadConn  *bufferedReadConn // a buffered-read net.Conn or buffered-read tls.Conn.
	tlsConn      *tls.Conn         // TLS connection, nil if not TLS.
	server       *Server           // a reference of server instance.
	capability   uint32            // client capability affects the way server handles client request.
	connectionID uint64            // atomically allocated by a global variable, unique in process scope.
	user         string            // user of the client.
	dbname       string            // default database name.
	salt         []byte            // random bytes used for authentication.
	alloc        arena.Allocator   // an memory allocator for reducing memory allocation.
	lastPacket   []byte            // latest sql query string, currently used for logging error.
	ctx          *TiDBContext      // an interface to execute sql statements.
	attrs        map[string]string // attributes parsed from client handshake response, not used for now.
	peerHost     string            // peer host
	peerPort     string            // peer port
	status       int32             // dispatching/reading/shutdown/waitshutdown
	lastCode     uint16            // last error code
	collation    uint8             // collation used by client, may be different from the collation used by database.
	lastActive   time.Time

	// mu is used for cancelling the execution of current transaction.
	mu struct {
		sync.RWMutex
		cancelFunc context.CancelFunc
	}
}
```
```
// TiDBContext implements QueryCtx.
type TiDBContext struct {
	session.Session   //https://github.com/gbwllx/daily/blob/master/docs/tidb%20session%E5%AD%A6%E4%B9%A0.md
	currentDB string
	stmts     map[int]*TiDBStatement
}

// TiDBStatement implements PreparedStatement.
type TiDBStatement struct {
	id          uint32
	numParams   int
	boundParams [][]byte
	paramsType  []byte
	ctx         *TiDBContext
	rs          ResultSet
	sql         string
}
```



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


