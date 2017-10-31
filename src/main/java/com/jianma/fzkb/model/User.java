package com.jianma.fzkb.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "sdx_fzkb")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String password;
	private Date createtime;
	private String realname;
	private String mobile;
	private String address;
	private byte valid;
	private String slot;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public User() {
	}

	public User(String email, String password, Date createtime, byte valid) {
		this.email = email;
		this.password = password;
		this.createtime = createtime;
		this.valid = valid;
	}

	public User(String email, String password, Date createtime, String realname, String mobile, String address,
			byte valid, String slot, Set<UserRole> userRoles) {
		this.email = email;
		this.password = password;
		this.createtime = createtime;
		this.realname = realname;
		this.mobile = mobile;
		this.address = address;
		this.valid = valid;
		this.slot = slot;
		this.userRoles = userRoles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "email", nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createtime", nullable = false, length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "realname", length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "mobile", length = 18)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "valid", nullable = false)
	public byte getValid() {
		return this.valid;
	}

	public void setValid(byte valid) {
		this.valid = valid;
	}

	@Column(name = "slot", length = 40)
	public String getSlot() {
		return this.slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Transient
	public String getCredentialsSalt() {
		return email + slot;
	}
}
