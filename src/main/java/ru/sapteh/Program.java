package ru.sapteh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;


public class Program extends Application {
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("C:/Users/student/Desktop/work16.02/src/main/java/ru/sapteh/View/WindowView.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Window");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
