package com.navigator.fx.panel;

import java.util.List;

import com.navigator.fx.NavigatorPosition;
import com.navigator.fx.helper.LayoutManager;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * The Class NavigatorPanel.
 */
public class NavigatorPanel extends ScrollPane implements NavigatorOptionDelegate {

	/** The Constant NAVIGATOR_PANEL_VERTICAL_CSS_CLASS. */
	private static final String NAVIGATOR_PANEL_VERTICAL_CSS_CLASS = "navigator-panel-vertical";

	/** The Constant NAVIGATOR_PANEL_CSS_CLASS. */
	private static final String NAVIGATOR_PANEL_CSS_CLASS = "navigator-panel";

	/** The Constant CSS_STYLESHEET. */
	private static final String CSS_STYLESHEET = "navigatorPanel.css";

	/** The option selected. */
	private NavigatorOption optionSelected;

	/** The position. */
	private NavigatorPosition position;

	/** The show property. */
	private final BooleanProperty showProperty = new SimpleBooleanProperty(false);

	/** The hide property. */
	private final BooleanProperty hideProperty = new SimpleBooleanProperty(false);

	/**
	 * Instantiates a new navigator panel.
	 */
	public NavigatorPanel() {
		initialize();
	}

	/**
	 * Instantiates a new navigator panel.
	 *
	 * @param position
	 *            the position
	 * @param options
	 *            the options
	 */
	public NavigatorPanel(NavigatorPosition position, List<NavigatorOption> options) {
		this.position = position;

		initialize();
		initOptions(options);
	}

	@Override
	public void onOptionClicked(NavigatorOption option) {
		if (optionSelected != null) {
			optionSelected.setSelected(false);
		}
		option.setSelected(true);
		optionSelected = option;
		LayoutManager.hidePanel(this);
	}

	/**
	 * Show property.
	 *
	 * @return the boolean property
	 */
	public final BooleanProperty showProperty() {
		return showProperty;
	}

	/**
	 * Gets the show.
	 *
	 * @return the show
	 */
	public final boolean getShow() {
		return showProperty.get();
	}

	/**
	 * Sets the show.
	 *
	 * @param show
	 *            the new show
	 */
	public final void setShow(boolean show) {
		this.showProperty.set(show);
	}

	/**
	 * Hide property.
	 *
	 * @return the boolean property
	 */
	public final BooleanProperty hideProperty() {
		return hideProperty;
	}

	/**
	 * Gets the hide.
	 *
	 * @return the hide
	 */
	public final boolean getHide() {
		return hideProperty.get();
	}

	/**
	 * Sets the hide.
	 *
	 * @param hide
	 *            the new hide
	 */
	public final void setHide(boolean hide) {
		this.hideProperty.set(hide);
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public NavigatorPosition getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position
	 *            the new position
	 */
	public void setPosition(NavigatorPosition position) {
		this.position = position;
	}

	/**
	 * Inits the options.
	 *
	 * @param options
	 *            the options
	 */
	private void initOptions(List<NavigatorOption> options) {
		if (options != null) {
			for (NavigatorOption navigatorOption : options) {
				navigatorOption.setDelegate(this);
				navigatorOption.setGraphicTextGap(0.0);
				((VBox) getContent()).getChildren().add(navigatorOption);
			}
		}
	}

	/**
	 * Initialize.
	 */
	private void initialize() {
		VBox content = new VBox();
		getStyleClass().add(NAVIGATOR_PANEL_CSS_CLASS);
		getStylesheets().add(getClass().getResource(CSS_STYLESHEET).toExternalForm());
		content.setFillWidth(true);

		setFitToHeight(true);
		setFitToWidth(true);

		if (NavigatorPosition.TOP.equals(position) || NavigatorPosition.BOTTOM.equals(position)) {
			content.setAlignment(Pos.CENTER);
		} else {
			content.setAlignment(Pos.TOP_LEFT);
		}

		setContent(content);
	}

}
