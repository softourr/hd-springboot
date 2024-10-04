package com.sample.spring.controller;

import com.sample.spring.dao.ISimpleBbsDao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @Autowired
    ISimpleBbsDao dao;

    @RequestMapping("/")
    public String root() {
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String listPage(Model model) {
        model.addAttribute("lists", dao.listDao());
        model.addAttribute("count", dao.countDao());
        return "list";
    }

    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "view";
    }
    @RequestMapping("/writeForm") // 글쓰기 페이지, 글쓰기 버튼 누르면 dao에 insert하고 리다이텍트로 list 페이지로
    public String writeForm() {
        return "writeForm";
    }
    @RequestMapping("/write")
    public String write(HttpServletRequest request) {
        // writeForm의 필드값 3개를 넘기기
        dao.writeDao(request.getParameter("writer"),
                request.getParameter("title"),
                request.getParameter("content"));

        return "redirect:list";
    }
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) {
        String sId = request.getParameter("id"); // 요청에서 id를 가져옴
        dao.delete(sId); // dao를 사용해 삭제
        return "redirect:list";
    }
}

