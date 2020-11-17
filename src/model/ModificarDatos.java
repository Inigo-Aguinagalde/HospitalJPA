package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ModificarDatos {

	public ModificarDatos()	{

	}

	public static void InsertarPaciente(EntityManager em, Paciente paciente){

		EntityTransaction tx = em.getTransaction();

		 tx.begin();

		em.persist(paciente);
		 tx.commit();
	}


	public static void InsertarMedico(EntityManager em, Medico medico){
		EntityTransaction tx = em.getTransaction();

		 tx.begin();

		em.persist(medico);
		 tx.commit();
	}

	public static void InsertarEnfermera(EntityManager em, Enfermera enfermera){
		 EntityTransaction tx = em.getTransaction();

		 tx.begin();

		em.persist(enfermera);
		 tx.commit();
	}

	public static void modificarPaciente(){

	}

	public static void modicarMedico(){

	}

	public static void modifarEnfermera(){

	}

	public static void eliminarPaciente(){

	}

	public static void eliminarMedico(){

	}

	public static void eliminarEnfermera(){

	}


	public static void eliminarTodosLosPacientes(){

	}

	public static void eliminarTodosLosMedicos(){

	}

	public static void eliminarTodosLasEnfermeras(){

	}

	public static void eliminrTablas(){

	}
}

