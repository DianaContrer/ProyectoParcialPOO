package application;

import java.util.ArrayList;

public class pruebaTextos{
	public static void main(String [] args) {
		int tamano, tamano2, i, j;
		String clean;
		
		ArrayList<String> tweets = new ArrayList<String>();
		ArrayList<String> palabras = new ArrayList<String>();
		int [] contador = new int[1000];
		
		Estadistica obj1 = new Estadistica();
		
		tweets = obj1.nombre("C:\\Users\\diana\\OneDrive\\Escritorio\\twitter_sentiment_data.csv");		
		palabras = obj1.listaPalabras("C:\\Users\\diana\\OneDrive\\Escritorio\\palabras.txt");
		
		String[] tempArray = tweets.toArray(new String[0]);
		String[] tempArray2 = palabras.toArray(new String[0]);
		
		tamano = tweets.size();
		tamano2 = palabras.size();
		
		int [] coincidencias = new int[tamano2];
		
		for(i=0; i<tamano; i++) {
			clean = obj1.limpiaTexto(tempArray[i]);
			for(j=0; j<tamano2; j++){
					coincidencias[j] = obj1.contarCoincidencias(clean, tempArray2[j]);
					contador[j] = contador[j] + coincidencias[j];
				}
			}
		
		for (j=0; j<tamano2; j++) {
			System.out.println(tempArray2[j] + " " + contador[j]);
			}
		
		}
	}
