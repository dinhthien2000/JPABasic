package stu.nvt.java.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import stu.nvt.java.dao.StudentDao;
import stu.nvt.java.entities.Student;

@WebServlet({ "/StudentServlet", "/StudentServlet/create", "/StudentServlet/update", "/StudentServlet/delete" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		StudentDao dao = new StudentDao();
		
		if(uri.contains("delete")) {
			String id = request.getParameter("id");
			boolean isRemove = dao.removeStudent(Integer.parseInt(id));
			
			request.setAttribute("isRemove", isRemove);
		}
		
		
		List<Student> list = dao.findAllStudent();

		request.setAttribute("list", list);

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = new Student();
		
		StudentDao dao = new StudentDao();

		String uri = request.getRequestURI();

		try {
			BeanUtils.populate(student, request.getParameterMap());
			Student responseStudent = null;
			
			if (uri.contains("create")) {

				responseStudent = dao.createStudent(student);

				request.setAttribute("student", responseStudent);

			} else {
				responseStudent = dao.updateStudent(student);

				request.setAttribute("student", responseStudent);
			}

			List<Student> list = dao.findAllStudent();
			request.setAttribute("list", list);

			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
