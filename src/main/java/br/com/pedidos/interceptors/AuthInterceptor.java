package br.com.pedidos.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {
	
	static Logger logger = Logger.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println(request.getRequestURL());
		
		if (request.getRequestURL().toString().contains("/auth/signin")) {
			return true;
		} else {
			
			System.out.println("header: " + request.getHeader("authorization"));
			
			if(request.getHeader("authorization") == null) {
				System.out.println(">>>>>>>>>>>null");
				response.sendError(response.SC_FORBIDDEN);
				return false;

			} else {
				
				System.out.println(">>>>>>>>>>>>>>>>>> notnull");
				return true;
			}

		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
