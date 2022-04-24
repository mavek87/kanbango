package com.matteoveroni.kanbango.javafx;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class KanbanController implements Initializable {

    @FXML
    GridPane root_grid_pane;

    private Gson gson;
    private Stage stage;
    private int column = 1;
    private int row = 1;

//    DragController draggableMaker = new DragController();
//
    public KanbanController(){}

    public KanbanController(Gson gson) {
        System.out.println("costruttore");
        this.gson = gson;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("init");

        Platform.runLater(() -> {
            System.out.println("init - runlater");

            stage = (Stage) root_grid_pane.getScene().getWindow();
            stage.widthProperty().addListener((observableValue, oldWidth, newWidth) -> setCurrentWidthToStage(newWidth));
            stage.heightProperty().addListener((observableValue, oldHeight, newHeight) -> setCurrentHeightToStage(newHeight));

            double width = stage.getWidth();
            double height = stage.getHeight();

            System.out.println("width: " + width);
            System.out.println("height: " + height);
        });


//        draggableMaker.makeDraggable(rectangle);
//        draggableMaker.makeDraggable(anchorPane);

//        new DragNodeDecorator(rectangle, true);
////        dragController.isDraggableProperty().bind(isDraggableBox.selectedProperty());
//
//        double viewOrder = rectangle.getViewOrder();
//        rectangle.toFront();
//        double viewOrder1 = anchorPane.getViewOrder();
//        System.out.println(viewOrder + " - " + viewOrder1);
    }

    private void setCurrentWidthToStage(Number width) {
        stage.setWidth((double) width);
//        for(int columnIndex=0; columnIndex<row; columnIndex++) {
//            root_grid_pane.addRow(columnIndex, new Button("ciao " + columnIndex));
//        }
    }

    private void setCurrentHeightToStage(Number height) {
        stage.setHeight((double) height);
//        for(int rowIndex=0; rowIndex<row; rowIndex++) {
//            root_grid_pane.addRow(rowIndex, new Button("ciao " + rowIndex));
//        }
    }


}
