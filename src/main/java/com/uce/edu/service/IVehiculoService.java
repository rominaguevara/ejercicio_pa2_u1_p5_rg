package com.uce.edu.service;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoService {

	// CRUD (insertar, actualizar, eliminar, seleccionar, seleccionar y eliminar)
	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

	public Vehiculo seleccionar(String placa);

	public Vehiculo selcElim(String placa);

}
