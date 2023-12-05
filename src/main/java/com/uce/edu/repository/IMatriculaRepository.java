package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaRepository {
	// CRUD (insertar, actualizar, eliminar, seleccionar, seleccionar y eliminar)
	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String cedula);

	public Matricula seleccionar(String cedula);

	public Matricula selcElim(String cedula);
}
