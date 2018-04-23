package kardex.logic;

import java.util.Stack;

public class LogicKardex implements ILogicKardex {

	private Stack<Registro> entradaCompras;
	private Stack<Registro> salidaVentas;
	private Stack<Registro> saldo;

	public LogicKardex(double saldoInicialUnid, double saldoInicialValUnid, double saldoInicialValTotal) {
		Registro saldoInicial = new Registro(saldoInicialUnid, saldoInicialValUnid, saldoInicialValTotal);
		saldo = new Stack<Registro>();
		saldo.push(saldoInicial);

	}

	public double getSaldoUnidades() {
		Registro saldoInicial = saldo.peek();
		return saldoInicial.getUnidades();
	}

	public void setSaldoUnidades(double saldoInicialUnid) {
		Registro saldoInicial = saldo.pop();
		saldoInicial.setUnidades(saldoInicialUnid);
		saldo.push(saldoInicial);
	}

	public double getSaldoValorUnidad() {
		Registro saldoInicial = saldo.peek();
		return saldoInicial.getValorUnidad();
	}

	public void setSaldoValorUnidad(double saldoInicialValUnid) {
		Registro saldoInicial = saldo.pop();
		saldoInicial.setValorUnidad(saldoInicialValUnid);
		saldo.push(saldoInicial);
	}

	public double getSaldoValorTotal() {
		Registro saldoInicial = saldo.peek();
		return saldoInicial.getValorTotal();
	}

	public void setSaldoValorTotal(double saldoInicialValTotal) {
		Registro saldoInicial = saldo.pop();
		saldoInicial.setValorTotal(saldoInicialValTotal);
		saldo.push(saldoInicial);
	}

	@Override
	public void registrarCompra(double unidades, double valorUnidade, double valorTotal) {

	}

	@Override
	public void registrarVenta(double unidades, double valorUnidade, double valorTotal) {
		// TODO Auto-generated method stub

	}

}
