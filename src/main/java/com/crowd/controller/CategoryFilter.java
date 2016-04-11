package com.crowd.controller;

import javax.servlet.*;
import java.io.IOException;



public class CategoryFilter implements Filter {
//    @Autowired
//    CategoryService categoryService;

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        try {
//
//            servletRequest.setAttribute("categories",categoryService.selectAll());
//            filterChain.doFilter(servletRequest, servletResponse);
//
//        } catch (Exception ex) {
//            servletRequest.setAttribute("errorMessage", ex);
//            servletRequest.getRequestDispatcher("/WEB-INF/views/jsp/error.jsp")
//                    .forward(servletRequest, servletResponse);
//        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
