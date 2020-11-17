package model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Buscar {


	public void listaPacientes(EntityManager em){


		TypedQuery<Paciente> listaPacientes=em.createNamedQuery("Paciente.findAll", Paciente.class);

		for(Paciente p : listaPacientes.getResultList() ){

			System.out.println(p.toString());

		}

	}

	public void BuscarPorApellidoPacientes(EntityManager em,String apellido){


		TypedQuery<Paciente> listaPacientes=em.createNamedQuery("Paciente.findByName", Paciente.class);
		listaPacientes.setParameter(1,apellido);

		for(Paciente p : listaPacientes.getResultList() ){

			System.out.println(p.toString());

		}

	}


	public void listaMedicos(EntityManager em){


		TypedQuery<Medico> listaMedico=em.createNamedQuery("Medico.findAll", Medico.class);

		for(Medico m : listaMedico.getResultList() ){

			System.out.println(m.toString());

		}

	}

	public void BuscarPorApellidoMedicos(EntityManager em,String apellido){


		TypedQuery<Medico> listaMedico=em.createNamedQuery("Medico.findByName", Medico.class);
		listaMedico.setParameter(1,apellido);

		for(Medico m : listaMedico.getResultList() ){

			System.out.println(m.toString());

		}

	}



	public void listaEnfermeras(EntityManager em){


		TypedQuery<Enfermera> listaEnfermera=em.createNamedQuery("Enfermera.findAll", Enfermera.class);

		for(Enfermera e : listaEnfermera.getResultList() ){

			System.out.println(e.toString());

		}

	}

	public void BuscarPorApellidoEnfermeras(EntityManager em,String apellido){


		TypedQuery<Enfermera> listaEnfermera=em.createNamedQuery("Enfermera.findByName", Enfermera.class);
		listaEnfermera.setParameter(1,apellido);

		for(Enfermera e : listaEnfermera.getResultList() ){

			System.out.println(e.toString());

		}

	}




}
