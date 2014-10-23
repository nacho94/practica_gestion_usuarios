import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

class MiComparador implements Comparator <String> {
	public void dd(String msj) {
		System.out.println(msj);
	}
	public boolean isNumber(char x) {
		return x >=48 && x<=57;

	}
	public int compare (String a, String b) {
		//dd("a = " + a + "--b = " + b);
		

		int l = a.length() < b.length() ? a.length() : b.length(); 
		//dd("l = " + Integer.toString(l));
		for (int i = 0; i<l;i++) {

			if(a.charAt(i) != b.charAt(i)) {
				if(isNumber(a.charAt(i)) ^ isNumber(b.charAt(i)) ) {
					if (a.charAt(i) > b.charAt(i)) {
						return -1;

					} else {
						return 1;
					}
				}
				if (a.charAt(i) > b.charAt(i)) {
					return 1;
				} else {
					return -1;
				}
			} 
		}
		if(a.length() < b.length()) {
			return -1;
		} else if(a.length() > b.length()){
			return 1;
		}
		return 0;
	}
}

public class GestionUsuarios {



	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		ArrayList <String> c1 = new ArrayList<String>();
		ArrayList <String> c2 = new ArrayList<>();
		
		ArrayList <String> contrasenas_c1 = new ArrayList <String>();
		ArrayList <String> contrasenas_c2 = new ArrayList <String>();
		
		ArrayList <String> contrasenas = new ArrayList <String>();
		ArrayList <String> repetidas = new ArrayList <String>();
		
		String conjunto1, conjunto2;
		
		
		conjunto1=scan.nextLine();
		conjunto2=scan.nextLine();

		//conjunto1 = "usuario1 password1 usuario2 password2 usuario3 pass";
		//conjunto2 = "usuario10 password1 usuario3 pass2";
		scan.close();
		
		c1=separador(conjunto1);
		c2=separador(conjunto2);
		
		
		contrasenas_c1=generaContrasenas(c1);
		contrasenas_c2=generaContrasenas(c2);
		
		contrasenas=guardaContrasenas(contrasenas_c1, contrasenas_c2);
		repetidas=guardaRepetidas(contrasenas_c1, contrasenas_c2);
		
		
		/*print(contrasenas_c1);
		print(contrasenas_c2);
		print(contrasenas);*/
		

		contrasenas = eliminarContrasenas(contrasenas,repetidas);

		
		print(ordenar(contrasenas));
		print(repetidas);
		/*ArrayList <String> a = new ArrayList <String>();
		a.add("casi");
		a.add("casae");
		print(ordenar(a)); */
	}
	
	public static ArrayList <String> separador (String conjunto) {
		
		ArrayList <String> separador = new ArrayList<>();
		
		Scanner scan = new Scanner(conjunto);
		
		while(scan.hasNext()){
			separador.add(scan.next());
		}
		
		scan.close();
		
		return separador;
		
	}
	
	
	public static ArrayList <String> generaContrasenas(ArrayList <String> conjunto) {
		ArrayList <String> contrasenas = new ArrayList <String>();
		
		for(int i=0;i<conjunto.size();i++){
			if(i%2!=0)
				contrasenas.add(conjunto.get(i));
		}
		
		return contrasenas;
		
		
	}
	public static ArrayList <String> guardaContrasenas(ArrayList <String> contrasenas1, ArrayList <String> contrasenas2) {
		
		ArrayList <String> contrasenas = new ArrayList <String>();

		for(int i=0;i<contrasenas1.size();i++){
			contrasenas.add(contrasenas1.get(i));
		}
			
		for(int i=0;i<contrasenas2.size();i++){
			contrasenas.add(contrasenas2.get(i));
		}
			
		return contrasenas;
	}
	
	public static ArrayList <String> guardaRepetidas(ArrayList <String> contrasenas1, ArrayList <String> contrasenas2){
		
		ArrayList <String> repetidas = new ArrayList <String>();

		for(int i=0;i<contrasenas1.size();i++){
			for(int j=0;j<contrasenas2.size();j++){
				if(contrasenas1.get(i).equals(contrasenas2.get(j)))
					repetidas.add(contrasenas1.get(i));
			}
		}
		return repetidas;
	}

	public static void print ( ArrayList <String> contrasenas) {
		for(int i=0;i<contrasenas.size(); i++){
                System.out.print(contrasenas.get(i));
                if(i<contrasenas.size() - 1) 
                    System.out.print(" ");
            }
            System.out.println();
	}
	
	public static ArrayList <String> eliminarContrasenas(ArrayList <String> conjunto , ArrayList <String> duplicadas) {

		for (int i = 0; i<conjunto.size(); i++ ) {
			for(int j=0; j<duplicadas.size(); j++) {
				if(conjunto.get(i).equals(duplicadas.get(j)))
					conjunto.remove(i);
			
			}
			
		}
		return guardaContrasenas(conjunto,duplicadas);

	}

	public static ArrayList <String> ordenar ( ArrayList <String> conjunto) {
		Collections.sort(conjunto, new MiComparador());

		return conjunto;
	}
}	
		