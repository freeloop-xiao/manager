package com.user.register.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "注册用户数据模型")
public class TabUserVO {
    @ApiModelProperty(value = "用户user唯一id")
    private String userNo;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "证件类型")
    private Integer idCardType;

    @ApiModelProperty(value = "证件号码")
    private String idCardNo;

    @ApiModelProperty(value = "电子邮件地址")
    private String email;

    @ApiModelProperty(value = "电话号码")
    private String phoneNo;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "用户等级")
    private Integer userLevel;

    @ApiModelProperty(value = "省份代码")
    private String provCode;

    @ApiModelProperty(value = "市代码")
    private String cityCode;

    @ApiModelProperty(value = "区、县编码")
    private String areaCode;

    @ApiModelProperty(value = "用户是否被锁定标识")
    private String available;

    @ApiModelProperty(value = "是否实名认证")
    private Integer realFlag;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "修改时间")
    private Date updateDate;

    @ApiModelProperty(value = "注册日期")
    private Date createDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode == null ? null : provCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Integer getRealFlag() {
        return realFlag;
    }

    public void setRealFlag(Integer realFlag) {
        this.realFlag = realFlag;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "TabUserVO{" +
                "userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", idCardType=" + idCardType +
                ", idCardNo='" + idCardNo + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", userLevel=" + userLevel +
                ", createDate=" + createDate +
                ", provCode='" + provCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", available=" + available +
                ", realFlag=" + realFlag +
                ", appId='" + appId + '\'' +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}