package oop.entities;

public class User {

    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public User(Long id, String name, String surname, Integer age){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User(String name, String surname, Integer age) {
        this(null, name, surname, age);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', surname='" + surname + "', age=" + age + "}";
    }
}