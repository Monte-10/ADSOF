import java.util.*;

public class SecuenciaSkiponacci {
    private List<Integer> secuencia;
    private int pos1, pos2;

    public SecuenciaSkiponacci(int pos1, int pos2, List<Integer> tipo, int longitud) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.secuencia = new ArrayList<>(tipo);

        while (this.secuencia.size()<longitud)
        this.next();
    }

    @Override
    public String toString() {
        return this.secuencia.toString();
    }

    public int next() {
        int numElementos = this.secuencia.size();
        int proxElemento = this.secuencia.get(numElementos-this.pos1)+this.secuencia.get(numElementos-this.pos2);
        this.secuencia.add(proxElemento);
        return proxElemento;
    }

    public boolean esSecuencia(List<Integer> sec) {
        int tamano = sec.size();
        List<Integer> tipo;
        if (this.pos1==1 && this.pos2==2 && tamano<2) return false;
        else if (this.pos1==2 && this.pos2==3 && tamano<3) return false;
        if (sec.get(0) == 0) tipo = List.of(0, 1);
        else if (sec.get(0) == 1) tipo = List.of(1, 1, 1);
        else if (sec.get(0) == 3) tipo = List.of(3, 0, 2);
        else return false;
        SecuenciaSkiponacci sp = new SecuenciaSkiponacci(this.pos1, this.pos2, tipo, tamano);
        return sp.secuencia.equals(sec);
    }
    public static void main (String ...args) {
        SecuenciaSkiponacci padovan = new SecuenciaSkiponacci(2, 3, List.of(1, 1, 1), 10);
        SecuenciaSkiponacci perrin = new SecuenciaSkiponacci(2, 3, List.of(3, 0, 2), 10);
        SecuenciaSkiponacci fibonacci = new SecuenciaSkiponacci(1, 2, List.of(0, 1), 10);
        System.out.println("Padovan[10] : "+ padovan);
        System.out.println("Perrin[10] : "+ perrin);
        System.out.println("Fibonacci[10]: "+ fibonacci);
        System.out.println("Fibonacci(11): "+ fibonacci.next());
        System.out.println("Fibonacci[11]: "+ fibonacci);
        System.out.println("Es Fibonacci?: "+ fibonacci.esSecuencia(List.of(0, 1, 1, 2, 3)));
        System.out.println("Es Perrin?: "+ perrin.esSecuencia(List.of(3, 0, 2, 4)));
    }
    }
    