package com.magma.testspring.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "T_Utilisateur", uniqueConstraints= {@UniqueConstraint(columnNames="login")})
public class Utilisateur implements Serializable, UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "tel")
	private int tel;
	
	@Column(name = "login", nullable = false, unique = true)
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "matricule")
	private float matricule;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "disponible")
	private boolean disponible;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn( name = "id_role", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Role role;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<DepDepeches>depDepeches;

	

	public Utilisateur() {
		
	}

	public Utilisateur(long id, String firstName, String lastName, int tel, String login, String password,
			float matricule, String code, boolean disponible) {
		this.id= id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.login = login;
		this.password = password;
		this.matricule = matricule;
		this.code = code;
		this.disponible = disponible;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTel() {
		return tel;
	} 

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getMatricule() {
		return matricule;
	}

	public void setMatricule(float matricule) {
		this.matricule = matricule;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public List<DepDepeches> getDepDepeches() {
		return depDepeches;
	}

	public void setDepDepeches(List<DepDepeches> depDepeches) {
		this.depDepeches = depDepeches;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}