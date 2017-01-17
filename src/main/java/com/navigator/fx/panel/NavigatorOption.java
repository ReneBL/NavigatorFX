package com.navigator.fx.panel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

/**
 * The Class NavigatorOption.
 */
public class NavigatorOption extends GridPane {

	/** The graphic text gap. */
	private DoubleProperty graphicTextGap = new SimpleDoubleProperty(20.0);

	/** The selected. */
	private BooleanProperty selected = new SimpleBooleanProperty(false);

	/** The delegate. */
	private NavigatorOptionDelegate delegate;

	/** The Constant SELECTED_PSEUDO_CLASS. */
	private static final PseudoClass SELECTED_PSEUDO_CLASS = PseudoClass.getPseudoClass("selected");

	/**
	 * Instantiates a new navigator option.
	 *
	 * @param name
	 *            the name
	 * @param graphic
	 *            the graphic
	 */
	public NavigatorOption(String name, Node graphic) {
		setCursor(Cursor.HAND);
		getStyleClass().add("navigator-option");

		addColumn(0, graphic);
		addColumn(1, new Text(name));

		ColumnConstraints iconColumnConstraint = new ColumnConstraints(50.0);
		iconColumnConstraint.setHalignment(HPos.LEFT);
		iconColumnConstraint.setHgrow(Priority.NEVER);

		ColumnConstraints textColumnConstraint = new ColumnConstraints();
		textColumnConstraint.setHalignment(HPos.LEFT);
		textColumnConstraint.setHgrow(Priority.ALWAYS);

		getColumnConstraints().add(iconColumnConstraint);
		getColumnConstraints().add(textColumnConstraint);

		setAlignment(Pos.CENTER);

		selected.addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				pseudoClassStateChanged(SELECTED_PSEUDO_CLASS, newValue.booleanValue());
			}
		});

		addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (delegate != null) {
					delegate.onOptionClicked(NavigatorOption.this);
				}
			};
		});
	}

	/**
	 * Sets the delegate.
	 *
	 * @param delegate
	 *            the new delegate
	 */
	public final void setDelegate(NavigatorOptionDelegate delegate) {
		this.delegate = delegate;
	}

	/**
	 * Sets the on click.
	 *
	 * @param handler
	 *            the new on click
	 */
	public void setOnClick(EventHandler<? super MouseEvent> handler) {
		setOnMouseClicked(handler);
	}

	/**
	 * Graphic text gap property.
	 *
	 * @return the double property
	 */
	public DoubleProperty graphicTextGapProperty() {
		return graphicTextGap;
	}

	/**
	 * Gets the graphic text gap.
	 *
	 * @return the graphic text gap
	 */
	public final double getGraphicTextGap() {
		return graphicTextGap.get();
	}

	/**
	 * Sets the graphic text gap.
	 *
	 * @param graphicTextGap
	 *            the new graphic text gap
	 */
	public final void setGraphicTextGap(double graphicTextGap) {
		this.graphicTextGap.set(graphicTextGap);
	}

	/**
	 * Selected property.
	 *
	 * @return the boolean property
	 */
	public BooleanProperty selectedProperty() {
		return selected;
	}

	/**
	 * Gets the selected.
	 *
	 * @return the selected
	 */
	public boolean getSelected() {
		return selected.get();
	}

	/**
	 * Sets the selected.
	 *
	 * @param selected
	 *            the new selected
	 */
	public void setSelected(boolean selected) {
		this.selected.set(selected);
	}

}
