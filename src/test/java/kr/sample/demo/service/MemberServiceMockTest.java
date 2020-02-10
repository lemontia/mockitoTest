package kr.sample.demo.service;

import kr.sample.demo.entity.Member;
import kr.sample.demo.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberServiceMockTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;



    @Test
    @DisplayName("mockito 레파지토리 테스트")
    void mockMemberRepositoryTest() {
        //given
        Member member1 = Member.builder()
                .name("mock유저1")
                .age(20)
                .build();
        List<Member> members = new ArrayList<>();
        members.add(member1);

        given(memberRepository.findAll()).willReturn(members);

        //when
        List<Member> findMembers = memberRepository.findAll();
        System.out.println("findMembers = " + findMembers);

        //then
        Assertions.assertEquals(1, findMembers.size());
        Assertions.assertEquals(member1.getName(), findMembers.get(0).getName());
    }


    @Test
    @DisplayName("mockito 서비스 테스트")
    void mockMemberServiceTest() {
        //given
        Member member1 = Member.builder()
                .name("mock유저1")
                .age(20)
                .build();
        List<Member> members = new ArrayList<>();
        members.add(member1);

        given(memberRepository.findAll()).willReturn(members);

        //when
        List<Member> findMembers = memberService.findMemberAll();

        System.out.println("memberAll = " + findMembers);


        //then
        Assertions.assertEquals(member1.getName(), findMembers.get(0).getName());
    }
}
