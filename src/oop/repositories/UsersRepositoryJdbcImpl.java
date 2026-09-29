package oop.repositories;

import oop.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Objects;
import java.util.StringJoiner;

public class UsersRepositoryJdbcImpl implements UserRepository{

    private final Connection connection;

    private static final String SQL_SELECT_FROM_DRIVERS = "select id, first_name, last_name, age from drivers";

    private static final String SQL_INSERT = "insert into drivers (first_name, last_name, age) values ";

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<User> findAll() {
        return findByQuery(SQL_SELECT_FROM_DRIVERS);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public java.util.List<User> findAllByAge(Integer age) {
        Objects.requireNonNull(age, "age не может быть null");
        return findByQuery(SQL_SELECT_FROM_DRIVERS + " where age = " + age);
    }

    @Override
    public void saveAll(List<User> users) {
        if (users == null || users.isEmpty()) {
            return;
        }

        StringJoiner values = new StringJoiner(", ");
        for (User user : users) {
            values.add("(" + quote(user.getName()) + ", "
                    + quote(user.getSurname()) + ", "
                    + user.getAge() + ")");
        }

        executeUpdate(SQL_INSERT + values);
    }

    @Override
    public List<User> findAllOlderThan(Integer age) {
        Objects.requireNonNull(age, "age не может быть null");
        return findByQuery(SQL_SELECT_FROM_DRIVERS + " where age > " + age);
    }

    private List<User> findByQuery(String sql) {
        List<User> result = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка при выполнении запроса: " + sql, e);
        }
        return result;
    }

    private void executeUpdate(String sql) {
//        System.out.println("SQL: " + sql);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка при выполнении запроса: " + sql, e);
        }
    }

    private User mapRow(ResultSet resultSet) throws SQLException {
        int age = resultSet.getInt("age");
        Integer ageOrNull = resultSet.wasNull() ? null : age;

        return new User(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString("last_name"),
                ageOrNull
        );
    }

    private String quote(String value) {
        if (value == null) {
            return "null";
        }
        return "'" + value.replace("'", "''") + "'";
    }
}