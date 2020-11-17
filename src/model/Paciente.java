package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p"),
	@NamedQuery(name="Paciente.findByName", query="Select p from Paciente p where p.name= ?1 and p.surname= ?2"),
})
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String joined;

	private String name;

	private String sex;

	private String surname;

	//bi-directional many-to-many association to Enfermera
	@ManyToMany
	@JoinTable(
		name="enfermerapaciente"
		, joinColumns={
			@JoinColumn(name="id_paciente")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_nurse")
			}
		)
	private List<Enfermera> enfermeras;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="id_docot")
	private Medico medico;

	public Paciente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJoined() {
		return this.joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Enfermera> getEnfermeras() {
		return this.enfermeras;
	}

	public void setEnfermeras(List<Enfermera> enfermeras) {
		this.enfermeras = enfermeras;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}