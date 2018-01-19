package com.medical.po;

public class Adminmenu {
    private Integer menuid;

    private String menuname;

    private Integer menufatherid;

    private String menuurl;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public Integer getMenufatherid() {
        return menufatherid;
    }

    public void setMenufatherid(Integer menufatherid) {
        this.menufatherid = menufatherid;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }
}