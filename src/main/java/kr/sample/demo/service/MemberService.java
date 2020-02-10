package kr.sample.demo.service;

import kr.sample.demo.entity.Member;
import kr.sample.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findMemberAll() {
        return memberRepository.findAll();
    }
}
