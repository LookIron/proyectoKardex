package Test;

import java.text.DecimalFormat;

import kardex.logic.LogicKardex;


public class Prueba {

	private LogicKardex kardex = new LogicKardex(1079, 1400, 1510600);

	void test() {

		System.out.println("-----------------------Compra-----------------------");
		kardex.registrarCompra(8000, 1500, 12000000);

		// Con formato
		DecimalFormat df = new DecimalFormat("#.00");
		String unidades = df.format(kardex.getSaldoUnidades());
		String valorUnidades = df.format(kardex.getSaldoValorUnidad());
		String Total = df.format(kardex.getSaldoValorTotal());
		System.out.println(unidades + " - " + valorUnidades + " - " + Total);

		// Sin formato

		int und = (int) kardex.getSaldoUnidades();
		int valUnds = (int) kardex.getSaldoValorUnidad();
		int tot = (int) kardex.getSaldoValorTotal();
		System.out.println("Unidades: " + und);
		System.out.println("Valor Unidades: " + valUnds);
		System.out.println("Total: " + tot);

		// -----------------------------------------------------------------------------
		// -----------------------------------------------------------------------------

		int mul = 6500 * valUnds;
		System.out.println("-----------------------Venta-----------------------" + (13510600 - mul));

		kardex.registrarVenta(6500, valUnds, 6500 * valUnds);

		// Asì lo recibiriamos
		DecimalFormat df1 = new DecimalFormat("#.00");
		String unida = df1.format(kardex.getSaldoUnidades());
		String valorUnida = df1.format(kardex.getSaldoValorUnidad());
		String Tota = df1.format(kardex.getSaldoValorTotal());
		System.out.println(unida + " - " + valorUnida + " - " + Tota + "------" + mul);

		// -----------------------------------------------------------------------------
		// -------------------------------Ejemplo----------------------------------------------

		// Asi lo enviariamos, con el nuevo formato
		double nuevaUnidad = Double.parseDouble(unida);
		double nuevoValorUnidad = Double.parseDouble(valorUnida);
		double nuevoTotal = Double.parseDouble(Tota);

	}

}
