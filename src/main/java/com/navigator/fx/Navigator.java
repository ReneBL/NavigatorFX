package com.navigator.fx;

import java.util.List;

import com.navigator.fx.helper.LayoutManager;
import com.navigator.fx.panel.NavigatorOption;
import com.navigator.fx.panel.NavigatorPanel;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * The Class Navigator.
 */
public class Navigator extends Button {

	/** The Constant DEFAULT_STYLE_CLASS. */
	private static final String DEFAULT_STYLE_CLASS = "navigator-btn";

	/** The Constant CSS_STYLESHEET. */
	private static final String CSS_STYLESHEET = "navigator.css";

	/** The panel. */
	private NavigatorPanel panel;

	/**
	 * Instantiates a new navigator.
	 */
	public Navigator() {
		initialize();
	}

	/**
	 * Instantiates a new navigator.
	 *
	 * @param position
	 *            the position
	 * @param options
	 *            the options
	 */
	public Navigator(NavigatorPosition position, List<NavigatorOption> options) {
		initialize();
		panel = new NavigatorPanel(position, options);

		setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LayoutManager.showPanel(panel, getScene());
			}
		});

	}

	/**
	 * Initialize.
	 */
	private final void initialize() {
		getStyleClass().add(DEFAULT_STYLE_CLASS);
		setGraphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.BARS, "40"));
		getStylesheets().add(getClass().getResource(CSS_STYLESHEET).toExternalForm());
	}

}
