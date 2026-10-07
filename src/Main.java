//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    //Pido el numero de incrementos por Scanner
    Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de incrementos");
       int incrementos = sc.nextInt();

       //Instancia unica de variable
   VariableCompartida variableCompartida = new VariableCompartida();
   variableCompartida.set(0); // v = 0;

    //creo las hebras que comparten misma variable y numero de incrementos.
   Hebra h1 = new Hebra(variableCompartida,incrementos);
   Hebra h2 =new Hebra(variableCompartida,incrementos);

   //inicio cada hebra
   h1.start();
   h2.start();

   //Hago que esperen en el main
   try {
       h1.join();
       h2.join();
   } catch (InterruptedException e) {
       throw new RuntimeException(e);
   }


    System.out.println("Incrementos por hebra: " + incrementos);
    System.out.println("Valor esperado       : " + (2 * incrementos));
    System.out.println("Valor final de v     : " + variableCompartida.get());

}
