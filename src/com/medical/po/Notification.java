package com.medical.po;

import java.util.Date;

public class Notification {
    private Integer notificationid;

    private String notificationtitle;

    private String notificationwords;

    private String notificationdata;

    private Date notificationcreatetime;

    private Date notificationreadtime;

    private Integer notificationsenderid;

    private Integer notificationreceiverid;

    private Boolean notificationread;

    private Boolean notificationremove;

    private Integer notificationtypeid;

    public Integer getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(Integer notificationid) {
        this.notificationid = notificationid;
    }

    public String getNotificationtitle() {
        return notificationtitle;
    }

    public void setNotificationtitle(String notificationtitle) {
        this.notificationtitle = notificationtitle == null ? null : notificationtitle.trim();
    }

    public String getNotificationwords() {
        return notificationwords;
    }

    public void setNotificationwords(String notificationwords) {
        this.notificationwords = notificationwords == null ? null : notificationwords.trim();
    }

    public String getNotificationdata() {
        return notificationdata;
    }

    public void setNotificationdata(String notificationdata) {
        this.notificationdata = notificationdata == null ? null : notificationdata.trim();
    }

    public Date getNotificationcreatetime() {
        return notificationcreatetime;
    }

    public void setNotificationcreatetime(Date notificationcreatetime) {
        this.notificationcreatetime = notificationcreatetime;
    }

    public Date getNotificationreadtime() {
        return notificationreadtime;
    }

    public void setNotificationreadtime(Date notificationreadtime) {
        this.notificationreadtime = notificationreadtime;
    }

    public Integer getNotificationsenderid() {
        return notificationsenderid;
    }

    public void setNotificationsenderid(Integer notificationsenderid) {
        this.notificationsenderid = notificationsenderid;
    }

    public Integer getNotificationreceiverid() {
        return notificationreceiverid;
    }

    public void setNotificationreceiverid(Integer notificationreceiverid) {
        this.notificationreceiverid = notificationreceiverid;
    }

    public Boolean getNotificationread() {
        return notificationread;
    }

    public void setNotificationread(Boolean notificationread) {
        this.notificationread = notificationread;
    }

    public Boolean getNotificationremove() {
        return notificationremove;
    }

    public void setNotificationremove(Boolean notificationremove) {
        this.notificationremove = notificationremove;
    }

    public Integer getNotificationtypeid() {
        return notificationtypeid;
    }

    public void setNotificationtypeid(Integer notificationtypeid) {
        this.notificationtypeid = notificationtypeid;
    }
}