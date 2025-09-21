package com.techmanager.controllers;

import com.techmanager.models.Technique;
import com.techmanager.models.TechniqueList;
import com.techmanager.utils.AlertUtils;
import com.techmanager.utils.AppStateManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTechniqueController {
    private Stage primaryStage;

    @FXML
    private TextField idField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField hoursField;

    @FXML
    private TextArea areaInfo;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleAddConfirm() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String number = numberField.getText().trim();
            int hours = Integer.parseInt(hoursField.getText().trim());

            TechniqueList techniqueList = AppStateManager.getInstance().getTechniqueList();

            if (techniqueList.isIdExists(id)) {
                AlertUtils.showErrorAlert("Ошибка", "Техника с ID " + id + " уже существует");
                return;
            }

            if (id <= 0 || hours < 0) {
                AlertUtils.showErrorAlert("Ошибка", "ID должен быть положительным числом, а часы - больше 0");
                return;
            }

            Technique technique = new Technique(id, hours, number);
            techniqueList.addTechnique(technique);

            areaInfo.setText("Техника успешно добавлена!\nID: " + technique.getId());

            idField.clear();
            numberField.clear();
            hoursField.clear();
        } catch (NumberFormatException ex) {
            AlertUtils.showErrorAlert("Ошибка", "Введите корректные числовые значения для ID и часов!");
        } catch (Exception ex) {
            AlertUtils.showErrorAlert("Ошибка", "Неизвестная ошибка: " + ex.getMessage());
        }
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}