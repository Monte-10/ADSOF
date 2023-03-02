package ciudades;
public class TesterVerticesArcos {
    public static void main(String[] args) {
        Vertice[] ciudades = {new Vertice("Madrid"),
                            new Vertice("Barcelona"),
                            new Vertice("Bilbao"),
                            new Vertice("Valencia")};
        
        for (Vertice v : ciudades)
            System.out.print(v+" ");

        for (Vertice v : ciudades)
            System.out.print(v+" ");
        
        System.out.println();
        
     
    }
    }

    /*
    Salida esperada: 
    
    Madrid(0) Barcelona(1) Bilbao(2) Valencia(3)
    506 km(0): Madrid -- Barcelona
    645 km(1): Barcelona -- Bilbao
    350 km(2): Madrid -- Valencia
    350 km(3): Valencia – Barcelona
     */