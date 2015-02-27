package edu.uniandes.ecos.psp2;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * @category Print
 *
 * Attributes
 * PFunction
 * iterations
 * iterationsRange
 * listFx
 * 
 * Methods
 * doGet
 * showHome
 * printListSimpleDouble
 * printListSimpleInteger
 * printListSimpleInteger
 * printHeader
 * printFooter
 */

public class PrintWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Attributes
	 */
	public double PFunction=0;
	public LinkedList<Integer> iterations=new LinkedList<Integer>();
	public LinkedList<Double> iterationsRange=new LinkedList<Double>();
	public LinkedList<Double> listFx=new LinkedList<Double>();

	
	/**
	 * Methods
	 */
	

	/**
	 * doGet: Answer when called by get
	 * 
	 * @param req
	 * @param resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		showHome(req,resp);
	}

	
	/**
	 * showHome: Answer with a simple html table
	 * 
	 * @param req
	 * @param resp
	 */
  	private void showHome(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	    resp.setContentType("text/html");
	    resp.getWriter().print(printHeader());
	    resp.getWriter().print("<table style='table, th, td{ border: 1px solid black; }'><tr><th>Resultado</th><th>Iteraciones</th><th>Rango Iteración</th><th>Resultados F(x)</th></tr>");
	    resp.getWriter().print("<tr><td>");
	    resp.getWriter().print(PFunction);
	    resp.getWriter().print("<td>"+printListSimpleInteger(iterations)+"</td>");
	    resp.getWriter().print("<td>"+printListSimpleDouble(iterationsRange)+"</td>");
	    resp.getWriter().print("<td>"+printListSimpleDouble(listFx)+"</td>");
	    resp.getWriter().print("</tr></table>");
	    resp.getWriter().print(printFooter());
  }


	/**
	 * printListSimpleDouble: Answer with a simple html table of double values
	 * @param linkedList
	 * @return text
	 */
	public String printListSimpleDouble(LinkedList<Double> linkedList){
		String text="<table>";
		for(double value: linkedList){
			text+="<tr>";
			text+="<td>"+value+"</td>";
			text+="</tr>";
		}
		text+="</table>";
		return text;
	}

	
	/**
	 * printListSimpleInteger: Answer with a simple html table of integer values
	 * @param linkedList
	 * @return text
	 */
	public String printListSimpleInteger(LinkedList<Integer> linkedList){
		String text="<table>";
		for(int value: linkedList){
			text+="<tr>";
			text+="<td>"+value+"</td>";
			text+="</tr>";
		}
		text+="</table>";
		return text;
	}
	


	/**
	 * printHeader: Answer with a simple header of an html doc
	 * @return text
	 */
	public String printHeader(){
		String text="<html><head><style>table, th, td {border: solid black 1px;}</style></head><body>";
		return text;
	}


	/**
	 * printFooter: Answer close the html doc
	 * @return text
	 */
	public String printFooter(){
		String texto="</body></html>";
		return texto;
	}
}


