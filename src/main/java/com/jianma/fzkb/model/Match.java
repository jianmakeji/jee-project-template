package com.jianma.fzkb.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Match generated by hbm2java
 */
@Entity
@Table(name = "match", catalog = "sdx_fzkb")
public class Match implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String underwear;
	private String greatcoat;
	private String trousers;
	private Date createTime;

	public Match() {
	}

	public Match(String name, String underwear, String greatcoat, String trousers, Date createTime) {
		this.name = name;
		this.underwear = underwear;
		this.greatcoat = greatcoat;
		this.trousers = trousers;
		this.createTime = createTime;
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

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "underwear", nullable = false)
	public String getUnderwear() {
		return this.underwear;
	}

	public void setUnderwear(String underwear) {
		this.underwear = underwear;
	}

	@Column(name = "greatcoat", nullable = false)
	public String getGreatcoat() {
		return this.greatcoat;
	}

	public void setGreatcoat(String greatcoat) {
		this.greatcoat = greatcoat;
	}

	@Column(name = "trousers", nullable = false)
	public String getTrousers() {
		return this.trousers;
	}

	public void setTrousers(String trousers) {
		this.trousers = trousers;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
