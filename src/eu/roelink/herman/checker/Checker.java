package eu.roelink.herman.checker;

public class Checker {

    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 2;
    public static final int MAX_NAME_LENGHT = 15;

    public static int checkPlayerAmtInput(String input) {
        try {
            int players = Integer.parseInt(input);
            return players <= MAX_PLAYERS && players >= MIN_PLAYERS ? players : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean checkNameInput(String input) {
        return input.length() <= MAX_NAME_LENGHT && !input.isEmpty();
    }

}
