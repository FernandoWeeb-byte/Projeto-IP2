package negocio;

import negocio.beans.*;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Principal extends Application{
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Mighty Blade");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.sizeToScene();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
