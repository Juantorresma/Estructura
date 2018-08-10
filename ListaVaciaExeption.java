
public class ListaVaciaExeption extends RuntimeException{
	public ListaVaciaExeption () {
		this("La lista esta vacia");
	}
	public ListaVaciaExeption(String msj) {
		super(msj);
	}
}
