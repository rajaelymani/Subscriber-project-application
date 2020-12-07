package com.CanalPlus.SubscriberProject.database.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MvtHistory {


    @Id
    @GeneratedValue
    private long id;
    private long subscriberId;
    private long contractId;
    private String modificationType;
    private Date date;
    private String newValue ;
    private String oldValue ;

    public MvtHistory() {
    }

    public MvtHistory(long subscriberId, long contractId, String modificationType, Date date, String newValue, String oldValue) {
        this.subscriberId = subscriberId;
        this.contractId = contractId;
        this.modificationType = modificationType;
        this.date = date;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public String getModificationType() {
        return modificationType;
    }

    public void setModificationType(String modificationType) {
        this.modificationType = modificationType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }
}
