import java.util.ArrayList;

public class Adicao extends Operador
{
    public Adicao(ArrayList<Expressao> elemento)
    { super(elemento); }

    @Override
    public char simbolo()
    { return '+'; }

    @Override
    public double resolva()
    { 
        double s = 0;
        for(Expressao e : this.elemento) {
            s = s + e.resolva();
        }
        return s; 
    }
}
