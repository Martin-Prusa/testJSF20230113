package cz.martin.models;

public class Publisher {
    private int id;
    private String name;
    private int count;

    public Publisher(String name, int count, int id) {
        this.name = name;
        this.count = count;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
}
