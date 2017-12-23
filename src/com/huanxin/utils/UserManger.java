package com.huanxin.utils;


import com.google.gson.Gson;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;


/**
 * @ClassName:     UserManger.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:48:28 
 */
public class UserManger {
	
    /**
     * 向环信注册一个用户
     */
    public static boolean register(String name, String password) {
        Document document = null;
        try {
            document = Jsoup.connect("https://a1.easemob.com/1133171107115421/medicalclient/users")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenManager.getToken())
                    .ignoreContentType(true)
                    .requestBody(new Gson().toJson(new UserRequest(name, password)))
                    .post();
            
        } catch (HttpStatusException e) {
        	int stateCode = e.getStatusCode();
        	//已注册
        	if (stateCode==400) {
				return true ;
			}
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if (document != null) {
            //UserResponse userResponse = new Gson().fromJson(document.body().html(), UserResponse.class);
            return true;
        }
        return false;
    }
    
    /**
     * 更新环信密码
     */
    public static boolean updatePassword(String name, String password) {
        Document document = null;
        try {
            document = Jsoup.connect("https://a1.easemob.com/1133171107115421/medicalclient/users/"+name+"/password")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenManager.getToken())
                    .ignoreContentType(true)
                    .requestBody(new Gson().toJson(new PasswordRequest(password)))
                    .post();
       	 
        } catch (IOException e) {
        
        	System.out.println();
            e.printStackTrace();
            return false;
        }
        if (document != null) {
            //UserResponse userResponse = new Gson().fromJson(document.body().html(), UserResponse.class);
            return true;
        }
        return false;
    }
    /**
     * 获取用户详细信息
     */
    public static boolean getUserInfo(String name) {
        Document document = null;
        try {
            document = Jsoup.connect("https://a1.easemob.com/1133171107115421/medicalclient/users/"+name)
            		.header("Content-Type", "application/json")
            		.header("Authorization", "Bearer " + TokenManager.getToken())
            		.ignoreContentType(true)
                    .get();
            
        }catch (HttpStatusException e) {
        	
        	System.out.println(e.getStatusCode());
           
            return false;
        } catch (IOException e) {
        	// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (document != null) {
            UserResponse userResponse = new Gson().fromJson(document.body().html(), UserResponse.class);
           System.out.println(userResponse.getEntities().get(0).getUsername());
            return true;
        }
        return false;
    }
    
    /**
     * 获取用户详细信息
     */
    public static boolean listUser() {
        Document document = null;
        try {
            document = Jsoup.connect("https://a1.easemob.com/1133171107115421/medicalclient/users")
            		.header("Content-Type", "application/json")
            		.header("Authorization", "Bearer " + TokenManager.getToken())
            		.ignoreContentType(true)
                    .get();
            
        }catch (HttpStatusException e) {
        	
        	System.out.println(e.getStatusCode());
           
            return false;
        } catch (IOException e) {
        	// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (document != null) {
            UserResponse userResponse = new Gson().fromJson(document.body().html(), UserResponse.class);
            List<com.huanxin.utils.UserManger.UserResponse.EntitiesBean> list = userResponse.getEntities();
            for (com.huanxin.utils.UserManger.UserResponse.EntitiesBean entitiesBean : list) {
            	System.out.println(entitiesBean.getUsername());
			}
             return true;
        }
        return false;
    }
    public static boolean delete(String name) {
        Document document = null;
        try {
            Connection connection = Jsoup.connect("https://a1.easemob.com/1133171107115421/medicalclient/users")
                     .header("Authorization", "Bearer " + TokenManager.getToken())
                    .ignoreContentType(true)
                    .method(Method.DELETE);
                    
                    connection.execute();
        } catch (IOException e) {
        
        	System.out.println();
            e.printStackTrace();
            return false;
        }
       
        return false;
    }
    public static void main(String args[]) {
    	//register("cs00", "cs004222");
    	//listUser();
    	System.out.println(delete("doc_75"));
    	listUser();
    }
    
    
    
    private static class UserRequest {
        String username;
        String password;

        public UserRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    private static class UserResponse {

        /**
         * action : post
         * application : 3a3f0f00-7029-11e6-b1f7-45fde34f3d59
         * path : /users
         * uri : https://a1.easemob.com/wangjiang/easyhabit/users
         * entities : [{"uuid":"2ce536d0-7115-11e6-b3a5-15437d9e5f9b","type":"user","created":1472824644285,"modified":1472824644285,"username":"cs004","activated":true}]
         * timestamp : 1472824644289
         * duration : 0
         * organization : wangjiang
         * applicationName : easyhabit
         */

        private String action;
        private String application;
        private String path;
        private String uri;
        private long timestamp;
        private int duration;
        private String organization;
        private String applicationName;
        /**
         * uuid : 2ce536d0-7115-11e6-b3a5-15437d9e5f9b
         * type : user
         * created : 1472824644285
         * modified : 1472824644285
         * username : cs004
         * activated : true
         */

        private List<EntitiesBean> entities;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getApplication() {
            return application;
        }

        public void setApplication(String application) {
            this.application = application;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public void setApplicationName(String applicationName) {
            this.applicationName = applicationName;
        }

        public List<EntitiesBean> getEntities() {
            return entities;
        }

        public void setEntities(List<EntitiesBean> entities) {
            this.entities = entities;
        }

        public static class EntitiesBean {
            private String uuid;
            private String type;
            private long created;
            private long modified;
            private String username;
            private boolean activated;

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public long getCreated() {
                return created;
            }

            public void setCreated(long created) {
                this.created = created;
            }

            public long getModified() {
                return modified;
            }

            public void setModified(long modified) {
                this.modified = modified;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public boolean isActivated() {
                return activated;
            }

            public void setActivated(boolean activated) {
                this.activated = activated;
            }
        }
    }
    
    private static class PasswordRequest{
    	String newpassword;
    	public PasswordRequest(String newpassword) {
            this.newpassword = newpassword;
        }
	}
    
    private static class PasswordResponse{
    	String newpassword;
    	public PasswordResponse(String newpassword) {
            this.newpassword = newpassword;
        }
	}
}
