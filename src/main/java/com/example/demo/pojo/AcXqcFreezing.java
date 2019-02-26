package com.example.demo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AcXqcFreezing implements Serializable {

    /**
     * ac_xqc_freezing
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "AcXqcFreezing{" +
                "bizNo='" + bizNo + '\'' +
                ", txnCode='" + txnCode + '\'' +
                ", xqcOpenId='" + xqcOpenId + '\'' +
                ", accountType='" + accountType + '\'' +
                ", payBrchType='" + payBrchType + '\'' +
                ", payBrchCode='" + payBrchCode + '\'' +
                ", payBrchName='" + payBrchName + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", acctName='" + acctName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", freezeAmt=" + freezeAmt +
                ", transDt='" + transDt + '\'' +
                ", transTime='" + transTime + '\'' +
                ", transRemark='" + transRemark + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                ", transStatus='" + transStatus + '\'' +
                ", freezingCode='" + freezingCode + '\'' +
                ", remark='" + remark + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", operStatus='" + operStatus + '\'' +
                ", validStatus='" + validStatus + '\'' +
                ", operType='" + operType + '\'' +
                ", versionNum=" + versionNum +
                ", createBy='" + createBy + '\'' +
                ", createDt=" + createDt +
                ", updateBy='" + updateBy + '\'' +
                ", updateDt=" + updateDt +
                '}';
    }

    /**
     * 业务流水号 发起方生成
     */
    private String bizNo;

    /**
     * 业务流水编号
     */
    private String txnCode;

    /**
     * 薪起程openId
     */
    private String xqcOpenId;

    /**
     * 账户类型 WALLET_CUP 银联钱包,BANK_CARD 银行卡,TRUST信托
     */
    private String accountType;

    /**
     * 
     */
    private String payBrchType;

    /**
     * 支付机构主键
     */
    private String payBrchCode;

    /**
     * 
     */
    private String payBrchName;

    /**
     * 支付机构下开立的账号
     */
    private String acctNo;

    /**
     * 支付机构下开立的账号名称
     */
    private String acctName;

    /**
     * 薪起程账户系统里的账户标识(唯一)
     */
    private String accountId;

    /**
     * 冻结金额
     */
    private BigDecimal freezeAmt;

    /**
     * 交易日期
     */
    private String transDt;

    /**
     * 交易时间
     */
    private String transTime;

    /**
     * 交易摘要
     */
    private String transRemark;

    /**
     * 业务状态  00待发送，01已发送，02 交易完成 
     */
    private String sendStatus;

    /**
     * 交易状态-- 参考StatusDefine
     */
    private String transStatus;

    /**
     * 返回的冻结编号
     */
    private String freezingCode;

    /**
     * 备注描述
     */
    private String remark;

    /**
     * 返回码结果码
     */
    private String returnCode;

    /**
     * 返回处理结果描述
     */
    private String returnMsg;

    /**
     * 业务状态操作状态PS015 PS020 PS040
     */
    private String operStatus;

    /**
     * 有效状态 ET01未生效 ET02已生效
     */
    private String validStatus;

    /**
     * 操作类型
     */
    private String operType;

    /**
     * 数据版本号
     */
    private Integer versionNum;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建日期
     */
    private Date createDt;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新日期
     */
    private Date updateDt;

    public AcXqcFreezing() {
    }

    public AcXqcFreezing(String bizNo, String acctNo, String acctName, String accountId, BigDecimal freezeAmt, String transDt,
                         String transTime, String transRemark, String sendStatus, String transStatus) {
        this.bizNo = bizNo;
        this.acctNo = acctNo;
        this.acctName = acctName;
        this.accountId = accountId;
        this.freezeAmt = freezeAmt;
        this.transDt = transDt;
        this.transTime = transTime;
        this.transRemark = transRemark;
        this.sendStatus = sendStatus;
        this.transStatus = transStatus;
    }

    public void fill(String operStatus, String validStatus, String operType, String createBy, Date createDt, String updateBy, Date updateDt) {
        this.operStatus = operStatus;
        this.validStatus = validStatus;
        this.operType = operType;
        this.createBy = createBy;
        this.createDt = createDt;
        this.updateBy = updateBy;
        this.updateDt = updateDt;
    }

    /**
     * 业务流水号 发起方生成
     * @return biz_no 业务流水号 发起方生成
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * 业务流水号 发起方生成
     * @param bizNo 业务流水号 发起方生成
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo == null ? null : bizNo.trim();
    }

    /**
     * 业务流水编号
     * @return txn_code 业务流水编号
     */
    public String getTxnCode() {
        return txnCode;
    }

    /**
     * 业务流水编号
     * @param txnCode 业务流水编号
     */
    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode == null ? null : txnCode.trim();
    }

    /**
     * 薪起程openId
     * @return xqc_open_id 薪起程openId
     */
    public String getXqcOpenId() {
        return xqcOpenId;
    }

    /**
     * 薪起程openId
     * @param xqcOpenId 薪起程openId
     */
    public void setXqcOpenId(String xqcOpenId) {
        this.xqcOpenId = xqcOpenId == null ? null : xqcOpenId.trim();
    }

    /**
     * 账户类型 WALLET_CUP 银联钱包,BANK_CARD 银行卡,TRUST信托
     * @return account_type 账户类型 WALLET_CUP 银联钱包,BANK_CARD 银行卡,TRUST信托
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 账户类型 WALLET_CUP 银联钱包,BANK_CARD 银行卡,TRUST信托
     * @param accountType 账户类型 WALLET_CUP 银联钱包,BANK_CARD 银行卡,TRUST信托
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * 
     * @return pay_brch_type 
     */
    public String getPayBrchType() {
        return payBrchType;
    }

    /**
     * 
     * @param payBrchType 
     */
    public void setPayBrchType(String payBrchType) {
        this.payBrchType = payBrchType == null ? null : payBrchType.trim();
    }

    /**
     * 支付机构主键
     * @return pay_brch_code 支付机构主键
     */
    public String getPayBrchCode() {
        return payBrchCode;
    }

    /**
     * 支付机构主键
     * @param payBrchCode 支付机构主键
     */
    public void setPayBrchCode(String payBrchCode) {
        this.payBrchCode = payBrchCode == null ? null : payBrchCode.trim();
    }

    /**
     * 
     * @return pay_brch_name 
     */
    public String getPayBrchName() {
        return payBrchName;
    }

    /**
     * 
     * @param payBrchName 
     */
    public void setPayBrchName(String payBrchName) {
        this.payBrchName = payBrchName == null ? null : payBrchName.trim();
    }

    /**
     * 支付机构下开立的账号
     * @return acct_no 支付机构下开立的账号
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * 支付机构下开立的账号
     * @param acctNo 支付机构下开立的账号
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    /**
     * 支付机构下开立的账号名称
     * @return acct_name 支付机构下开立的账号名称
     */
    public String getAcctName() {
        return acctName;
    }

    /**
     * 支付机构下开立的账号名称
     * @param acctName 支付机构下开立的账号名称
     */
    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    /**
     * 薪起程账户系统里的账户标识(唯一)
     * @return account_id 薪起程账户系统里的账户标识(唯一)
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 薪起程账户系统里的账户标识(唯一)
     * @param accountId 薪起程账户系统里的账户标识(唯一)
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 冻结金额
     * @return freeze_amt 冻结金额
     */
    public BigDecimal getFreezeAmt() {
        return freezeAmt;
    }

    /**
     * 冻结金额
     * @param freezeAmt 冻结金额
     */
    public void setFreezeAmt(BigDecimal freezeAmt) {
        this.freezeAmt = freezeAmt;
    }

    /**
     * 交易日期
     * @return trans_dt 交易日期
     */
    public String getTransDt() {
        return transDt;
    }

    /**
     * 交易日期
     * @param transDt 交易日期
     */
    public void setTransDt(String transDt) {
        this.transDt = transDt == null ? null : transDt.trim();
    }

    /**
     * 交易时间
     * @return trans_time 交易时间
     */
    public String getTransTime() {
        return transTime;
    }

    /**
     * 交易时间
     * @param transTime 交易时间
     */
    public void setTransTime(String transTime) {
        this.transTime = transTime == null ? null : transTime.trim();
    }

    /**
     * 交易摘要
     * @return trans_remark 交易摘要
     */
    public String getTransRemark() {
        return transRemark;
    }

    /**
     * 交易摘要
     * @param transRemark 交易摘要
     */
    public void setTransRemark(String transRemark) {
        this.transRemark = transRemark == null ? null : transRemark.trim();
    }

    /**
     * 业务状态  00待发送，01已发送，02 交易完成 
     * @return send_status 业务状态  00待发送，01已发送，02 交易完成 
     */
    public String getSendStatus() {
        return sendStatus;
    }

    /**
     * 业务状态  00待发送，01已发送，02 交易完成 
     * @param sendStatus 业务状态  00待发送，01已发送，02 交易完成 
     */
    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus == null ? null : sendStatus.trim();
    }

    /**
     * 交易状态-- 参考StatusDefine
     * @return trans_status 交易状态-- 参考StatusDefine
     */
    public String getTransStatus() {
        return transStatus;
    }

    /**
     * 交易状态-- 参考StatusDefine
     * @param transStatus 交易状态-- 参考StatusDefine
     */
    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    /**
     * 返回的冻结编号
     * @return freezing_code 返回的冻结编号
     */
    public String getFreezingCode() {
        return freezingCode;
    }

    /**
     * 返回的冻结编号
     * @param freezingCode 返回的冻结编号
     */
    public void setFreezingCode(String freezingCode) {
        this.freezingCode = freezingCode == null ? null : freezingCode.trim();
    }

    /**
     * 备注描述
     * @return remark 备注描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注描述
     * @param remark 备注描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 返回码结果码
     * @return return_code 返回码结果码
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * 返回码结果码
     * @param returnCode 返回码结果码
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    /**
     * 返回处理结果描述
     * @return return_msg 返回处理结果描述
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * 返回处理结果描述
     * @param returnMsg 返回处理结果描述
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg == null ? null : returnMsg.trim();
    }

    /**
     * 业务状态操作状态PS015 PS020 PS040
     * @return oper_status 业务状态操作状态PS015 PS020 PS040
     */
    public String getOperStatus() {
        return operStatus;
    }

    /**
     * 业务状态操作状态PS015 PS020 PS040
     * @param operStatus 业务状态操作状态PS015 PS020 PS040
     */
    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus == null ? null : operStatus.trim();
    }

    /**
     * 有效状态 ET01未生效 ET02已生效
     * @return valid_status 有效状态 ET01未生效 ET02已生效
     */
    public String getValidStatus() {
        return validStatus;
    }

    /**
     * 有效状态 ET01未生效 ET02已生效
     * @param validStatus 有效状态 ET01未生效 ET02已生效
     */
    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus == null ? null : validStatus.trim();
    }

    /**
     * 操作类型
     * @return oper_type 操作类型
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 操作类型
     * @param operType 操作类型
     */
    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    /**
     * 数据版本号
     * @return version_num 数据版本号
     */
    public Integer getVersionNum() {
        return versionNum;
    }

    /**
     * 数据版本号
     * @param versionNum 数据版本号
     */
    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    /**
     * 创建者
     * @return create_by 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 创建日期
     * @return create_dt 创建日期
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * 创建日期
     * @param createDt 创建日期
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * 更新者
     * @return update_by 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 更新日期
     * @return update_dt 更新日期
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * 更新日期
     * @param updateDt 更新日期
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }


}