package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

//사용자가 요청->응답(html)
// @Controller

//사용자가 요청 ->응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTeset :";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m1 = Member.builder().username("cadre").password("1234").id(1).email("email@com.com").build();

        System.out.println(TAG+"getter : " + m1.getId());
        m1.setId(5000);
        System.out.println(TAG+"setter : " + m1.getId());

        return m1.toString();
    }

    @GetMapping("/http/get")
    public String getTest(Member m){
        return "get 요청"+ m;
    }
    @PostMapping("/http/post")
    public String postTest(Member m){
        return "post 요청" +m;
    }

    @PutMapping("/http/put")
    public String putTest(){
        return "put 요청";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}
