package com.medical.po.custom.user.order;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class UserOrderListInUser {

    
        /**
         * inhospname : 安徽省安医大二附院
         * inhosploginpix : http://oytv6cmyw.bkt.clouddn.com/20171103064014944735.jpg
         * userorderid : 128
         * familyname : 王五
         * usersickpic :
         * userorderprice : 5
         * usersickdesc : 透明人头痛发热
         * doctitle : 住院医师
         * familyage : 18
         * userorderactualhospitalizationid : 4
         * userorderappointment : 2017-12-21 上午
         * userorderstatename : 评价完成
         * docaddresslocation : 安徽大学老区
         * userorderdeposit : 200
         * docloginid : 49
         * dochuanxinaccount : doc_49
         * familymale : 男
         * docloginpix : http://oytv6cmyw.bkt.clouddn.com/20171121021117806785.jpg
         * docname : 六角恐龙
         * userorderstateid : 10
         */

        private String inhospname;
        private String inhosploginpix;
        private int userorderid;
        private String familyname;
        private String usersickpic;
        @NumberFormat(style=Style.PERCENT)
        private BigDecimal userorderprice;
        private String usersickdesc;
        private String doctitle;
        private int familyage;
        private int userorderactualhospitalizationid;
        private String userorderappointment;
        private String userorderstatename;
        private String docaddresslocation;
        @NumberFormat(style=Style.PERCENT)
        private Double userorderdeposit;
        private int docloginid;
        private String dochuanxinaccount;
        private String familymale;
        private String docloginpix;
        private String docname;
        private int userorderstateid;

        public String getInhospname() {
            return inhospname;
        }

        public void setInhospname(String inhospname) {
            this.inhospname = inhospname;
        }

        public String getInhosploginpix() {
            return inhosploginpix;
        }

        public void setInhosploginpix(String inhosploginpix) {
            this.inhosploginpix = inhosploginpix;
        }

        public int getUserorderid() {
            return userorderid;
        }

        public void setUserorderid(int userorderid) {
            this.userorderid = userorderid;
        }

        public String getFamilyname() {
            return familyname;
        }

        public void setFamilyname(String familyname) {
            this.familyname = familyname;
        }

        public String getUsersickpic() {
            return usersickpic;
        }

        public void setUsersickpic(String usersickpic) {
            this.usersickpic = usersickpic;
        }
        
        public BigDecimal getUserorderprice() {
            return userorderprice;
        }

        public void setUserorderprice(BigDecimal userorderprice) {
            this.userorderprice = userorderprice;
        }

        public String getUsersickdesc() {
            return usersickdesc;
        }

        public void setUsersickdesc(String usersickdesc) {
            this.usersickdesc = usersickdesc;
        }

        public String getDoctitle() {
            return doctitle;
        }

        public void setDoctitle(String doctitle) {
            this.doctitle = doctitle;
        }

        public int getFamilyage() {
            return familyage;
        }

        public void setFamilyage(int familyage) {
            this.familyage = familyage;
        }

        public int getUserorderactualhospitalizationid() {
            return userorderactualhospitalizationid;
        }

        public void setUserorderactualhospitalizationid(int userorderactualhospitalizationid) {
            this.userorderactualhospitalizationid = userorderactualhospitalizationid;
        }

        public String getUserorderappointment() {
            return userorderappointment;
        }

        public void setUserorderappointment(String userorderappointment) {
            this.userorderappointment = userorderappointment;
        }

        public String getUserorderstatename() {
            return userorderstatename;
        }

        public void setUserorderstatename(String userorderstatename) {
            this.userorderstatename = userorderstatename;
        }

        public String getDocaddresslocation() {
            return docaddresslocation;
        }

        public void setDocaddresslocation(String docaddresslocation) {
            this.docaddresslocation = docaddresslocation;
        }

        public Double getUserorderdeposit() {
            return userorderdeposit;
        }

        public void setUserorderdeposit(Double userorderdeposit) {
            this.userorderdeposit = userorderdeposit;
        }

        public int getDocloginid() {
            return docloginid;
        }

        public void setDocloginid(int docloginid) {
            this.docloginid = docloginid;
        }

        public String getDochuanxinaccount() {
            return dochuanxinaccount;
        }

        public void setDochuanxinaccount(String dochuanxinaccount) {
            this.dochuanxinaccount = dochuanxinaccount;
        }

        public String getFamilymale() {
            return familymale;
        }

        public void setFamilymale(String familymale) {
            this.familymale = familymale;
        }

        public String getDocloginpix() {
            return docloginpix;
        }

        public void setDocloginpix(String docloginpix) {
            this.docloginpix = docloginpix;
        }

        public String getDocname() {
            return docname;
        }

        public void setDocname(String docname) {
            this.docname = docname;
        }

        public int getUserorderstateid() {
            return userorderstateid;
        }

        public void setUserorderstateid(int userorderstateid) {
            this.userorderstateid = userorderstateid;
        }
    }

