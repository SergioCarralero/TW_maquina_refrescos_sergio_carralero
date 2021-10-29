package com.maquina.TW_maquina_refrescos;

public class Maquina {

	private double cambios;
	private Refresco refresco;
	private int refrescosVendidos;

	public Maquina(double cambios, Refresco refresco) {
		this.cambios = cambios;
		this.refresco = refresco;
		this.refrescosVendidos = 0;
	}

	public double getCambios() {
		return cambios;
	}

	public Refresco getRefresco() {
		return refresco;
	}

	private void vender(Refresco r, double dinero) {
		if (dinero > 0) {
			if (r.getStock() > 0) {
				r.setStock(-1);
				refrescosVendidos++;
				double dineroDevuelto = dinero - r.getPrecio();

				if (dineroDevuelto > this.cambios) {
					System.out.println("No hay cambios");
				} else {
					cambios += r.getPrecio();
					System.out.println(dineroDevuelto);
				}

			} else {
				System.out.println("No quedan refrescos");
			}
		} else {
			System.out.println("El dinero ingresado no puede ser negativo");
		}
	}

	private String generarInforme(Refresco r) {
		String s = "Se han vendido " + this.refrescosVendidos + " y su precio total de ventas es "
				+ r.getPrecio() * this.refrescosVendidos;
		System.out.println(s);
		return s;
	}

	private String mostrarEstado(Refresco r) {
		String s = "Quedan " + r.getStock() + " refrescos y quedan " + this.cambios + " cambios";
		System.out.println(s);
		return s;
	}

	public static void main(String[] args) {
		Refresco r = new Refresco(2, 3, "");
		Maquina m = new Maquina(20, r);

		m.mostrarEstado(r);
		m.vender(r, 5);
		m.mostrarEstado(r);
		m.vender(r, -2);
		m.vender(r, 6);
		m.generarInforme(r);
	}

}
