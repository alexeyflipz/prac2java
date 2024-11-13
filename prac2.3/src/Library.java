import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Library<T extends Media> {
    private List<T> mediaList = new ArrayList<>();

    public void addMedia(T media) {
        mediaList.add(media);
        System.out.println("Added: " + media);
    }

    public void removeMedia(T media) {
        if (mediaList.remove(media)) {
            System.out.println("Removed: " + media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public List<T> searchByTitle(String title) {
        return mediaList.stream()
                .filter(media -> media.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<T> searchByPublisher(String publisher) {
        return mediaList.stream()
                .filter(media -> media.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    public void displayAllMedia() {
        if (mediaList.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            mediaList.forEach(System.out::println);
        }
    }
}