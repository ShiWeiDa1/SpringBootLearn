/** 
* Project Name:aw 
* File Name:ThirdTagSeqNumsDTO.java 
* Package Name:so.sao.ucode.aw.dto 
* Date:2019年10月22日下午2:23:10 
* Copyright (c) 2019, TouYun All Rights Reserved. 
* 
*/
package com.regan.thread.com.regan.model;

import java.io.Serializable;
import java.util.Objects;

/** 
* @author user-
* @version 1.0.0
* @date 2019年10月22日 下午2:23:10
*/
public class ThirdTagSeqNumsDTO implements Serializable {

    private static final long serialVersionUID = 9124898337773637086L;

    private Long eseId; // 企业id
    private Long tagBatchId; // 批次Id
    private Long eseConfigId; // 配置id
    private Long seqnumStart; // 系统开始序号
    private Long seqnumEnd; // 系统结束序号
    private Long eseSeqnumStart; // 企业开始序号
    private Long eseSeqnumEnd; // 企业结束序号
    private String domainUri; // 域名（分库键域名）
    private Long productId; // 产品id,aw入库暂时不用

    public Long getEseId() {
        return eseId;
    }

    public void setEseId(Long eseId) {
        this.eseId = eseId;
    }

    public Long getTagBatchId() {
        return tagBatchId;
    }

    public void setTagBatchId(Long tagBatchId) {
        this.tagBatchId = tagBatchId;
    }

    public Long getEseConfigId() {
        return eseConfigId;
    }

    public void setEseConfigId(Long eseConfigId) {
        this.eseConfigId = eseConfigId;
    }

    public Long getSeqnumStart() {
        return seqnumStart;
    }

    public void setSeqnumStart(Long seqnumStart) {
        this.seqnumStart = seqnumStart;
    }

    public Long getSeqnumEnd() {
        return seqnumEnd;
    }

    public void setSeqnumEnd(Long seqnumEnd) {
        this.seqnumEnd = seqnumEnd;
    }

    public Long getEseSeqnumStart() {
        return eseSeqnumStart;
    }

    public void setEseSeqnumStart(Long eseSeqnumStart) {
        this.eseSeqnumStart = eseSeqnumStart;
    }

    public Long getEseSeqnumEnd() {
        return eseSeqnumEnd;
    }

    public void setEseSeqnumEnd(Long eseSeqnumEnd) {
        this.eseSeqnumEnd = eseSeqnumEnd;
    }

    public String getDomainUri() {
        return domainUri;
    }

    public void setDomainUri(String domainUri) {
        this.domainUri = domainUri;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ThirdTagSeqNumsDTO{" +
                "eseId=" + eseId +
                ", tagBatchId=" + tagBatchId +
                ", eseConfigId=" + eseConfigId +
                ", seqnumStart=" + seqnumStart +
                ", seqnumEnd=" + seqnumEnd +
                ", eseSeqnumStart=" + eseSeqnumStart +
                ", eseSeqnumEnd=" + eseSeqnumEnd +
                ", domainUri='" + domainUri + '\'' +
                ", productId=" + productId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThirdTagSeqNumsDTO that = (ThirdTagSeqNumsDTO) o;
        return Objects.equals(eseId, that.eseId) &&
                Objects.equals(tagBatchId, that.tagBatchId) &&
                Objects.equals(eseConfigId, that.eseConfigId) &&
                Objects.equals(seqnumStart, that.seqnumStart) &&
                Objects.equals(seqnumEnd, that.seqnumEnd) &&
                Objects.equals(eseSeqnumStart, that.eseSeqnumStart) &&
                Objects.equals(eseSeqnumEnd, that.eseSeqnumEnd) &&
                Objects.equals(domainUri, that.domainUri) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eseId, tagBatchId, eseConfigId, seqnumStart, seqnumEnd, eseSeqnumStart, eseSeqnumEnd, domainUri, productId);
    }
}
