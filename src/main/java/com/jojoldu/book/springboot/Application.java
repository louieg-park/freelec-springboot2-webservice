package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * FileName : Application
 * Created By PARKPRO on 2022-07-09(토)
 * Version : 0.1
 * <p>
 * 스프링부트에서 테스트코드 작성하기 - 2.2 Hello Controller 테스트 코드 작성하기 : step_01) 메인 클래스 생성
 * <p>
 * Application.java → Main Class
 *
 * @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 항상 메인클래스는 프로젝트의 최상단에 위치해야 함.
 */
@SpringBootApplication //스프링부트의 자동설정, 스프링 Bean 읽기 및 생성을 모두 자동으로 설정
public class Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * SpringApplication.run() → 내장 WAS(Web Application Server) 실행
     *
     */
    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
