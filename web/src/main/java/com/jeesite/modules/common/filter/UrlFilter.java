package com.jeesite.modules.common.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

//@Component
//@WebFilter(urlPatterns = "/*", filterName = "urlFilter")
public class UrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getServletPath();
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher(uri);
//        requestDispatcher.forward(req, resp);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
