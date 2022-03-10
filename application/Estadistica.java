package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Estadistica {
	
	/** Guarda 1000 tweets del csv en un ArrayList y lo devuelve
	 * @param rutaArchivo
	 * @return ArrayList<String>
	 */
	public ArrayList<String> nombre(String rutaArchivo){
		
		ArrayList<String> list = new ArrayList<>();
		int count = 0;
		
		try {
			BufferedReader br = new BufferedReader ( new FileReader(rutaArchivo));
			while(count < 1000) {
				list.add(br.readLine());
				count++;
				}
			} catch (FileNotFoundException ex) {
				System.err.println(ex.getMessage());
				} catch (java.io.IOException ex) {
					System.err.println(ex.getMessage());
					}
		return list;
		}
	
	
	/** Guarda palabras de un archivo de texto en un ArrayList y lo devuelve
	 * @param rutaArchivo
	 * @return ArrayList<String>
	 */
	public ArrayList<String> listaPalabras(String rutaArchivo){
		ArrayList<String> listaPalabras = new ArrayList<>();
		try {
			Scanner csvData = new Scanner(new File(rutaArchivo));
			while (csvData.hasNext()) {
				listaPalabras.add(csvData.nextLine());
				}
			}catch(FileNotFoundException ex) {
				System.out.println(ex.toString());
				}
		return listaPalabras;
		}
	
	
	/** Limpia un string de texto (numeros y caracteres especiales)
	 * @param entrada
	 * @return String
	 */
	public String limpiaTexto (String entrada) {
		String temp = entrada.replaceAll("\\W", " ");
		String salida = temp.replaceAll("\\d", " ");
		return salida;
		}
	
	
	/** Cuenta la frecuencia de aparicion de una lista de palabras en un string
	 * @param oracion
	 * @param palabra
	 * @return int
	 */
	public int contarCoincidencias(String oracion, String palabra) {
		int coincidencia = 0;
		oracion = oracion.toLowerCase();
		String [] divide = oracion.split(" ");
		int tamano = divide.length;
		for(int i=0; i<tamano;i++) {
			if(divide[i].contains(palabra)){
				coincidencia++;
				}
			}
		return coincidencia;
		}
	}