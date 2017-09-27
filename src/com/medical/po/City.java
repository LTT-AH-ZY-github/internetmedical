package com.medical.po;

public class City {
    private String citycode;

    private String cityname;

    private String cityparentcode;

    private Integer citylevel;

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getCityparentcode() {
        return cityparentcode;
    }

    public void setCityparentcode(String cityparentcode) {
        this.cityparentcode = cityparentcode == null ? null : cityparentcode.trim();
    }

    public Integer getCitylevel() {
        return citylevel;
    }

    public void setCitylevel(Integer citylevel) {
        this.citylevel = citylevel;
    }
}