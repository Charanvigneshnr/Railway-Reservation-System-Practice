package SD;

public class Passenger {
    private final int id;
    private String name;
    private int age;
    private char berthPreference;

    public Passenger(int id, String name, int age, char berthPreference) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference;
    }

    public Passenger(int pid) {
        this.id = pid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public char getBerthPreference() {
        return berthPreference;
    }

}
