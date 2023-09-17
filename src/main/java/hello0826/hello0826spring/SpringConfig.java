package hello0826.hello0826spring;

import hello0826.hello0826spring.repository.JdbcMemberRepository;
import hello0826.hello0826spring.repository.JdbcTemplateMemberRepository;
import hello0826.hello0826spring.repository.MemberRepository;
import hello0826.hello0826spring.repository.MemoryMemberRepository;
import hello0826.hello0826spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
