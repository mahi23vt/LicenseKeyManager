package com.example.licensekey;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 800);
        stage.setTitle("License Manager");


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}