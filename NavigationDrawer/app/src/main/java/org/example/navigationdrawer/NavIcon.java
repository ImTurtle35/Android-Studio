package org.example.navigationdrawer;

public class NavIcon {
    public int drawableId;
    public String viewname;
    public NavIcon(int drawableId, String viewname) {
        this.drawableId = drawableId;
        this.viewname = viewname;
    }

    public String getName() {
        return viewname;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setName(String viewname) {
        this.viewname = viewname;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }
}
