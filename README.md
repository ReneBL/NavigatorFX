# NavigatorFX

NavigatorFX is a simple and easy to use slide menu made in JavaFX. It allows you to layout it vertically (top or bottom) as well as horizontally (left or right), and it is completely configurable.

Example:
  
```java  
List< NavigatorOption > options = new ArrayList< NavigatorOption >();
NavigatorOption optionHome = new NavigatorOption("Home", new ImageView(...));

optionHome.setOnMouseClicked(new EventHandler<MouseEvent>() { 
	@Override
	public void handle(MouseEvent event) {
		System.out.println("At home section!");
  	};      
});

NavigatorOption money = new NavigatorOption("Economy", new ImageView(...));
NavigatorOption sports = new NavigatorOption("Sports", new ImageView(...));

options.addAll(Arrays.asList(optionHome, money, sports));

Navigator navigator = new Navigator(NavigatorPosition.LEFT, options);
``` 
