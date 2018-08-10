import java.util.Scanner;

public class Estructura {
	public ListaEnlazada lista;

	public Estructura(){
		ListaEnlazada lista = new ListaEnlazada();
		this.lista=lista;
	}
	public void agregar (int numero) {
		this.lista.insertarFin(numero);
	}
	public  double mediana() {
		double mediana=0;
		if(this.lista.size()%2==0) {
			mediana =(lista.getAt(lista.size()/2)+lista.getAt(lista.size()/2-1))/2;
		}else {
			mediana=lista.getAt(lista.size()/2);

		}
		return mediana;
	}

	public static void main(String[] args) {
		long inicio =System.currentTimeMillis();
		int b = 0;
		Estructura estructura = new Estructura();
		while (b==0) {
			b=1;
			System.out.println("To add press 1");
			System.out.println("To show median press 2");
			System.out.println("To exit press 3");
			int a=0;
			Scanner leer = new Scanner(System.in);
			a=leer.nextInt();
			switch(a) {
			case 1: 
				System.out.println("What number do you wanna add?");
				int c=leer.nextInt();
				estructura.agregar(c);
				b=0;
				break;
			case 2: 
				System.out.println("La mediana es "+estructura.mediana());
				b=0;
				break;
			case 3: 
				System.out.println("Time elapsed = "+ (System.currentTimeMillis()-inicio)+" miliseconds");
				break;
			}

		}
	}
}
