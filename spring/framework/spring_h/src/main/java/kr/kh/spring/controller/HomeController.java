package kr.kh.spring.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.dto.PersonDTO;
import kr.kh.spring.model.vo.MemberVo;
import kr.kh.spring.service.MemberService;

/*@Controller
 * => HandletMapping에 url을 등록하기 위한 어노테이션
 * */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MemberService memberService;
	/*@RequestMapping
	 * => 처리할 URL 정보를 지정하는 어노테이션으로 해당 정보와 일치하는 경우 메소드를 호출하여 실행
	 * => value : 처리할 URL을 지정
	 * => method: 리퀘스트 메소드 처리 방식을 지정. GET,POST,PUT,DELETE 등
	 * 
	 * @GetMapping
	 * => @RequestMapping(method = RequestMethod.GET)인 경우 대체할 수 있는 어노테이션
	 * 
	 * @PostMapping
	 * =>@RequestMapping(method = RequestMethod.Post)인 경우 대체할 수 있는 어노테이션
	 * */
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/example")
	public String example(Locale locale, Model model, String name,Integer age) {
		System.out.println("화면에서 보낸 이름: "+name);
		System.out.println("화면에서 보낸 나이: "+age);
		/*화면에 데이터를 전송하는 방법
		 * 	-Model 객체를 이용하여 전송
		 * 	-addAttribute("화면에서 쓸 이름", 데이터);
		 * */
		model.addAttribute("name","홍길동");
		/*컨트롤러가 Dispatcher Servlet(이하 디스패처)에게 home이라는 문자열을 반환
		 * =>디스패처가 View Resolver(이하 뷰 리졸버)에게 home이라는 문자열을 전달
		 * =>뷰 리졸버는 설정된 방법에 따라 home을 가공함
		 * 	=>뷰 리졸버 설정은 servlet-context.xml에 있음
		 * 	=>기본 뷰 리졸버에 의해 /WEB-INF/view/home.jsp가 완성되어
		 * 		최종적으로 해당 jsp의 결과 화면을 클라이언트에 전송*/
		
		return "/sample/home";
	}
	@GetMapping("/")
	public String home() {
		return"home";
	}
	/*메소드 매개변수에 객체를 넣어주면, 맵핑이 되든 안되든 기본 생성자를 이용하여 객체를 만듬
	 * => 화면에서 보낸 변수의 이름과 같은 필드가 있으면 자동으로 맵핑이 되어 값이 변경됨.
	 * 		이때 setter를 호출
	 * */
	@RequestMapping("/send")
	public String home2(Model model,PersonDTO person) {
		/*서버에서 화면으로 객체를 전송*/
		model.addAttribute("person",person);
		return"/sample/send";
	}
	@GetMapping("/{name}/{age}")
	public String nameAge(@PathVariable("name")String name1, @PathVariable("age")int age1) {
		return "/sample/send";
	}
	@GetMapping("/redirect")
	public String redirect(PersonDTO person) {
		System.out.println(person);
		return "/redirect:/send";
	}
	@GetMapping("/jstl")
	public String jstl(Model model) {
		List<String> list = Arrays.asList("사과","참외","수박","바나나"); 
		model.addAttribute("str","<h1>서버에서 보낸 데이터입니다만.</h1>");
		model.addAttribute("age",20);
		model.addAttribute("list",list);
		model.addAttribute("date",new Date());
		return"/sample/jstl";
	}
	@GetMapping("/signup")
	public String signup() {
		return"/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(MemberVo member) {
		if(memberService.singup(member)) {
			return "redirect:/";
		}
		return"redirect:/signup";
	}
	@GetMapping("/login")
	public String login() {
		return"/member/login";
	}
	@PostMapping("/login")
	public String loginPost(Model model,MemberVo member) {
		//화면에서 보낸 회원 정보를 일치하는 회원 정보를 DB에서 가져옴
		MemberVo user = memberService.login(member);
		//가져온 회원 정보를 인터셉터에게 전달
		model.addAttribute("user",user);
		if(user == null) { return "redirect:/login";}
		return"redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		//세션에 있는 user를 삭제
		HttpSession session= request.getSession();
		session.removeAttribute("user");
		return"redirect:/";
	}
}
