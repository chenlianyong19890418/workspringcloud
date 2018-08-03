package com.dlsmartercity.annualaccount.dto.single;

import com.dlsmartercity.annualaccount.core.dto.BaseDto;
import java.io.Serializable;
import java.math.BigDecimal;

public class SysAccount extends BaseDto implements Serializable {
    private Integer id;

    private BigDecimal amount;

    private BigDecimal prizeamount;

    private BigDecimal cashamount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", prizeamount=").append(prizeamount);
        sb.append(", cashamount=").append(cashamount);
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
        SysAccount other = (SysAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getPrizeamount() == null ? other.getPrizeamount() == null : this.getPrizeamount().equals(other.getPrizeamount()))
            && (this.getCashamount() == null ? other.getCashamount() == null : this.getCashamount().equals(other.getCashamount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getPrizeamount() == null) ? 0 : getPrizeamount().hashCode());
        result = prime * result + ((getCashamount() == null) ? 0 : getCashamount().hashCode());
        return result;
    }
}