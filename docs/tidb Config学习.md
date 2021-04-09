#### 一、Config
、、、
type Config struct {
	Host             string `toml:"host" json:"host"`     //host
	AdvertiseAddress string `toml:"advertise-address" json:"advertise-address"`   //ip
	Port             uint   `toml:"port" json:"port"`     //端口
	Cors             string `toml:"cors" json:"cors"`     //http跨域配置
	Store            string `toml:"store" json:"store"`   //存储类型：一种真实：tikv，两种mock类型：mocktikv，unistore
	Path             string `toml:"path" json:"path"`     //存储地址，用于建立连接
	Socket           string `toml:"socket" json:"socket"` //The socket file to use for connection
	Lease            string `toml:"lease" json:"lease"`   //ddl变更，等待schema更新时间
	RunDDL           bool   `toml:"run-ddl" json:"run-ddl"`  //run ddl worker on this tidb-server
	SplitTable       bool   `toml:"split-table" json:"split-table"`  // 默认：true。EnableSplitTableRegion is a flag to decide whether to split a new region for a newly created table. It takes effect only if the Storage supports split region.
	TokenLimit       uint   `toml:"token-limit" json:"token-limit"`  // 默认：1000。the limit of concurrent executed sessions
	OOMUseTmpStorage bool   `toml:"oom-use-tmp-storage" json:"oom-use-tmp-storage"`  //oom相关策略暂时忽略
	TempStoragePath  string `toml:"tmp-storage-path" json:"tmp-storage-path"`        //oom相关策略暂时忽略
	OOMAction        string `toml:"oom-action" json:"oom-action"`                    //oom相关策略暂时忽略
	MemQuotaQuery    int64  `toml:"mem-quota-query" json:"mem-quota-query"`          //mem quota
	// TempStorageQuota describe the temporary storage Quota during query exector when OOMUseTmpStorage is enabled
	// If the quota exceed the capacity of the TempStoragePath, the tidb-server would exit with fatal error
	TempStorageQuota int64                   `toml:"tmp-storage-quota" json:"tmp-storage-quota"` // Bytes  oom相关策略暂时忽略
	EnableStreaming  bool                    `toml:"enable-streaming" json:"enable-streaming"`   // enables TiDB to use streaming API for coprocessor requests.
	EnableBatchDML   bool                    `toml:"enable-batch-dml" json:"enable-batch-dml"`   // 默认false，目测暂时不支持
	TxnLocalLatches  tikvcfg.TxnLocalLatches `toml:"-" json:"-"`                                 // 默认不开启，TxnLocalLatches
	// Set sys variable lower-case-table-names, ref: https://dev.mysql.com/doc/refman/5.7/en/identifier-case-sensitivity.html.
	// TODO: We actually only support mode 2, which keeps the original case, but the comparison is case-insensitive.
	LowerCaseTableNames        int                `toml:"lower-case-table-names" json:"lower-case-table-names"`
	ServerVersion              string             `toml:"server-version" json:"server-version"`
	Log                        Log                `toml:"log" json:"log"`                       //暂时忽略
	Security                   Security           `toml:"security" json:"security"`             //暂时忽略
	Status                     Status             `toml:"status" json:"status"`                 //status server 暂时忽略
	Performance                Performance        `toml:"performance" json:"performance"`       //****主要配置
	PreparedPlanCache          PreparedPlanCache  `toml:"prepared-plan-cache" json:"prepared-plan-cache"`
	OpenTracing                OpenTracing        `toml:"opentracing" json:"opentracing"`
	ProxyProtocol              ProxyProtocol      `toml:"proxy-protocol" json:"proxy-protocol"`
	PDClient                   tikvcfg.PDClient   `toml:"pd-client" json:"pd-client"`
	TiKVClient                 tikvcfg.TiKVClient `toml:"tikv-client" json:"tikv-client"`
	Binlog                     Binlog             `toml:"binlog" json:"binlog"`
	CompatibleKillQuery        bool               `toml:"compatible-kill-query" json:"compatible-kill-query"`
	Plugin                     Plugin             `toml:"plugin" json:"plugin"`
	PessimisticTxn             PessimisticTxn     `toml:"pessimistic-txn" json:"pessimistic-txn"`
	CheckMb4ValueInUTF8        bool               `toml:"check-mb4-value-in-utf8" json:"check-mb4-value-in-utf8"`
	MaxIndexLength             int                `toml:"max-index-length" json:"max-index-length"`
	IndexLimit                 int                `toml:"index-limit" json:"index-limit"`
	TableColumnCountLimit      uint32             `toml:"table-column-count-limit" json:"table-column-count-limit"`
	GracefulWaitBeforeShutdown int                `toml:"graceful-wait-before-shutdown" json:"graceful-wait-before-shutdown"`
	// AlterPrimaryKey is used to control alter primary key feature.
	AlterPrimaryKey bool `toml:"alter-primary-key" json:"alter-primary-key"`
	// TreatOldVersionUTF8AsUTF8MB4 is use to treat old version table/column UTF8 charset as UTF8MB4. This is for compatibility.
	// Currently not support dynamic modify, because this need to reload all old version schema.
	TreatOldVersionUTF8AsUTF8MB4 bool `toml:"treat-old-version-utf8-as-utf8mb4" json:"treat-old-version-utf8-as-utf8mb4"`
	// EnableTableLock indicate whether enable table lock.
	// TODO: remove this after table lock features stable.
	EnableTableLock     bool        `toml:"enable-table-lock" json:"enable-table-lock"`
	DelayCleanTableLock uint64      `toml:"delay-clean-table-lock" json:"delay-clean-table-lock"`
	SplitRegionMaxNum   uint64      `toml:"split-region-max-num" json:"split-region-max-num"`
	StmtSummary         StmtSummary `toml:"stmt-summary" json:"stmt-summary"`
	// RepairMode indicates that the TiDB is in the repair mode for table meta.
	RepairMode      bool     `toml:"repair-mode" json:"repair-mode"`
	RepairTableList []string `toml:"repair-table-list" json:"repair-table-list"`
	// IsolationRead indicates that the TiDB reads data from which isolation level(engine and label).
	IsolationRead IsolationRead `toml:"isolation-read" json:"isolation-read"`
	// MaxServerConnections is the maximum permitted number of simultaneous client connections.
	MaxServerConnections uint32 `toml:"max-server-connections" json:"max-server-connections"`
	// NewCollationsEnabledOnFirstBootstrap indicates if the new collations are enabled, it effects only when a TiDB cluster bootstrapped on the first time.
	NewCollationsEnabledOnFirstBootstrap bool `toml:"new_collations_enabled_on_first_bootstrap" json:"new_collations_enabled_on_first_bootstrap"`
	// Experimental contains parameters for experimental features.
	Experimental Experimental `toml:"experimental" json:"experimental"`
	// EnableCollectExecutionInfo enables the TiDB to collect execution info.
	EnableCollectExecutionInfo bool `toml:"enable-collect-execution-info" json:"enable-collect-execution-info"`
	// SkipRegisterToDashboard tells TiDB don't register itself to the dashboard.
	SkipRegisterToDashboard bool `toml:"skip-register-to-dashboard" json:"skip-register-to-dashboard"`
	// EnableTelemetry enables the usage data report to PingCAP.
	EnableTelemetry bool `toml:"enable-telemetry" json:"enable-telemetry"`
	// Labels indicates the labels set for the tidb server. The labels describe some specific properties for the tidb
	// server like `zone`/`rack`/`host`. Currently, labels won't affect the tidb server except for some special
	// label keys. Now we have following special keys:
	// 1. 'group' is a special label key which should be automatically set by tidb-operator. We don't suggest
	// users to set 'group' in labels.
	// 2. 'zone' is a special key that indicates the DC location of this tidb-server. If it is set, the value for this
	// key will be the default value of the session variable `txn_scope` for this tidb-server.
	Labels map[string]string `toml:"labels" json:"labels"`
	// EnableGlobalIndex enables creating global index.
	EnableGlobalIndex bool `toml:"enable-global-index" json:"enable-global-index"`
	// DeprecateIntegerDisplayWidth indicates whether deprecating the max display length for integer.
	DeprecateIntegerDisplayWidth bool `toml:"deprecate-integer-display-length" json:"deprecate-integer-display-length"`
	// EnableEnumLengthLimit indicates whether the enum/set element length is limited.
	// According to MySQL 8.0 Refman:
	// The maximum supported length of an individual SET element is M <= 255 and (M x w) <= 1020,
	// where M is the element literal length and w is the number of bytes required for the maximum-length character in the character set.
	// See https://dev.mysql.com/doc/refman/8.0/en/string-type-syntax.html for more details.
	EnableEnumLengthLimit bool `toml:"enable-enum-length-limit" json:"enable-enum-length-limit"`
	// StoresRefreshInterval indicates the interval of refreshing stores info, the unit is second.
	StoresRefreshInterval uint64 `toml:"stores-refresh-interval" json:"stores-refresh-interval"`
	// EnableTCP4Only enables net.Listen("tcp4",...)
	// Note that: it can make lvs with toa work and thus tidb can get real client ip.
	EnableTCP4Only bool `toml:"enable-tcp4-only" json:"enable-tcp4-only"`
	// The client will forward the requests through the follower
	// if one of the following conditions happens:
	// 1. there is a network partition problem between TiDB and PD leader.
	// 2. there is a network partition problem between TiDB and TiKV leader.
	EnableForwarding bool `toml:"enable-forwarding" json:"enable-forwarding"`
}	
、、、
#### 二、默认配置
、、、
var defaultConf = Config{
	Host:                         DefHost,
	AdvertiseAddress:             "",
	Port:                         DefPort,
	Cors:                         "",
	Store:                        "unistore",
	Path:                         "/tmp/tidb",
	RunDDL:                       true,
	SplitTable:                   true,
	Lease:                        "45s",
	TokenLimit:                   1000,
	OOMUseTmpStorage:             true,
	TempStorageQuota:             -1,
	TempStoragePath:              tempStorageDirName,
	OOMAction:                    OOMActionCancel,
	MemQuotaQuery:                1 << 30,
	EnableStreaming:              false,
	EnableBatchDML:               false,
	CheckMb4ValueInUTF8:          true,
	MaxIndexLength:               3072,
	IndexLimit:                   64,
	TableColumnCountLimit:        1017,
	AlterPrimaryKey:              false,
	TreatOldVersionUTF8AsUTF8MB4: true,
	EnableTableLock:              false,
	DelayCleanTableLock:          0,
	SplitRegionMaxNum:            1000,
	RepairMode:                   false,
	RepairTableList:              []string{},
	MaxServerConnections:         0,
	TxnLocalLatches:              defTiKVCfg.TxnLocalLatches,
	LowerCaseTableNames:          2,
	GracefulWaitBeforeShutdown:   0,
	ServerVersion:                "",
	Log: Log{
		Level:               "info",
		Format:              "text",
		File:                logutil.NewFileLogConfig(logutil.DefaultLogMaxSize),
		SlowQueryFile:       "tidb-slow.log",
		SlowThreshold:       logutil.DefaultSlowThreshold,
		ExpensiveThreshold:  10000,
		DisableErrorStack:   nbUnset,
		EnableErrorStack:    nbUnset, // If both options are nbUnset, getDisableErrorStack() returns true
		EnableTimestamp:     nbUnset,
		DisableTimestamp:    nbUnset, // If both options are nbUnset, getDisableTimestamp() returns false
		QueryLogMaxLen:      logutil.DefaultQueryLogMaxLen,
		RecordPlanInSlowLog: logutil.DefaultRecordPlanInSlowLog,
		EnableSlowLog:       logutil.DefaultTiDBEnableSlowLog,
	},
	Status: Status{
		ReportStatus:    true,
		StatusHost:      DefStatusHost,
		StatusPort:      DefStatusPort,
		MetricsInterval: 15,
		RecordQPSbyDB:   false,
	},
	Performance: Performance{
		MaxMemory:             0,
		ServerMemoryQuota:     0,
		MemoryUsageAlarmRatio: 0.8,
		TCPKeepAlive:          true,
		TCPNoDelay:            true,
		CrossJoin:             true,
		StatsLease:            "3s",
		RunAutoAnalyze:        true,
		StmtCountLimit:        5000,
		FeedbackProbability:   0.0,
		QueryFeedbackLimit:    512,
		PseudoEstimateRatio:   0.8,
		ForcePriority:         "NO_PRIORITY",
		BindInfoLease:         "3s",
		TxnEntrySizeLimit:     DefTxnEntrySizeLimit,
		TxnTotalSizeLimit:     DefTxnTotalSizeLimit,
		DistinctAggPushDown:   false,
		CommitterConcurrency:  defTiKVCfg.CommitterConcurrency,
		MaxTxnTTL:             defTiKVCfg.MaxTxnTTL, // 1hour
		MemProfileInterval:    "1m",
		// TODO: set indexUsageSyncLease to 60s.
		IndexUsageSyncLease: "0s",
		GOGC:                100,
	},
	ProxyProtocol: ProxyProtocol{
		Networks:      "",
		HeaderTimeout: 5,
	},
	PreparedPlanCache: PreparedPlanCache{
		Enabled:          false,
		Capacity:         100,
		MemoryGuardRatio: 0.1,
	},
	OpenTracing: OpenTracing{
		Enable: false,
		Sampler: OpenTracingSampler{
			Type:  "const",
			Param: 1.0,
		},
		Reporter: OpenTracingReporter{},
	},
	PDClient:   defTiKVCfg.PDClient,
	TiKVClient: defTiKVCfg.TiKVClient,
	Binlog: Binlog{
		WriteTimeout: "15s",
		Strategy:     "range",
	},
	PessimisticTxn: DefaultPessimisticTxn(),
	StmtSummary: StmtSummary{
		Enable:              true,
		EnableInternalQuery: false,
		MaxStmtCount:        200,
		MaxSQLLength:        4096,
		RefreshInterval:     1800,
		HistorySize:         24,
	},
	IsolationRead: IsolationRead{
		Engines: []string{"tikv", "tiflash", "tidb"},
	},
	Experimental: Experimental{
		AllowsExpressionIndex: false,
		EnableGlobalKill:      false,
	},
	EnableCollectExecutionInfo: true,
	EnableTelemetry:            true,
	Labels:                     make(map[string]string),
	EnableGlobalIndex:          false,
	Security: Security{
		SpilledFileEncryptionMethod: SpilledFileEncryptionMethodPlaintext,
	},
	DeprecateIntegerDisplayWidth: false,
	EnableEnumLengthLimit:        true,
	StoresRefreshInterval:        defTiKVCfg.StoresRefreshInterval,
	EnableForwarding:             defTiKVCfg.EnableForwarding,
}  
、、、  
  
