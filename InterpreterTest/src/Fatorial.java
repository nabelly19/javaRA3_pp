public class Fatorial extends Expressao {
    private Expressao operando;

    public Fatorial(Expressao operando) {
        this.operando = operando;
    }

    @Override
    public double resolva() {
        int valor = (int) operando.resolva();
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
    public String toString() {
        return "(! " + operando.toString() + ")";
    }
}