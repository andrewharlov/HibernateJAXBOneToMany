package edu.tsystems.casm.harlov.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@Entity
@Table(name = "SVV_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "USERNAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "ROLE_ID")
	private int roleId;
	
	@Column(name = "MAIN_ASSIGNEE_GROUP_ID")
	private int mainAssigneeGroupId;
	
	@Column(name = "COMPANY")
	private String company;
	
	@Column(name = "TIMEZONE_ID")
	private int timezoneId;
	
	@Column(name = "LOCKED")
	private int locked;
	
	@OneToOne(mappedBy = "user")
	private UserConfig userConfig;

	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "password")
	public String getPassword() {
		return password;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}

	@XmlElement(name = "country")
	public String getCountry() {
		return country;
	}

	@XmlElement(name = "full_name")
	public String getFullName() {
		return fullName;
	}

	@XmlElement(name = "role_id")
	public int getRoleId() {
		return roleId;
	}

	@XmlElement(name = "main_assignee_groupId")
	public int getMainAssigneeGroupId() {
		return mainAssigneeGroupId;
	}

	@XmlElement(name = "company")
	public String getCompany() {
		return company;
	}

	@XmlElement(name = "timezone_id")
	public int getTimezoneId() {
		return timezoneId;
	}

	@XmlElement(name = "locked")
	public int getLocked() {
		return locked;
	}

	@XmlElement(name = "user_config")
	public UserConfig getUserConfig() {
		return userConfig;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", country="
				+ country + ", fullName=" + fullName + ", roleId=" + roleId + ", mainAssigneeGroupId="
				+ mainAssigneeGroupId + ", company=" + company + ", timezoneId=" + timezoneId + ", locked=" + locked
				+ ", userConfig=" + userConfig + "]";
	}
}
