package hello0826.hello0826spring.repository;

import hello0826.hello0826spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();

    }
    @Test
    void save() {


        Member member1 = new Member();


        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member1);
        repository.save(member2);

        System.out.println(member1.getId());
        System.out.println(member2.getId());
        System.out.println(member1.getName());
        System.out.println(member2.getName());



        Member result = repository.findById(member1.getId()).get();
        Optional<Member> result2 = repository.findById(member2.getId());
        System.out.println(result2.get().getId());
        Member result3 = repository.findByName("spring1").get();
        System.out.println(result3.getName());

        //System.out.println(result.getName());
        System.out.println(result.getId());


        System.out.println("result = " + (result == member1)) ;
       // /¿org.assert/j//.core.api.Assertions
        assertThat(member1).isEqualTo(result);

        //        Assertions.assertEquals(member,null);
//        System.out.println(member.getId());
//        System.out.println(repository.findById(member.getId()));

    }

    @Test
    void findById() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Optional<Member> result = repository.findById(member1.getId());

        System.out.println(result.get().getName());

        Member member3 = result.get();


    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);




    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

    @Test
    void clearStore() {
    }
}