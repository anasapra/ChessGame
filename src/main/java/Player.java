public class Player {
    private String name;
    private String email;
    private boolean white;
    private int rank;
    private int age;

    public Player(String name, String email, boolean white, int rank, int age) {
        //обработка ошибок внутри конструктора
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("The name should not be empty");
        } else {
            this.name = name;
        }
        if (email == null || email.isBlank() || email.isEmpty()) {
            throw new IllegalArgumentException("The name should not be empty");
        }
        if (email.contains("@") == false || email.contains(".") == false) {
            throw new IllegalArgumentException("The email adress should contain '@' and '.'");
        } else {
            this.email = email;
        }
        this.white = white;
        this.rank = rank;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        //обработка ошибок внутри метода
        if (rank < 100 || rank > 3000) {
            throw new IllegalArgumentException("The rank should be in range of 100 and 3000");
        }
        this.rank = rank;
        System.out.println("The rank of" + name + "was changed to" + rank);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void movePiece(Piece piece, Spot spot) {
        if (isWhite() != piece.isWhite()) {
            throw new IllegalArgumentException("Incorrect piece color. Try again");
        }
        piece.setSpot(spot);
        System.out.println("Piece " + piece.getName() + " is moved to: " + spot);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", white=" + white +
                ", rank=" + rank +
                ", age=" + age +
                '}';
    }
}
