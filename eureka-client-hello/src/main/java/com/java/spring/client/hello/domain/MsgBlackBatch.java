package com.java.spring.client.hello.domain;

import com.java.spring.client.hello.base.BaseDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "MSG_BLACK_BATCH")
public class MsgBlackBatch extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String customerTarget;
    private Integer sourceSystem;
    private String customerRemark;
    private Integer customerNum;
    private Integer organization;
    private Integer customerType;
    private String operator;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerTarget() {
        return customerTarget;
    }

    public void setCustomerTarget(String customerTarget) {
        this.customerTarget = customerTarget == null ? null : customerTarget.trim();
    }

    public Integer getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(Integer sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark == null ? null : customerRemark.trim();
    }

    public Integer getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(Integer customerNum) {
        this.customerNum = customerNum;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerTarget=").append(customerTarget);
        sb.append(", sourceSystem=").append(sourceSystem);
        sb.append(", customerRemark=").append(customerRemark);
        sb.append(", customerNum=").append(customerNum);
        sb.append(", organization=").append(organization);
        sb.append(", customerType=").append(customerType);
        sb.append(", operator=").append(operator);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}