package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	//컨트롤러에서 나올 떄 가로채는 겨우 호출이 됨
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		 //컨트롤러가 보내준 회원 정보를 가져옴
		MemberVo user = (MemberVo)modelAndView.getModel().get("user");
		//가져온 회원 정보가 있으면 세션에 회원을 
		HttpSession session = request.getSession();
		if(user != null) {
			session.setAttribute("user", user);
		}
	}
	//컨트롤러로 들어가기 전 가로채는 경우 호출이 됨
	//리턴이 true이면 가던 url로 가서 실행
	//리턴이 fasle이면 가던 url로 가지 못함. 보통 이 경우는 redirect로 다른 url로 가라고 함.
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			//구현
			return true;
	}
}
