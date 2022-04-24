package com.matteoveroni.kanbango.javafx;

import com.google.gson.Gson;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FXMLLoaderBuilder {

    private final Gson gson;

    public FXMLLoaderBuilder(Gson gson) {
        this.gson = gson;
    }

    public FXMLLoader build() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StandardCharsets.UTF_8);
        fxmlLoader.setControllerFactory(controllerClass -> {
            if (controllerClass == KanbanController.class) {
                return new KanbanController(gson);
            } else {
                throw new IllegalStateException("Not recognized controller class!");
            }
        });
        return fxmlLoader;
    }
}
