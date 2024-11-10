import java.util.ArrayList;

public class Subtracao extends Operador {

    public Subtracao(ArrayList<Expressao> elemento) {
        super(elemento);
    }

    @Override
    public char simbolo() {
        return '-';
    }

    @Override
    public double resolva(){
        double s = 0;
        boolean flag = true;
        for (Expressao e : this.elemento) {
            if (flag) {
                s = e.resolva();
                flag = false;
            } else {
                s = s - e.resolva();
            }
        }
        return s;
    }
}