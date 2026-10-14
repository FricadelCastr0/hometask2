package main.java.ru.aston.hometask_2;

// Импорт библиотеки Gson для чтения JSON-файлов и т.д.
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         // Блок try-catch для обработки ошибок (при случае если что то пойдет не так)
        try {
            // часть чтения json
            Gson gson = new Gson();
            Reader reader = new FileReader("src/main/resources/students.json");//не тот адрес- выведится ошибка
            Type listType = new TypeToken<List<Student>>() {}.getType();
            List<Student> students = gson.fromJson(reader, listType);

            // единый поток (обработка списка) 
            students.stream()
                
                //Вывести в консоль студентов 
                .peek(System.out::println)
                
                //Получить для студентов список книг
                .map(Student::getBooks)
                
                //Получить все книги 
                // (сплющиваем списки в один поток)
                .flatMap(List::stream)
                
                // Отсортировать книги по количеству страниц
                .sorted(Comparator.comparingInt(Book::getPages))
                
                // убрать повтор данных 
                // (чтобы не было дубликатов с помощью equals() и hashCode())
                .distinct()
                
                //Отфильтровать книги после 2000 г.
                .filter(book -> book.getYear() > 2000)
                
                // Ограничить стрим на 3 элементах
                .limit(3)
                
                //Получить из книг годы выпуска
                .map(Book::getYear)
                
                // Метод короткого замыкания 
                // (стрим останавливается, как только нашёл первый результат)Optional<Integer>
                .findFirst()
                
                //Получить значение из Optional и вывести в консоль
                .ifPresentOrElse(
                    year -> System.out.println("Найден год: " + year),
                    () -> System.out.println("Такая книга отсутствует")
                );

        } catch (Exception e) {//  (e) это объект ошибки, в нём есть сообщение о том, что случилось
            System.out.println(" есть ошибка: " + e.getMessage()); //сообщение об ошибке
        }
    }
}