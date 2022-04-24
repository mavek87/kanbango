package com.matteoveroni.kanbango;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.matteoveroni.kanbango.domain.KanbanTask;
import com.matteoveroni.kanbango.javafx.FXMLLoaderBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// https://stackoverflow.com/questions/31219169/javafx-application-name-on-gnome   - Fix per bug nome con package in gnome

public class App extends Application {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final FXMLLoaderBuilder fxmlLoaderBuilder = new FXMLLoaderBuilder(gson);
    private String jsonKanbanTask;

    public static void main(String[] args) {
        App.launch(args);
    }

    @Override
    public void init() throws Exception {
        KanbanTask kanbanTask = new KanbanTask("First task", "This is the first task", "This is the long story description of the first task");
        jsonKanbanTask = gson.toJson(kanbanTask);
    }

    @Override
    public void start(Stage stage) throws Exception {
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
//        webEngine.load("http://127.0.0.1:12999");
        webEngine.load("http://google.com");
        System.out.println(webEngine.getUserAgent());


        BorderPane rootPane = new BorderPane();
        rootPane.setCenter(browser);


//        FXMLLoader fxmlLoader = fxmlLoaderBuilder.build();
//        Parent root = fxmlLoader.load(getClass().getClassLoader().getResource("kanban.fxml"));
        stage.setTitle("Hello World");
//        stage.setScene(new Scene(root));
//
        stage.setScene(new Scene(rootPane));
        stage.show();
    }


}
