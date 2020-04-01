package main.Controller;

import main.View.MainWindow;
import main.View.TestWindow;

public class Controller {
    private static final Controller instance = new Controller();
    private MainWindow mainWindow;
    private TestWindow testWindow;

    private Controller() {}

    public static Controller getInstance() {
        return instance;
    }

    public void initialize() {
        //testWindow = new TestWindow();
        mainWindow = new MainWindow();
    }

    public void closeAndSave() {
        //TODO
    }
    public void reDraw() {
        //TODO
    }

    public void error(Exception e) {
        System.out.println(e);
    }
}

