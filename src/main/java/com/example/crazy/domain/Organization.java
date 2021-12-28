package com.example.crazy.domain;

public class Organization {
    private String orgName;

    private String nameCn;

    private String image;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgName=").append(orgName);
        sb.append(", nameCn=").append(nameCn);
        sb.append(", image=").append(image);
        sb.append("]");
        return sb.toString();
    }
}