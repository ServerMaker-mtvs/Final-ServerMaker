package com.ohgiraffers.MemberService;

import java.util.List;

public class CheckMemberId {// 정재민

    public void checkBlankId(String id){
        //Null값 처리
        if(id==null){
            throw new IllegalArgumentException("ID를 입력해 주세요.");
        }
    }

    public void checkPatternId(String id){ //ID 패턴 탐지
        String pattern1 = "^[a-zA-Z]{1}[a-zA-Z0-9]{4,11}$";
        /*
            / ^[A-Za-z]{1} 첫글자가 A~Z, a~z 로 시작되고
            [A-Za-z0-9] 영어 대문자,소문자,숫자를 포함하는
            {4,11}/ 첫글자를 제외하고 4~11자 (총 5~12자)
            특수문자, 공백문자 제외
         */
        if(!id.matches(pattern1)){
            /*
                입력받은 id가, 패턴과 일치하지 않을경우
                IllegalArgumentException 발생
             */
            throw new IllegalArgumentException("형식에 맞지않는 ID 입니다.");
        }
    }

    public void checkEqualId(String id1, List<String> dataId){ //중복 ID 검사
        /*
            입력문자열 String id1
            가입된 아이디 를 입력해 넣은 List<String> dateId를 입력받아
            문자열 2개를 입력받아
            equals 연산으로 비교하여, 동일 값을 가질경우
            IllegalArgumentException 발생
         */
        //LIST 사용시 향상된 for문 이용 비교
        //조회이기 때문에 요소를 수정할 필요는 없음.
        for(String equalId : dataId){
            // for(자료형 변수명 : (리스트)배열명)
            if(id1.equals(equalId)){
                //id1 변수값과 dataId내의 equals 연산을 for문을 이용하여 끝까지 반복
                //equals 연산이 성립할경우 에러발생
                throw new IllegalArgumentException("중복된 아이디 입니다.");
            }
        }
    }
}
//https://regex101.com/
//정규식 검증