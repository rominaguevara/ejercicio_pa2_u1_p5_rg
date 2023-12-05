package com.uce.edu.service;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietaroService {
	// CRUD (insertar, actualizar, eliminar, seleccionar, seleccionar y eliminar)
	public void insertar(Propietario propietario);

	public void actualizar(Propietario propietario);

	public void eliminar(String cedula);

	public Propietario seleccionar(String cedula);

	public Propietario selcElim(String cedula);
}
