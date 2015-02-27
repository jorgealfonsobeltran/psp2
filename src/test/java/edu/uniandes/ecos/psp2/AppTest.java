package edu.uniandes.ecos.psp2;

import java.util.LinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test for the class MathOperations
     */
    public void testApp()
    {  	
    	MathOperations calculos=new MathOperations();
    	LinkedList<Double> listaNumeros=new LinkedList<Double>();
    	listaNumeros.add(10.3);
    	listaNumeros.add(20.3);
    	listaNumeros.add(30.4);
    
        assertEquals("Lista para prueba (10.3 , 20.3 , 30.4), el resultado para sumatoria deben ser 61 ",61.0,  calculos.Sum(listaNumeros)); // Test for Sum
        
        assertEquals("Resultados para factorial de 6, el resultado debe ser 720 ",720.0,  calculos.factorial(6)); // Test for Factorial
        
        assertEquals("Resultados para factorial de 3.5, el resultado debe ser 11.631728396567448",11.631728396567448,  calculos.factorialFraction(3.5)); // Test for Factorial of fraction
        
        assertEquals("Resultados para función gamma de 4.5, el resultado debe ser 11.631728396567448",11.631728396567448,  calculos.gammaFunction(4.5)); // Test for gamma function

        assertEquals("Resultados para función gamma de 6, el resultado debe ser 120",120.0,  calculos.gammaFunction(6)); // Test for gamma function

    	calculos.setValues(1.1, 9, 10);
        assertEquals("Resultados para función de Simpson cuando x=1.1, grados de libertad=9 e iteraciones=10 el resultado debe ser 0.3500589042865572",0.3500589042865572,  calculos.PFunction()); // Test for gamma function

        assertEquals("Resultados para función 1+(x^2/(grados de libertad)) si x=1.1, grados de libertad= 9 y el resultado de xi=0.88 debe ser 1.0860444444444444",1.0860444444444444,  calculos.TFunctionPartA(0.88)); // Test for 1+(x^2/(grados de libertad))

        assertEquals("Resultados para función 1+(x^2/(grados de libertad))^(-(grados de libertad+1)/2) si x=1.1, grados de libertad= 9 y el valor de xi=0.88, el resultado debe ser 0.6618537109614103",0.6618537109614103,  calculos.TFunctionPartB(0.88)); // Test for 1+(x^2/(grados de libertad))^(-(grados de libertad+1)/2)

        assertEquals("Resultados para función constante grados de libertad= 9, el resultado debe ser 0.3880349088716687",0.3880349088716687,  calculos.TFunctionPartConstant()); // Test for constantFunction

    	calculos.setValues(55, 9, 10);
        assertEquals("Resultados para el intervalo, si x=55 e iteraciones=10, resultado debe ser 5.5",5.5,  calculos.width()); // Test for width of the range
    }
}
