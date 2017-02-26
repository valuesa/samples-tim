# 慢查询 SLOW_QUERY
https://dev.mysql.com/doc/refman/5.7/en/mysqldumpslow.html
> 慢查询日志查询: mysqldumpslow
show variables like '%slow%' 查看慢查询配置
log-slow-queries = /usr/local/mysql/var/slowquery.log
long_query_time = 1  #单位是秒
log-queries-not-using-indexes

> 查询slow_query_log的相关配置
show variables like '%slow_query_log%'
有两个参数： slow_query_log（是否开启），slow_query_log_file(日志文件位置)