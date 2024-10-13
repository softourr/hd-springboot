package com.sample.spring.controll;

import com.sample.spring.domain.Member;
import com.sample.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class Membercontroller {
	@Autowired
	private MemberService memberService;

	@RequestMapping("/")
	public String root() {
		return "test";
	}

	@RequestMapping("/all")
	public String selectAll(Model model) {
		List<Member> result = memberService.selectAll();	r
		model.addAttribute("members", result);
		return "selectAll";
	}
}
