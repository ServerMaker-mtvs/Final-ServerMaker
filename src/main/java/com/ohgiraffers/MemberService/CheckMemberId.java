package com.ohgiraffers.MemberService;

public class CheckMemberId {// 재민님

    public void CheckBlankId(String id){ //Null값이거나 공백,특수 문자를 포함한경우 오류처리
        String patternBlank1= "/\\W|\\s/"; //
        /*
          \W 알파벳이나 숫자를 제외한 문자
          | or
          \s/ 공백문자

         */
        if(id==null){
            throw new IllegalArgumentException("ID를 입력해 주세요.");
        }else if(!id.matches(patternBlank1)){
            throw new IllegalArgumentException("ID는 공백문자 또는 특수문자를 포함할 수 없습니다.");
        }

    }

    public void CheckPatternId(String id){ //ID 패턴 탐지
        String pattern1 = " /^[A-Za-z][A-Za-z0-9]{5,12}$/ ";
        /*
            / ^[A-Za-z]+ A~Z, a~z 로 시작되고
            [A-Za-z0-9] 영어 대문자,소문자,숫자를 포함하는
            {5,12}/ 5~12자
         */
        if(!id.matches(pattern1)){
            /*
                입력받은 id가, 패턴과 일치하지 않을경우
                IllegalArgumentException 발생
             */
            throw new IllegalArgumentException("형식에 맞지않는 ID 입니다.");
        }
    }

    public void CheckEqualId(String id1, String id2){ //중복 ID 검사
        /*
            문자열 2개를 입력받아
            equals 연산으로 비교하여, 동일 값을 가질경우
            IllegalArgumentException 발생
         */
        if(id1.equals(id2)){
            throw new IllegalArgumentException("중복된 아이디 입니다.");
        }
    }
}
//https://regex101.com/