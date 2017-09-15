package com.smvd.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request1, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) request1;
		if (request.getSession().getAttribute("uname")!=null) {
			filterChain.doFilter(request1, response);
		}else {
			request.getSession().setAttribute("errmsg", "请先登录");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
