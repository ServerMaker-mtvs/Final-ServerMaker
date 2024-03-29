package com.ohgiraffers.MemberService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckMemberNameTest { //정재민

    private CheckMemberName checkMemberName;
    private Exception e;

    @BeforeEach
    public void setUp(){
        this.checkMemberName=new CheckMemberName();
        this.e=new Exception();
    }

    //검증내용
    //1. 이름이 널값이거나, 공백, 특수문자를 포함한 입력시 오류를 발생시킨다
    //2. 이름은 영어나, 숫자, ㄱㄴㅇ, ㅏㅑㅐ 등의 자모음 단독 글자를 차단한다
    //3. 이름은 2~30자를 만족한다.

    @DisplayName("입력받은 name의 값이 NULL일때 IllegalArgumentException 발생")
    @Test
    public void inputNullArgument(){ //null이 입력되었을때.

        //given
        String name1=null; //입력값이 null일때

        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkBlankName(name1)
        );
        System.out.println(e);

        //then
    }
    @DisplayName("입력받은 name의 값이 공백,특수문자,숫자일때 IllegalArgumentException 발생")
    @Test
    public void inputBalnkArgument(){ //null이 입력되었을때.

        //given
        String name1=" ";
        String name2="홍길동!";
        String name3="홍길동1";
        String name4="홍길동"; //에러검증을 위한 정상동작 요구값
        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name2)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name3)
        );
        System.out.println(e);

        //then
        //Test실패 (정상동작)
//        e= Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> checkMemberName.checkPatternName(name4)
//        );
//        System.out.println(e);
    }
    @DisplayName("이름에 영어,숫자,단독 자,모음은 차단한다")
    @Test
    public void inputPatternArgument(){ //패턴검증
        //given
        String name1="홍길동s"; //영어포함
        String name2="홍길동1"; //숫자포함
        String name3="홍길동ㅎ"; //자음 포함
        String name4="홍";//1글자
        String name5="홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍길동홍";//31자
        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name2)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name3)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name4)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberName.checkPatternName(name5)
        );
        System.out.println(e);
        //then
    }


}
