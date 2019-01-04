package ds.pojo;

import java.util.Date;

public class Brands {
    private Long brandId;

    private String brandName;

    private String brandImage;

    private String brandDec;

    private String brandUrl;

    private Boolean valued;

    private Date updated;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage == null ? null : brandImage.trim();
    }

    public String getBrandDec() {
        return brandDec;
    }

    public void setBrandDec(String brandDec) {
        this.brandDec = brandDec == null ? null : brandDec.trim();
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl == null ? null : brandUrl.trim();
    }

    public Boolean getValued() {
        return valued;
    }

    public void setValued(Boolean valued) {
        this.valued = valued;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}