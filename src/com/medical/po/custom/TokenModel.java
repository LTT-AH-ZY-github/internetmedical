package com.medical.po.custom;

import java.io.Serializable;

/**
 * 
 * @ClassName: Token 
 * @Description: TODO
 * @author: xyh
 * @date: 2017年8月4日 下午4:27:08
 */
public class TokenModel implements Serializable
{
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = 1L;
    
    private Integer uid;
    
    private String phone;
    
    private long createTime;
    
    
    
   

	public Integer getUid()
    {
        return uid;
    }

    public void setUid(Integer uid)
    {
        this.uid = uid;
    }

    

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(long createTime)
    {
        this.createTime = createTime;
    }
    
    

    @Override
    public String toString()
    {
        return "Token [uid=" + uid + ", phone=" + phone + ", createTime=" + createTime + "]";
    }
}

