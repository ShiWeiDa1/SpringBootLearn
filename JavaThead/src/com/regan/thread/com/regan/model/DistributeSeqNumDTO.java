package com.regan.thread.com.regan.model;

import java.io.Serializable;

public class DistributeSeqNumDTO implements Serializable {
    private static final long serialVersionUID = -1970085848394684500L;

    private Long eseId;

    private String uri;

    private Integer seqCount = 1;
    
    private Integer totalCount = 1;

    public Long getEseId() {
        return eseId;
    }

    public void setEseId(Long eseId) {
        this.eseId = eseId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getSeqCount() {
        return seqCount;
    }

    public void setSeqCount(Integer seqCount) {
        this.seqCount = seqCount;
    }
    
    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    
}
