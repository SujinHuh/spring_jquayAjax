package com.example.spring_jquayajax.Controller;


import com.example.spring_jquayajax.dto.Jamong;
import com.example.spring_jquayajax.dto.MessageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller //view 반환
public class MainController {

    @RequestMapping(value = "/dataSend",method = RequestMethod.POST)
    public String dataSend(Model model, MessageDTO dto){
        model.addAttribute("msg",dto.getResult()+"/ this is the value sent by the server ");
        return "index :: #resultDiv";
    }

    @RequestMapping(value = "/dataPend",method = RequestMethod.POST)
    public String dataPend(Model model,MessageDTO dto){
        model.addAttribute("msg",dto.getResult()+"/ 서버에서 붙여준 값입니다");
        return "index :: #resultDive";
    }
    @RequestMapping(value="/requestObject", method=RequestMethod.POST)
    @ResponseBody
    public String simpleWithObject(Jamong jamong) {
        //필요한 로직 처리
        return jamong.getName() + jamong.getAge();
    }

    @RequestMapping(value="/stringify", method=RequestMethod.POST)
    @ResponseBody
    public Object stringify(@RequestBody Jamong jamong) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", jamong.getName());
        map.put("age", jamong.getAge());
        return map;
    }

}
