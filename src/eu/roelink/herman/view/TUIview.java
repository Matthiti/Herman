package eu.roelink.herman.view;

import java.util.Scanner;

public class TUIview implements View {

    private Scanner scanner;

    public TUIview() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String askInput() {
        // has next?
        return scanner.nextLine();
    }
}
