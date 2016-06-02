package com.manchey.model.po;

import javax.persistence.*;

/**
 * Created by Ray on 2016/6/2.
 */
@Entity
@Table(name = "operator", schema = "manchey", catalog = "")
public class TOperator {
    private String operno;
    private String password;
    private Byte adminlevel;

    @Id
    @Column(name = "operno", nullable = false, length = 20)
    public String getOperno() {
        return operno;
    }

    public void setOperno(String operno) {
        this.operno = operno;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "adminlevel", nullable = true)
    public Byte getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(Byte adminlevel) {
        this.adminlevel = adminlevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TOperator tOperator = (TOperator) o;

        if (operno != null ? !operno.equals(tOperator.operno) : tOperator.operno != null) return false;
        if (password != null ? !password.equals(tOperator.password) : tOperator.password != null) return false;
        if (adminlevel != null ? !adminlevel.equals(tOperator.adminlevel) : tOperator.adminlevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operno != null ? operno.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (adminlevel != null ? adminlevel.hashCode() : 0);
        return result;
    }
}
