package com.ohgiraffers.MemberService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class CheckMemberBirthday {
    public void checkBirth(String date) throws ParseException {

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();// Calendar 객체 생성
        cal.setTime(sdf.parse(date)); //String 타입을 Calendar타입으로 convert 하기 위함


        LocalDate now=LocalDate.now(); //날짜 까지만 비교하기 떄문에 LocalDate 객체를 사용
        LocalDate paramDate20=LocalDate.of(cal.get(Calendar.YEAR)+19,cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE));


        if(0>=now.compareTo(paramDate20)){
            throw new IllegalArgumentException("미성년입니다.");
        }
        //LocalDate compareTo()
        //파라미터로 전달받은 날짜와 같을 경우 0
        //파라미터로 전달받은 날짜보다 클 경우 양수
        //파라미터로 전달받은 날짜보다 작을 경우 음수
    }
    // 유열님
}

