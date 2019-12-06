package eu.roelink.herman.view;

public interface View {

    void showMessage(String message);

    String askInput();

    default String askInput(String question) {
        showMessage(question);
        return askInput();
    }

}
