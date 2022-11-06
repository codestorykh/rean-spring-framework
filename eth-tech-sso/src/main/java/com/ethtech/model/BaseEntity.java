package com.ethtech.model;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity extends Auditable<String> {

    private static final long serialVersionUID = -3493097939513641578L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "is_activate")
    protected Boolean isActivate;

    @Column(name = "code")
    protected String code;

    @Column(name = "desc_en", length = 2000)
    protected String descEn;

    @Column(name = "desc_local", length = 4000)
    protected String descLocal;

    @Column(name = "num_order")
    public int numOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
    }

    public String getDescLocal() {
        return descLocal;
    }

    public void setDescLocal(String descLocal) {
        this.descLocal = descLocal;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }
}
