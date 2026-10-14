package main.java.ru.aston.hometask_2;

import java.util.List;
/*
 * По заданию у каждого студента обязательно должен быть список книг (минимум 5).

 *Student хранит имя и список книг
 */
public class Student {
    private String name;
    private List<Book> books;
// Геттер имени нужен для Gson
    public String getName() {
         return name; 
        }
         // Геттер списка книг (для .map(Student::getBooks))
    public List<Book> getBooks() {
         return books;
        }

    @Override
    // toString() (для .peek(System.out::println))
    public String toString() {
        return "Студент: " + name;
    }
}