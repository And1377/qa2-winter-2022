import org.junit.jupiter.api.Test;

public class ObjectsPractice {
    @Test
    public void workingWithOrders() {
        Order firstOrder = new Order();

        firstOrder.setTotalPrice(12.34);
        firstOrder.setAddress("Rigas str. 22");
        firstOrder.setItemCount(9);

        Order secondOrder = new Order();
        secondOrder.setTotalPrice(55.67);
        secondOrder.setAddress("Lubanas str. 43-13");
        secondOrder.setItemCount(3);
        System.out.println("Hello, world!");
        System.out.println("1st order:");
        System.out.println(firstOrder.getTotalPrice());
        System.out.println("2nd order:");
        System.out.println(secondOrder.getTotalPrice());

    }
}
