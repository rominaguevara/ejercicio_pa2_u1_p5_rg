package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	public List<Propietario> base = new ArrayList<Propietario>();

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		base.add(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Propietario propietario = this.selcElim(cedula);
		base.remove(propietario);
	}

	@Override
	public Propietario seleccionar(String cedula) {
		// TODO Auto-generated method stub
		for (Propietario propietario : base) {
			if (propietario.getCedula().equals(cedula)) {
				Propietario prop = new Propietario();
				prop.setNombre(propietario.getNombre());
				prop.setApellido(propietario.getApellido());
				prop.setCedula(propietario.getCedula());
				prop.setGenero(propietario.getGenero());

				return prop;
			}
		}
		return null;
	}

	@Override
	public Propietario selcElim(String cedula) {
		// TODO Auto-generated method stub
		for (Propietario propietario : base) {
			if (propietario.getCedula().equals(cedula)) {
				return propietario;
			}
		}
		return null;
	}
}