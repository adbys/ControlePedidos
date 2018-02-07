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
import br.com.pedidos.services.ClientSessionService;

@Component
public class AuthInterceptor implements HandlerInterceptor {
	
	static Logger logger = Logger.getLogger(AuthInterceptor.class);
	
	@Autowired
	private ClientSessionService clientSessionService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println(request.getRequestURL());
		String token = request.getHeader("authorization");
		
		//TODO: criar authService
		if (request.getRequestURL().toString().contains("/auth/signin") || request.getRequestURL().toString().contains("/auth/checkToken")) {
			System.out.println(">>>>>>>>>>>>>>>>>> signin");
			return true;
		} else {
			System.out.println("header: " + request.getHeader("authorization"));
			if(token == null) {
				System.out.println(">>>>>>>>>>>null");
				response.sendError(response.SC_FORBIDDEN);
				return false;

			} else {
				ClientSession clientSession = clientSessionService.buscarClientSession(token);
				if (clientSession == null) {
					response.sendError(response.SC_BAD_REQUEST);
					return false;
				} else {
					Date now = new Date();
					if (now.compareTo(clientSession.getVencimento()) > 0) {
						System.out.println("vencido");
						clientSessionService.deleteClientSession(token);
						response.sendError(response.SC_BAD_REQUEST);
						return false;
					} else {
						return true;
					}
					
				}
				
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
