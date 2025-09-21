package com.techmanager.controllers;

import com.techmanager.utils.AppStateManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleAddTechnique() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/add-technique-view.fxml"));
            Parent root = loader.load();

            AddTechniqueController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setScene(scene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleViewTechnique() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/view-technique-view.fxml"));
            Parent root = loader.load();

            ViewTechniqueController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
            controller.updateTechniqueListDisplay();

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleExit() {
        primaryStage.close();
    }
}