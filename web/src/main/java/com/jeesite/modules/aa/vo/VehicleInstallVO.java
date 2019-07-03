package com.jeesite.modules.aa.vo;

public class VehicleInstallVO {
    private String project;
    private String projectName;
    private Integer sort;
    private String vehicleInstallId;
    private boolean isSelected;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getVehicleInstallId() {
        return vehicleInstallId;
    }

    public void setVehicleInstallId(String vehicleInstallId) {
        this.vehicleInstallId = vehicleInstallId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
