package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"","/"})
    public String index(){ // 컨트롤러에서 세션은 어케 찾음?
        ///WEB-INF/views/index.jsp
        return "index";
    }
}
