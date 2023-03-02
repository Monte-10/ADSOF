package nodos;
public class TesterVerticesArcos {
    public static void main(String[] args) {
        Vertice[] ciudades = {new Vertice("Madrid"),
                            new Vertice("Barcelona"),
                            new Vertice("Bilbao"),
                            new Vertice("Valencia")};
        
        for (Vertice v : ciudades)
            System.out.print(v+" ");

        System.out.println("\n\nComprobamos que los id de los vértices son correctos\n");

        for (Vertice v : ciudades)
            System.out.println(v+" ");
        
        System.out.println();
        
        Arco carreteras[] = {new Arco(ciudades[0], ciudades[1], "506 km"),
                            new Arco(ciudades[1], ciudades[2], "645 km"),
                            new Arco(ciudades[0], ciudades[3], "350 km"),
                            new Arco(ciudades[3], ciudades[1], "350 km")};
        
        for (Arco a : carreteras)
            System.out.println(a);

        System.out.println("\nComprobamos que los id de los arcos son correctos\n");

        for (Arco a : carreteras)
            System.out.println(a);
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