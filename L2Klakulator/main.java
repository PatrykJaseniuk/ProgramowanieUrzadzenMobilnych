public class main {
    
    public static void main(String[] args) {
        Kalkulator k = new Kalkulator();

        System.out.println("witam!");

        boolean b1 = k.putOperator(Kalkulator.Operator.add);

        boolean b2 = k.putArgument(10);

        boolean b3 = k.putOperator(Kalkulator.Operator.add);

        boolean b4 = k.putArgument(1);

        boolean b5 = k.putOperator(Kalkulator.Operator.add);

        boolean b6 = k.putArgument(1);

        float resolve = k.getResult();       
    }
}
