package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
		
	public void start(Stage primaryStage) {
		
		CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Palabras");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Frecuencia");

       
		BarChart<Number, String> chart = new BarChart<Number, String>(xAxis, yAxis);
        chart.setTitle("Prueba Ventana MFG");
        // agregamos datos 
        chart.setData(obtenerDatos());
        
        // Paneles
        StackPane root = new StackPane();
        root.getChildren().add(chart);
        
        // Tama o del Frame
        Scene scene = new Scene(root, 640, 427);

        primaryStage.setTitle("Cambio Climático");
        primaryStage.setScene(scene);
        primaryStage.show();
        
	}
	@SuppressWarnings("unchecked")
	public static ObservableList<XYChart.Series<Number, String>> obtenerDatos() {
		
	
        XYChart.Series<Number, String> frecuenciasPalabras = new XYChart.Series<>();
        frecuenciasPalabras.setName("Cantidad Palabras");
        
        int tamanoTweets, tamanoPalabras, i, j;
		String clean;
		
		ArrayList<String> tweets = new ArrayList<String>();
		ArrayList<String> palabras = new ArrayList<String>();
		int [] contador = new int[1000];
		
		Estadistica obj1 = new Estadistica();
		
		tweets = obj1.nombre("C:\\Users\\diana\\OneDrive\\Escritorio\\twitter_sentiment_data.csv");		
		palabras = obj1.listaPalabras("C:\\Users\\diana\\OneDrive\\Escritorio\\palabras.txt");
		
		String[] tempArray = tweets.toArray(new String[0]);
		String[] tempArray2 = palabras.toArray(new String[0]);
		
		tamanoTweets = tweets.size();
		tamanoPalabras = palabras.size();
		
		int [] coincidencias = new int[tamanoPalabras];
		
		for(i=0; i<tamanoTweets; i++) {
			clean = obj1.limpiaTexto(tempArray[i]);
			for(j=0; j<tamanoPalabras; j++){
					coincidencias[j] = obj1.contarCoincidencias(clean, tempArray2[j]);
					contador[j] = contador[j] + coincidencias[j];
			}
		}
		
		for(i = 0; i<tamanoPalabras; i++) {
			frecuenciasPalabras.getData().addAll(new XYChart.Data<>(contador[i], tempArray2[i]));
		}       

        ObservableList<XYChart.Series<Number, String>> data = FXCollections.observableArrayList();
        data.addAll(frecuenciasPalabras);

        return data;
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
