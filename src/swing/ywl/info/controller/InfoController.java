package swing.ywl.info.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import swing.ywl.info.service.InfoService;

@RequestMapping("/ywl")
@Controller
public class InfoController {

	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/toHome")
	public String toHome(HttpServletRequest request){
		return "ywl/home";
	}
	
}
