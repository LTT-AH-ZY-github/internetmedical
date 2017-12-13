package com.medical.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.medical.controller.validation.Add;
import com.medical.controller.validation.Del;
import com.medical.controller.validation.Get;
import com.medical.controller.validation.List;
import com.medical.controller.validation.Update;
import com.medical.controller.validation.ValidGroup1;
import com.medical.controller.validation.ValidGroup2;



public class Doctoraddress {
	
	

	@NotNull(message="地址id为空",groups= {Update.class,Del.class,Get.class})
    private Integer docaddressid;
    
	@NotBlank(message="地址位置为空",groups= {Add.class})
    private String docaddresslocation;
	
	@NotBlank(message="省为空",groups= {Add.class})
    private String docaddressprovince;
	
	@NotBlank(message="市为空",groups= {Add.class})
    private String docaddresscity;
	
	@NotBlank(message="区县为空",groups= {Add.class})
    private String docaddressarea;
	
	private String docaddressother;
	
	@NotBlank(message="经度为空",groups= {Add.class})
    private String docaddresslon;
	
	@NotBlank(message="纬度为空",groups= {Add.class})
    private String docaddresslat;
	
	@NotNull(message="医生登录id为空",groups= {Add.class,Update.class,Del.class,Get.class,List.class})
    private Integer docloginid;

    private Boolean docaddresstype;

    private Boolean docaddresschecked;

    public Integer getDocaddressid() {
        return docaddressid;
    }

    public void setDocaddressid(Integer docaddressid) {
        this.docaddressid = docaddressid;
    }

    public String getDocaddresslocation() {
        return docaddresslocation;
    }

    public void setDocaddresslocation(String docaddresslocation) {
        this.docaddresslocation = docaddresslocation == null ? null : docaddresslocation.trim();
    }

    public String getDocaddressprovince() {
        return docaddressprovince;
    }

    public void setDocaddressprovince(String docaddressprovince) {
        this.docaddressprovince = docaddressprovince == null ? null : docaddressprovince.trim();
    }

    public String getDocaddresscity() {
        return docaddresscity;
    }

    public void setDocaddresscity(String docaddresscity) {
        this.docaddresscity = docaddresscity == null ? null : docaddresscity.trim();
    }

    public String getDocaddressarea() {
        return docaddressarea;
    }

    public void setDocaddressarea(String docaddressarea) {
        this.docaddressarea = docaddressarea == null ? null : docaddressarea.trim();
    }

    public String getDocaddressother() {
        return docaddressother;
    }

    public void setDocaddressother(String docaddressother) {
        this.docaddressother = docaddressother == null ? null : docaddressother.trim();
    }

    public String getDocaddresslon() {
        return docaddresslon;
    }

    public void setDocaddresslon(String docaddresslon) {
        this.docaddresslon = docaddresslon == null ? null : docaddresslon.trim();
    }

    public String getDocaddresslat() {
        return docaddresslat;
    }

    public void setDocaddresslat(String docaddresslat) {
        this.docaddresslat = docaddresslat == null ? null : docaddresslat.trim();
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }

    public Boolean getDocaddresstype() {
        return docaddresstype;
    }

    public void setDocaddresstype(Boolean docaddresstype) {
        this.docaddresstype = docaddresstype;
    }

    public Boolean getDocaddresschecked() {
        return docaddresschecked;
    }

    public void setDocaddresschecked(Boolean docaddresschecked) {
        this.docaddresschecked = docaddresschecked;
    }
}