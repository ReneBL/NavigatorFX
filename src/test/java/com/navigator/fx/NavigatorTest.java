package com.navigator.fx;

import java.util.ArrayList;
import java.util.List;

import com.navigator.fx.panel.NavigatorOption;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The Class NavigatorTest.
 */
public class NavigatorTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane ap = new AnchorPane();

		Navigator navigator = new Navigator(NavigatorPosition.BOTTOM, generateOptions());
		ap.getChildren().add(navigator);
		AnchorPane.setLeftAnchor(navigator, 0.0);
		AnchorPane.setTopAnchor(navigator, 0.0);

		Scene scene = new Scene(ap, 800.0, 600.0);
		primaryStage.setScene(scene);

		primaryStage.show();

	}

	private static List<NavigatorOption> generateOptions() {

		List<NavigatorOption> options = new ArrayList<>();

		NavigatorOption optionHome = new NavigatorOption("Home",
				FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.HOME, "20"));
		optionHome.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				System.out.println("At home section!");
			};
		});

		NavigatorOption money = new NavigatorOption("Economy",
				FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.MONEY, "20"));

		NavigatorOption sports = new NavigatorOption("Sports",
				FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.SOCCER_BALL_ALT, "20"));

		NavigatorOption travel = new NavigatorOption("Travel",
				FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.PLANE, "20"));

		NavigatorOption travel2 = new NavigatorOption("Travel",
				FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.PLANE, "20"));

		NavigatorOption travel3 = new NavigatorOption("Travel",
				FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.PLANE, "20"));

		options.add(optionHome);
		options.add(money);
		options.add(sports);
		options.add(travel);
		options.add(travel2);
		options.add(travel3);

		return options;

	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
