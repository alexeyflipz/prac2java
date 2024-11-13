abstract class Media {
    private String title;
    private String publisher;

    public Media(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Publisher: " + publisher;
    }
}

class Book extends Media {
    private String author;

    public Book(String title, String publisher, String author) {
        super(title, publisher);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book - " + super.toString() + ", Author: " + author;
    }
}

class Magazine extends Media {
    private int issueNumber;

    public Magazine(String title, String publisher, int issueNumber) {
        super(title, publisher);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine - " + super.toString() + ", Issue Number: " + issueNumber;
    }
}

class DVD extends Media {
    private int duration;

    public DVD(String title, String publisher, int duration) {
        super(title, publisher);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "DVD - " + super.toString() + ", Duration: " + duration + " mins";
    }
}