#### 三、  flag
  version      = flagBoolean(nmVersion, false, "print version information and exit")
	configPath   = flag.String(nmConfig, "", "config file path")
	configCheck  = flagBoolean(nmConfigCheck, false, "check config file validity and exit")
	configStrict = flagBoolean(nmConfigStrict, false, "enforce config file validity")

	// Base
	store            = flag.String(nmStore, "unistore", "registered store name, [tikv, mocktikv, unistore]")
	storePath        = flag.String(nmStorePath, "/tmp/tidb", "tidb storage path")
	host             = flag.String(nmHost, "0.0.0.0", "tidb server host")
	advertiseAddress = flag.String(nmAdvertiseAddress, "", "tidb server advertise IP")
	port             = flag.String(nmPort, "4000", "tidb server port")
	cors             = flag.String(nmCors, "", "tidb server allow cors origin")
	socket           = flag.String(nmSocket, "", "The socket file to use for connection.")
	enableBinlog     = flagBoolean(nmEnableBinlog, false, "enable generate binlog")
	runDDL           = flagBoolean(nmRunDDL, true, "run ddl worker on this tidb-server")
	ddlLease         = flag.String(nmDdlLease, "45s", "schema lease duration, very dangerous to change only if you know what you do")
	tokenLimit       = flag.Int(nmTokenLimit, 1000, "the limit of concurrent executed sessions")
	pluginDir        = flag.String(nmPluginDir, "/data/deploy/plugin", "the folder that hold plugin")
	pluginLoad       = flag.String(nmPluginLoad, "", "wait load plugin name(separated by comma)")
	affinityCPU      = flag.String(nmAffinityCPU, "", "affinity cpu (cpu-no. separated by comma, e.g. 1,2,3)")
	repairMode       = flagBoolean(nmRepairMode, false, "enable admin repair mode")
	repairList       = flag.String(nmRepairList, "", "admin repair table list")
	requireTLS       = flag.Bool(nmRequireSecureTransport, false, "require client use secure transport")

	// Log
	logLevel     = flag.String(nmLogLevel, "info", "log level: info, debug, warn, error, fatal")
	logFile      = flag.String(nmLogFile, "", "log file path")
	logSlowQuery = flag.String(nmLogSlowQuery, "", "slow query file path")

	// Status
	reportStatus    = flagBoolean(nmReportStatus, true, "If enable status report HTTP service.")
	statusHost      = flag.String(nmStatusHost, "0.0.0.0", "tidb server status host")
	statusPort      = flag.String(nmStatusPort, "10080", "tidb server status port")
	metricsAddr     = flag.String(nmMetricsAddr, "", "prometheus pushgateway address, leaves it empty will disable prometheus push.")
	metricsInterval = flag.Uint(nmMetricsInterval, 15, "prometheus client push interval in second, set \"0\" to disable prometheus push.")

	// PROXY Protocol
	proxyProtocolNetworks      = flag.String(nmProxyProtocolNetworks, "", "proxy protocol networks allowed IP or *, empty mean disable proxy protocol support")
	proxyProtocolHeaderTimeout = flag.Uint(nmProxyProtocolHeaderTimeout, 5, "proxy protocol header read timeout, unit is second.")


