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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/members")
public class MemberListServlet extends HttpServlet {
    //태현님

    private MemberRepository memberRepository = MemberRepository.getInstance();

    public MemberListServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MemberDTO> members = memberRepository.findAll();

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<a href=\"/index.jsp\">메인</a>")
                .append("<h3>\n")
                .append("회원 리스트")
                .append("</h3>\n")
                .append("<table>\n")
                .append("<thead>\n")
                .append("<th>\n")
                .append("이름\n")
                .append("</th>\n")
                .append("<th>\n")
                .append("id\n")
                .append("</th>\n")
                .append("<th>\n")
                .append("생년월일\n")
                .append("</th>\n")
                .append("<tbody>\n");

                for (MemberDTO member : members) {
                    responseText.append("<tr>")
                            .append("<td>\n")
                            .append(member.getName() + "\n")
                            .append("</td>\n")
                            .append("<td>\n")
                            .append(member.getId() + "\n")
                            .append("</td>\n")
                            .append("<td>\n");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = formatter.format(member.getBirth());
                    responseText.append(strDate + "\n")
                            .append("</td>\n")
                            .append("</tr>\n");
                }
                responseText.append("</tbody>\n")
                        .append("</tbody>\n")
                        .append("</table>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText.toString());

        out.flush();
        out.close();

    }
}
