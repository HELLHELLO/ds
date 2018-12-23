package ds.pojo;

public class Expert {
    private Long expert;

    private String name;

    private String category;

    private Long fee;

    private Boolean valued;

    public Long getExpert() {
        return expert;
    }

    public void setExpert(Long expert) {
        this.expert = expert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Boolean getValued() {
        return valued;
    }

    public void setValued(Boolean valued) {
        this.valued = valued;
    }
}