package kardex.logic;

public interface ILogicKardex {

	/**
	 * Permite registrar una compra en el Kardex, actualizando automatibamente los
	 * valores del nuevo saldo, es to es sus unidades, su valor por unidad y su
	 * valor total
	 * 
	 * @param unidades,
	 *            las unidades que se estan comprando
	 * @param valorUnidade,
	 *            el valor de cada unidad
	 * @param valorTotal,
	 *            el valor total
	 */
	public void registrarCompra(double unidades, double valorUnidade, double valorTotal);

	/**
	 * Permite registrar las ventas que se desean realizar, calculando
	 * automaticamente el nuevo saldo, esto es las unidades, el valor por unidad y
	 * el valor total
	 * 
	 * @param unidades,
	 *            aquellas que se vendieron
	 * @param valorUnidade,
	 *            el valor al que se venden las unidades
	 * @param valorTotal,
	 *            el valor total que se vendio
	 */
	public void registrarVenta(double unidades, double valorUnidade, double valorTotal);

}
