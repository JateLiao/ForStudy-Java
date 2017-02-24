package com.better517na.forStudy.frameworks.poi;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO 表说�?
 *
 * @author tianzhong
 */
public class EquipmentVo {

    /**
     * @设备�?
     */
    private String eqmName;

    /**
     * @设备价格.
     */
    private BigDecimal eqmPrice;

    /**
     * @设备描述.
     */
    private String description;

    /**
     * @设备状�?.
     */
    private String eqmStatus;

    /**
     * @设备管理员账�?
     */
    private String managerId;

    /**
     * @设备厂商.
     */
    private String eqmFactory;

    /**
     * @设备类别.
     */
    private String eqmClass;

    /**
     * @设备�?��实验�?
     */
    private String eqmLab;

    /**
     * @主键ID.
     */
    private Integer keyID;

    /**
     * 设置eqmLab.
     * 
     * @return 返回eqmLab
     */
    public String getEqmLab() {
        return eqmLab;
    }

    /**
     * 获取eqmLab.
     * 
     * @param eqmLab
     *            要设置的eqmLab
     */
    public void setEqmLab(String eqmLab) {
        this.eqmLab = eqmLab;
    }

    /**
     * @采购�?
     */
    private String buyStaff;

    /**
     * @�?��学院.
     */
    private String college;

    /**
     * @扩展字段2.
     */
    private String tmp2;

    /**
     * @扩展字段1.
     */
    private String tmp1;

    /**
     * @扩展字段3.
     */
    private String tmp3;

    /**
     * @设备管理�?
     */
    private String manager;

    /**
     * @设备型号.
     */
    private String eqmType;

    /**
     * @采购时间.
     */
    private Date buyTime;

    /**
     * @记录修改时间
     */
    private Date modifyTime;

    /**
     * 
     * 无参数构造函�?
     * 
     */
    public EquipmentVo() {
        // 构�?
    }

    /**
     * 
     * 有参数构造函�?
     *
     * @param var
     *            转换对象（Object自己换成要转的实际类型，这个构�?只是�?��模板�?
     */
    public EquipmentVo(EquipmentVo var) {
        this.eqmName = var.getEqmName();
        this.eqmPrice = var.getEqmPrice();
        this.description = var.getDescription();
        this.eqmFactory = var.getEqmFactory();
        this.eqmClass = var.getEqmClass();
        this.keyID = var.getKeyID();
        this.buyStaff = var.getBuyStaff();
        this.college = var.getCollege();
        this.tmp2 = var.gettmp2();
        this.tmp1 = var.gettmp1();
        this.tmp3 = var.gettmp3();
        this.manager = var.getManager();
        this.eqmType = var.getEqmType();
        this.buyTime = var.getBuyTime();
        this.modifyTime = var.getModifyTime();
    }

    /**
     * 设置eqmName.
     * 
     * @return 返回eqmName
     */
    public String getEqmName() {
        return eqmName;
    }

    /**
     * 获取eqmName.
     * 
     * @param eqmName
     *            要设置的eqmName
     */
    public void setEqmName(String eqmName) {
        this.eqmName = eqmName;
    }

    /**
     * 设置eqmPrice.
     * 
     * @return 返回eqmPrice
     */
    public BigDecimal getEqmPrice() {
        return eqmPrice;
    }

    /**
     * 获取eqmPrice.
     * 
     * @param eqmPrice
     *            要设置的eqmPrice
     */
    public void setEqmPrice(BigDecimal eqmPrice) {
        this.eqmPrice = eqmPrice;
    }

    /**
     * 设置description.
     * 
     * @return 返回description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 获取description.
     * 
     * @param description
     *            要设置的description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 设置eqmFactory.
     * 
     * @return 返回eqmFactory
     */
    public String getEqmFactory() {
        return eqmFactory;
    }

    /**
     * 获取eqmFactory.
     * 
     * @param eqmFactory
     *            要设置的eqmFactory
     */
    public void setEqmFactory(String eqmFactory) {
        this.eqmFactory = eqmFactory;
    }

    /**
     * 设置eqmClass.
     * 
     * @return 返回eqmClass
     */
    public String getEqmClass() {
        return eqmClass;
    }

    /**
     * 获取eqmClass.
     * 
     * @param eqmClass
     *            要设置的eqmClass
     */
    public void setEqmClass(String eqmClass) {
        this.eqmClass = eqmClass;
    }

    /**
     * 设置keyID.
     * 
     * @return 返回keyID
     */
    public Integer getKeyID() {
        return keyID;
    }

    /**
     * 获取keyID.
     * 
     * @param keyID
     *            要设置的keyID
     */
    public void setKeyID(Integer keyID) {
        this.keyID = keyID;
    }

    /**
     * 设置buyStaff.
     * 
     * @return 返回buyStaff
     */
    public String getBuyStaff() {
        return buyStaff;
    }

    /**
     * 获取buyStaff.
     * 
     * @param buyStaff
     *            要设置的buyStaff
     */
    public void setBuyStaff(String buyStaff) {
        this.buyStaff = buyStaff;
    }

    /**
     * 设置college.
     * 
     * @return 返回college
     */
    public String getCollege() {
        return college;
    }

    /**
     * 获取college.
     * 
     * @param college
     *            要设置的college
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * 设置tmp2.
     * 
     * @return 返回tmp2
     */
    public String gettmp2() {
        return tmp2;
    }

    /**
     * 获取tmp2.
     * 
     * @param tmp22
     *            要设置的tmp2
     */
    public void settmp2(String tmp22) {
        this.tmp2 = tmp22;
    }

    /**
     * 设置tmp1.
     * 
     * @return 返回tmp1
     */
    public String gettmp1() {
        return tmp1;
    }

    /**
     * 获取tmp1.
     * 
     * @param tmp11
     *            要设置的tmp1
     */
    public void settmp1(String tmp11) {
        this.tmp1 = tmp11;
    }

    /**
     * 设置tmp3.
     * 
     * @return 返回tmp3
     */
    public String gettmp3() {
        return tmp3;
    }

    /**
     * 获取tmp3.
     * 
     * @param tmp33
     *            要设置的tmp3
     */
    public void settmp3(String tmp33) {
        this.tmp3 = tmp33;
    }

    /**
     * 设置manager.
     * 
     * @return 返回manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * 获取manager.
     * 
     * @param manager
     *            要设置的manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 设置eqmType.
     * 
     * @return 返回eqmType
     */
    public String getEqmType() {
        return eqmType;
    }

    /**
     * 获取eqmType.
     * 
     * @param eqmType
     *            要设置的eqmType
     */
    public void setEqmType(String eqmType) {
        this.eqmType = eqmType;
    }

    /**
     * 设置buyTime.
     * 
     * @return 返回buyTime
     */
    public Date getBuyTime() {
        return buyTime;
    }

    /**
     * 获取buyTime.
     * 
     * @param buyTime
     *            要设置的buyTime
     */
    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    /**
     * 设置modifyTime.
     * 
     * @return 返回modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 获取modifyTime.
     * 
     * @param modifyTime
     *            要设置的modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 设置modifyTime.
     * 
     * @return 返回modifyTime
     */
    public String getEqmStatus() {
        return eqmStatus;
    }

    /**
     * 获取eqmStatus.
     * 
     * @param eqmStatus
     *            要设置的eqmStatus
     */
    public void setEqmStatus(String eqmStatus) {
        this.eqmStatus = eqmStatus;
    }

    /**
     * 设置managerId.
     * 
     * @return 返回managerId
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * 获取managerId.
     * 
     * @param managerId
     *            要设置的managerId
     */
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

}
