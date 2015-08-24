package com.job5156.model.mail;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 无效的EMAIL（硬退信）
 * @author leeton
 * 
 */
@Entity
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class EmailInvaild implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // 主键ID
	private Integer perUserId;
	private String email;
	private Date createDate; // 创建日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerUserId() {
        return perUserId;
    }

    public void setPerUserId(Integer perUserId) {
        this.perUserId = perUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
