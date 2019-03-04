package ds.pojo;

public class Admin {
    private Long adminId;

    private String adminName;

    private String adminPassword;

    private Boolean valued;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public Boolean getValued() {
        return valued;
    }

    public void setValued(Boolean valued) {
        this.valued = valued;
    }
}