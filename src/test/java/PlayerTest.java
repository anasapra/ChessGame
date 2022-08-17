import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class PlayerTest {

private static ArrayList<Player> players;
private static HashMap<String, Piece> pieceHashMap;
    @BeforeAll
    public static void setUp(){
        ChessMain main = new ChessMain();
         players = main.createPlayers();
         pieceHashMap = main.createPieces();
    }

    @BeforeEach
    public void beforeEachTest(){
        System.out.println("Running before each test");
    }

    @AfterEach
    public void AfterEachTest(){
        System.out.println("Running after each test");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Running after all tests");
    }

    @Test
    public void validMoveTest() {
players.get(0).movePiece(pieceHashMap.get("white_king"), new Spot("h", 8));
Assertions.assertEquals(8,pieceHashMap.get("white_king").getSpot().getY());
    }

    @Test
    public  void invalidMovePieceColorTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            players.get(0).movePiece(pieceHashMap.get("black_king"), new Spot("h",8));
        });
    }

    @Test
    public  void invalidMoveBadSpotTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            players.get(0).movePiece(pieceHashMap.get("white_king"), new Spot("h",10));
        });
    }

    @Test
    public void playerCreationSuccessTest() {
        Player whitePlayer = new Player("Anna", "ams@bk.ru", true, 2000, 39);
        Assertions.assertEquals("Anna", whitePlayer.getName());
        Assertions.assertEquals("ams@bk.ru", whitePlayer.getEmail());
        Assertions.assertTrue(whitePlayer.isWhite());
        Assertions.assertEquals(2000, whitePlayer.getRank());
        Assertions.assertEquals(39, whitePlayer.getAge());
    }
    @ParameterizedTest
    @MethodSource("nameError")
  //  @ValueSource(strings = {null, "", " "})
    public void playerCreationIncorrectNameTest(String name){
Assertions.assertThrows(IllegalArgumentException.class, () -> {
    Player whitePlayer = new Player(name, "ams@bk.ru", true, 2000, 39);
});
    }
    static Stream<String> nameError(){
        return Stream.of("", " ", null);
    }

    @ParameterizedTest
    @MethodSource("emailError")
    //  @ValueSource(strings = {null, "", " "})
    public void playerCreationIncorrectEmailTest(String email){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Player whitePlayer = new Player("Anna", email, true, 2000, 39);
        });
    }
    static Stream<String> emailError(){
        return Stream.of("", " ", null, "ams.bk.ru", "ams");
    }
}
