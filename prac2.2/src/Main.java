import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private String name;
    private List<Department> departments = new ArrayList<>();

    public Main(String name) {
        this.name = name;
    }

    public class Department {
        private String departmentName;
        private List<String> professors;

        public Department(String departmentName) {
            this.departmentName = departmentName;
            this.professors = new ArrayList<>();
        }

        public void addProfessor(String professorName) {
            professors.add(professorName);
        }

        public List<String> getProfessors() {
            return professors;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void showDepartmentInfo() {
            System.out.println("Кафедра: " + departmentName);
            System.out.println("Викладачі: " + String.join(", ", professors));
        }
    }

    public static class Helper {

        public static double calculateAverageScore(List<Integer> scores) {
            if (scores == null || scores.isEmpty()) return 0.0;
            int sum = scores.stream().mapToInt(Integer::intValue).sum();
            return (double) sum / scores.size();
        }
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void manageEvents() {
        EventManager eventManager = new EventManager() {
            @Override
            public void organizeConference(String topic) {
                System.out.println("Організація конференції на тему: " + topic);
            }

            @Override
            public void organizeSeminar(String topic) {
                System.out.println("Організація семінару на тему: " + topic);
            }
        };

        eventManager.organizeConference("Штучний інтелект в освіті");
        eventManager.organizeSeminar("Новітні тенденції в комп'ютерних науках");
    }

    interface EventManager {
        void organizeConference(String topic);
        void organizeSeminar(String topic);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main university = new Main("Національний університет");

        System.out.println("=== Університетська система ===");
        boolean running = true;

        while (running) {
            System.out.println("\nОберіть дію:");
            System.out.println("1 - Додати кафедру");
            System.out.println("2 - Додати викладача до кафедри");
            System.out.println("3 - Показати інформацію про кафедри");
            System.out.println("4 - Організувати подію");
            System.out.println("5 - Обчислити середній бал студентів");
            System.out.println("6 - Вийти");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть назву кафедри: ");
                    String departmentName = scanner.nextLine();
                    university.addDepartment(departmentName);
                    System.out.println("Кафедра " + departmentName + " додана.");
                    break;

                case 2:
                    System.out.print("Введіть назву кафедри: ");
                    departmentName = scanner.nextLine();
                    Department department = university.departments.stream()
                            .filter(d -> d.getDepartmentName().equals(departmentName))
                            .findFirst()
                            .orElse(null);

                    if (department != null) {
                        System.out.print("Введіть ім'я викладача: ");
                        String professorName = scanner.nextLine();
                        department.addProfessor(professorName);
                        System.out.println("Викладач " + professorName + " доданий до кафедри " + departmentName + ".");
                    } else {
                        System.out.println("Кафедра не знайдена.");
                    }
                    break;

                case 3:
                    System.out.println("Інформація про кафедри:");
                    for (Department d : university.getDepartments()) {
                        d.showDepartmentInfo();
                    }
                    break;

                case 4:
                    university.manageEvents();
                    break;

                case 5:
                    System.out.println("Введіть кількість оцінок:");
                    int n = scanner.nextInt();
                    List<Integer> scores = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Введіть оцінку " + (i + 1) + ": ");
                        scores.add(scanner.nextInt());
                    }
                    double average = Helper.calculateAverageScore(scores);
                    System.out.println("Середній бал студентів: " + average);
                    break;

                case 6:
                    running = false;
                    System.out.println("Вихід з програми...");
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
        scanner.close();
    }
}