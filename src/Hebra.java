

public class Hebra  extends Thread{

        private final VariableCompartida variable;
        private final int incrementos;

        //La hebra se compone de un a VariablCompartida y el n de incrementos
        public Hebra(VariableCompartida variable, int incrementos){
            this.variable = variable;
            this.incrementos = incrementos;
        }

        //Sobreescribo run y aplico el metodo inc
        @Override
    public void run(){
            for (int i = 0; i <incrementos ; i++) {
                variable.inc();
            }
    }

}
