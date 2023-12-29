public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());

        System.out.println("     ");

        SalesTracker tracker = new SalesTracker();
        tracker.addSale("Товар1",4);
        tracker.addSale("Товар2",5);
        tracker.addSale("Товар1",4);
        tracker.addSale("Товар3",6);
        System.out.println("Общая сумма продаж: " + tracker.getTotalSales());
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularItem());
    }
}
