
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

    //JUSTIFICACIÓN DE RESULTADO

    /*
     El resultado falla porque inc() contiene la operacion v++ que no es atómica.
     Primero lee, luego suma y luego escribe. Son tres pasos.

     Cuando ingresas un numero de incrementos bajo como 10, los resultados coinciden.
     A partir de 1000 es muy poco probable que coincidan resultados.
        Eso se debe a que cuanto más grande es la suma, más tarda en realizarse y da tiempo a que el otro hilo acceda al valor antes de modificarlo
        y se pierden incrementos

        */



}
