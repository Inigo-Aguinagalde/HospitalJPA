package model;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		PedirInformacion PI = new PedirInformacion();
		int usuario=0;
		boolean error=false;
		Buscar bs = new Buscar();
		ModificarDatos MD = new ModificarDatos();
		//CreateQuery CQ = new CreateQuery();
		//CreateNameQuery CNQ = new CreateNameQuery();

		 EntityManagerFactory emf =
		         Persistence.createEntityManagerFactory("HospitalJPA");
		      EntityManager em = emf.createEntityManager();




		boolean repetir=true;
		while(repetir){
			menu.mostrarMenu();
			do{
				try{
					System.out.println("Introcuzca una opcion del muenu");
					usuario=sc.nextInt();
					if(usuario<=0|| usuario>18){
						System.out.println("Error esa opcion no exite");
						error=true;
					}
				}catch(InputMismatchException ex){
					System.out.println("Porfavor introduce una opción del menu.");
					sc.next();
				}

			}while(error);




			switch(usuario){

			case 1:
				bs.listaPacientes(em);
				break;
			case 2:
				String apellidoP = PI.PedirApellido("paciente");
				bs.BuscarPorApellidoPacientes(em, apellidoP);
				break;
			case 3:
				bs.listaMedicos(em);
				break;
			case 4:
				String apellidoM = PI.PedirApellido("medico");
				bs.BuscarPorApellidoMedicos(em, apellidoM);
				break;
			case 5:
				bs.listaEnfermeras(em);
				break;
			case 6:
				String apellidoE;
				apellidoE= PI.PedirApellido("enfermera");
				bs.BuscarPorApellidoEnfermeras(em, apellidoE);
				break;
			case 7:
				Paciente paciente =PI.pedirInformacionPaciente(em);
				MD.InsertarPaciente(em, paciente);

				break;
			case 8:

				break;
			case 9:

				break;
			case 10:
				Medico medico=PI.pedirInformacionMedico();
				MD.InsertarMedico(em, medico);
				break;
			case 11:

				break;
			case 12:

				break;
			case 13:
				Enfermera enfermera=PI.pedirInformacionEnfermera();
				MD.InsertarEnfermera(em, enfermera);
				break;
			case 14:

				break;
			case 15:

				break;
			case 16:

				break;
			case 17:

				break;
			case 18:

				break;
			case 19:
				salir();
				break;


			}
		}


		}

	public static void salir(){
		System.exit(0);

	}

}
