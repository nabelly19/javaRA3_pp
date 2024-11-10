import java.util.ArrayList;
abstract public class Operador extends Expressao {

    protected ArrayList<Expressao> elemento;

    public Operador(ArrayList<Expressao> elemento) {
        this.elemento = elemento;
    }

    abstract public char simbolo();

    @Override
    public String toString() {
        String s = "("+this.simbolo();
        for (Expressao e : this.elemento) 
            s = s + " " + e.toString();

        return s+")";
    }
}