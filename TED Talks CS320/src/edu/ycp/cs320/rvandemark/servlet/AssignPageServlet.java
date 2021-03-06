package edu.ycp.cs320.rvandemark.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.rvandemark.controller.AssignmentController;
import edu.ycp.cs320.rvandemark.model.Assignment;

public class AssignPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/assignPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String assign = req.getParameter("assign");
		String date = req.getParameter("date");

		Assignment model = new Assignment();

		AssignmentController controller = new AssignmentController();
		model.setAssign(assign);
		model.setDate(date);
		controller.setModel(model);

		req.setAttribute("model", model);
		req.getRequestDispatcher("/_view/assignPage.jsp").forward(req, resp);
	}
}