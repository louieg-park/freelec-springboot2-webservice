package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;

/**
 * FileName : HomeController
 * Created By PARKPRO on 2022-07-09(토)
 * Version : 0.1
 *
 * <p>
 * 스프링부트에서 테스트코드 작성하기 - 2.2 Hello Controller 테스트 코드 작성하기 : step_02) 간단한 API 생성 > HomeController 생성
 *                              ↓
 * 스프링부트에서 테스트코드 작성하기 - 2.4 HelloController 코드를 Lombok으로 리팩토링하기 : HelloController에서 HelloResponseDto 사용하기
 * <p>
 */
@RestController //JSON을 반환하는 Controller로 만들어줌 → @ResponsBody를 각 메소드별로 선언했던 것을 한 번에 사용할 수 있도록 처리
public class HomeController {

    /**
     * Hello string.
     *
     * @return the string
     */
    @GetMapping("/hello") // = '@RequestMapping(name = "/hello", method = RequestMethod.GET)' : "/hello"라는 요청을 GET 요청으로 받는다 
    public String hello() {
        return "hello"; // 문자열인 hello를 반환
    }
    
    /**
     * HelloResponseDto를 HelloController에 적용하기
     *
     * @param name   the name
     * @param amount the amount
     * @return the hello response dto
     * 
     * Comment : @RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션 : @RequestParam("name") 의 값을 변수 name에 저장
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto hello(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
