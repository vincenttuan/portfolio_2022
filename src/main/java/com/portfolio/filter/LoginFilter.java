package com.portfolio.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 要將 StsPortfolioApplication.java 配置加上 @ServletComponentScan */
@WebFilter("/*")
public class LoginFilter extends BaseFilter {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		System.out.println("LoginFilter");
		// 測試資料
		session.setAttribute("investor_username", "User");
		session.setAttribute("investor_id", 1);
		session.setAttribute("watch_id", 1);
		session.setAttribute("investor", null);
		chain.doFilter(request, response);
	}
	
	
	
}
