package com.cos.blog.controller.api;


import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController: save 호출");
        //실제로 DB에 insert 하고 아래에서 return이 되면 됨.

        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }



    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user,
                                       @AuthenticationPrincipal PrincipalDetail principal,
                                       HttpSession session){
        userService.회원수정(user);
        //DB값은 변경됬지만 session값은 변경되지 않았다.
        //직접 세션값을 변경해 줄거임.

        // 1. 현재 인증(Authentication) 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 2. 변경된 사용자 정보를 포함하는 PrincipalDetail 객체 생성
        PrincipalDetail principalDetail = new PrincipalDetail(user); // 변경된 사용자 정보를 담은 UserDetails 객체 생성
        // 3. 새로운 UsernamePasswordAuthnticationToken 생성하여 인증 정보 업데이트
        UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(principalDetail, authentication.getCredentials(), authentication.getAuthorities());
        // 4. SecurityContextHolder의 현재 인증 정보를 업데이트
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }






}
