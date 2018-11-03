package patterns.decorator;

public class Guest {
    public static void main(String[] args) {
       Coffee lattee = new Espresso();
       lattee = new WithChocolate(lattee);
       System.out.println(lattee.getIngredient().toString());
       lattee = new WithMilk(lattee);
       System.out.println(lattee.getIngredient().toString());
       lattee = new WithMilk(lattee);
       System.out.println(lattee.getIngredient().toString());

       System.out.println(lattee.getPrice());
       System.out.println(lattee.getName());
    }
}
