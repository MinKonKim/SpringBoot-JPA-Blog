package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity //User 클래스가 MySQL에 테이블이 생성이 된다.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    private int id;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 : <html>태그가 섞임

    private int count; //조회수

    @ManyToOne(fetch=FetchType.EAGER)  //Many = Board , One = User
    @JoinColumn(name="userId") //유저정보를 무조건 가져올게(Eager)
    private  User user;//DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

    //mappedBy가 적혀있으면 연관관계의 주인이 아니다(FK가 아니다.) = DB에 컬럼을 만들지 마세요
    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER)//필요하면 가져올게(Lazy)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
