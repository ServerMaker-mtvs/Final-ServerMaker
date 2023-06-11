package com.ohgiraffers.MemberController;

import com.ohgiraffers.MemberService.CheckMemberBirthday;
import com.ohgiraffers.MemberService.SaveMemberInformation;
import jakarta.servlet.RequestDispatcher;
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
import java.util.Enumeration;

@WebServlet("/regist")
public class MemberFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration params=req.getParameterNames();  //아마도 null값으로 넣을경우 error페이지 이동
        while (params.hasMoreElements()){
            String name=(String)params.nextElement();
            if(req.getParameter(name).equals("")||req.getParameter(name).equals(null)){
                resp.sendError(500,"입력되지않은 정보가 있습니다.");
                break;
            }
        }


        try { //검증 서비스 호출 및 저장
            SaveMemberInformation smi=new SaveMemberInformation();
            smi.saveInformation(req);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher=req.getRequestDispatcher("/himember"); //저장이 된 후 페이지 이동
        dispatcher.forward(req,resp);
    }
    //유열님
}
