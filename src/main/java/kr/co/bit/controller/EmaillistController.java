package kr.co.bit.controller;

import kr.co.bit.dao.EmailListDao;
import kr.co.bit.vo.EmailListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller//컨트롤러지정
public class EmaillistController {

    @Autowired//자동으로 연결
    private EmailListDao emailListDao;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(){
        System.out.println("form들어옴");
        return "form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute EmailListVO emailListVO){
        System.out.println("add들어옴");
        System.out.println(emailListVO.toString());

        emailListDao.insert(emailListVO);

        return "redirect:/form";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        List<EmailListVO> list = emailListDao.getList();

        model.addAttribute("list",list);

        return "list";
    }


}
