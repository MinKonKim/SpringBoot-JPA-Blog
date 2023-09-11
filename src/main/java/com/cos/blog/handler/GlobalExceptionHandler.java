package com.cos.blog.handler;

import com.cos.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 Exception 발생 시 해당 클래스로 들어옴
@RestController
public class GlobalExceptionHandler {

//    @ExceptionHandler(value=IllegalArgumentException.class)// IllegalArgumentException만 받을거임
    @ExceptionHandler(value=Exception.class) //모든 Exception들 다 받겠어
    public ResponseDto<String> handleArgumentException(IllegalArgumentException e){
       return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//        return "<h1>"+e.getMessage()+"</h1>";
    }
}
