package kr.sample.demo.service;

import kr.sample.demo.entity.Member;
import kr.sample.demo.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

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
    @DisplayName("서비스회원조회테스트")
    @Transactional
    void findMemberAllTest() {
        // given

        // when
        List<Member> members = memberService.findMemberAll();

        // then
        Assertions.assertEquals(2, members.size());
    }
}