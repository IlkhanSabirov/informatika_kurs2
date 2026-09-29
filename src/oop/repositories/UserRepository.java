package oop.repositories;

import oop.entities.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User> {
    List<User> findAllByAge(Integer age);
    List<User> findAllOlderThan(Integer age);
}