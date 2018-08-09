package edu.tsystems.casm.harlov.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "group_config")
@Entity
@Table(name = "SVV_GROUP_CONFIG")
public class GroupConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "GROUP_NAME")
	private String groupName;
	
	@Column(name = "COLOUR")
	private String colour;
	
	@OneToMany(targetEntity=Filter.class, mappedBy = "groupConfig", fetch = FetchType.EAGER)
	private List<Filter> filters;

	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "group_name")
	public String getGroupName() {
		return groupName;
	}

	@XmlElement(name = "colour")
	public String getColour() {
		return colour;
	}

	@XmlElement(name = "filter")
	public List<Filter> getFilters() {
		return filters;
	}

	@Override
	public String toString() {
		return "GroupConfig [id=" + id + ", groupName=" + groupName + ", colour=" + colour + ", filters=" + filters
				+ "]";
	}
}
