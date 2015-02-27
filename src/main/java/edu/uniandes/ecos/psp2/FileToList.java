package edu.uniandes.ecos.psp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * @category I/O
 *  
 * 
 * Methods
 * FileToSingleList
 * 
 */
public class FileToList {
	

	/**
	 * fileToSingleList: Reads the file send as string getting root as base path
	 * 
	 * @param fileName
	 * @return linkedList
	 */
	public LinkedList<Double> fileToSingleList(String fileName) throws IOException{
		LinkedList<Double> linkedList=new LinkedList<Double>();
		File archivo=new File(fileName);
		FileReader lectorArchivo=new FileReader(archivo);
		BufferedReader bufferLector=new BufferedReader(lectorArchivo);
		String linea;
		int numeroLinea=0;
		while((linea=bufferLector.readLine ()) != null){
			numeroLinea++;
			try{
				linkedList.add(Double.parseDouble(linea));
			}
			catch(Exception e){
				System.out.println("La linea "+numeroLinea);
			}
		}
		bufferLector.close();
		return linkedList;
	}
}
