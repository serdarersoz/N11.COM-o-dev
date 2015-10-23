package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(Model model,HttpServletRequest request) {




		Map<String,String> info =new HashMap<String, String>();


		Cookie[] cookies= request.getCookies();

		for(Cookie cookie:cookies){

			if(cookie.getName().equals("birthdate")){
				info.put("birthdate",cookie.getValue());
			}
			else if(cookie.getName().equals("education")){
				info.put("education",cookie.getValue());
			}
			else if(cookie.getName().equals("experience")){
				info.put("experience",cookie.getValue());
			}


		}




		model.addAttribute("info",info);





		return "index";
	}


	@RequestMapping(value = "/social",method = RequestMethod.GET)
	public String printSocial(Model model,HttpSession session) {


		model.addAttribute("info",session.getAttribute("social-info"));



		return "social";
	}


	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String showUpdate(@RequestParam Map<String,String> reqParams,HttpSession session,HttpServletRequest request, HttpServletResponse response,Model model) {

		String message="";

		Map<String,String> info=new HashMap<String, String>();

		if(reqParams.containsKey("target")) {

			if (reqParams.get("target").equals("save-social")) {

				info.put("facebook", reqParams.get("facebook"));
				info.put("twitter", reqParams.get("twitter"));
				info.put("instagram", reqParams.get("instagram"));

				session.setAttribute("social-info", info);

				message="social info saved successfully";

			} else if (reqParams.get("target").equals("save-resume")) {

				CookieGenerator cookie = new CookieGenerator();
				cookie.setCookieMaxAge(60 * 60 * 24 * 30);
				cookie.setCookieName("birthdate");
				cookie.addCookie(response, reqParams.get("birthdate"));

				cookie = new CookieGenerator();
				cookie.setCookieMaxAge(60 * 60 * 24 * 30);
				cookie.setCookieName("education");
				cookie.addCookie(response, reqParams.get("education"));

				cookie = new CookieGenerator();
				cookie.setCookieMaxAge(60 * 60 * 24 * 30);
				cookie.setCookieName("experience");
				cookie.addCookie(response, reqParams.get("experience"));

				message="resume saved successfully";
			}
		}

		model.addAttribute("message",message);

		return "update";
	}






}





