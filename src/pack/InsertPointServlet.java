package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;

import pack.DbManager;
import pack.modal.Point;

public class InsertPointServlet extends HttpServlet {

	Statement stmt = null;

	private static final String inputQuery = "INSERT INTO items VALUES\n" + "\t(?, ?);";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Routes to JSP page with insert form
		req.getRequestDispatcher("/insertPointForm.jsp").forward(req, resp);
	}


	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		log("in post method");
		
//		Connection Class
//		DbManager db = new DbManager();
//
//		PrintWriter pw = resp.getWriter();
//		resp.setContentType("text/html");
//
//		int x = Integer.parseInt(req.getParameter("x"));
//		int y = Integer.parseInt(req.getParameter("y"));
//
//		try {
//			Connection conn = db.getConnection();
//			stmt = conn.createStatement();
//
//			PreparedStatement preparedStmt = conn.prepareStatement(inputQuery);
//			preparedStmt.setInt(1, x);
//			preparedStmt.setInt(2, y);
//			preparedStmt.execute();
//
//			conn.close();
//			System.out.println("from mysql");
//		} catch (SQLException | ClassNotFoundException e) {
//			System.out.println("error");
//			System.err.println(e.getMessage());
//		}
//
//		pw.close();
		
		
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hello");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(new Point(x, y));
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

		
		
	}

}
