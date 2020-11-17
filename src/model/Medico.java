package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicos database table.
 *
 */
@Entity
@Table(name="medicos")
@NamedQueries({
	@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m"),
	@NamedQuery(name="Medico.findByName", query="Select m from Medico m where m.name= ?1 and m.surname= ?2"),
})
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int dni;

	private String name;

	private int phone;

	private String sex;

	private String surname;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="medico")
	private List<Paciente> pacientes;

	public Medico() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setMedico(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setMedico(null);

		return paciente;
	}

}