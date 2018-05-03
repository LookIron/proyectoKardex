package kardex.logic;

public class nodo {
	public static final String INGRESO = "ingreso";
	public static final String COSTO = "costo";
	public static final String PASIVOS = "pasivos";
	public static final String ACTIVOS = "activos";
	public static final String PATRIMONIO = "patrimonio";
	public static final String L_PLAZO = "largo plazo";
	public static final String C_PLAZO = "corto plazo";
	public static final String OPERATIVO = "operativo";
	public static final String NOPERATIVO = "no operativo";
	String nombre;
	String tipo;
	String sub_Tipo;
	double concepto;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSub_Tipo() {
		return sub_Tipo;
	}
	public void setSub_Tipo(String sub_Tipo) {
		this.sub_Tipo = sub_Tipo;
	}
	public double getConcepto() {
		return concepto;
	}
	public void setConcepto(double concepto) {
		this.concepto = concepto;
	}
	
	public nodo(String nombre, String tipo, String sub_Tipo, double concepto) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.sub_Tipo = sub_Tipo;
		this.concepto = concepto;
	}
	

}
