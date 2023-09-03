package hello0826.hello0826spring.repository;

import hello0826.hello0826spring.domain.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class test {

    public static void main(String[] args) {
        Map<Long, Long> store = new HashMap<>();
        long sequence = 0L;
        long i;

        Member member = new Member();
         member.setName("hello");
         member.setId(1l);

         store.put(1l,1l);
        System.out.println(Optional.ofNullable(store.get(1l)).get());

        System.out.println(store.values());
//        i = sequence++;



//        store.put(i,3l);
//        System.out.println(store.get(i));
//        System.out.println(member.getName());
    }

}
