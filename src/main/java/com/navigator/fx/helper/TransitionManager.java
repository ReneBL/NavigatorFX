package com.navigator.fx.helper;

import com.navigator.fx.NavigatorPosition;
import com.navigator.fx.panel.NavigatorPanel;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * The Class TransitionManager.
 */
public class TransitionManager {

	/**
	 * Slide.
	 *
	 * @param node
	 *            the node
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @param onFinish
	 *            the on finish
	 */
	public static final void slideIn(NavigatorPanel panel, NavigatorPosition position, double duration,
			EventHandler<ActionEvent> onFinish) {
		// Force StackPane to size itself and it's children
		panel.getParent().applyCss();
		panel.getParent().layout();

		switch (position) {
		case TOP:
			doSlideVertically(-panel.getHeight(), 0.0, duration, panel, onFinish);
			break;
		case BOTTOM:
			doSlideVertically(panel.getHeight(), 0.0, duration, panel, onFinish);
			break;
		case RIGHT:
			doSlideHorizontally(panel.getWidth(), 0.0, duration, panel, onFinish);
			break;
		case LEFT:
			doSlideHorizontally(-panel.getWidth(), 0.0, duration, panel, onFinish);
			break;
		default:
			break;
		}

	}

	public static final void slideOut(NavigatorPanel panel, NavigatorPosition position, double duration,
			EventHandler<ActionEvent> onFinish) {
		// Force StackPane to size itself and it's children
		panel.getParent().applyCss();
		panel.getParent().layout();

		switch (position) {
		case TOP:
			doSlideVertically(0.0, -panel.getHeight(), duration, panel, onFinish);
			break;
		case BOTTOM:
			doSlideVertically(0.0, panel.getHeight(), duration, panel, onFinish);
			break;
		case RIGHT:
			doSlideHorizontally(0.0, panel.getWidth(), duration, panel, onFinish);
			break;
		case LEFT:
			doSlideHorizontally(0.0, -panel.getWidth(), duration, panel, onFinish);
			break;
		default:
			break;
		}
	}

	private static final void doSlideHorizontally(double from, double to, double duration, NavigatorPanel panel,
			EventHandler<ActionEvent> onFinish) {

		TranslateTransition transition = new TranslateTransition(Duration.seconds(duration), panel);

		transition.setFromX(from);
		transition.setToX(to);
		transition.setCycleCount(1);
		if (onFinish != null) {
			transition.setOnFinished(onFinish);
		}

		transition.play();

	}

	private static final void doSlideVertically(double from, double to, double duration, NavigatorPanel panel,
			EventHandler<ActionEvent> onFinish) {

		TranslateTransition transition = new TranslateTransition(Duration.seconds(duration), panel);

		transition.setFromY(from);
		transition.setToY(to);
		transition.setCycleCount(1);
		if (onFinish != null) {
			transition.setOnFinished(onFinish);
		}

		transition.play();

	}

}
