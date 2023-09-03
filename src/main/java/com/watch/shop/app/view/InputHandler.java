package com.watch.shop.app.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String getUserInput() {
        return scanner.nextLine();
    }
}
