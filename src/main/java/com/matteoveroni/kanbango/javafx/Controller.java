package com.matteoveroni.kanbango.javafx;

import com.matteoveroni.kanbango.utils.graphics.DragNodeDecorator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Rectangle rectangle;

    @FXML
    private AnchorPane anchorPane;

//    DragController draggableMaker = new DragController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        draggableMaker.makeDraggable(rectangle);
//        draggableMaker.makeDraggable(anchorPane);

        new DragNodeDecorator(rectangle, true);
//        dragController.isDraggableProperty().bind(isDraggableBox.selectedProperty());

        double viewOrder = rectangle.getViewOrder();
        rectangle.toFront();
        double viewOrder1 = anchorPane.getViewOrder();
        System.out.println(viewOrder + " - " + viewOrder1);
    }


}
