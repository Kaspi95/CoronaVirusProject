package main.Controller;

import main.View.MainWindow;

public class Controller {
    private static final Controller instance = new Controller();
    private MainWindow mainWindow;

    private Controller() {}

    public static Controller getInstance() {
        return instance;
    }

    public void initialize() {
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

