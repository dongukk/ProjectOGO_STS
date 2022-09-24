package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

// 로그인 처리
// /loginCheck/**
// 처리후 /loginCheck/loginForm 되므로 ../loginForm 으로 설정하기
// servlet-context.xml에서 주소처리 등록
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle=========");
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {	// 로그인 안된 경우
			System.out.println("interceptor 로그인 정보 없음");
//			response.sendRedirect("loginForm");		// /loginCheck/loginForm  => 오류
			response.sendRedirect("../MainForm");	// /loginForm => 정상
			// /loginCheck/** 주소시 /loginCheck이 남아 있게 되어 /loginCheck/loginForm 주소요청이 됨 ../ 이용 하나 위로 올려 찾게 함
			// servlet-context.xml
			// <mvc:view-controller path="/loginForm" view-name="loginForm"/>	// loginForm.jsp
			return false;	// 주의
		}else {	// 로그인 시
			System.out.println("interceptor 로그인 정보 있음");
			return true;	// 주의
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
