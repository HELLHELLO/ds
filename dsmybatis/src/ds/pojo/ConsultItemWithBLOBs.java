package ds.pojo;

public class ConsultItemWithBLOBs extends ConsultItem {
    private String itemDesc;

    private String consultTx;

    private String resposeTx;

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    public String getConsultTx() {
        return consultTx;
    }

    public void setConsultTx(String consultTx) {
        this.consultTx = consultTx == null ? null : consultTx.trim();
    }

    public String getResposeTx() {
        return resposeTx;
    }

    public void setResposeTx(String resposeTx) {
        this.resposeTx = resposeTx == null ? null : resposeTx.trim();
    }
}