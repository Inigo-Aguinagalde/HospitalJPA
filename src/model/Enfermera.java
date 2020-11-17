package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enfermera database table.
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Enfermera.findAll", query="SELECT e FROM Enfermera e"),
	@NamedQuery(name="Enfermera.findByName", query="Select e from Enfermera e where e.name= ?1 and e.surname = ?2"),
	@NamedQuery(name="Enfermera.update", query="update Enfermera e set e.name = ?1 and e.surname= ?2 where e.name =?3 ")
})

public class Enfermera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String surname;

	//bi-directional many-to-many association to Paciente
	@ManyToMany(mappedBy="enfermeras")
	private List<Paciente> pacientes;

	public Enfermera() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}