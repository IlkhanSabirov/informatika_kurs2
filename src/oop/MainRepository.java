package oop;

import oop.entities.User;
import oop.repositories.UserRepository;
import oop.repositories.UsersRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainRepository {

    private static final String DB_USERNAME = "postgres";

    private static final String DB_PASSWORD = "";

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/homework_db";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        UserRepository userRepository = new UsersRepositoryJdbcImpl(connection);

        List<User> users = userRepository.findAll();

        users.forEach(user -> System.out.println(user));

        List<User> newUsers = List.of(
                new User("Иван", "Иванов", 30),
                new User("Пётр", "Петров", 35),
                new User("Анна", "Воронина", 22),
                new User("Мария", "Кузнецова", 30),
                new User("Алексей", "Сидоров", 47),
                new User("Екатерина", "Антоновна", 18)
        );
        userRepository.saveAll(newUsers);

        System.out.println("\nВсе пользователи после добавления:");
        userRepository.findAll().forEach(user -> System.out.println(user));

        System.out.println("\nПользователи возрастом 30:");
        userRepository.findAllByAge(30).forEach(user -> System.out.println(user));

        System.out.println("\nПользователи старше 25:");
        userRepository.findAllOlderThan(25).forEach(user -> System.out.println(user));

        connection.close();
    }
}