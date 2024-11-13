import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library<Media> library = new Library<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add DVD");
            System.out.println("4. Remove Media by Title");
            System.out.println("5. Search Media by Title");
            System.out.println("6. Search Media by Publisher");
            System.out.println("7. Display All Media");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addMedia(new Book(title, publisher, author));
                }
                case 2 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter issue number: ");
                    int issueNumber = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    library.addMedia(new Magazine(title, publisher, issueNumber));
                }
                case 3 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    library.addMedia(new DVD(title, publisher, duration));
                }
                case 4 -> {
                    System.out.print("Enter title of media to remove: ");
                    String title = scanner.nextLine();
                    library.searchByTitle(title).forEach(library::removeMedia);
                }
                case 5 -> {
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    library.searchByTitle(title).forEach(System.out::println);
                }
                case 6 -> {
                    System.out.print("Enter publisher to search: ");
                    String publisher = scanner.nextLine();
                    library.searchByPublisher(publisher).forEach(System.out::println);
                }
                case 7 -> library.displayAllMedia();
                case 8 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
