package bd2.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;

import bd2.Muber.model.Conductor;
import bd2.Muber.model.ConductorDetalle;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;
import bd2.Muber.DAOImpl.MuberConductorDAOImpl;
import bd2.Muber.DAOImpl.MuberPasajeroDAOImpl;
import bd2.Muber.DAOImpl.MuberViajeDAOImpl;
import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.PasajeroDTO;
import bd2.Muber.dto.ViajeDTO;
import bd2.Muber.model.Calificacion;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	
	protected Session getSession() {
		try {
			// return new
			// Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory();
			Configuration configuration = new Configuration();
			configuration.configure("hibernate/hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			return (configuration.buildSessionFactory(serviceRegistry)).openSession();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}


	// http://localhost:8080/MuberRESTful/rest/services/pasajeros
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getPasajeros() {
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		MuberPasajeroDAOImpl m = new MuberPasajeroDAOImpl(session);
		List<PasajeroDTO> pasajerosDTO = m.listar();
		
		transaction.commit();
		session.close();

		Map<String,Object> aMap = new HashMap<String,Object>();
		aMap.put("pasajeros", pasajerosDTO);
		return new Gson().toJson(aMap);
	}

	// http://localhost:8080/MuberRESTful/rest/services/conductores
	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getConductores() {
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
				
		MuberConductorDAOImpl m = new MuberConductorDAOImpl(session);
		List<ConductorDTO> conductoresDTO = m.listar();
		
		transaction.commit();
		session.close();
		
		Map<String,Object> aMap = new HashMap<String,Object>();
		aMap.put("conductores", conductoresDTO);
		return new Gson().toJson(aMap);
	}

	// http://localhost:8080/MuberRESTful/rest/services/viajes/abiertos
	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getViajesAbiertos() {
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		MuberViajeDAOImpl m = new MuberViajeDAOImpl(session);
		List<ViajeDTO> viajesDTO = m.listarViajesAbiertos();
		
		transaction.commit();
		session.close();
		
		Map<String,Object> aMap = new HashMap<String,Object>();
		aMap.put("Viajes", viajesDTO);
		return new Gson().toJson(aMap);
	}

	// http://localhost:8080/MuberRESTful/rest/services/conductores/detalle
	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getConductorDetalle(@RequestParam("conductorId") Integer conductorId) {
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		ConductorDetalle conductDet=null;
		MuberConductorDAOImpl m = new MuberConductorDAOImpl(session);
		ConductorDTO conductorDTO = m.getConductor(conductorId);
		if (conductorDTO != null){
			 conductDet= m.conductorDetalle(conductorId);
			 conductorDTO.setPuntajePromedio(conductDet.getPromedio());
			 conductorDTO.setViajesRealizados(conductDet.getViajes());
		}
		
		transaction.commit();
		session.close();
		
		Map<String, Object> aMap = new HashMap<String,Object>();
		if (conductorDTO != null){	
			aMap.put("nombreUsuario", conductorDTO.getNombre());
			aMap.put("ViajesRealizados", conductorDTO.getViajesRealizados());
			aMap.put("puntajePromedio", conductorDTO.getPuntajePromedio());
			aMap.put("fecha Licencia", conductorDTO.getFechaLicencia());
		}
		else{
			aMap.put("Mensaje", "El conductor Ingresado no existe");
		}

		return new Gson().toJson(aMap);
	}

	// http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo
	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String crearViaje(@RequestParam("origen") String origen, @RequestParam("destino") String destino,
			@RequestParam("conductorId") Integer conductorId, @RequestParam("costoTotal") Double costoTotal,
			@RequestParam("cantidadPasajeros") Integer cantidadPasajeros) {
		// Creo el viaje
		
		Viaje v = new Viaje(cantidadPasajeros, origen, destino, costoTotal);

		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		
		MuberConductorDAOImpl mcdi = new MuberConductorDAOImpl(session);
		// Recupero el conductor con sus viajes
		Conductor conductor = mcdi.getConductorBase(conductorId);
		Boolean agregado = false;
		if(conductor != null){
			agregado = conductor.agregarViaje(v);
			mcdi.modificar(conductor);
		}
			
		transaction.commit();
		session.close();
		
		Map<String, Object> aMap = new HashMap<String,Object>();
		if(conductor != null && agregado){
			aMap.put("Mensaje", "Se agrego el Viaje");
		}
		else if (conductor == null){
			aMap.put("Mensaje", "no existe el conductor");
		}
		else{
			aMap.put("Mensaje", "La licencia del conductor esta vencida");
		}
		return new Gson().toJson(aMap);
	}

	// http://localhost:8080/MuberRESTful/rest/services/viajes/agregarPasajero
	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json")
	public String agregarPasajero(@RequestBody Map<String,Integer> paramP) {

		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		MuberViajeDAOImpl msv = new MuberViajeDAOImpl(session);
		MuberPasajeroDAOImpl msp = new MuberPasajeroDAOImpl(session);
		Boolean ok = false;
		
		// Recupero el viaje
		Viaje v = msv.getViaje(paramP.get("viajeId"));
		Pasajero p = msp.getPasajero(paramP.get("pasajeroId"));
		if (v != null && p != null){
		ok = v.agregarPasajero(p);
		msv.modificar(v);
		}
		
		transaction.commit();
		session.close();
		
		Map<String, Object> aMap = new HashMap<String,Object>();
		if(v == null){
			aMap.put("Mensaje", "El viaje no existe");
		}
		else if (p == null){
			aMap.put("Mensaje", "El usuario no existe");
		}
		else if (!ok){
			aMap.put("Mensaje", "El viaje esta completo o ha finalizado");
		}
		else{
			aMap.put("Mensaje", "Se ha cargado el Pasajero con exito");
		}
		return new Gson().toJson(aMap);
	}

	// http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String calificarViaje(@RequestParam("viajeId") Integer viajeId, @RequestParam("pasajeroId") Integer pasajeroId,
			@RequestParam("puntaje") Integer puntaje, @RequestParam("comentario") String comentario) {

		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		
		MuberViajeDAOImpl m = new MuberViajeDAOImpl(session);
		MuberPasajeroDAOImpl msp = new MuberPasajeroDAOImpl(session);
		// Recupero el viaje
		Viaje v = m.getViajeCalificaciones(viajeId);
		Pasajero p = msp.getPasajero(pasajeroId);
		String resultado = v.agregarCalificacion(new Calificacion(comentario, puntaje,p));
		if (resultado.equals("2")){
		m.modificar(v);
		}
		
		transaction.commit();
		session.close();
		
		Map<String, Object> aMap = new HashMap<String,Object>();
		if(resultado.equals("2")){
			aMap.put("Mensaje", "Se ha calificado correctamente");
		}
		else if (resultado.equals("1")){
			aMap.put("Mensaje", "El usuario ya ha calificado este viaje");
		}
		else if (resultado.equals("3")){
			aMap.put("Mensaje", "El pasajero no ha viajado en este viaje, no puede calificar");
		}

		return new Gson().toJson(aMap);
	}

	// http://localhost:8080/MuberRESTful/rest/services/viajes/cargarCredito
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json")
	public String cargarCredito(@RequestBody Map<String,String> paramC) {
		
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		MuberPasajeroDAOImpl msp = new MuberPasajeroDAOImpl(session);

		// Recupero el pasajero
		Pasajero p = msp.getPasajero(Integer.parseInt(paramC.get("pasajeroId")));
		if ( p!=null){
		p.cargarCredito(Double.parseDouble( paramC.get("monto") ));
		msp.modificar(p);
		}
		
		transaction.commit();
		session.close();
		
		Map<String, Object> aMap = new HashMap<String,Object>();
		if( p!=null){
			aMap.put("Mensaje", "Se ha cargado credito correctamente");
		}
		else{
			aMap.put("Mensaje", "El pasajero especificado no existe");
		}

		return new Gson().toJson(aMap);
		
	}

	// http://localhost:8080/MuberRESTful/rest/services/viajes/finalizar
	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json")
	public String finalizar(@RequestBody Map<String,Integer> param) {
		
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		MuberViajeDAOImpl msp = new MuberViajeDAOImpl(session);
		// Recupero el viaje
		Viaje v = msp.getViaje(param.get("viajeId"));
		if (v != null){
		v.finalizar();
		msp.modificar(v);
		}

		transaction.commit();
		session.close();
		
		Map<String, Object> aMap = new HashMap<String,Object>();
		
		if(v==null){
			aMap.put("Mensaje", "No existe el viaje");
		}
		else{
			aMap.put("Mensaje", "Se ha finalizado el viaje con exito");
		}

		return new Gson().toJson(aMap);
		
	}
	
	// http://localhost:8080/MuberRESTful/rest/services/conductores/top10
	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String getConductoresTop10() {
		
		Session session = this.getSession();
		Transaction transaction = session.beginTransaction();
		
		MuberConductorDAOImpl m = new MuberConductorDAOImpl(session);
		List<ConductorDTO> conductores = m.getConductoresTop10();
		
		transaction.commit();
		session.close();
		
		Map<String, Object> aMap = new HashMap<String,Object>();
		aMap.put("Conductores", conductores);
		return new Gson().toJson(aMap);		
	}


}
