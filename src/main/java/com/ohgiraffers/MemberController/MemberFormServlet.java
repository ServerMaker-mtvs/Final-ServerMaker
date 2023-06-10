package com.ohgiraffers.MemberController;

import com.ohgiraffers.MemberService.CheckMemberBirthday;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/regist")
public class MemberFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            CheckMemberBirthday check=new CheckMemberBirthday();
            check.checkBirth(req.getParameter("memberBirth"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
    //유열님
}
