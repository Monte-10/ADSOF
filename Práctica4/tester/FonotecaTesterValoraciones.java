public class FonotecaTesterValoraciones extends FonotecaTesterErrores {
    public static void main(String[] args) {
        FonotecaTesterValoraciones main = new FonotecaTesterValoraciones();
        Fonoteca fonoteca = new Fonoteca();
        main.crearMusica(fonoteca);
        main.valoraciones(fonoteca);
    }
    
    public void valoraciones(Fonoteca fonoteca) {
        Usuario usuario1 = fonoteca.registrarUsuario("Sonia Melero Vegas", "smelero"),
                usuario2 = fonoteca.registrarUsuario("Miguel Cuevas Alonso", "mcuevas");
        fonoteca.valorar(usuario1, this.canciones[0], Valoracion.DISLIKE)
                .valorar(usuario1, this.album1, Valoracion.LIKE)
                .valorar(usuario1, this.canciones[3], Valoracion.DISLIKE)
                .valorar(usuario2, this.canciones[1], Valoracion.DISLIKE);
        fonoteca.mostrarValoraciones(usuario1);
        fonoteca.mostrarValoraciones(usuario2);
    }
}
