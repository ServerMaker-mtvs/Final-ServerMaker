package com.ohgiraffers.MemberService;

import com.ohgiraffers.Member.MemberDTO;
import com.ohgiraffers.Member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveMemberInformation {

    public void saveInformation (HttpServletRequest req) throws ParseException {
        String memberName= req.getParameter("memberName");
        String memberId=req.getParameter("memberId");
        String memberPwd1=req.getParameter("memberPwd1");
        String memberPwd2=req.getParameter("memberPwd2");
        String memberBirth=req.getParameter("memberBirth");
        SimpleDateFormat parseFm=new SimpleDateFormat("yyyy-MM-dd");
        Date parDate=parseFm.parse(memberBirth);

        MemberDTO dto=new MemberDTO(memberName,memberId,memberPwd1,parDate);
        MemberRepository memberRepository=MemberRepository.getInstance(); // 모든 검증 로직이 다끝나고 나면 Repository에 접근

        // Id 유효성 확인
        /*
        try {
            CheckMemberId checkMemberId = new CheckMemberId();
            checkMemberId.CheckBlankId(memberId);
            checkMemberId.CheckPatternId(memberId);
            checkMemberId.CheckEqualId(memberId,memberId);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        */
        // 이름 유효성 확인
        try {
            CheckMemberName checkMemberName = new CheckMemberName();
            checkMemberName.CheckBlankName(memberName);
            checkMemberName.CheckPatternName(memberName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        //  비밀번호 유효성 확인
        try {
            CheckMemberPwd checkMemberPwd = new CheckMemberPwd();
            checkMemberPwd.checkPwd(memberPwd1,memberPwd2);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        // 나이 유효성 확인
        try {
            CheckMemberBirthday checkMemberBirthday = new CheckMemberBirthday();
            checkMemberBirthday.checkBirth(memberBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        memberRepository.save(dto); //데이터 저장
    }

}
