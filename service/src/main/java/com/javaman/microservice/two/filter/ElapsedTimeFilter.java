package com.javaman.microservice.two.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * @author pengzhe
 * @date 2019-07-18 11:44
 */
@Activate(group = {Constants.PROVIDER})
public class ElapsedTimeFilter implements Filter {
    private static Logger log = LoggerFactory
        .getLogger(ElapsedTimeFilter.class);


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.currentTimeMillis();
        Result result = invoker.invoke(invocation);
        long elapsed = System.currentTimeMillis() - start;
        log.warn("-----服务端接口调用耗时-----" + elapsed);
        return result;
    }
}
