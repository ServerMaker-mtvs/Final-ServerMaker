package com.ohgiraffers.MemberService;

import com.ohgiraffers.Member.MemberDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckMemberIdTest { //정재민
    private CheckMemberId checkMemberId;
    private Exception e;
    private List<String> dataId;
    private List<String> dataId2;

    @BeforeEach
    public void setUp(){
        this.checkMemberId =new CheckMemberId();
        this.e=new Exception();
        this.dataId=new ArrayList<String>();
        this.dataId2=new ArrayList<String>();
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
                () -> checkMemberId.checkBlankId(id1)
        );
        System.out.println(e);

        //then
    }
    @DisplayName("입력받은 ID의 값이 공백, 특수문자일때 IllegalArgumentException 발생")
    @Test
    public void inputBalnkArgument(){ //null이 입력되었을때.

        //given
        String id1="ser ver";
        String id2="server!";
        String id3="server1"; //void 메소드 검증을 위해 정상값 입력  (Test는 실패유도)

        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberId.checkPatternId(id1)
        );
        System.out.println(e);

        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberId.checkPatternId(id2)
        );
        System.out.println(e);


        //then
        //Test 에러(정상작동)
//        e= Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> checkMemberId.checkPatternId(id3)
//        );
//        System.out.println(e);
    }
    @DisplayName("ID의 첫글자는 알파벳으로 시작하고 대문자,소문자,숫자를 포함")
    @Test
    public void inputPatternArgument(){ //패턴검증
        //given
        String id1="1server"; //첫글자가 숫자
        String id2="serv"; //5글자
        String id3="asdfasdfasdfa"; //13글자
        String id4="server1"; ////void 메소드 검증을 위해 정상값 입력 (Test는 실패유도)
        //when
        e= Assertions.assertThrows( //id1
                IllegalArgumentException.class,
                () -> checkMemberId.checkPatternId(id1)
        );
        System.out.println(e);

        e= Assertions.assertThrows( //id2
                IllegalArgumentException.class,
                () -> checkMemberId.checkPatternId(id2)
        );
        System.out.println(e);

        e= Assertions.assertThrows( //id3
                IllegalArgumentException.class,
                () -> checkMemberId.checkPatternId(id3)
        );
        System.out.println(e);
        //then
        //Test에러 (정상작동)
//        e= Assertions.assertThrows( //id4
//                IllegalArgumentException.class,
//                () -> checkMemberId.checkPatternId(id4)
//        );
//        System.out.println(e);
    }

    @DisplayName("입력받은 2개의 String 값 비교 후 동일값 일 떄 IllegalArgumentException 발생 ")
    @Test
    public void inputEqualsTwoArgument(){ //동등비교

        //given
        String id1="server1";
        dataId.add("server1"); //List 타입에 검증용 값 입력
        dataId2.add("server2"); //List 타입2에 검증용 정상 값 입력

        //when
        e= Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> checkMemberId.checkEqualId(id1, dataId)
        );
        System.out.println(e);

        //then
        //Test에러 (정상작동)
//        e= Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> checkMemberId.checkEqualId(id1, dataId2)
//        );
//        System.out.println(e);
    }
}
