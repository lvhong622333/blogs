package com.lvhong.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    /**
	 * 序列化用户信息
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
    private String userName;

    private String password;

    private String telephone;

    private String eMail;

    private String rowVersion;

    private String isvalid;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(String rowVersion) {
        this.rowVersion = rowVersion == null ? null : rowVersion.trim();
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isvalid == null) ? 0 : isvalid.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rowVersion == null) ? 0 : rowVersion.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isvalid == null) {
			if (other.isvalid != null)
				return false;
		} else if (!isvalid.equals(other.isvalid))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rowVersion == null) {
			if (other.rowVersion != null)
				return false;
		} else if (!rowVersion.equals(other.rowVersion))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", telephone=" + telephone
				+ ", eMail=" + eMail + ", rowVersion=" + rowVersion + ", isvalid=" + isvalid + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
    
}