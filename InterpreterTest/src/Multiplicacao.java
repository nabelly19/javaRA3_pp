import java.util.ArrayList;

public class Multiplicacao extends Operador
{
    public Multiplicacao(ArrayList<Expressao> elemento)
    { super(elemento); }

    @Override
    public char simbolo()
    { return '*'; }

    @Override
    public double resolva()
    { 
        double s = 1;
        for(Expressao e : this.elemento) {
            s = s * e.resolva();
        }
        return s; 
    }
}

