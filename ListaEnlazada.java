
public class ListaEnlazada{
	private Nodo inicio,
	fin;
	private int size;

	public ListaEnlazada(){
		this.size=0;
		this.inicio = this.fin=null;
	}

	public ListaEnlazada(int[] datos) {
		// constructor de tarea
		for(int i =0; i<datos.length;i++) {
			insertarFin(datos[i]);
		}

	}
	//que pasa si la lista esta vacia?
	public double inicio () {
		if(this.size!=0){
			return this.inicio.getInfo();
		}else {
			throw new ListaVaciaExeption("Una lista vacia no tiene inicio");
		}
	}
	//que pasas si la lista esta vacia? exexpcion
	public double fin () {
		if(this.size!=0){
			return this.fin.getInfo();
		}else {
			throw new ListaVaciaExeption("Una lista vacia no tiene fin");
		}
	}

	public int size () {
		return this.size;
	}

	public boolean estaVacia() {
		return this.size==0;
	}

	public void insertarInicio(int dato) {
		Nodo tmp = new Nodo(dato,this.inicio);
		this.inicio=tmp;
		if(size==0) {
			this.fin=tmp;
		}
		this.size++;
	}

	//index out of bounds si pos<0, o mayor a size
	public void insertarEn(int pos,int dato) {
		if(pos>0&&pos<=size) {
			Nodo current = this.inicio;
			for (int i=0;i<pos;i++) {
				current=current.getNext();
			}
			Nodo tmp = new Nodo(dato,current.getNext());
			current.setNext(tmp);
			this.size++;
		}else {
			throw new IndexOutOfBoundsException("La posicion no existe");
		}
	}

	public void insertarFin(int dato) {
		if(size==0) {
			this.insertarInicio(dato);
		}else {
			Nodo tmp = new Nodo(dato);
			this.fin.setNext(tmp);
			this.fin= tmp;
			this.size++;
		}
	}



	public double borrarInicio(){

		try {
			double tmp=this.inicio.getInfo();
			this.inicio=this.inicio.getNext();
			this.size--;
			if(size==0) {
				this.fin=null;
			}
			return tmp;
		} catch (NullPointerException e) {
			throw new ListaVaciaExeption("No se puede borrar de lista vacia");
		}
	}

	public double borrarFin() {
		try{
			if(this.size==1) {
				return this.borrarInicio();
			}else {
				double tmp = this.fin.getInfo();
				Nodo current=this.inicio;
				for(int i=0;i<size-2;i++) {
					current=current.getNext();
				}
				this.fin=current;
				current.setNext(null);
				this.size--;
				return tmp;
			}
		} catch(NullPointerException ex) {
			throw new ListaVaciaExeption("No se puede borrar el fin de una lista vacia");
		}

	}

	//public E borrarEn(int pos) {
	//hacer
	//	}

	public void setAt(int pos, int dato) {
		if(pos>=0&&pos<this.size) {
			Nodo current = this.inicio;

			for(int i=0; i<pos;i++) {
				current=current.getNext();
			}
			current.setInfo(dato);
		}else {
			throw new IndexOutOfBoundsException("No se puede remplazar el dato en la posicion"+pos+"en una lista de tamaño"+ size);
		}
	}
	
	public double getAt(int pos ) {
		if (pos<0||pos>=this.size) {
			throw new IndexOutOfBoundsException("El indice no es valido para una lista de tamaño"+size);
		}
		Nodo current= this.inicio;
		for(int i =0; i<pos;i++) {
			current=current.getNext();
		}
		return current.getInfo();
	}

	public String toString() {
		String res="";
		Nodo current=this.inicio;
		for (int i=0;i<this.size;i++) {
			res+=current.getInfo()+"| ";
			current=current.getNext();
		}
		return res;
	}
	public static void main(String[] args) {
			}


}



class Nodo {
	private Nodo next;
	private  double Info;
	public Nodo( int Info, Nodo next) {
		this.next = next;
		this.Info = Info;
	}
	public Nodo(int data) {
		this(data,null);
	}
	public Nodo getNext() {
		return next;
	}
	public void setNext(Nodo next) {
		this.next = next;
	}
	public double getInfo() {
		return Info;
	}
	public void setInfo(int Info) {
		this.Info = Info;
	}

	public String toString() {
		return String.valueOf(Info);
	}
}