package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController //DATA 리턴하는 Controller
public class DumyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }
        return "삭제되었습니다. id"+id;
    }

    //save함수는 id 전달해주면 insert
    //save함수는 id 전달하면 해당 id에 대한 데이터가 있으면 update 해준다.
    //save함수는 id 전달하면 해당 id에 대한 데이터가 없으면 insert 해준다.
    @Transactional
    @PutMapping("/dummy/user/{id}")
    //json 데이터를 요청 => Java Object(MessageConverter와 Jackson라이브러리가 변환해서 받아줌)
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){
        System.out.println("id : "+id);
        System.out.println("password : "+requestUser.getPassword());

        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
//        userRepository.save(user);
//        더티 체킹
        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size=2,sort="id",direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUser =  userRepository.findAll(pageable); //페이징 가능하게 하기 위함.

        List<User> users = pagingUser.getContent();
        return users;
    }
    @PostMapping("/dummy/join")
    public String join(User user)
    {
        System.out.println("유저 아이디 : "+ user.getId());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료";
    }

    //{id} 주소로 파라미터 전달 받을 수 있음.
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        //Optional : 너가 User 객체 원해서 가져왔더니 null값이면 어캄..
        // 그러니까 Optional로 한번 감싸줄테니 알아서 쓰렴

        //람다식
        /*
        User user = userRepository.findById(i).orElseThrow(()->{
            return IllegalArgumentException("해당 사용자는 없습니다.");
        })*/

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : "+id);
            }
        });
        //요청 : 웹 브라우저
        //user 객체 = 자바 오브젝트
        //변환 (웹브라우저가 이해할수 있는 데이터 -> json(Gson라이브러리)
        //스프링부트  = MessageConverter라는 애가 응답시에 자동 작동
        //만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
        // user 오브젝트를 json으로 변환해서 브라우저에 던져준다.

        return user;
    }
}
