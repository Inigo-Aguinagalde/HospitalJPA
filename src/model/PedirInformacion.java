package model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

public class PedirInformacion {



	public PedirInformacion(){

	}

	public String PedirApellido( String posicion) {
		Scanner sc = new Scanner(System.in);

		String apellido = null;
		boolean error=true;

		do{

			System.out.println("Introduzca el apellido del "+posicion);
			try {
				apellido=sc.nextLine();
				error=false;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("El apellido no puede tener numeros");
				sc.next();
				error=true;
			}

		}while(error);



		return apellido;

	}


	public static Enfermera pedirInformacionEnfermera(){
		Enfermera enfermera = new Enfermera();
		Scanner sc = new Scanner(System.in);

		boolean name=true;
		boolean surname=true;

		String usuario = null;

		do{
			name=false;
			try{


				System.out.println("Introduzca el nombre de la emfermera");
				usuario=sc.nextLine();

			}catch(Exception e){
				sc.next();
				name=true;
				System.out.println("No puedes meter numeors");

			}
			enfermera.setName(usuario);
		}while(name);

		do{
			surname=false;
			try{


				System.out.println("Introduzca el apellido de la emfermera");
				usuario=sc.nextLine();
			}catch(Exception e){
				sc.next();
				surname=true;
				System.out.println("No puedes meter numeors");

			}
			enfermera.setSurname(usuario);
		}while(surname);



		return enfermera;

	}



