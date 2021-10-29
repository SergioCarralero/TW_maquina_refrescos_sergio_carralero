package com.maquina.TW_maquina_refrescos;

public class Maquina2 {

	private double cambios;
	private Refresco[] refrescos;
//	private int refrescosVendidos;

	public Maquina2(double cambios, Refresco[] refrescos) {
		this.cambios = cambios;
		this.refrescos = refrescos;
//		this.refrescosVendidos = 0; Ahora esto esta en el refresco para saber cuantos refrescos se han vendido de cada uno y asi poder hacer un informe mas detallado
	}

	public double getCambios() {
		return cambios;
	}

	public Refresco getRefresco(int i) {
		return refrescos[i];
	}

	private void vender(double dinero, int posicion) {
		System.out.println("--VENDER--");
		Refresco refrescoAVender = refrescos[posicion];
		if (dinero > 0) {
			if (refrescoAVender.getStock() > 0) {
				refrescoAVender.setStock(-1);
				refrescoAVender.sumarCantidad(1);
				double dineroDevuelto = dinero - refrescoAVender.getPrecio();

				if (dineroDevuelto > this.cambios) {
					System.out.println("No hay cambios");
				} else {
					cambios += refrescoAVender.getPrecio();
					System.out.println(
							"Se ha vendido el refresco: " + refrescos[posicion].getNombre() + " que tiene un precio de "
									+ refrescos[posicion].getPrecio() + "€. Quedan " + refrescos[posicion].getStock());
					System.out
							.println("El dinero introducido ha sido: " + dinero + "€. Y el dinero devuelto ha sido de "
									+ dineroDevuelto + "€. Quedan " + this.cambios + "€.");
					System.out.println("--FIN VENDER--");

				}

			} else {
				System.out.println("No quedan refrescos");
			}
		} else {
			System.out.println("El dinero ingresado no puede ser negativo");
		}
	}

	private String mostrarEstado(Refresco[] refrescos) {
		System.out.println("--Estado de la maquina--");
		int refrescosTotalesRestantes = 0;
		for (int i = 0; i < refrescos.length; i++) {
			refrescosTotalesRestantes += refrescos[i].getStock();
		}
		String s = "Quedan " + refrescosTotalesRestantes + " refrescos y quedan " + this.cambios + " cambios";
		System.out.println(s);
		return s;
	}

	private void generarInforme(Refresco[] refrescos) {
		System.out.println("--Informe--");
		int refrescosTotalesVendidos = 0;
		double precioTotalDeVentas = 0;
		for (int i = 0; i < refrescos.length; i++) {
			refrescosTotalesVendidos += refrescos[i].getCantidadVendida();
			precioTotalDeVentas += refrescos[i].getPrecio() * refrescos[i].getCantidadVendida();
		}
		String s = "Se han vendido " + refrescosTotalesVendidos + " refrescos y su precio total de ventas es "
				+ precioTotalDeVentas + "€";
		System.out.println(s);
	}

	public static void main(String[] args) {
		Refresco[] refrescos = { new Refresco(3, 5, "coca-cola"), new Refresco(2, 4, "fanta"),
				new Refresco(5, 8, "kas") };
		Maquina2 m = new Maquina2(20, refrescos);

		m.mostrarEstado(refrescos);

		m.vender(5, 0);
		m.vender(5, 1);
		m.vender(5, 2);
		m.mostrarEstado(refrescos);
		m.vender(-1, 2);
		m.vender(2, 1);
		m.generarInforme(refrescos);
	}

}
