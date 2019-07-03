package com.jeesite.modules.aa.vo;

import com.jeesite.modules.aa.entity.PictureType;
import com.jeesite.modules.aa.entity.PictureUser;

import java.util.List;

public class PictureTypeAndUserVO {
    private PictureType pictureType;
    private PictureUser pictureUser;
    private PictureType parentPictureType;
    private List<PictureUser> children;

    public PictureType getPictureType() {
        return pictureType;
    }

    public void setPictureType(PictureType pictureType) {
        this.pictureType = pictureType;
    }

    public PictureUser getPictureUser() {
        return pictureUser;
    }

    public PictureType getParentPictureType() {
        return parentPictureType;
    }

    public void setParentPictureType(PictureType parentPictureType) {
        this.parentPictureType = parentPictureType;
    }

    public List<PictureUser> getChildren() {
        return children;
    }

    public void setChildren(List<PictureUser> children) {
        this.children = children;
    }

    public void setPictureUser(PictureUser pictureUser) {
        this.pictureUser = pictureUser;
    }
}
