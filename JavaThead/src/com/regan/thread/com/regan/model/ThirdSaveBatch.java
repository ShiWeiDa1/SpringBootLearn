package com.regan.thread.com.regan.model;


import java.io.Serializable;

/**
 * 环节保存批次
 * 
 * @author jianbiao.wu
 *
 */
public class ThirdSaveBatch implements Serializable {

    private String id;

    private Long eseId;

    private String uri;
    
    private boolean over;
    
    private Integer seqCount;

    private Long tagBatchId;
    
    private Long eseConfigId;
    
    private Long seqnumStart;
    
    private Long seqnumEnd;
    
    private Long seqnumCurrent;
    
    private Long eseSeqnumStart;
    
    private Long eseSeqnumEnd;
    
    private Long productId;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

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
    
    public Long getSeqnumCurrent() {
        return seqnumCurrent;
    }

    public void setSeqnumCurrent(Long seqnumCurrent) {
        this.seqnumCurrent = seqnumCurrent;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

}
