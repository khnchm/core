package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",  //빈 등록을 위한 시작 위치 지정
//        basePackageClasses = AutoAppConfig.class, // 빈등록을 할 class를 설정할 수 있음.
        //시작위치를 지정하지 않으면 @ComponentScan이 있는 설정 파일의 패키지위치를 시작위치로 자동 지정.

        /**
         * 컴포넌트 스캔의 대상
         * @Component
         * @Controller
         * @Service
         * @Repository
         * @Configuration
        */

        /**
         * includeFilters
         * excludeFilters
        */

        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)// 빈등록을 제외하고 싶은 정보를 filter를 이용하여 설정

)
public class AutoAppConfig {
      // memoryMemberRepository -> 자동, 수동 빈 등록을 통한 충돌이 날 경우 스프링에서는 error로 팅겨낸다.(스프링부트에서)
      // 수동, 자동 빈 등록 이슈로 인해 애매한 오류가 발생하여 스프링에서 error로 팅겨내도록 기본이 설정됨.
        /*  @Bean(name="memoryMemberRepository")
        MemberRepository memberRepository(){
                return new MemoryMemberRepository();
        }*/

}
