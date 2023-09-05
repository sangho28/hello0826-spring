package hello0826.hello0826spring.service;

import hello0826.hello0826spring.domain.Member;
import hello0826.hello0826spring.repository.MemberRepository;
import hello0826.hello0826spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    public final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     *  회원가입
     */
    public long join(Member member) {
        validateDuplicateMember(member); //같은 이름이 있는 중복 확인 x
        memberRepository.save(member);
        return member.getId();



    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미존재");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
