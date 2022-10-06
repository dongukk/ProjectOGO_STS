package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dto.member.MemberDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {

// 관리자 처리
// /AdminCheck/**
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle=========");
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {	// 관리자가 아닌 경우
			System.out.println("interceptor 관리자 정보 없음");
			session.setAttribute("mesg", "관리자 권한이 필요한 페이지입니다.");
			response.sendRedirect("../MainForm");
			return false;
		}else {	// 관리자인 경우
			System.out.println("interceptor 관리자 정보 있음");
			session.setAttribute("interceptor", "interceptor");
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle=========");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion=========");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("afterConcurrentHandlingStarted=========");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
