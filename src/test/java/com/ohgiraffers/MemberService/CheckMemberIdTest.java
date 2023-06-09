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
    //4. 입력받은 2개의 String 값 비교 메소드
    @DisplayName("입력받은 ID의 값이 NULL일때 IllegalArgumentException 발생")
    @Test
    public void inputNullArgument(){ //null이 입력되었을때.

        //given
        String id1=null; //입력값이 null일때

        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkmemberid.CheckBlankId(id1)
        );
        System.out.println(e);

        //then
    }
    @DisplayName("입력받은 ID의 값이 공백, 특수문자일때 IllegalArgumentException 발생")
    @Test
    public void inputBalnkArgument(){ //null이 입력되었을때.

        //given
        String id1=" ";
        String id2="!!!!!";
        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkmemberid.CheckBlankId(id1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkmemberid.CheckBlankId(id2)
        );
        System.out.println(e);

        //then
    }

    @DisplayName("ID의 첫글자는 알파벳으로 시작하고 대문자,소문자,숫자를 포함")
    @Test
    public void inputPatternArgument(){ //패턴검증
        //given
        String id1="1server"; //첫글자가 숫자
        String id2="server1!"; //특수문자포함
        String id3="sever 1"; //띄어쓰기 포함
        String id4="serv"; //5글자
        String id5="asdfasdfasdfa"; //13글자
        //when
        e= Assertions.assertThrows( //id1
                IllegalArgumentException.class,
                () -> checkmemberid.CheckPatternId(id1)
        );
        System.out.println(e);

        e= Assertions.assertThrows( //id2
                IllegalArgumentException.class,
                () -> checkmemberid.CheckPatternId(id2)
        );
        System.out.println(e);

        e= Assertions.assertThrows( //id3
                IllegalArgumentException.class,
                () -> checkmemberid.CheckPatternId(id3)
        );
        System.out.println(e);

        e= Assertions.assertThrows( //id4
                IllegalArgumentException.class,
                () -> checkmemberid.CheckPatternId(id4)
        );
        System.out.println(e);

        e= Assertions.assertThrows( //id5
                IllegalArgumentException.class,
                () -> checkmemberid.CheckPatternId(id5)
                );
        System.out.println(e);
        //then
    }

    @DisplayName("입력받은 2개의 String 값 비교 후 동일값 일 떄 IllegalArgumentException 발생 ")
    @Test
    public void inputEqualsTwoArgument(){ //동등비교

        //given
        String id1="server1";
        String id2="server1";
        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkmemberid.CheckEqualId(id1, id2)
        );
        System.out.println(e);

        //then
    }
}
