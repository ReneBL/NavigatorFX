package com.navigator.fx.helper;

import com.navigator.fx.panel.NavigatorPanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * The Class LayoutManager.
 */
public class LayoutManager {

	/** The Constant MAX_WIDTH. */
	private static final double MAX_WIDTH = 200.0;

	/** The Constant MAX_HEIGHT. */
	private static final double MAX_HEIGHT = 195.0;

	/** The Constant ROOT_STACK_PANE_NODE_ID. */
	private static final String ROOT_STACK_PANE_NODE_ID = "rootStackPane";

	/** The Constant CURRENT_ROOT_NODE_ID. */
	private static final String CURRENT_ROOT_NODE_ID = "currentRoot";

	/** The Constant SLIDE_IN_DURATION_SECONDS. */
	private static final double SLIDE_IN_DURATION_SECONDS = 0.4;

	/** The Constant SLIDE_OUT_DURATION_SECONDS. */
	private static final double SLIDE_OUT_DURATION_SECONDS = 0.5;

	/**
	 * Show panel.
	 *
	 * @param panel
	 *            the panel
	 * @param scene
	 *            the current scene
	 */
	public static void showPanel(NavigatorPanel panel, Scene scene) {

		Parent root = scene.getRoot();
		root.setId(CURRENT_ROOT_NODE_ID);

		StackPane stackPane = new StackPane(root);
		stackPane.setId(ROOT_STACK_PANE_NODE_ID);
		Node shadowedLayer = createShadowedLayer();
		shadowedLayer.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				hidePanel(panel);
			}

		});
		stackPane.getChildren().add(shadowedLayer);

		switch (panel.getPosition()) {
		case TOP:
			StackPane.setAlignment(panel, Pos.TOP_CENTER);
			panel.setMaxHeight(MAX_HEIGHT);

			break;
		case RIGHT:
			StackPane.setAlignment(panel, Pos.CENTER_RIGHT);
			panel.setMaxWidth(MAX_WIDTH);

			break;
		case BOTTOM:
			StackPane.setAlignment(panel, Pos.BOTTOM_CENTER);
			panel.setMaxHeight(MAX_HEIGHT);

			break;
		case LEFT:
			StackPane.setAlignment(panel, Pos.CENTER_LEFT);
			panel.setMaxWidth(MAX_WIDTH);

			break;
		default:
			break;
		}

		stackPane.getChildren().add(panel);
		scene.setRoot(stackPane);

		TransitionManager.slideIn(panel, panel.getPosition(), SLIDE_IN_DURATION_SECONDS, null);

	}

	/**
	 * Hide panel.
	 *
	 * @param panel
	 *            the panel
	 */
	public static void hidePanel(NavigatorPanel panel) {

		TransitionManager.slideOut(panel, panel.getPosition(), SLIDE_OUT_DURATION_SECONDS,
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						StackPane stackPane = (StackPane) panel.getScene().getRoot();
						Parent currentRoot = (Parent) stackPane.lookup("#" + CURRENT_ROOT_NODE_ID);

						// Save current scene
						Scene scene = panel.getScene();
						stackPane.getChildren().clear();

						scene.setRoot(currentRoot);
					}
				});

	}

	/**
	 * Adds the shadowed layer.
	 *
	 * @return the node
	 */
	private static Node createShadowedLayer() {
		StackPane pane = new StackPane();
		pane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5)");

		return pane;
	}

}
