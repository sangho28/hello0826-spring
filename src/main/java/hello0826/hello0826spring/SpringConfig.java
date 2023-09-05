package hello0826.hello0826spring;

import hello0826.hello0826spring.repository.MemberRepository;
import hello0826.hello0826spring.repository.MemoryMemberRepository;
import hello0826.hello0826spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
