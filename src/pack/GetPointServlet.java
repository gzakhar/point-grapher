package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetPointServlet extends HttpServlet {

	Statement stmt;

	private static final String selectById = "SELECT id, x, y\n" + "FROM points\n"
			+ "WHERE id = ?;";

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/searchPointForm.jsp").forward(req, resp);
	}
	
	
	
	
	
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		DbManager db = new DbManager();
//
//		PrintWriter pw = resp.getWriter();
//		resp.setContentType("text/html");
//
//		try {
//
//			Connection conn = db.getConnection();
//			stmt = conn.createStatement();
//
//			PreparedStatement preparedStatement = conn.prepareStatement(selectById);
//			preparedStatement.setInt(1, Integer.parseInt(req.getParameter("id")));
//			ResultSet result = preparedStatement.executeQuery();
//
//			while (result.next()) {
//				pw.println(result.getInt(1) + " " + result.getNString(2) + " " + result.getInt(3) + " "
//						+ result.getBoolean(4));
//			}
//
//		} catch (SQLException | ClassNotFoundException e) {
//			System.err.println(e.getMessage());
//		}
//
//		pw.close();
//	}

}
