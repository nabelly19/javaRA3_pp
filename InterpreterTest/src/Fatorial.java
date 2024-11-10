import java.util.ArrayList;

public class Fatorial extends Operador {

    public Fatorial(ArrayList<Expressao> elemento) {
        super(elemento);
        if (elemento.size() != 1) {
            throw new IllegalArgumentException("O operador fatorial deve ter exatamente um operando.");
        }
    }

    @Override
    public double resolva() {
        int valor = (int) elemento.get(0).resolva();
        if (valor < 0) {
            throw new IllegalArgumentException("Fatorial de número negativo não é definido.");
        }
        return calcularFatorial(valor);
    }

    private int calcularFatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calcularFatorial(n - 1);
    }

    @Override
    public char simbolo() {
        return '!';
    }

    @Override
    public String toString() {
        return "(! " + elemento.get(0).toString() + ")";
    }
}
