package ds.pojo;

import java.util.Date;

public class ItemPic {
    private Long picId;

    private Long itemsId;

    private String picDec;

    private String picUrl;

    private Boolean picStatu;

    private Boolean picMaster;

    private Date modifiedTime;

    private Boolean valued;

    private String userId;

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public String getPicDec() {
        return picDec;
    }

    public void setPicDec(String picDec) {
        this.picDec = picDec == null ? null : picDec.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Boolean getPicStatu() {
        return picStatu;
    }

    public void setPicStatu(Boolean picStatu) {
        this.picStatu = picStatu;
    }

    public Boolean getPicMaster() {
        return picMaster;
    }

    public void setPicMaster(Boolean picMaster) {
        this.picMaster = picMaster;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean getValued() {
        return valued;
    }

    public void setValued(Boolean valued) {
        this.valued = valued;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}