package com.maquina.TW_maquina_refrescos;

public class Refresco {

	private String nombre;
	private double precio;
	private int stock;
	private int cantidadVendida;
//	private Tipo tipo;

	public Refresco(double precio, int stock, String nombre) {
		this.precio = precio;
		this.stock = stock;
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (this.stock > 0) {
			this.stock += stock;
		}
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void sumarCantidad(int cantidadVendida) {
		this.cantidadVendida += cantidadVendida;
	}

	public String getNombre() {
		return nombre;
	}
}
