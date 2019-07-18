package com.wayn.commom.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wayn.commom.base.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author wayn
 * @since 2019-06-27
 */
@TableName("sys_dict")
public class Dict extends BaseEntity<Dict> {

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标签名
     */
    private String name;

    /**
     * 数据值
     */
    private String value;

    /**
     * 1 启用  -1 禁用
     */
    private Integer dictState;

    /**
     * 1 字典类型  2 类型对应值
     */
    private Integer type;

    /**
     * 排序（升序）
     */
    private BigDecimal sort;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    public Long getId() {
        return id;
    }

    public Dict setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dict setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Dict setValue(String value) {
        this.value = value;
        return this;
    }

    public Integer getDictState() {
        return dictState;
    }

    public Dict setDictState(Integer dictState) {
        this.dictState = dictState;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Dict setType(Integer type) {
        this.type = type;
        return this;
    }

    public BigDecimal getSort() {
        return sort;
    }

    public Dict setSort(BigDecimal sort) {
        this.sort = sort;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Dict setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Dict setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public Dict setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Dict setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Dict setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public Dict setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getDictType() {
        return dictType;
    }

    public Dict setDictType(String dictType) {
        this.dictType = dictType;
        return this;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", dictState=" + dictState +
                ", type=" + type +
                ", sort=" + sort +
                ", dictType='" + dictType + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}