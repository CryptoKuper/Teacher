import java.util.ArrayList;
import java.util.List;

// Класс, представляющий объект "Учитель"
class Teacher {
    private String name;
    private String subject;

    // Конструктор класса Учитель
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    // Геттеры и сеттеры для имени и предмета
    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

// Класс, предоставляющий сервисные методы для работы с объектами "Учитель"
class TeacherService {
    private List<Teacher> teachers;

    // Конструктор класса УчительСервис
    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    // Метод для добавления нового учителя в список
    public void addTeacher(String name, String subject) {
        Teacher teacher = new Teacher(name, subject);
        teachers.add(teacher);
    }

    // Метод для редактирования данных конкретного учителя
    public void editTeacher(int index, String name, String subject) {
        if (index >= 0 && index < teachers.size()) {
            Teacher teacher = teachers.get(index);
            teacher.setName(name);
            teacher.setSubject(subject);
        }
    }

    // Метод для получения списка всех учителей
    public List<Teacher> getTeachers() {
        return teachers;
    }
}

// Класс, представляющий отображение списка учителей
class TeacherView {
    // Метод для отображения списка учителей на экране
    public void showTeachers(List<Teacher> teachers) {
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            System.out.println("Teacher " + (i + 1) + ":");
            System.out.println("Name: " + teacher.getName());
            System.out.println("Subject: " + teacher.getSubject());
            System.out.println();
        }
    }
}

// Класс, предоставляющий интерфейс для взаимодействия с учителями
class TeacherController {
    private TeacherService service;
    private TeacherView view;

    // Конструктор класса УчительКонтроллер
    public TeacherController(TeacherService service, TeacherView view) {
        this.service = service;
        this.view = view;
    }

    // Метод для добавления нового учителя
    public void addTeacher(String name, String subject) {
        service.addTeacher(name, subject);
    }

    // Метод для редактирования данных учителя
    public void editTeacher(int index, String name, String subject) {
        service.editTeacher(index, name, subject);
    }

    // Метод для отображения списка всех учителей
    public void showTeachers() {
        List<Teacher> teachers = service.getTeachers();
        view.showTeachers(teachers);
    }
}

// Класс Main, используется для демонстрации функциональности
public class Main {
    public static void main(String[] args) {
        // Создание сервиса, представления и контроллера
        TeacherService service = new TeacherService();
        TeacherView view = new TeacherView();
        TeacherController controller = new TeacherController(service, view);

        // Добавление нескольких учителей
        controller.addTeacher("John Doe", "Math");
        controller.addTeacher("Alice Smith", "History");

        // Отображение списка учителей до редактирования
        System.out.println("Teachers before editing:");
        controller.showTeachers();

        // Редактирование данных первого учителя
        controller.editTeacher(0, "John Smith", "Physics");

        // Отображение списка учителей после редактирования
        System.out.println("Teachers after editing:");
        controller.showTeachers();
    }
}
