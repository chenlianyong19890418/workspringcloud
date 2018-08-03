package com.dlsmartercity.annualaccount.dto.single;

import com.dlsmartercity.annualaccount.core.dto.BaseDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysAccountLog extends BaseDto implements Serializable {
    private Long id;

    private Integer eid;

    private Short optType;

    private String optCode;

    private BigDecimal amount;

    private BigDecimal imageAccount;

    private BigDecimal account;

    private BigDecimal prizeamount;

    private BigDecimal cashamount;

    private Date createDate;

    private Integer thirdId;

    private Integer thirdType;

    private Integer uid;

    private String remarks;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Short getOptType() {
        return optType;
    }

    public void setOptType(Short optType) {
        this.optType = optType;
    }

    public String getOptCode() {
        return optCode;
    }

    public void setOptCode(String optCode) {
        this.optCode = optCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getImageAccount() {
        return imageAccount;
    }

    public void setImageAccount(BigDecimal imageAccount) {
        this.imageAccount = imageAccount;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public BigDecimal getPrizeamount() {
        return prizeamount;
    }

    public void setPrizeamount(BigDecimal prizeamount) {
        this.prizeamount = prizeamount;
    }

    public BigDecimal getCashamount() {
        return cashamount;
    }

    public void setCashamount(BigDecimal cashamount) {
        this.cashamount = cashamount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eid=").append(eid);
        sb.append(", optType=").append(optType);
        sb.append(", optCode=").append(optCode);
        sb.append(", amount=").append(amount);
        sb.append(", imageAccount=").append(imageAccount);
        sb.append(", account=").append(account);
        sb.append(", prizeamount=").append(prizeamount);
        sb.append(", cashamount=").append(cashamount);
        sb.append(", createDate=").append(createDate);
        sb.append(", thirdId=").append(thirdId);
        sb.append(", thirdType=").append(thirdType);
        sb.append(", uid=").append(uid);
        sb.append(", remarks=").append(remarks);
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
        SysAccountLog other = (SysAccountLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
            && (this.getOptType() == null ? other.getOptType() == null : this.getOptType().equals(other.getOptType()))
            && (this.getOptCode() == null ? other.getOptCode() == null : this.getOptCode().equals(other.getOptCode()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getImageAccount() == null ? other.getImageAccount() == null : this.getImageAccount().equals(other.getImageAccount()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPrizeamount() == null ? other.getPrizeamount() == null : this.getPrizeamount().equals(other.getPrizeamount()))
            && (this.getCashamount() == null ? other.getCashamount() == null : this.getCashamount().equals(other.getCashamount()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getThirdId() == null ? other.getThirdId() == null : this.getThirdId().equals(other.getThirdId()))
            && (this.getThirdType() == null ? other.getThirdType() == null : this.getThirdType().equals(other.getThirdType()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getOptType() == null) ? 0 : getOptType().hashCode());
        result = prime * result + ((getOptCode() == null) ? 0 : getOptCode().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getImageAccount() == null) ? 0 : getImageAccount().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPrizeamount() == null) ? 0 : getPrizeamount().hashCode());
        result = prime * result + ((getCashamount() == null) ? 0 : getCashamount().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getThirdId() == null) ? 0 : getThirdId().hashCode());
        result = prime * result + ((getThirdType() == null) ? 0 : getThirdType().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }
}