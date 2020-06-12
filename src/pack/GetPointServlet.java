package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.modal.Point;

public class GetPointServlet extends HttpServlet {

	Statement stmt;

	private static final String selectById = "SELECT id, x, y\n" + "FROM points\n" + "WHERE id = ?;";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/searchPointForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		log("id : " + id);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hello");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Point point = entityManager.find(Point.class, id);
		
		log("/displayPoint.jsp?" + 
				"id=" + point.getId() + 
				"&x=" + point.getX() + 
				"&y=" + point.getY());

		
		req.getRequestDispatcher(
				"/displayPoint.jsp?" + 
				"id=" + point.getId() + 
				"&x=" + point.getX() + 
				"&y=" + point.getY()).forward(req, resp);
	}
}
