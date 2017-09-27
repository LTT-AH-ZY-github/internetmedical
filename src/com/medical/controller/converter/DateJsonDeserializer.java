package com.medical.controller.converter;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;  
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;  

  
public class DateJsonDeserializer extends JsonDeserializer<Date>  
{  
	public static final SimpleDateFormat format=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");  
	@Override
	public Date deserialize(JsonParser jsonParser,DeserializationContext deserializationContext)  
            throws IOException,JsonProcessingException  {
		System.out.println("json调用");
        try  
        {  
        	System.out.println("json调用"+jsonParser.getText());
            return format.parse(jsonParser.getText());
        }  
        catch(Exception e)  
        {  
            System.out.println(e.getMessage());  
            throw new RuntimeException(e);  
        }   
	}  
}  