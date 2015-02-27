package edu.uniandes.ecos.psp2;

import java.io.IOException;
import java.util.LinkedList;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * @category Control
 *
 */
public class App 
{
	/**
	 * 
	 * @param args
	 * 
	 */
    public static void main( String[] args )
    {
    	FileToList archivoLectura=new FileToList();
    	LinkedList<Double> listaNumeros=new LinkedList<Double>();
    	PrintConsole impresoraConsola=new PrintConsole();
    	PrintWeb impresoraWeb=new PrintWeb();
    	double resultado=0;
		try {
			listaNumeros = archivoLectura.fileToSingleList("arreglo.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
    	MathOperations calculos=new MathOperations();
    	calculos.setValues(listaNumeros.get(0), listaNumeros.get(1).intValue(), listaNumeros.get(2).intValue());
    	resultado=calculos.PFunction();
    	System.out.print("Resultado: ");
    	System.out.println(resultado);
    	impresoraConsola.printListInteger(calculos.iterations);
    	impresoraConsola.printListDouble(calculos.iterationsRange);
    	impresoraConsola.printListDouble(calculos.listFx);
    	
    	

	    impresoraWeb.PFunction=resultado;
	    impresoraWeb.iterations=calculos.iterations;
	    impresoraWeb.iterationsRange=calculos.iterationsRange;
	    impresoraWeb.listFx=calculos.listFx;
	    Server server = new Server(5000);
	    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	    context.setContextPath("/");
	    server.setHandler(context);
	    context.addServlet(new ServletHolder(impresoraWeb), "/*");
		try {
			server.start();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	    try {
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
