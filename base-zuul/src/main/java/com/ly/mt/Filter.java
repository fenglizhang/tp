package com.ly.mt;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description 拦截器
 * @Author taoye
 * @Date 2018/01/22
 **/

@Component
public class Filter extends ZuulFilter {
    private final static Logger LOGGER = LoggerFactory.getLogger(Filter.class);

    /**filterType表示filter执行的时机
     * pre:在请求被路由之前调用
     * routing: 在请求被路由之中调用
     * post: 在请求被路由之后调用
     * error: 处理请求发生错误时调用
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤的顺序，数字越大越靠后
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * @Description 拦截地址过滤，true过滤，false不过滤
     * @Author taoye
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @Description 未登录拦截
     * @Author taoye
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("----------uri:------------"+request.getRequestURI());
       return null;
    }
}