package com.dlsmartercity.annualaccount.dto.single;

import com.dlsmartercity.annualaccount.core.dto.BaseDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BuMoneyLog extends BaseDto implements Serializable {
    private Integer lid;

    private Integer uid;

    private Integer pgtype;

    private Integer pgid;

    private Integer tid;

    private String eventsum;

    private String ltype;

    private BigDecimal cash;

    private BigDecimal oldcash;

    private Date paytime;

    private String remark;

    private String status;

    private Integer updateby;

    private Date updatedate;

    private Integer createby;

    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPgtype() {
        return pgtype;
    }

    public void setPgtype(Integer pgtype) {
        this.pgtype = pgtype;
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

    public String getEventsum() {
        return eventsum;
    }

    public void setEventsum(String eventsum) {
        this.eventsum = eventsum;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getOldcash() {
        return oldcash;
    }

    public void setOldcash(BigDecimal oldcash) {
        this.oldcash = oldcash;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
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
        sb.append(", lid=").append(lid);
        sb.append(", uid=").append(uid);
        sb.append(", pgtype=").append(pgtype);
        sb.append(", pgid=").append(pgid);
        sb.append(", tid=").append(tid);
        sb.append(", eventsum=").append(eventsum);
        sb.append(", ltype=").append(ltype);
        sb.append(", cash=").append(cash);
        sb.append(", oldcash=").append(oldcash);
        sb.append(", paytime=").append(paytime);
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
        BuMoneyLog other = (BuMoneyLog) that;
        return (this.getLid() == null ? other.getLid() == null : this.getLid().equals(other.getLid()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPgtype() == null ? other.getPgtype() == null : this.getPgtype().equals(other.getPgtype()))
            && (this.getPgid() == null ? other.getPgid() == null : this.getPgid().equals(other.getPgid()))
            && (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getEventsum() == null ? other.getEventsum() == null : this.getEventsum().equals(other.getEventsum()))
            && (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getCash() == null ? other.getCash() == null : this.getCash().equals(other.getCash()))
            && (this.getOldcash() == null ? other.getOldcash() == null : this.getOldcash().equals(other.getOldcash()))
            && (this.getPaytime() == null ? other.getPaytime() == null : this.getPaytime().equals(other.getPaytime()))
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
        result = prime * result + ((getLid() == null) ? 0 : getLid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPgtype() == null) ? 0 : getPgtype().hashCode());
        result = prime * result + ((getPgid() == null) ? 0 : getPgid().hashCode());
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getEventsum() == null) ? 0 : getEventsum().hashCode());
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getCash() == null) ? 0 : getCash().hashCode());
        result = prime * result + ((getOldcash() == null) ? 0 : getOldcash().hashCode());
        result = prime * result + ((getPaytime() == null) ? 0 : getPaytime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateby() == null) ? 0 : getUpdateby().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getCreateby() == null) ? 0 : getCreateby().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }
}