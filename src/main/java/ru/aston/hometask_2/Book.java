package main.java.ru.aston.hometask_2;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int pages;
    private int year;

    public String getTitle() { 
        return title;
     }
    public String getAuthor() {
         return author; 
        }
    public int getPages() { 
        return pages; 
    }
    public int getYear() { 
        return year; 
    }
  // Переопределение toString() из Object
    @Override //переопределяю метод toString() из класса Object (защита от опечаток: если уберу и ошибусь в методе, он создаст новый)
    public String toString() {
        return title + " (" + author + ", " + year + " г., " + pages + " стр.)";
    }

    @Override
    public boolean equals(Object o) {
        // Если сравнить объект сам с собой то они равны
        if (this == o) 
            return true;
         // Если передан null или объект другого класса то не равнф
        if (o == null || getClass() != o.getClass()) 
            return false;
        // Привод. Object к Book, чтобы получить доступ к полям
        Book book = (Book) o;
        // Сравниваем все поля (всё совпадает—книги одинаковые)
        return pages == book.pages && year == book.year &&
               Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
    // Переопред. hashCode() в паре с equals()
    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages, year);
    }
}