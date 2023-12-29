public class Main {
    public static void main(String[] args) {

        Audiobook audiobook1 = new Audiobook("Слава королю", "Mad Blade During Troubled Times", 2019, "Вася", 380);
        Audiobook audiobook2 = new Audiobook("Три мушкетера", "Дюма Александр", 1844, "Горбунов Сергей", "Вася",  29);
        audiobook1.setNarrator("Петя");
        audiobook1.printInfo();
        audiobook1.read();
        
        System.out.println();

        audiobook2.printInfo();
        audiobook2.read();

        System.out.println();
        
        Movie movie1 = new Movie("Мушкетёры", "Дюма Александр", 2011, "Пол У. С. Андерсон"," Пол Хаслингер ", 110);
        movie1.printInfo();
        movie1.read();
        
        System.out.println();
        
        Musical musical = new Musical();
        musical.printInfo();
        musical.read();
        System.out.println("TotalBooks " + Book.getTotalBooks());
        
    }

}