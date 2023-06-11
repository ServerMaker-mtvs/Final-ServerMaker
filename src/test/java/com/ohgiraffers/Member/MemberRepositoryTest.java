package com.ohgiraffers.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 각 테스트가 끝날 때마다 초기화
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @DisplayName("새로 생성한 멤버와 저장한 멤버가 같은지 여부 판단")
    @Test
    void save() throws ParseException {
        /*
            필기.
                member 객체를 생성하기 위해 파라미터로 Date 타입의 생년월일 정보를 넘겨줘야 하는데
                String을 Date로 파싱하여 넘겨주기 위해 임의로 아래와 같은 단계를 거친다.
         */
        // 문자열
        String taedyDateStr = "1990-09-08";
        // 포맷터
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // 문자열 -> Date
        Date date = formatter.parse(taedyDateStr);

        // given
        MemberDTO member = new MemberDTO("김태현", "taedy", "server1", date);

        // when
        MemberDTO savedMember = memberRepository.save(member);

        // then
        Assertions.assertEquals(member, savedMember);
    }

    @DisplayName("임의로 멤버 2명을 생성 후 저장하고, 저장한 멤버의 수가 2명이 맞는지 확인")
    @Test
    void findAll() throws ParseException {
        // 문자열
        String member1DateStr = "2023-06-01";
        String member2DateStr = "2003-05-30";
        // 포맷터
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // 문자열 -> Date
        Date member1date = formatter.parse(member1DateStr);
        Date member2date = formatter.parse(member2DateStr);


        //given
        MemberDTO member1 = new MemberDTO("member1Name", "member1Id", "member1Pwd", member1date);
        MemberDTO member2 = new MemberDTO("member2Name", "member2Id", "member2Pwd", member2date);

        //when
        MemberDTO savedMember1 = memberRepository.save(member1);
        MemberDTO savedMember2 = memberRepository.save(member2);

        //then
        List<MemberDTO> result = memberRepository.findAll();
        Assertions.assertEquals(2, result.size());
    }

    @DisplayName("임의로 멤버 2명을 생성 후 저장하고, 생성한 멤버의 ID와 저장한 멤버의 ID가 모두 맞게 나오는지 확인")
    @Test
    void findAllId() throws ParseException {
        // 문자열
        String member1DateStr = "2023-06-01";
        String member2DateStr = "2003-05-30";
        // 포맷터
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // 문자열 -> Date
        Date member1date = formatter.parse(member1DateStr);
        Date member2date = formatter.parse(member2DateStr);


        //given
        MemberDTO member1 = new MemberDTO("member1Name", "member1Id", "member1Pwd", member1date);
        MemberDTO member2 = new MemberDTO("member2Name", "member2Id", "member2Pwd", member2date);

        //when
        MemberDTO savedMember1 = memberRepository.save(member1);
        MemberDTO savedMember2 = memberRepository.save(member2);

        //then
        List<String> result = memberRepository.findAllId();

        // 2명이 맞게 저장되었는지 확인
        Assertions.assertEquals(2, result.size());

        // 생성한 멤버 Id와 저장한 멤버 Id가 같은지 확인
        Assertions.assertEquals("member1Id", result.get(0));
        Assertions.assertEquals("member2Id", result.get(1));
    }
}
