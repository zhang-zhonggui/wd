package com.zzg.maven.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class CharsetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/json;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {

    }
}
