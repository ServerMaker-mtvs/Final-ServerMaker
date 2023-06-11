package com.ohgiraffers.MemberView;

import com.ohgiraffers.Member.MemberDTO;
import com.ohgiraffers.Member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/himember")
public class MemberSaveServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public MemberSaveServlet() {}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<MemberDTO> members = memberRepository.findAll();

        String memberName = req.getParameter("memberName");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<a href=\"/index.jsp\">메인</a>")
                .append("<h3 align=\"center\">")
                .append(memberName)
                .append("님 환영합니다!!</h3>")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(responseText.toString());

        out.flush();
        out.close();
    }
}