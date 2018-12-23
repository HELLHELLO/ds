package ds.pojo;

import java.util.Date;

public class Cart {
    private Long cartId;

    private Long userId;

    private Long itemId;

    private Integer itemNum;

    private Date itemUpdateTime;

    private Byte itemStatu;

    private Boolean valued;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Date getItemUpdateTime() {
        return itemUpdateTime;
    }

    public void setItemUpdateTime(Date itemUpdateTime) {
        this.itemUpdateTime = itemUpdateTime;
    }

    public Byte getItemStatu() {
        return itemStatu;
    }

    public void setItemStatu(Byte itemStatu) {
        this.itemStatu = itemStatu;
    }

    public Boolean getValued() {
        return valued;
    }

    public void setValued(Boolean valued) {
        this.valued = valued;
    }
}