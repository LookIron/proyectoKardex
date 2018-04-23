package kardex.logic;

public class Registro {

	private double unidades;
	private double valorUnidad;
	private double valorTotal;

	public Registro(double unidades, double valorUnidade, double valorTotal) {
		super();
		this.unidades = unidades;
		this.valorUnidad = valorUnidade;
		this.valorTotal = valorTotal;
	}

	public Registro() {

	}

	public double getUnidades() {
		return unidades;
	}

	public void setUnidades(double unidades) {
		this.unidades = unidades;
	}

	public double getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(double valorUnidade) {
		this.valorUnidad = valorUnidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double valorTotal(double unidades, double valorUnidade) {
		return unidades * valorUnidade;
	}

	public double valorUnidad(double unidades, double valorTotal) {
		return unidades / valorTotal;
	}

}
