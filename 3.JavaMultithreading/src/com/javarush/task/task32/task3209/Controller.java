package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.util.Collections;

public class Controller {
    private HTMLDocument document;
    private View view;
    private File currentFile;

    public void init() {

    }

    public Controller(View view) {
        this.view = view;
    }

    public void exit() {
        System.exit(0);
    }

    public static void main (String... args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
