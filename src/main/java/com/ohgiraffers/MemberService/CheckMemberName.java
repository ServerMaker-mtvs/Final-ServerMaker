package com.ohgiraffers.MemberService;

public class CheckMemberName {//정재민
    public void checkBlankName(String id){
        String patternBlank1= "/\\W|\\s/";
        /*
          \W 알파벳이나 숫자를 제외한 문자
          | or
          \s 공백문자(띄어쓰기)
          를 포함하는 문자패턴을 검색
         */
        if(id==null){
            throw new IllegalArgumentException("이름을 입력해 주세요.");
        }else if(!id.matches(patternBlank1)){
            throw new IllegalArgumentException("이름은 공백,특수문자,숫자를 포함할 수 없습니다.");
        }
    }

    public void checkPatternName(String id){ //ID 패턴 탐지
        String pattern1 = "/^[가-힣]{2,30}$/";
        /*
            /^[가-힣] 가~ 힣 까지 모든 조합된 한글 (ㄱ,ㄴ,ㄷ,ㅏ,ㅑ등 불가능)
            {2,30}$ 2자~30자 내의
            문자패턴 검색
         */
        if(!id.matches(pattern1)){
            /*
                입력받은 이름이, 패턴과 일치하지 않을경우
                IllegalArgumentException 발생
             */
            throw new IllegalArgumentException("형식에 맞지않는 이름 입니다.");
        }
    }

}
