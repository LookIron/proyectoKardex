package kardex.logic;

import java.util.ArrayList;

public class principal {
	ArrayList<nodo> EstadoResultados;
	ArrayList<nodo> BalanceGeneral;

	public principal() {
		EstadoResultados = new ArrayList<nodo>();
		BalanceGeneral = new ArrayList<nodo>();
		BalanceGeneral.add(0,new nodo("Utilidades", nodo.PATRIMONIO, "ninguno", 0));
	}

	public void agregarAEstadoResultado(nodo nod) {
		EstadoResultados.add(nod);
	}

	public void agregarABalanceGEneral(nodo nod) {
		BalanceGeneral.add(nod);
	}

	public String buscarCostos() {
		String res = "gastos operativos"+ "\n";
		for (int i = 0; i < EstadoResultados.size(); i++) {
			if (EstadoResultados.get(i).getTipo().equals(nodo.COSTO)&& EstadoResultados.get(i).getSub_Tipo().equals(nodo.OPERATIVO) ) {
				res+=EstadoResultados.get(i).getNombre()+"\t"+"\t"+"\t"+EstadoResultados.get(i).getConcepto()+"\n";
			}
		}
		res+= "gastos no operativos" +"\n";
		for (int i = 0; i < EstadoResultados.size(); i++) {
			if (EstadoResultados.get(i).getTipo().equals(nodo.COSTO) && EstadoResultados.get(i).getSub_Tipo().equals(nodo.NOPERATIVO) ) {
				res+=EstadoResultados.get(i).getNombre()+"\t"+"\t"+"\t"+EstadoResultados.get(i).getConcepto()+"\n";
			}
		}
		return res;
	}
	public String buscaringreso() {
		String res = "ingresos operativos"+ "\n";
		for (int i = 0; i < EstadoResultados.size(); i++) {
			if (EstadoResultados.get(i).getTipo().equals(nodo.INGRESO)&& EstadoResultados.get(i).getSub_Tipo().equals(nodo.OPERATIVO) ) {
				res+=EstadoResultados.get(i).getNombre()+"\t"+"\t"+"\t"+EstadoResultados.get(i).getConcepto()+"\n";
			}
		}
		res+= "inrgesos no operativos" +"\n";
		for (int i = 0; i < EstadoResultados.size(); i++) {
			if (EstadoResultados.get(i).getTipo().equals(nodo.INGRESO) && EstadoResultados.get(i).getSub_Tipo().equals(nodo.NOPERATIVO) ) {
				res+=EstadoResultados.get(i).getNombre()+"\t"+"\t"+"\t"+EstadoResultados.get(i).getConcepto()+"\n";
			}
		}
		return res;
	}
	public String buscarPasivos() {
		String res = "Pasivos corto Plazo"+ "\n";
		for (int i = 0; i < BalanceGeneral.size(); i++) {
			if (BalanceGeneral.get(i).getTipo().equals(nodo.PASIVOS)&& BalanceGeneral.get(i).getSub_Tipo().equals(nodo.C_PLAZO) ) {
				res+=BalanceGeneral.get(i).getNombre()+"\t"+"\t"+"\t"+BalanceGeneral.get(i).getConcepto()+"\n";
			}
		}
		res+= "pasivos largo plazo" +"\n";
		for (int i = 0; i < BalanceGeneral.size(); i++) {
			if (BalanceGeneral.get(i).getTipo().equals(nodo.PASIVOS) && BalanceGeneral.get(i).getSub_Tipo().equals(nodo.L_PLAZO) ) {
				res+=BalanceGeneral.get(i).getNombre()+"\t"+"\t"+"\t"+BalanceGeneral.get(i).getConcepto()+"\n";
			}
		}
		return res;
	}
	public String buscarActivos() {
		String res = "activos corto Plazo"+ "\n";
		for (int i = 0; i < BalanceGeneral.size(); i++) {
			if (BalanceGeneral.get(i).getTipo().equals(nodo.ACTIVOS)&& BalanceGeneral.get(i).getSub_Tipo().equals(nodo.C_PLAZO) ) {
				res+=BalanceGeneral.get(i).getNombre()+"\t"+"\t"+"\t"+BalanceGeneral.get(i).getConcepto()+"\n";
			}
		}
		res+= "activos largo plazo" +"\n";
		for (int i = 0; i < BalanceGeneral.size(); i++) {
			if (BalanceGeneral.get(i).getTipo().equals(nodo.ACTIVOS) && BalanceGeneral.get(i).getSub_Tipo().equals(nodo.L_PLAZO) ) {
				res+=BalanceGeneral.get(i).getNombre()+"\t"+"\t"+"\t"+BalanceGeneral.get(i).getConcepto()+"\n";
			}
		}
		return res;
	}
	public String buscarPatrimonio() {
		String res = "";
		for (int i = 0; i < BalanceGeneral.size(); i++) {
			if (BalanceGeneral.get(i).getTipo().equals(nodo.PATRIMONIO)) {
				res+=BalanceGeneral.get(i).getNombre()+"\t"+"\t"+"\t"+BalanceGeneral.get(i).getConcepto()+"\n";
			}
		}
		return res;
	}
	public int  sumarPasivos(){
		int tot = 0;
		for (int i = 0; i < BalanceGeneral.size(); i++) {
			if (BalanceGeneral.get(i).getTipo().equals(nodo.PATRIMONIO) ||BalanceGeneral.get(i).getTipo().equals(nodo.PASIVOS) ) {
				tot+= BalanceGeneral.get(i).getConcepto();
			}
			
		}
		return tot;
	}
	public int  sumarActivos(){
		int tot = 0;
		for (int i = 0; i < BalanceGeneral.size(); i++) {
			if (BalanceGeneral.get(i).getTipo().equals(nodo.ACTIVOS)){
				tot+= BalanceGeneral.get(i).getConcepto();
			}
			
		}
		return tot;
	}	
	public int calcularUtilidad(){
		int ingreso = 0;
		int costo 	= 0;
		for (int i = 0; i < EstadoResultados.size(); i++) {
			if (EstadoResultados.get(i).getTipo().equals(nodo.COSTO)) {
				costo+= EstadoResultados.get(i).getConcepto();
			} else {
				ingreso+= EstadoResultados.get(i).getConcepto();
			}
		}

		BalanceGeneral.get(0).setConcepto(ingreso-costo);
		return ingreso-costo;
	}
}
