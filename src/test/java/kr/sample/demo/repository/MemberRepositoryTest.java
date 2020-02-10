package kr.sample.demo.repository;

import kr.sample.demo.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @BeforeEach
    void setup() {
        Member member = Member.builder()
                .name("유저1")
                .age(20)
                .build();

        memberRepository.persist(member);


        Member member2 = Member.builder()
                .name("유저2")
                .age(30)
                .build();

        memberRepository.persist(member2);
    }

    @Test
    @DisplayName("고객조회")
    @Transactional
    void memberFindAll() throws Exception{
        // given

        // when
        List<Member> members = memberRepository.findAll();

        // then
        System.out.println("members = " + members);
    }
}