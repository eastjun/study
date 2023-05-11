package min.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import min.servlet.dto.MemberDTO;

@WebServlet("/Member")
public class Member extends HttpServlet{
	
	private static Log log = LogFactory.getLog(Member.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String[] hobbyArray = req.getParameterValues("hobby");
		String hobby ="";
		for (int i = 0; i < hobbyArray.length; i++) {
			
			hobby += hobbyArray[i] +"  ";
		}
	
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPassword(password);
		memberDTO.setGender(gender);
		memberDTO.setHobby(hobby);
		log.info(memberDTO);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("이름 : " + memberDTO.getName() + "<br>");
		out.println("아이디 : " + memberDTO.getId() + "<br>");
		out.println("패스워드 : " + memberDTO.getPassword() + "<br>");
		
		if (memberDTO.getGender().equals("m")) {
			out.println("성별 : 남자 <br>");
		}
		else {
			out.println("성별 : 여자 <br>");
		}
		
		out.println("취미 :"+ memberDTO.getHobby());
		
	}
}
