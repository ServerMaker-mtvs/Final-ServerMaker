package com.ohgiraffers.MemberService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMemberPwd {
    public void checkPwd(String pwd1, String pwd2) {
        // 입력받은 두 문자열 null 확인
        checkNull(pwd1, pwd2);
        // 입력받은 두 문자열이 일치하는지 확인
        checkTwoPwd(pwd1, pwd2);
        // 입력받은 첫번째 문자열이 영문&숫자&특수문자 포함, 공백&한글 미포함, 5~12자리인지 확인
        checkPattern(pwd1);
    }

    private void checkNull(String pwd1, String pwd2) {
        if (pwd1 == null)
            throw new IllegalArgumentException("비밀번호를 제대로 입력해주세요.");
        else if (pwd2 == null)
            throw new IllegalArgumentException("비밀번호를 제대로 입력해주세요.");
    }

    private void checkTwoPwd(String pwd1, String pwd2) {
        if (!pwd1.equals(pwd2))
            throw  new IllegalArgumentException("입력하신 두 비밀번호가 다릅니다.");
    }

    private void checkPattern(String pwd) {
        // 영문 포함, 숫자 포함, 특수 문자 포함, 한글 미포함, 공백 미포함, 5자리 이상 12자리 이하인지 확인하는 패턴
        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W)(?!.*[ㄱ-ㅎㅏ-ㅣ가-힣])(?!.*\\s).{5,12}$");
        Matcher passPattern = pattern.matcher(pwd);

        // 입력받은 비밀번호와 패턴이 일치하지 않으면 false 반환 -> IllegalException 발생
        if (!passPattern.find())
            throw new IllegalArgumentException("비밀번호는 영문, 숫자, 특수문자를 1개 이상 포함하며, 5자리 이상 12자리 이하여야합니다.");
    }
}
