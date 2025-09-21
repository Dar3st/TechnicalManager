package com.techmanager.controllers;

import com.techmanager.models.TechniqueList;
import com.techmanager.utils.AppStateManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewTechniqueController {
    private Stage primaryStage;

    @FXML
    private TextArea listArea;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void updateTechniqueListDisplay() {
        TechniqueList techniqueList = AppStateManager.getInstance().getTechniqueList();

        if (techniqueList.isEmpty()) {
            listArea.setText("Список техники пуст.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Всего техники: ").append(techniqueList.size()).append("\n\n");

        for (com.techmanager.models.Technique t : techniqueList.getAll()) {
            sb.append(t.toString()).append("\n\n");
        }

        listArea.setText(sb.toString());
    }

    @FXML
    private void handleRefresh() {
        updateTechniqueListDisplay();
    }

    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main-view.fxml"));
            Parent root = loader.load();

            MainController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root, 400, 300);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}