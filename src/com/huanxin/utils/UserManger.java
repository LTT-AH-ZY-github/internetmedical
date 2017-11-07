package com.huanxin.utils;


import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.List;

/**
 * Created by WangJiang on 2016/9/2.
 */
public class UserManger {

    /**
     * 向环信注册一个用户
     */
    public static boolean register(String name, String password) {
        Document document = null;
        try {
            document = Jsoup.connect("https://a1.easemob.com/wangjiang/medicalclient/users")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + TokenManager.getToken())
                    .ignoreContentType(true)
                    .requestBody(new Gson().toJson(new UserRequest(name, password)))
                    .post();

        } catch (IOException e) {
        	
            e.printStackTrace();
            return false;
        }
        if (document != null) {
            UserResponse userResponse = new Gson().fromJson(document.body().html(), UserResponse.class);
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        register("cs004", "cs004");
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

}
