package edu.tsystems.casm.harlov.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "user_group_config")
@Entity
@Table(name = "SVV_USER_GROUP_CONFIG")
public class UserGroupConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "GROUP_CONFIG_ID")
	private int groupConfigId;
	
	@Column(name = "USER_CONFIG_ID")
	private String userConfigId;
	
	@OneToOne
	@JoinColumn(name = "GROUP_CONFIG_ID", updatable = false, insertable = false)
	private GroupConfig groupConfig;
	
	@ManyToOne
	@JoinColumn(name = "USER_CONFIG_ID", updatable = false, insertable = false)
	private UserConfig userConfig;

	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "group_config_id")
	public int getGroupConfigId() {
		return groupConfigId;
	}

	@XmlElement(name = "user_config_id")
	public String getUserConfigId() {
		return userConfigId;
	}

	public UserConfig getUserConfig() {
		return userConfig;
	}

	@XmlElement(name = "group_config")
	public GroupConfig getGroupConfig() {
		return groupConfig;
	}

	@Override
	public String toString() {
		return "UserGroupConfig [id=" + id + ", groupConfigId=" + groupConfig.getId() + ", userConfig=" + userConfig + "]";
	}
}
