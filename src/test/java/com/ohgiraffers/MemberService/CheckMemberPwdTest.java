package com.ohgiraffers.MemberService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckMemberPwdTest {
    CheckMemberPwd checkMemberPwd;

    @BeforeEach
    public void setUp(){
        this.checkMemberPwd = new CheckMemberPwd();
    }

    @DisplayName("4자리 입력 - 에러")
    @Test
    public void lessPwd() {
        // given
        String input1 = "1~e4";
        String input2 = "1~e4";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("15자리 입력 - 에러")
    @Test
    public void morePwd() {
        // given
        String input1 = "1234dkjjkfjk23!##";
        String input2 = "1234dkjjkfjk23!##";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("5자리 입력 - 통과")
    @Test
    public void fivePwd() {
        // given
        String input1 = "123A@";
        String input2 = "123A@";

        // when, then
        Assertions.assertDoesNotThrow(() -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("서로 다른 비밀번호 2개 입력 - 에러")
    @Test
    public void compareTwoPwds() {
        // given
        String input1 = "123A@";
        String input2 = "1k3A@";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("특수문자, 숫자, 영문(대문자만) 포함 입력 - 통과")
    @Test
    public void patternPwd1() {
        // given
        String input1 = "LL2$$U44";
        String input2 = "LL2$$U44";

        // when, then
        Assertions.assertDoesNotThrow(() -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("특수문자, 숫자, 영문(소문자만) 포함 입력 - 통과")
    @Test
    public void patternPwd2() {
        // given
        String input1 = "u2$$d44";
        String input2 = "u2$$d44";

        // when, then
        Assertions.assertDoesNotThrow(() -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("특수문자, 숫자, 영문(대문자&소문자) 포함 입력 - 통과")
    @Test
    public void patternPwd3() {
        // given
        String input1 = "u2$$HH44";
        String input2 = "u2$$HH44";

        // when, then
        Assertions.assertDoesNotThrow(() -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("특수문자 미포함 비밀번호 입력 - 에러")
    @Test
    public void patterPwd4() {
        // given
        String input1 = "123dkfk23";
        String input2 = "123dkfk23";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("숫자 미포함 비밀번호 입력 - 에러")
    @Test
    public void patterPwd5() {
        // given
        String input1 = "dk%jjkfjk";
        String input2 = "dk%jjkfjk";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("영문 미포함 비밀번호 입력 - 에러")
    @Test
    public void patterPwd6() {
        // given
        String input1 = "12^3423";
        String input2 = "12^3423";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("공백 포함 - 에러")
    @Test
    public void patterPwd7() {
        // given
        String input1 = "33A 3j$";
        String input2 = "33A 3j$";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("한글 포함(자음) - 에러")
    @Test
    public void patterPwd8() {
        // given
        String input1 = "33Aㅇ3j$";
        String input2 = "33Aㅇ3j$";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("한글 포함(모음) - 에러")
    @Test
    public void patterPwd9() {
        // given
        String input1 = "33ㅓA3j$";
        String input2 = "33ㅓA3j$";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

    @DisplayName("한글 포함(글자) - 에러")
    @Test
    public void patterPwd10() {
        // given
        String input1 = "33A3뒔j$";
        String input2 = "33A3뒔j$";

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkMemberPwd.checkPwd(input1, input2));
    }

}