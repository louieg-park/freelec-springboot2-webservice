package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

/**
 * FileName : HelloConrollerTest
 * Created By PARKPRO on 2022-07-09(토)
 * Version : 0.1
 * <p>
 * 스프링부트에서 테스트코드 작성하기 - 2.2 Hello Controller 테스트 코드 작성하기 : step_02) 간단한 API 생성 > HomeController 생성
 *                              ↓
 * 스프링부트에서 테스트코드 작성하기 - 2.4 HelloController 코드를 Lombok으로 리팩토링하기 : HelloController에서 HelloResponseDto 사용하기  - API 테스트하기
 */
/* jUnit4의 @RunWith(SpringRunner.class)와 같은 역할을 하는 jUnit5 어노테이션 */
@ExtendWith(SpringExtension.class)
/*
    @WebMvcTest
    Web(SpringMVC)에 집중할 수 있는 어노테이션
    - @Controller, @ControllerAdvice등을 사용가능.
    - 단, @Service, @Repository, @Component 등은 사용 불가능
*/
@WebMvcTest
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean) 주입
    private MockMvc mvc; //Web API 테스트시 사용, 스프링MVC 테스트의 시작이며 HTTP GET, POST등에 대한 API 테스트 가능

    /**
     * Hello 가 리턴된다.
     *
     * @throws Exception the exception
     */
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        /* MockMVC를 통해 /hello로 HTTP GET 요청 - 체이닝 지원 : 여러 검증 기능을 이어 선언가능 */
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                /* mvc.perform()의 수행 결과를 검증 - HTTP Header의 Status를 검증(200, 404, 500 등) : 여기선 isOk의 의미는 200인지 아닌지를 검증 */
                .andExpect(status().isOk())
                /* mvc.perform()의 수행 결과를 검증 - HTTP 응답 본문 내용 검증 : HomeController에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증 */
                .andExpect(content().string(hello));
    }

    /**
     * 2.4 HelloController 코드를 Lombok으로 리팩토링하기 : HelloController에서 HelloResponseDto 사용하기  - API 테스트하기
     *
     * @throws Exception the exception
     */
    @Test
    public void helloDto_가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(MockMvcRequestBuilders.get("/hello/dto")
                /* param() : API 테스트할 때 사용될 요청파라미터를 설정. 단, String만 허용되며 그외 타입은 문자열로 변경해야 함. */
                .param("name", name)
                .param("amount", String.valueOf(amount))).andExpect(status().isOk())
                /* jsonPath() : JSON응답 값을 필드별로 검증할 수 있는 메소드로서 $를 기준으로 필드명을 명시 */
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
