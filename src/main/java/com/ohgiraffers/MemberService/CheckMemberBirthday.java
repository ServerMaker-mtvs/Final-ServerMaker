package com.ohgiraffers.MemberService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class CheckMemberBirthday {
    public void checkBirth(String date) throws ParseException {

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date parsingDate=sdf.parse(date);

        Calendar cal=Calendar.getInstance();
        cal.setTime(parsingDate); //Date 타입 시간을 Calendar 시간으로 변경 Date 타입의 내장함수들이 deprecated 상태로 된게 많아서 사용
        LocalDate now=LocalDate.now();
        LocalDate paramDate20=LocalDate.of(cal.get(Calendar.YEAR)+19,cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE));


        if(1!=now.compareTo(paramDate20)){
            throw new IllegalArgumentException("미성년입니다.");
        }
        //LocalDate compareTo()
        //파라미터로 전달받은 날짜와 같을 경우 0
        //파라미터로 전달받은 날짜보다 클 경우 양수
        //파라미터로 전달받은 날짜보다 작을 경우 음수
    }
    // 유열님
}

