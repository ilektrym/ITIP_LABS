public class Musical extends Book {
    private String authorScript;
    private int duration;
    private String composer;
    
    public Musical() {
        super("title", "author", 0);
    }
    @Override
    public void printInfo() {
        System.out.println("Musical: " + getTitle() + " Author: " + getAuthor() + ", Year: " + getYear() + ", AuthorScript: " + getAuthorScript() + ", Composer:" + getComposer()+ ", Duration: " + getDuration() + " minutes");
    }
    
    @Override
    public void read() {
        System.out.println("Listening to " + getTitle() + " musical");
    }

    public String getAuthorScript() {
        return authorScript;
    }

    public void setAuthorScript(String authorScript) {
        this.authorScript = authorScript;
    }
    
    public int getDuration() {
        return duration;
    }

    public String getComposer(){
        return composer;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}