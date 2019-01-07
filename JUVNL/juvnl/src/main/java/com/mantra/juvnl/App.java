package com.mantra.juvnl;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setTitle("Mantra Solves");
		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));
		 
		 Text name = new Text();
		 

		 Scene scene = new Scene(grid, 300, 275);
		 
		 primaryStage.setScene(scene);
		 primaryStage.show();
		
	}
}
