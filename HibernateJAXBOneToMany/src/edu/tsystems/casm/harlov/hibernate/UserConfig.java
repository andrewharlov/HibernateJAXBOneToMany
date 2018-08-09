package edu.tsystems.casm.harlov.hibernate;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user_config")
@Entity
@Table(name = "SVV_USER_CONFIG")
public class UserConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "FILTER_COCKPIT_ENABLED")
	private int filterCockpitEnabled;
	
	@Column(name = "GROUP_COCKPIT_ENABLED")
	private int groupCockpitEnabled;
	
	@OneToOne
	@JoinColumn(name = "USER_ID", updatable = false, insertable = false)
	private User user;
	
	@OneToMany(mappedBy = "userConfig", fetch = FetchType.EAGER)
	private List<UserGroupConfig> userGroupConfig;

	@XmlElement(name = "id")
	public int getId() {
		return id;
	}

	@XmlElement(name = "user_id")
	public String getUserId() {
		return userId;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	@XmlElement(name = "filter_cockpit_enabled")
	public int getFilterCockpitEnabled() {
		return filterCockpitEnabled;
	}

	@XmlElement(name = "group_cockpit_enabled")
	public int getGroupCockpitEnabled() {
		return groupCockpitEnabled;
	}
	
	public User getUser() {
		return user;
	}
	
	@XmlElement(name = "user_group_config")
	public Collection<UserGroupConfig> getUserGroupConfig() {
		return userGroupConfig;
	}

	@Override
	public String toString() {
		return "UserConfig [id=" + id + ", user=" + user.getId() + ", name=" + name + ", filterCockpitEnabled="
				+ filterCockpitEnabled + ", groupCockpitEnabled=" + groupCockpitEnabled + "]";
	}
}
