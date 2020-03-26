package com.khan.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ZIP_CODE")
public class ZipCode implements Serializable {

    private static final long serialVersionUID = 5770852395582272919L;

    @Id
    @Basic(optional = false)
    @Column(name = "ZIPCODE")
    private String zipcode;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_created;

    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date last_updated;

    @Column(name = "UNMAPPED_DMA_ID")
    private String unmapped_dma_id;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public String getUnmapped_dma_id() {
        return unmapped_dma_id;
    }

    public void setUnmapped_dma_id(String unmapped_dma_id) {
        this.unmapped_dma_id = unmapped_dma_id;
    }
}