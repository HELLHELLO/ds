package ds.pojo;

public class UserShopWithBLOBs extends UserShop {
    private String shopHead;

    private String data;

    public String getShopHead() {
        return shopHead;
    }

    public void setShopHead(String shopHead) {
        this.shopHead = shopHead == null ? null : shopHead.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}