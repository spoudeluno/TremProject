

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.LangtangTrekking;
import util.UtilCalculatePrice;
import util.UtilDB;

/**
 * Servlet implementation class LangtangTrekking
 */
@WebServlet("/LangtangTrekkingHB")
public class LangtangTrekkingHB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LangtangTrekkingHB() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<LangtangTrekking> listLangtang = UtilDB.listLangtangTrekking();
		 if (listLangtang.size() == 0)
		 {
			 UtilDB.populateTable();
		 }
		 listLangtang = UtilDB.listLangtangTrekking();
		 UtilCalculatePrice price = new UtilCalculatePrice();
		 price.CalculatePrice(listLangtang.size());
		 retrieveDisplayData(listLangtang, response.getWriter(),price.getFiveStarHotel(),price.getFourStarHotel(), price.getThreeStarHotel());
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	void retrieveDisplayData( List<LangtangTrekking> langtang, PrintWriter out,Integer five, Integer four, Integer three) {
	      String title = "Langtang Trekking";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
		            "<html>\n" + //
		            "<head><title>" + title + "</title> <style>\r\n" + 
		            		"header {\r\n" + 
		            		"    background-color:black;\r\n" + 
		            		"    color:white;\r\n" + 
		            		"    text-align:center;\r\n" + 
		            		"    padding:5px;	 \r\n" + 
		            		"}\r\n" + 
		            		".flex-container {\r\n" + 
		            		"    display: flex;\r\n" + 
		            		"    align: Center;\r\n" + 
		            		"    padding:5px;\r\n" + 
		            		"}\r\n" + 
		            		"\r\n" + 
		            		".flex-child {\r\n" + 
		            		"    flex: 1;\r\n" + 
		            		"    align: center;\r\n" + 
		            		"}  \r\n" + 
		            		"\r\n" + 
		            		".flex-child:first-child {\r\n" + 
		            		"    margin-right: 20px;\r\n" + 
		            		"}  \r\n" + 
		            		"</style></head>\n" + //
		            "<body bgcolor=\"#f0f0f0\">\n" + //
		            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<ul>");
	      for (LangtangTrekking langtangItinary : langtang) {
	    	  out.println("<p> Day:" + langtangItinary.getDay() + "&emsp;" 
		               + langtangItinary.getDesc() + "</p>");
	      }
	      out.println("</ul>");
	      out.println("<br> Total Price Calculated Based on Hotel Ratings:"
		      		+ "<p>Five Star Hotel: $" + five +"</p>"
		      		+ "<p>Four Star Hotel: $" + four +"</p>"
		      		+ "<p>Three Star Hotel:$ " + three +"</p>"
		      		+ ""
		      		+ "<div class=\"flex-container\">\r\n" + 
		      		"		<div class=\"flex-child\">\r\n" + 
		      		"			<a href=\"index.html\" >	\r\n" + 
		      		"			  <input type=\"submit\" value=\"Home\">\r\n" + 
		      		"			</a>\r\n" + 
		      		"		</div>\r\n" + 
		      		"		\r\n" + 
		      		"		<div class=\"flex-child\">\r\n" + 
		      		"			<form action=\"EverestTrekkingHB\" >		\r\n" + 
		      		"			<input type=\"submit\" value=\"Everest Trekking\">\r\n" + 
		      		"			</form>\r\n" + 
		      		"		</div>\r\n" + 
		      		"	</div></body></html>");
	   }
	
	

}
