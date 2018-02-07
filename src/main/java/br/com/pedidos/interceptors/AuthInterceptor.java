package br.com.pedidos.interceptors;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import br.com.pedidos.model.ClientSession;
import br.com.pedidos.services.AuthService;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	
	static Logger logger = Logger.getLogger(AuthInterceptor.class);
	
	@Autowired
	private AuthService authService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println(request.getRequestURL());
		
		if (request.getRequestURL().toString().contains("/auth/signin") || request.getRequestURL().toString().contains("/usuario") || request.getRequestURL().toString().contains("/error")) {
			return true;
		} else {
			String token = request.getHeader("authorization");
			if(token == null) {
				response.sendError(response.SC_FORBIDDEN);
				return false;
			} else {
				int responseStatus = authService.checkToken(token);
				
				if (responseStatus == HttpServletResponse.SC_ACCEPTED) {
					return true;
				} else {
					response.sendError(responseStatus);
					return false;
				}

			}

		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		

	}

}
