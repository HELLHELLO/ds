package ds.pojo;

import java.util.Date;

public class TraceMng {
    private Long mngId;

    private String mngName;

    private Long traceId;

    private Long itemCatId;

    private Long itemsId;

    private Long itemId;

    private Long shopId;

    private Date created;

    private Date updated;

    private Byte verifed;

    private Boolean valued;

    private String data;

    public Long getMngId() {
        return mngId;
    }

    public void setMngId(Long mngId) {
        this.mngId = mngId;
    }

    public String getMngName() {
        return mngName;
    }

    public void setMngName(String mngName) {
        this.mngName = mngName == null ? null : mngName.trim();
    }

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
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

    public Byte getVerifed() {
        return verifed;
    }

    public void setVerifed(Byte verifed) {
        this.verifed = verifed;
    }

    public Boolean getValued() {
        return valued;
    }

    public void setValued(Boolean valued) {
        this.valued = valued;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}