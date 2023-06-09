package com.ohgiraffers.MemberService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckMemberIdTest {
    private CheckMemberId checkmemberid;
    private Exception e;

    @BeforeEach
    public void setUp(){
        this.checkmemberid =new CheckMemberId();
        this.e=new Exception();
    }

    //검증내용
    //1. 입력받은 ID의 값이 null 일때 IllegalArgumentException 발생
    //2. 입력받은 ID의 값에 특수문자, 공백문자가 포함되어 있을때 IllegalArgumentException 발생
    //3. ID의 첫글자는 알파벳으로 시작하고 대문자,소문자,숫자를 포함하는 5~12자의 모음

    @DisplayName("입력받은 ID의 값이 NULL일때 IllegalArgumentException 발생")
    @Test
    public void inputNullArgument(){ //null이 입력되었을때.

        //given
        String id=null; //입력값이 null일때

        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkmemberid.CheckBlankId(id)
        );
        System.out.println(e);

        //then
    }
    }
