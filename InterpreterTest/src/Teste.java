
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

        //novas implementações

        Expressao n = new Constante(10.0);
        Expressao c1_new = new Constante(20.0);
        Expressao c2_new = new Constante(40.0);
        Expressao v1_new = new Variavel("v1", 10.0);
        Expressao v2_new = new Variavel("v2", 100.0);

        programa.add(n);
        programa.add(c1_new);
        programa.add(c2_new);
        programa.add(v1_new);
        programa.add(v2_new);

        // Fatorial de n: (! n)
        ArrayList<Expressao> listaFat = new ArrayList<Expressao>();
        listaFat.add(n);
        Expressao fat = new Fatorial(listaFat);
        programa.add(fat);

        // Soma: (+ c1 v1 fat)
        ArrayList<Expressao> listaAdicao = new ArrayList<Expressao>();
        listaAdicao.add(c1_new);
        listaAdicao.add(v1_new);
        listaAdicao.add(fat);
        Expressao a_new = new Adicao(listaAdicao);
        programa.add(a_new);

        // Subtração: (- (+ c1 v1) v1)
        ArrayList<Expressao> listaSubtracao = new ArrayList<Expressao>();
        listaSubtracao.add(a_new);
        listaSubtracao.add(v1_new);
        Expressao s_new = new Subtracao(listaSubtracao);
        programa.add(s_new);

        // Divisão: (/ (- (+ c1 v1) v1) (+ c1 v1))
        ArrayList<Expressao> listaDivisao = new ArrayList<Expressao>();
        listaDivisao.add(s_new);
        listaDivisao.add(a_new);
        Expressao d_new = new Divisao(listaDivisao);
        programa.add(d_new);

        // Multiplicação: (* (+ c1 v1) (- (+ c1 v1) v1))
        ArrayList<Expressao> listaMultiplicacao = new ArrayList<Expressao>();
        listaMultiplicacao.add(a_new);
        listaMultiplicacao.add(s_new);
        Expressao m_new = new Multiplicacao(listaMultiplicacao);
        programa.add(m_new);


        //implementação existente
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