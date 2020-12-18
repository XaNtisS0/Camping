package pl.pzp.Camping.model;

import java.util.UUID;

public class Client {
    private final UUID id;
    private final String name;
    private final int age;

    public Client(UUID id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
