public class Audiobook extends Book {
    private String narrator;
    private int duration;
    private String narrator_2;
    
    public Audiobook(String title, String author, int year, String narrator, int duration) {
        super(title, author, year);
        this.narrator = narrator;
        this.duration = duration;
    }

    public Audiobook(String title, String author, int year, String narrator, String narrator_2, int duration) {
        super(title, author, year);
        this.narrator = narrator;
        this.narrator_2 = narrator_2;
        this.duration = duration;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Audiobook: " + getTitle() + " Author: " + getAuthor() + ", Year: " + getYear() + ", Narrator: " + getNarrator() + ", Narrator2: " + getNarrator_2() +  ", Duration:" + getDuration() + " hours");
    }
    
    @Override
    public void read() {
        System.out.println("Playing " + getTitle() + " audiobook");
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNarrator_2() {
        return narrator_2;
    }

    public void setNarrator_2(String narrator_2) {
        this.narrator_2 = narrator_2;
    }
    
}
