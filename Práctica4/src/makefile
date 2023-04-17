JC = javac
JV = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = fonoteca/Album.java fonoteca/Cancion.java fonoteca/EstiloMusical.java fonoteca/Fonoteca.java fonoteca/ListaMusica.java tester/FonotecaTester.java tester/FonotecaTesterErrores.java tester/FonotecaTesterValoraciones.java tester/FonotecaTesterPopularidad.java tester/FonotecaTesterAfinidad.java

MAIN = tester/FonotecaTesterAfinidad

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JV) $(MAIN)

clean:
	$(RM) */*.class
