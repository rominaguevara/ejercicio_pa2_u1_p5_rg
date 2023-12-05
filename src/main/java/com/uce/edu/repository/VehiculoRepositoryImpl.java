package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	
	public List<Vehiculo> base = new ArrayList<Vehiculo>();
	
			@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		base.add(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.selcElim(placa);
		base.remove(vehiculo);
	}

	@Override
	public Vehiculo seleccionar(String placa) {
		// TODO Auto-generated method stub
		for(Vehiculo vehiculo : base) {
			if(vehiculo.getPlaca().equals(placa)) {
				Vehiculo auto = new Vehiculo();
				auto.setMarca(vehiculo.getMarca());
				auto.setPlaca(vehiculo.getPlaca());
				auto.setPrecio(vehiculo.getPrecio());
				auto.setTipo(vehiculo.getTipo());
				return auto;
			}
		}
		return null;
	}

	@Override
	public Vehiculo selcElim(String placa) {
		// TODO Auto-generated method stub
		for(Vehiculo vehiculo : base) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}

}
