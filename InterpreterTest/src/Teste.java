
import java.util.ArrayList;

public class Teste
{
    public static void execute()
    {
        ArrayList<Expressao> programa = new ArrayList<Expressao>();
        ArrayList<Expressao> la       = new ArrayList<Expressao>();
        ArrayList<Expressao> ls       = new ArrayList<Expressao>();
        ArrayList<Expressao> ld       = new ArrayList<Expressao>();
        ArrayList<Expressao> lm       = new ArrayList<Expressao>();

        Expressao c1 = new Constante(20.0); 
        programa.add(c1);
        
        Expressao c2 = new Constante(40.0); 
        programa.add(c2);
        
        Expressao v1 = new Variavel("v1", 10); 
        programa.add(v1);
        
        Expressao v2 = new Variavel("v2", 100); 
        programa.add(v2);
        
        la.add(c1); 
        la.add(v1);
        Expressao a = new Adicao(la); 
        programa.add(a);
        // la = (c1, v1);   a = (+ c1, v1)
        
        ls.add(a); 
        ls.add(v1);  
        Expressao s = new Subtracao(ls); 
        programa.add(s);
        // ls = (  (+ c1, v1), v1) 
        //  s = (- (+ c1, v1), v1)
        
        ld.add(s); 
        ld.add(a);    
        Expressao d = new Divisao(ld); 
        programa.add(d);
        // ld = (  (- (+ c1, v1), v1) (+ c1, v1))
        // d  = (/ (- (+ c1, v1), v1) (+ c1, v1))
        
        lm.add(a); 
        lm.add(s);
        Expressao m = new Multiplicacao(lm); 
        programa.add(m);
        // lm = (  (+ c1, v1), (- (+ c1, v1), v1))
        // m  = (* (+ c1, v1), (- (+ c1, v1), v1))
        
        // mostre a string de cada expressao (toString) e 
        // também o seu resultado (resolva).
	for ( Expressao p : programa)
            System.out.println(p.toString()+ " = " + p.resolva());
    }
    
    public static void main(String [] args){
        Teste.execute();
    }

}