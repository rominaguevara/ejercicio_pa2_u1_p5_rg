package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietaroService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5RgApplication implements CommandLineRunner {

	@Autowired
	private IMatriculaService iMatriculaService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietaroService iPropietaroService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5RgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Vehiculo vehiculo1 = new Vehiculo();
		vehiculo1.setPlaca("PXQ0678");
		vehiculo1.setMarca("Mitsubishi");
		vehiculo1.setPrecio(new BigDecimal(16000));
		vehiculo1.setTipo("liviano");

		this.iVehiculoService.insertar(vehiculo1);

		Propietario propietario = new Propietario();
		propietario.setNombre("Romina");
		propietario.setApellido("Guevara");
		propietario.setCedula("1750888404");
		propietario.setGenero("Femenino");

		this.iPropietaroService.insertar(propietario);

		propietario.setNombre("Romina Mishell");
		propietario.setApellido("Guevara Guanuchi");

		this.iPropietaroService.actualizar(propietario);

		this.iMatriculaService.matricularVehiculo("1750888404", "PXQ0678");
		
		System.out.println(this.iMatriculaService.seleccionar("1750888404"));
		
		
	}

}
