package edu.tsystems.casm.harlov.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GenerationType;

@XmlRootElement(name = "filter")
@Entity
@Table(name = "SVV_FILTERS")
public class Filter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "SQL_QUERY")
	private String sqlQuery;
	
	@Column(name = "GROUP_CONFIG_ID")
	private int groupConfigId;
	
	@ManyToOne
	@JoinColumn(name = "GROUP_CONFIG_ID", updatable = false, insertable = false )
	private GroupConfig groupConfig;

	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	//@XmlElement(name = "sql_query")
	public String getSqlQuery() {
		return sqlQuery;
	}
	
	@XmlElement(name = "group_config_id")
	public int getGroupConfigId() {
		return groupConfigId;
	}

	public GroupConfig getGroupConfig() {
		return groupConfig;
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", name=" + name + ", sqlQuery=" + sqlQuery + ", groupConfig=" + groupConfig.getId() + "]";
	}
}
