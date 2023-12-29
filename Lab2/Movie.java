public class Movie extends Book {
    private String director;
    private int duration;
    private String composer;
    
    public Movie(String title, String author, int year, String director, String composer, int duration) {
        super(title, author, year);
        this.director = director;
        this.composer = composer;
        this.duration = duration;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Movie: " + getTitle() + " Author: " + getAuthor() + ", Year: " + getYear() + ", Director: " + getDirector() + " Composer:" + getComposer() + ", Duration: " + getDuration() + " minutes");
    }
    
    @Override
    public void read() {
        System.out.println("Watching " + getTitle() + " movie");
    
    }  
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getComposer(){
        return composer;
    }
}