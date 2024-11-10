abstract public class Operando extends Expressao
{
    protected double valor;

    public Operando(double valor)
    { this.valor = valor; }

    @Override
    public String toString()
    { return ""+this.valor; }

    @Override
    public double resolva()
    { return this.valor; }
}