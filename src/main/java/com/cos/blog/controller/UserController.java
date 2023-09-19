package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.UUID;


//인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
//그냥 주소가 /이면 index.jsp 허용
//static이하에 있는  /js/**, /css/**,/image/**

@Controller
public class UserController {

    @Value("${cos.key}")
    private String cosKey;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @GetMapping("/auth/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String UpdateForm( ){return "user/updateForm";}
    
    @GetMapping("/auth/kakao/callback")
    public String kakaoCallback(String code) throws JsonProcessingException { // Data를 리턴해주는 Controller함수

        RestTemplate rt= new RestTemplate();

        //HttpHeader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HttpBody 오브젝트 생성
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id","8c28c140ae5be295966e9baae7c4991e");
        body.add("redirect_uri","http://localhost:8000/auth/kakao/callback");
        body.add("code",code);

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> kakoTokenRequest=
                new HttpEntity<>(body, headers);

        // Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakoTokenRequest,
                String.class
        );
        // Gson , Json Simple, ObejectMapper
        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        String accessToken = jsonNode.get("access_token").asText();

        System.out.println("카카오 엑세스 토큰 : "+accessToken);

        /***--------------토큰으로 카카오 API 호출하기 --------------**/

        RestTemplate rt2= new RestTemplate();

        //HttpHeader 오브젝트 생성
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer "+accessToken);
        headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> kakoProfileRequest=
                new HttpEntity<>(headers2);

        // Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response2 = rt2.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.GET,
                kakoProfileRequest,
                String.class
        );

        //받아온 정보를 변수에 저장
        String responseBody2 = response2.getBody();
        jsonNode = objectMapper.readTree(responseBody2);
        Long id = jsonNode.get("id").asLong();
        String nickname = jsonNode.get("properties")
                .get("nickname").asText();
        String email = jsonNode.get("kakao_account")
                .get("email").asText();

        System.out.print("카카오 프로필  : ");
        System.out.println("아이디 : "+id+ "\t닉네임 :"+nickname);
    //  UUID란 -> 중복되지 않는 어떤 특정 값을 만들어내는 알고리즘
        UUID garbagePassword = UUID.randomUUID();

        User kakaoUser = User.builder()
                .username(nickname+"_"+id)
                .password(cosKey)
                .email(email)
                .build();

        //가입자 혹은 비가입자 체크해서 처리
        User originuser = userService.회원찾기(kakaoUser.getUsername());
//        System.out.println("회원찾기 정상완료");
        if(originuser.getUsername() == null){ //비가입자라면
            System.out.println("기존 회원이 아닙니다.");
            userService.회원가입(kakaoUser);
        }
        //로그인 처리
        // 1. 현재 인증(Authentication) 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 2. 변경된 사용자 정보를 포함하는 PrincipalDetail 객체 생성
        PrincipalDetail principalDetail = new PrincipalDetail(kakaoUser); // 변경된 사용자 정보를 담은 UserDetails 객체 생성
        // 3. SecurityContextHolder의 현재 인증 정보를 업데이트
        SecurityContextHolder.getContext()
                .setAuthentication( new UsernamePasswordAuthenticationToken(principalDetail, authentication.getCredentials(), authentication.getAuthorities()));


        return "redirect:/";
    }


}
