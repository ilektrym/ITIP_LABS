public abstract class Book {
    protected String title;
    protected String author;
    protected int year;
    public static int totalBooks = 0;
    
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        totalBooks += 1;
    }
    
    public abstract void printInfo();
    
    public abstract void read();
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public static int getTotalBooks() {
        return totalBooks;
    }
}