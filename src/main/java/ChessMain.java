import java.util.ArrayList;
import java.util.HashMap;

public class ChessMain {
    public static void main(String[] args) {
        ChessMain main = new ChessMain();
        ArrayList<Player> players = main.createPlayers();
        for (Player player : players) {
            System.out.println(player);
        }
        HashMap<String, Piece> pieceHashMap = main.createPieces();
        System.out.println(pieceHashMap);
        main.play(players, pieceHashMap);
      /*  try {
            whitePlayer.setRank(10000);

        } catch (IllegalArgumentException err) {
            System.out.println("please update rank to valid");
            //обработка ошибки без присвоения значения и падения программы
            System.out.println(whitePlayer.getRank());
        }*/
    }

    public ArrayList<Player> createPlayers() {
        Player whitePlayer = new Player("Anna", "ams@bk.ru", true, 2000, 39);
        Player blackPlayer = new Player("Andrey", "kas@mail.ru", false, 1300, 40);
        ArrayList<Player> players = new ArrayList<>();
        players.add(whitePlayer);
        players.add(blackPlayer);
        return players;
    }

    public HashMap<String, Piece> createPieces() {
        King whiteKing = new King(new Spot("h", 7), "white_king", true);
        King blackKing = new King(new Spot("d", 8), "black_king", false);
        Rook whiteRook1 = new Rook(new Spot("a", 7), "white_rook1", true);
        Rook whiteRook2 = new Rook(new Spot("g", 7), "white_rook2", true);
        Knight blackKnight = new Knight(new Spot("d", 6), "black_knight", false);

        HashMap<String, Piece> pieceHashMap = new HashMap<>();
        pieceHashMap.put(whiteKing.getId(), whiteKing);
        pieceHashMap.put(blackKing.getId(), blackKing);
        pieceHashMap.put(whiteRook1.getId(), whiteRook1);
        pieceHashMap.put(whiteRook2.getId(), whiteRook2);
        pieceHashMap.put(blackKnight.getId(), blackKnight);

        return pieceHashMap;
    }

    public void play(ArrayList<Player> players, HashMap<String, Piece> hashMap) {
        //move 1
        try {
            players.get(0).movePiece(hashMap.get("white_rook1"), new Spot("a", 8));
        } catch (IllegalArgumentException error) {
            System.out.println("The move is incorrect, please try again!");
        }
        players.get(1).movePiece(hashMap.get("black_knight1"), new Spot("c", 8));
    }
}