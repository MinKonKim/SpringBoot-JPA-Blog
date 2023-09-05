package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

//ORM -> Java Object ->테이블로 매핑해주는 기술
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //User 클래스가 MySQL에 테이블이 생성이 된다.
public class User {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //넘버링 전략 : 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    //db : 오라클 -> 오라클 전략
    //   : mysql  -> mysql 전략
    private  int id; //시퀀스, auto_increment

    @Column(nullable= false, length=30)
    private String username; //아이디

    @Column(nullable= false, length=100) //해쉬 (암호화)
    private String password;

    @Column(nullable= false, length=50)
    private String email;

    @ColumnDefault("'user'")
    private String role;
    @CreationTimestamp // 시간이 자동으로 입력
    private Timestamp createDate;
}
