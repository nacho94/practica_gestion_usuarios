import java.util.ArrayList;
import java.util.Scanner;

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
		
		scan.close();
		
		c1=separador(conjunto1);
		c2=separador(conjunto2);
		
		
		contrasenas_c1=generaContrasenas(c1);s
		contrasenas_c2=generaContrasenas(c2);
		
		contrasenas=guardaContrasenas(contrasenas_c1, contrasenas_c2);
		repetidas=guardaRepetidas(contrasenas_c1, contrasenas_c2);
		
		
		print(contrasenas_c1);
		print(contrasenas_c2);
		print(contrasenas);
		print(repetidas);
		
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
                if(i<contrasenas.size()) 
                    System.out.print(" ");
            }
            System.out.println();
	}
	
	
}	
		