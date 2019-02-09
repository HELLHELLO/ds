package ds.pojo;

import java.util.Date;

public class TraceAccess {
    private Long traceAccessId;

    private Long traceManagerId;

    private Long shopId;

    private Long cid;

    private Date created;

    private Date updated;

    private Boolean valued;

    public Long getTraceAccessId() {
        return traceAccessId;
    }

    public void setTraceAccessId(Long traceAccessId) {
        this.traceAccessId = traceAccessId;
    }

    public Long getTraceManagerId() {
        return traceManagerId;
    }

    public void setTraceManagerId(Long traceManagerId) {
        this.traceManagerId = traceManagerId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Boolean getValued() {
        return valued;
    }

    public void setValued(Boolean valued) {
        this.valued = valued;
    }
}