	public static Paciente pedirInformacionPaciente(EntityManager em){
		Paciente paciente = new Paciente();
		Scanner sc = new Scanner(System.in);
		char usuarioChar;
		String usuario = null;
		List<Enfermera> usuarioEnfermera = null;
		int usuarioInt;
		Medico usuarioMedico = null;

		boolean error=true;
		boolean enfermera=true;
		boolean joined=true;
		boolean medico=true;
		boolean sex=true;
		boolean name=true;
		boolean surname=true;

		do{

			while(name){
				try{
					System.out.println("Introduzaca el nombre del paciente");
					usuario=sc.nextLine();
					name=false;
				}catch(Exception e){
					sc.next();
					name=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setName(usuario);


			}
			while(surname){
				try{
					System.out.println("Introduzaca el apellido del paciente");
					usuario=sc.nextLine();
					surname=false;
				}catch(Exception e){
					sc.next();
					surname=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setSurname(usuario);
			}

			while(enfermera){
				try{
					System.out.println("Introduzaca el id de la emfermera que le cuida");
					usuarioInt=sc.nextInt();
					try {
						em.getTransaction().begin();
						Enfermera enfermeras = new Enfermera();
						enfermeras.setId(usuarioInt);
						em.persist(enfermera);
						em.flush();

						System.out.println("Id: " + enfermeras.getId());

						List<Paciente> lista  = enfermeras.getPacientes();
						Paciente emp2 = em.getReference(model.Paciente.class, 1);
						Paciente emp3 = em.getReference(model.Paciente.class, 2);
						lista.add(emp2);
						lista.add(emp3);
						enfermeras.setPacientes(lista);

						em.persist(em);
						em.getTransaction().commit();

					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}catch(Exception e){
					e.printStackTrace();

				}

			}

			while(sex){
				try{
					System.out.println("Introduzaca sexo del paciente");
					usuario=sc.nextLine();
					name=false;
				}catch(Exception e){
					sc.next();
					sex=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setSex(usuario);
			}
			while(medico){
				try{
					System.out.println("Introduzaca el id del medico del Pacinte");
					usuarioInt =sc.nextInt();
					usuarioMedico = new Medico();
					usuarioMedico.setId(usuarioInt);
					medico=false;
				}catch(Exception e){
					sc.next();
					medico=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setMedico(usuarioMedico);
			}
			while(joined){
				try{
					System.out.println("Introduzaca la fecha de cuando fue ingresado el paciente");
					usuario=sc.nextLine();
					joined=false;
				}catch(InputMismatchException ex){
					sc.next();
					joined=true;
					error=true;
					System.out.println("Error, no puedes meter letras");
				}
				paciente.setJoined(usuario);
			}


		}while(error);

		return paciente;
	}

	public static Medico pedirInformacionMedico() {

		Medico medico = new Medico();
		Scanner sc = new Scanner(System.in);

		boolean name=true;
		boolean surname=true;
		boolean sex=true;
		boolean phone=true;
		boolean DNI=true;
		int usuarioInt = 0;

		String usuario = null;

		do{
			name=false;
			try{


				System.out.println("Introduzca el nombre del medico");
				usuario=sc.nextLine();

			}catch(Exception e){
				sc.next();
				name=true;
				System.out.println("No puedes meter numeors");

			}
			medico.setName(usuario);

		}while(name);

		do{
			surname=false;
			try{


				System.out.println("Introduzca el apellido del medico");
				usuario=sc.nextLine();
			}catch(Exception e){
				sc.next();
				surname=true;
				System.out.println("No puedes meter numeors");

			}
			medico.setSurname(usuario);
		}while(surname);


		do{
			sex=false;
			try{


				System.out.println("Introduzca el sex del medico");
				usuario=sc.nextLine();

			}catch(Exception e){
				sc.next();
				sex=true;
				System.out.println("No puedes meter numeors");

			}
			medico.setSex(usuario);
		}while(sex);


		do {
			DNI=false;
			System.out.println("Introduzca el DNI del medico");

			try {
				usuarioInt=sc.nextInt();
			}catch(InputMismatchException ex){
				System.out.println("No metas una letra");
				DNI=true;
				sc.next();
			}

			medico.setDni(usuarioInt);
		}while(DNI);



		do{
			phone=false;
			System.out.println("Introduzca el telefono del medico");
			try {
				usuarioInt=sc.nextInt();
			}catch(InputMismatchException ex){
				System.out.println("No metas una letra");
				phone=true;
				sc.next();
			}


			medico.setPhone(usuarioInt);
		}while(name);

		return medico;

	}

	public static Paciente modificarPaciente(EntityManager em){
		Paciente paciente = new Paciente();
		Scanner sc = new Scanner(System.in);
		char usuarioChar;
		String usuario = null;
		List<Enfermera> usuarioEnfermera = null;
		int usuarioInt;
		Medico usuarioMedico = null;

		boolean error=true;
		boolean enfermera=true;
		boolean joined=true;
		boolean medico=true;
		boolean sex=true;
		boolean name=true;
		boolean surname=true;

		do{

			while(name){
				try{
					System.out.println("Introduzaca el nombre del paciente");
					usuario=sc.nextLine();
					name=false;
				}catch(Exception e){
					sc.next();
					name=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setName(usuario);


			}
			while(surname){
				try{
					System.out.println("Introduzaca el apellido del paciente");
					usuario=sc.nextLine();
					surname=false;
				}catch(Exception e){
					sc.next();
					surname=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setSurname(usuario);
			}

			while(enfermera){
				try{
					System.out.println("Introduzaca el id de la emfermera que le cuida");
					usuarioInt=sc.nextInt();
					try {
						em.getTransaction().begin();
						Enfermera enfermeras = new Enfermera();
						enfermeras.setId(usuarioInt);
						em.persist(enfermera);
						em.flush();

						System.out.println("Id: " + enfermeras.getId());

						List<Paciente> lista  = enfermeras.getPacientes();
						Paciente emp2 = em.getReference(model.Paciente.class, 1);
						Paciente emp3 = em.getReference(model.Paciente.class, 2);
						lista.add(emp2);
						lista.add(emp3);
						enfermeras.setPacientes(lista);

						em.persist(em);
						em.getTransaction().commit();

					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}catch(Exception e){
					e.printStackTrace();

				}
			}

			while(sex){
				try{
					System.out.println("Introduzaca sexo del paciente");
					usuario=sc.nextLine();
					name=false;
				}catch(Exception e){
					sc.next();
					sex=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setSex(usuario);
			}
			while(medico){
				try{
					System.out.println("Introduzaca el id del medico del Pacinte");
					usuarioInt =sc.nextInt();
					usuarioMedico = new Medico();
					usuarioMedico.setId(usuarioInt);
					medico=false;
				}catch(Exception e){
					sc.next();
					medico=true;
					error=true;
					System.out.println("Error, no puedes meter numeros");
				}
				paciente.setMedico(usuarioMedico);
			}
			while(joined){
				try{
					System.out.println("Introduzaca la fecha de cuando fue ingresado el paciente");
					usuario=sc.nextLine();
					joined=false;
				}catch(InputMismatchException ex){
					sc.next();
					joined=true;
					error=true;
					System.out.println("Error, no puedes meter letras");
				}
				paciente.setJoined(usuario);
			}


		}while(error);

		return paciente;
	}
	
	public static Enfermera modificarEnfermera(){
		Enfermera enfermera = new Enfermera();
		
		
		
		return enfermera;
	}

}

