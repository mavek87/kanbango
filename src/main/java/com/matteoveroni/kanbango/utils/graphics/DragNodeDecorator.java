package com.matteoveroni.kanbango.utils.graphics;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Reference: https://edencoding.com/drag-shapes-javafx/
 * Simpler reference: https://gist.github.com/Da9el00/74cc0100b67ade75308f3875c2c681cb
 */
public class DragNodeDecorator {

    private final Node node;

    private double anchorX;
    private double anchorY;

    private double mouseOffsetFromNodeZeroX;
    private double mouseOffsetFromNodeZeroY;

    private EventHandler<MouseEvent> setAnchor;
    private EventHandler<MouseEvent> updatePositionOnDrag;
    private EventHandler<MouseEvent> commitPositionOnRelease;

    private final int ACTIVE = 1;
    private final int INACTIVE = 0;
    private int cycleStatus = INACTIVE;
    private BooleanProperty isDraggable;

    public DragNodeDecorator(Node node) {
        this(node, false);
    }

    public DragNodeDecorator(Node node, boolean isDraggable) {
        this.node = node;
        createHandlers();
        createDraggableProperty();
        this.isDraggable.set(isDraggable);
    }

    private void createHandlers() {
        setAnchor = event -> {
            if (event.isPrimaryButtonDown()) {
                cycleStatus = ACTIVE;
                anchorX = event.getSceneX();
                anchorY = event.getSceneY();
                mouseOffsetFromNodeZeroX = event.getX();
                mouseOffsetFromNodeZeroY = event.getY();
            }
            if (event.isSecondaryButtonDown()) {
                cycleStatus = INACTIVE;
                node.setTranslateX(0);
                node.setTranslateY(0);
            }
        };
        updatePositionOnDrag = event -> {
            if (cycleStatus != INACTIVE) {
                node.setTranslateX(event.getSceneX() - anchorX);
                node.setTranslateY(event.getSceneY() - anchorY);
            }
        };
        commitPositionOnRelease = event -> {
            if (cycleStatus != INACTIVE) {
                // commit changes to LayoutX and LayoutY
                node.setLayoutX(event.getSceneX() - mouseOffsetFromNodeZeroX);
                node.setLayoutY(event.getSceneY() - mouseOffsetFromNodeZeroY);
                // clear changes from TranslateX and TranslateY
                node.setTranslateX(0);
                node.setTranslateY(0);
            }
        };
    }

    public void createDraggableProperty() {
        isDraggable = new SimpleBooleanProperty();
        isDraggable.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                node.addEventFilter(MouseEvent.MOUSE_PRESSED, setAnchor);
                node.addEventFilter(MouseEvent.MOUSE_DRAGGED, updatePositionOnDrag);
                node.addEventFilter(MouseEvent.MOUSE_RELEASED, commitPositionOnRelease);
            } else {
                node.removeEventFilter(MouseEvent.MOUSE_PRESSED, setAnchor);
                node.removeEventFilter(MouseEvent.MOUSE_DRAGGED, updatePositionOnDrag);
                node.removeEventFilter(MouseEvent.MOUSE_RELEASED, commitPositionOnRelease);
            }
        });
    }

    public boolean isDraggable() {
        return isDraggable.get();
    }

    public BooleanProperty isDraggableProperty() {
        return isDraggable;
    }
}