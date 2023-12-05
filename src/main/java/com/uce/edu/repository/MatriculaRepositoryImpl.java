package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	public List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		base.add(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.eliminar(matricula.getPropietario().getCedula());
		this.insertar(matricula);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Matricula matricula = this.selcElim(cedula);
		base.remove(matricula);
	}

	@Override
	public Matricula seleccionar(String cedula) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula)) {
				Matricula mat = new Matricula();
				mat.setPropietario(matricula.getPropietario());
				mat.setVehiculo(matricula.getVehiculo());
				mat.setFechaMatricula(matricula.getFechaMatricula());
				mat.setValorMatricula(matricula.getValorMatricula());

				return mat;
			}
		}
		return null;
	}

	@Override
	public Matricula selcElim(String cedula) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getCedula().equals(cedula)) {
				return matricula;
			}
		}
		return null;
	}

}
