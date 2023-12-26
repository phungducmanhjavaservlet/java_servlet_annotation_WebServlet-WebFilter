package com.example.webservlet.webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "filterDuocThucHienTruocViTenClassNhoHonFilter1", displayName = "filter",value = { "/*" })
public class MyFilter implements Filter {

     @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init filter");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("filter 0 request: " + hashCode());
        chain.doFilter(request, response);
        System.out.println("filter 0 response: " + hashCode());

    }

}
