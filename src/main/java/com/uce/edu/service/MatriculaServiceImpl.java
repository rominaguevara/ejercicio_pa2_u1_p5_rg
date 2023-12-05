package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.actualizar(matricula);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.eliminar(cedula);
	}

	@Override
	public Matricula seleccionar(String cedula) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionar(cedula);
	}

	@Override
	public Matricula selcElim(String cedula) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.selcElim(cedula);
	}

	@Override
	public void matricularVehiculo(String cedula, String placa) {
		// TODO Auto-generated method stub
		// LOGICA DE NEGOCIO
		// 1.-Buscar vehiculo
		Vehiculo auto = this.iVehiculoRepository.seleccionar(placa);
		// 2.-Buscar Propietario
		Propietario propietario = this.iPropietarioRepository.seleccionar(cedula);
		// 3.-Variables para el calculo
		BigDecimal pesado = new BigDecimal(0.25);
		BigDecimal liviano = new BigDecimal(0.20);
		BigDecimal vMatricula = new BigDecimal(0);
		BigDecimal superior = new BigDecimal(2200);
		BigDecimal descuento = new BigDecimal(0.95);

		if (auto.getTipo() == "pesado") {
			vMatricula = auto.getPrecio().multiply(pesado);
		} else if (auto.getTipo() == "liviano") {
			vMatricula = auto.getPrecio().multiply(liviano);
		}

		if (vMatricula.compareTo(superior) >= 1) {
			vMatricula = vMatricula.multiply(descuento);
		}
		// 4.-Insertar matricula
		Matricula matricula = new Matricula();
		matricula.setPropietario(propietario);
		matricula.setVehiculo(auto);
		matricula.setValorMatricula(vMatricula);
		matricula.setFechaMatricula(LocalDateTime.now());

		this.iMatriculaRepository.insertar(matricula);
		System.out.println("Su matricula se registró con éxito");
	}

}
