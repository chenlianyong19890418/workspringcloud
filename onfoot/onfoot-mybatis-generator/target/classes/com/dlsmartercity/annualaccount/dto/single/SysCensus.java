package com.dlsmartercity.annualaccount.dto.single;

import com.dlsmartercity.annualaccount.core.dto.BaseDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysCensus extends BaseDto implements Serializable {
    private Integer id;

    private String censusYear;

    private Integer uid;

    private String uname;

    private String hurl;

    private String reportNum;

    private String registerTime;

    private String reportFlag;

    private String firstReportTime;

    private String url1;

    private String eventsum;

    private String position;

    private String rewardFlag;

    private String rewardNum;

    private String firstRewardNum;

    private String ratio;

    private String firstRewardTime;

    private String filingNum;

    private String receiveFlag;

    private String receiveNum;

    private String finishFlag;

    private String finishNum;

    private String devoteSelf;

    private String devoteAll;

    private String honorary;

    private String honoraryType;

    private String redbagFlag;

    private String redbagNum;

    private String finalRedbagNum;

    private Integer ranking;

    private Integer pollShow;

    private Integer poll;

    private BigDecimal redbagMultiple;

    private String redbagWhetherFlg;

    private String annualBonusFlg;

    private Date updatedate;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(String censusYear) {
        this.censusYear = censusYear;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getHurl() {
        return hurl;
    }

    public void setHurl(String hurl) {
        this.hurl = hurl;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(String reportFlag) {
        this.reportFlag = reportFlag;
    }

    public String getFirstReportTime() {
        return firstReportTime;
    }

    public void setFirstReportTime(String firstReportTime) {
        this.firstReportTime = firstReportTime;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getEventsum() {
        return eventsum;
    }

    public void setEventsum(String eventsum) {
        this.eventsum = eventsum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRewardFlag() {
        return rewardFlag;
    }

    public void setRewardFlag(String rewardFlag) {
        this.rewardFlag = rewardFlag;
    }

    public String getRewardNum() {
        return rewardNum;
    }

    public void setRewardNum(String rewardNum) {
        this.rewardNum = rewardNum;
    }

    public String getFirstRewardNum() {
        return firstRewardNum;
    }

    public void setFirstRewardNum(String firstRewardNum) {
        this.firstRewardNum = firstRewardNum;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getFirstRewardTime() {
        return firstRewardTime;
    }

    public void setFirstRewardTime(String firstRewardTime) {
        this.firstRewardTime = firstRewardTime;
    }

    public String getFilingNum() {
        return filingNum;
    }

    public void setFilingNum(String filingNum) {
        this.filingNum = filingNum;
    }

    public String getReceiveFlag() {
        return receiveFlag;
    }

    public void setReceiveFlag(String receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public String getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(String receiveNum) {
        this.receiveNum = receiveNum;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

    public String getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(String finishNum) {
        this.finishNum = finishNum;
    }

    public String getDevoteSelf() {
        return devoteSelf;
    }

    public void setDevoteSelf(String devoteSelf) {
        this.devoteSelf = devoteSelf;
    }

    public String getDevoteAll() {
        return devoteAll;
    }

    public void setDevoteAll(String devoteAll) {
        this.devoteAll = devoteAll;
    }

    public String getHonorary() {
        return honorary;
    }

    public void setHonorary(String honorary) {
        this.honorary = honorary;
    }

    public String getHonoraryType() {
        return honoraryType;
    }

    public void setHonoraryType(String honoraryType) {
        this.honoraryType = honoraryType;
    }

    public String getRedbagFlag() {
        return redbagFlag;
    }

    public void setRedbagFlag(String redbagFlag) {
        this.redbagFlag = redbagFlag;
    }

    public String getRedbagNum() {
        return redbagNum;
    }

    public void setRedbagNum(String redbagNum) {
        this.redbagNum = redbagNum;
    }

    public String getFinalRedbagNum() {
        return finalRedbagNum;
    }

    public void setFinalRedbagNum(String finalRedbagNum) {
        this.finalRedbagNum = finalRedbagNum;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getPollShow() {
        return pollShow;
    }

    public void setPollShow(Integer pollShow) {
        this.pollShow = pollShow;
    }

    public Integer getPoll() {
        return poll;
    }

    public void setPoll(Integer poll) {
        this.poll = poll;
    }

    public BigDecimal getRedbagMultiple() {
        return redbagMultiple;
    }

    public void setRedbagMultiple(BigDecimal redbagMultiple) {
        this.redbagMultiple = redbagMultiple;
    }

    public String getRedbagWhetherFlg() {
        return redbagWhetherFlg;
    }

    public void setRedbagWhetherFlg(String redbagWhetherFlg) {
        this.redbagWhetherFlg = redbagWhetherFlg;
    }

    public String getAnnualBonusFlg() {
        return annualBonusFlg;
    }

    public void setAnnualBonusFlg(String annualBonusFlg) {
        this.annualBonusFlg = annualBonusFlg;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", censusYear=").append(censusYear);
        sb.append(", uid=").append(uid);
        sb.append(", uname=").append(uname);
        sb.append(", hurl=").append(hurl);
        sb.append(", reportNum=").append(reportNum);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", reportFlag=").append(reportFlag);
        sb.append(", firstReportTime=").append(firstReportTime);
        sb.append(", url1=").append(url1);
        sb.append(", eventsum=").append(eventsum);
        sb.append(", position=").append(position);
        sb.append(", rewardFlag=").append(rewardFlag);
        sb.append(", rewardNum=").append(rewardNum);
        sb.append(", firstRewardNum=").append(firstRewardNum);
        sb.append(", ratio=").append(ratio);
        sb.append(", firstRewardTime=").append(firstRewardTime);
        sb.append(", filingNum=").append(filingNum);
        sb.append(", receiveFlag=").append(receiveFlag);
        sb.append(", receiveNum=").append(receiveNum);
        sb.append(", finishFlag=").append(finishFlag);
        sb.append(", finishNum=").append(finishNum);
        sb.append(", devoteSelf=").append(devoteSelf);
        sb.append(", devoteAll=").append(devoteAll);
        sb.append(", honorary=").append(honorary);
        sb.append(", honoraryType=").append(honoraryType);
        sb.append(", redbagFlag=").append(redbagFlag);
        sb.append(", redbagNum=").append(redbagNum);
        sb.append(", finalRedbagNum=").append(finalRedbagNum);
        sb.append(", ranking=").append(ranking);
        sb.append(", pollShow=").append(pollShow);
        sb.append(", poll=").append(poll);
        sb.append(", redbagMultiple=").append(redbagMultiple);
        sb.append(", redbagWhetherFlg=").append(redbagWhetherFlg);
        sb.append(", annualBonusFlg=").append(annualBonusFlg);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", createDate=").append(createDate);
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
        SysCensus other = (SysCensus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCensusYear() == null ? other.getCensusYear() == null : this.getCensusYear().equals(other.getCensusYear()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUname() == null ? other.getUname() == null : this.getUname().equals(other.getUname()))
            && (this.getHurl() == null ? other.getHurl() == null : this.getHurl().equals(other.getHurl()))
            && (this.getReportNum() == null ? other.getReportNum() == null : this.getReportNum().equals(other.getReportNum()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getReportFlag() == null ? other.getReportFlag() == null : this.getReportFlag().equals(other.getReportFlag()))
            && (this.getFirstReportTime() == null ? other.getFirstReportTime() == null : this.getFirstReportTime().equals(other.getFirstReportTime()))
            && (this.getUrl1() == null ? other.getUrl1() == null : this.getUrl1().equals(other.getUrl1()))
            && (this.getEventsum() == null ? other.getEventsum() == null : this.getEventsum().equals(other.getEventsum()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getRewardFlag() == null ? other.getRewardFlag() == null : this.getRewardFlag().equals(other.getRewardFlag()))
            && (this.getRewardNum() == null ? other.getRewardNum() == null : this.getRewardNum().equals(other.getRewardNum()))
            && (this.getFirstRewardNum() == null ? other.getFirstRewardNum() == null : this.getFirstRewardNum().equals(other.getFirstRewardNum()))
            && (this.getRatio() == null ? other.getRatio() == null : this.getRatio().equals(other.getRatio()))
            && (this.getFirstRewardTime() == null ? other.getFirstRewardTime() == null : this.getFirstRewardTime().equals(other.getFirstRewardTime()))
            && (this.getFilingNum() == null ? other.getFilingNum() == null : this.getFilingNum().equals(other.getFilingNum()))
            && (this.getReceiveFlag() == null ? other.getReceiveFlag() == null : this.getReceiveFlag().equals(other.getReceiveFlag()))
            && (this.getReceiveNum() == null ? other.getReceiveNum() == null : this.getReceiveNum().equals(other.getReceiveNum()))
            && (this.getFinishFlag() == null ? other.getFinishFlag() == null : this.getFinishFlag().equals(other.getFinishFlag()))
            && (this.getFinishNum() == null ? other.getFinishNum() == null : this.getFinishNum().equals(other.getFinishNum()))
            && (this.getDevoteSelf() == null ? other.getDevoteSelf() == null : this.getDevoteSelf().equals(other.getDevoteSelf()))
            && (this.getDevoteAll() == null ? other.getDevoteAll() == null : this.getDevoteAll().equals(other.getDevoteAll()))
            && (this.getHonorary() == null ? other.getHonorary() == null : this.getHonorary().equals(other.getHonorary()))
            && (this.getHonoraryType() == null ? other.getHonoraryType() == null : this.getHonoraryType().equals(other.getHonoraryType()))
            && (this.getRedbagFlag() == null ? other.getRedbagFlag() == null : this.getRedbagFlag().equals(other.getRedbagFlag()))
            && (this.getRedbagNum() == null ? other.getRedbagNum() == null : this.getRedbagNum().equals(other.getRedbagNum()))
            && (this.getFinalRedbagNum() == null ? other.getFinalRedbagNum() == null : this.getFinalRedbagNum().equals(other.getFinalRedbagNum()))
            && (this.getRanking() == null ? other.getRanking() == null : this.getRanking().equals(other.getRanking()))
            && (this.getPollShow() == null ? other.getPollShow() == null : this.getPollShow().equals(other.getPollShow()))
            && (this.getPoll() == null ? other.getPoll() == null : this.getPoll().equals(other.getPoll()))
            && (this.getRedbagMultiple() == null ? other.getRedbagMultiple() == null : this.getRedbagMultiple().equals(other.getRedbagMultiple()))
            && (this.getRedbagWhetherFlg() == null ? other.getRedbagWhetherFlg() == null : this.getRedbagWhetherFlg().equals(other.getRedbagWhetherFlg()))
            && (this.getAnnualBonusFlg() == null ? other.getAnnualBonusFlg() == null : this.getAnnualBonusFlg().equals(other.getAnnualBonusFlg()))
            && (this.getUpdatedate() == null ? other.getUpdatedate() == null : this.getUpdatedate().equals(other.getUpdatedate()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCensusYear() == null) ? 0 : getCensusYear().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUname() == null) ? 0 : getUname().hashCode());
        result = prime * result + ((getHurl() == null) ? 0 : getHurl().hashCode());
        result = prime * result + ((getReportNum() == null) ? 0 : getReportNum().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getReportFlag() == null) ? 0 : getReportFlag().hashCode());
        result = prime * result + ((getFirstReportTime() == null) ? 0 : getFirstReportTime().hashCode());
        result = prime * result + ((getUrl1() == null) ? 0 : getUrl1().hashCode());
        result = prime * result + ((getEventsum() == null) ? 0 : getEventsum().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getRewardFlag() == null) ? 0 : getRewardFlag().hashCode());
        result = prime * result + ((getRewardNum() == null) ? 0 : getRewardNum().hashCode());
        result = prime * result + ((getFirstRewardNum() == null) ? 0 : getFirstRewardNum().hashCode());
        result = prime * result + ((getRatio() == null) ? 0 : getRatio().hashCode());
        result = prime * result + ((getFirstRewardTime() == null) ? 0 : getFirstRewardTime().hashCode());
        result = prime * result + ((getFilingNum() == null) ? 0 : getFilingNum().hashCode());
        result = prime * result + ((getReceiveFlag() == null) ? 0 : getReceiveFlag().hashCode());
        result = prime * result + ((getReceiveNum() == null) ? 0 : getReceiveNum().hashCode());
        result = prime * result + ((getFinishFlag() == null) ? 0 : getFinishFlag().hashCode());
        result = prime * result + ((getFinishNum() == null) ? 0 : getFinishNum().hashCode());
        result = prime * result + ((getDevoteSelf() == null) ? 0 : getDevoteSelf().hashCode());
        result = prime * result + ((getDevoteAll() == null) ? 0 : getDevoteAll().hashCode());
        result = prime * result + ((getHonorary() == null) ? 0 : getHonorary().hashCode());
        result = prime * result + ((getHonoraryType() == null) ? 0 : getHonoraryType().hashCode());
        result = prime * result + ((getRedbagFlag() == null) ? 0 : getRedbagFlag().hashCode());
        result = prime * result + ((getRedbagNum() == null) ? 0 : getRedbagNum().hashCode());
        result = prime * result + ((getFinalRedbagNum() == null) ? 0 : getFinalRedbagNum().hashCode());
        result = prime * result + ((getRanking() == null) ? 0 : getRanking().hashCode());
        result = prime * result + ((getPollShow() == null) ? 0 : getPollShow().hashCode());
        result = prime * result + ((getPoll() == null) ? 0 : getPoll().hashCode());
        result = prime * result + ((getRedbagMultiple() == null) ? 0 : getRedbagMultiple().hashCode());
        result = prime * result + ((getRedbagWhetherFlg() == null) ? 0 : getRedbagWhetherFlg().hashCode());
        result = prime * result + ((getAnnualBonusFlg() == null) ? 0 : getAnnualBonusFlg().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }
}