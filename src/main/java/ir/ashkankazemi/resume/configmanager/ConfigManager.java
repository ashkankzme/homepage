/*
 * Copyright 2015 ashkan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ir.ashkankazemi.resume.configmanager;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashkan
 */
public class ConfigManager {
    private HashMap<String, Object> mainConfig;
    private static ConfigManager instance;
    private ConfigManager(){
        try {
            this.mainConfig = new Gson().
                    fromJson(
                            new InputStreamReader(ConfigManager.class.getResourceAsStream("/main-config.json")), 
                            new TypeToken<HashMap<String, Object>>(){}.getType());
        } catch (Exception ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    public static ConfigManager getInstance(){
        if (instance == null){
            instance = new ConfigManager();
        }
        return instance;
    }
    
    public String getHomePageTitle(){
        return (String) this.mainConfig.get("home_page_title");
    }
    
    public String getBrandName(){
        return (String) this.mainConfig.get("brand_name");
    }
    
    public String getHomeIntroTitle(){
        return (String) this.mainConfig.get("home_intro_title");
    }
    
    public List<String> getHomeIntro(){
        return (List<String>) this.mainConfig.get("home_intro");
    }
    
    public Boolean getPhoneNoVisibility(){
        return (Boolean) this.mainConfig.get("show_phone");
    }
    
    public String getContactInfoTitle(){
        return (String) this.mainConfig.get("ci_title");
    }
    
    public String getPhoneNo(){
        return (String) this.mainConfig.get("ci_phone");
    }
    
    public String getEMailAddress(){
        return (String) this.mainConfig.get("ci_mail");
    }
    
    public String getLinkedIn(){
        return (String) this.mainConfig.get("ci_linkedin");
    }
    
    public String getTwitter(){
        return (String) this.mainConfig.get("ci_twitter");
    }
    
    public String getHomePhotoPath(){
        return (String) this.mainConfig.get("home_photo_path");
    }
    
    public String getCVFilePath(){
        return (String) this.mainConfig.get("cv_file_path");
    }
}
