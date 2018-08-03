package com.dlsmartercity.annualaccount.dto.single;

import com.dlsmartercity.annualaccount.core.dto.BaseDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BuMessage extends BaseDto implements Serializable {
    private Integer umid;

    private Integer uidfrom;

    private Integer uidto;

    private String umtype;

    private Integer platformType;

    private String message;

    private String umstatus;

    private BigDecimal tmoney;

    private Integer pgid;

    private Integer tid;

    private Integer nid;

    private String remark;

    private String status;

    private Integer updateby;

    private Date updatedate;

    private Integer createby;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Integer getUmid() {
        return umid;
    }

    public void setUmid(Integer umid) {
        this.umid = umid;
    }

    public Integer getUidfrom() {
        return uidfrom;
    }

    public void setUidfrom(Integer uidfrom) {
        this.uidfrom = uidfrom;
    }

    public Integer getUidto() {
        return uidto;
    }

    public void setUidto(Integer uidto) {
        this.uidto = uidto;
    }

    public String getUmtype() {
        return umtype;
    }

    public void setUmtype(String umtype) {
        this.umtype = umtype;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUmstatus() {
        return umstatus;
    }

    public void setUmstatus(String umstatus) {
        this.umstatus = umstatus;
    }

    public BigDecimal getTmoney() {
        return tmoney;
    }

    public void setTmoney(BigDecimal tmoney) {
        this.tmoney = tmoney;
    }

    public Integer getPgid() {
        return pgid;
    }

    public void setPgid(Integer pgid) {
        this.pgid = pgid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", umid=").append(umid);
        sb.append(", uidfrom=").append(uidfrom);
        sb.append(", uidto=").append(uidto);
        sb.append(", umtype=").append(umtype);
        sb.append(", platformType=").append(platformType);
        sb.append(", message=").append(message);
        sb.append(", umstatus=").append(umstatus);
        sb.append(", tmoney=").append(tmoney);
        sb.append(", pgid=").append(pgid);
        sb.append(", tid=").append(tid);
        sb.append(", nid=").append(nid);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", updateby=").append(updateby);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", createby=").append(createby);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BuMessage other = (BuMessage) that;
        return (this.getUmid() == null ? other.getUmid() == null : this.getUmid().equals(other.getUmid()))
            && (this.getUidfrom() == null ? other.getUidfrom() == null : this.getUidfrom().equals(other.getUidfrom()))
            && (this.getUidto() == null ? other.getUidto() == null : this.getUidto().equals(other.getUidto()))
            && (this.getUmtype() == null ? other.getUmtype() == null : this.getUmtype().equals(other.getUmtype()))
            && (this.getPlatformType() == null ? other.getPlatformType() == null : this.getPlatformType().equals(other.getPlatformType()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getUmstatus() == null ? other.getUmstatus() == null : this.getUmstatus().equals(other.getUmstatus()))
            && (this.getTmoney() == null ? other.getTmoney() == null : this.getTmoney().equals(other.getTmoney()))
            && (this.getPgid() == null ? other.getPgid() == null : this.getPgid().equals(other.getPgid()))
            && (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getNid() == null ? other.getNid() == null : this.getNid().equals(other.getNid()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateby() == null ? other.getUpdateby() == null : this.getUpdateby().equals(other.getUpdateby()))
            && (this.getUpdatedate() == null ? other.getUpdatedate() == null : this.getUpdatedate().equals(other.getUpdatedate()))
            && (this.getCreateby() == null ? other.getCreateby() == null : this.getCreateby().equals(other.getCreateby()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUmid() == null) ? 0 : getUmid().hashCode());
        result = prime * result + ((getUidfrom() == null) ? 0 : getUidfrom().hashCode());
        result = prime * result + ((getUidto() == null) ? 0 : getUidto().hashCode());
        result = prime * result + ((getUmtype() == null) ? 0 : getUmtype().hashCode());
        result = prime * result + ((getPlatformType() == null) ? 0 : getPlatformType().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getUmstatus() == null) ? 0 : getUmstatus().hashCode());
        result = prime * result + ((getTmoney() == null) ? 0 : getTmoney().hashCode());
        result = prime * result + ((getPgid() == null) ? 0 : getPgid().hashCode());
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getNid() == null) ? 0 : getNid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateby() == null) ? 0 : getUpdateby().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getCreateby() == null) ? 0 : getCreateby().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }
}