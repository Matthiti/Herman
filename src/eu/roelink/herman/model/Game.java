package eu.roelink.herman.model;

import java.util.List;

public class Game {

    private Table table;
    private List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
        this.table = new Table();
    }

    // requires players.size() == 1
    public Player getWinner() {
        assert players.size() == 1;
        return players.get(0);
    }

    public boolean hasEnded() {
        return players.size() == 1;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
