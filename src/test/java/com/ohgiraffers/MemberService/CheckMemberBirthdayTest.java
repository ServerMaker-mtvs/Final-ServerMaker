package com.ohgiraffers.MemberService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class CheckMemberBirthdayTest {
    CheckMemberBirthday cmb;
    @BeforeEach
    public void setUp(){
        this.cmb=new CheckMemberBirthday();
    }
    @DisplayName("04년6월20일생 확인 - 미성년이기 때문에 오류 발생 확인")
    @Test
    public void checkLowBirth() throws ParseException {
        //given
            String lowDate="2004-06-20";
        //when&then
        Assertions.assertThrows(IllegalArgumentException.class,()->cmb.checkBirth(lowDate));
    }
    @DisplayName("04년6월10월생 확인 - 생일이 안지났기때문에 오류발생 확인")
    @Test
    public void checkEqualsBirth() throws ParseException {
        //given
        String equalsDate="2004-06-10";
        //when&then
        Assertions.assertThrows(IllegalArgumentException.class,()->cmb.checkBirth(equalsDate));
    }
    @DisplayName("04년6월9월생 확인 - 생일이 지났기 때문에 오류 발생 안되는지 확인")
    @Test
    public void checkHighBirth() {
        //given
        String highDate="2004-06-09";
        //when&then
        Assertions.assertDoesNotThrow(()->cmb.checkBirth(highDate));
    }
}
