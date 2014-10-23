

all:
	javac GestionUsuarios.java

run: all
	java GestionUsuarios

.PHONY: clean

clean:
	rm -f *.class
