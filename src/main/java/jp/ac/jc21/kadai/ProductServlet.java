package jp.ac.jc21.kadai;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = { "/item" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final String dbServer = "192.168.54.231";
	final String dbPort = "3306";
	final String dbName = "test2023";
	final String user = "test2023";
	final String pass = "test2023";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "jdbc:mysql://"+dbServer+"/"+dbName;
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<h2>Connect to : ").append(url).append("</h2>");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection  conn = DriverManager.getConnection(url, user, pass);
			
			String sql1 ="SELECT MAKER_CODE,MAKER_NAME FROM MAKER";
			String sql2 ="SELECT PRODUCT.PRODUCT_CODE,PRODUCT.PRODUCT_NAME,PRODUCT.MAKER_CODE,MAKER.MAKER_NAME FROM PRODUCT "
					+ "INNER JOIN MAKER ON PRODUCT.MAKER_CODE = MAKER.MAKER_CODE";
			
			
			PreparedStatement statement = conn.prepareStatement(sql1);
			PreparedStatement statement2 = conn.prepareStatement(sql2);
			
			ResultSet rs = statement.executeQuery();
			
			ArrayList<String[]> result = new ArrayList<>();
			
			String id = request.getParameter("ID");

			while(rs.next()==true) {
				String[] s = new String[2];
				s[0] = rs.getString("MAKER_CODE");
				s[1] = rs.getString("MAKER_NAME");
				
				result.add(s);
			}
			


			if(id != null) {
				sql2 = sql2 +  " Where PRODUCT.MAKER_CODE = ? ";
				statement2 = conn.prepareStatement(sql2);
				id = request.getParameter("ID");
				statement2.setString(1, id);
			}
			

			ResultSet rs2 = statement2.executeQuery();
			
			
			ArrayList<String[]> result2 = new ArrayList<>();
			
			while(rs2.next()==true) {
				String[] s2 = new String[3];
				s2[0] = rs2.getString("PRODUCT_CODE");
				s2[1] = rs2.getString("PRODUCT_NAME");
				s2[2] = rs2.getString("MAKER_NAME");
				result2.add(s2);
			}
			
			request.setAttribute("product", result);
			request.setAttribute("product2", result2);
			
			
			RequestDispatcher rd1 =
					request.getRequestDispatcher("/WEB-INF/jsp/product.jsp");
			rd1.forward(request, response);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}

}
