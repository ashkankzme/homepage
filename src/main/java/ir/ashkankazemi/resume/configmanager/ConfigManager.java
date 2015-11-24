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

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashkan
 */
public class ConfigManager {
    private Properties mainConfig;
    private static ConfigManager instance;
    private ConfigManager(){
        this.mainConfig = new Properties();
        try {
            this.mainConfig.load(ConfigManager.class.getResourceAsStream("/main-config.properties"));
        } catch (IOException ex) {
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
        return this.mainConfig.getProperty("home_page_title", "Welcome!");
    }
    
    public String getBrandName(){
        return this.mainConfig.getProperty("brand_name", "Welcome!");
    }
    
    public String getHomeIntroTitle(){
        return this.mainConfig.getProperty("home_intro_title", "About Me");
    }
    
    public String getHomeIntro(){
        return this.mainConfig.getProperty("home_intro", "Please set the \"home_intro\" config in the \"main-config.properties\" file");
    }
    
    public Boolean getPhoneNoVisibility(){
        return this.mainConfig.getProperty("show_phone", "true").toLowerCase().equals("true");
    }
    
    public String getContactInfoTitle(){
        return this.mainConfig.getProperty("ci_title", "Contact me at:");
    }
    
    public String getPhoneNo(){
        return this.mainConfig.getProperty("ci_phone", "Please configure your phone number!");
    }
    
    public String getEMailAddress(){
        return this.mainConfig.getProperty("ci_mail", "Please configure your E-Mail Address!");
    }
    
    public String getLinkedIn(){
        return this.mainConfig.getProperty("ci_linkedin", "Please configure your LinkedIn Profile!");
    }
    
    public String getTwitter(){
        return this.mainConfig.getProperty("ci_twitter", "Please configure your Twitter Profile!");
    }
    
    public String getHomePhotoPath(){
        return this.mainConfig.getProperty("home_photo_path", "photo.jpg");
    }
}
