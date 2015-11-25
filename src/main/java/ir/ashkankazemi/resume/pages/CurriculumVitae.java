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
package ir.ashkankazemi.resume.pages;

import de.agilecoders.wicket.core.Bootstrap;
import ir.ashkankazemi.resume.configmanager.ConfigManager;
import ir.ashkankazemi.resume.utils.ExternalContentExhibitor;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author ashkan
 */
public class CurriculumVitae extends WebPage {

    public CurriculumVitae(PageParameters params) {
        super(params);
        this.add(HomePage.getMainNavBar("navigation"));
        this.add(new Label("pageTitle", ConfigManager.getInstance().getHomePageTitle()));
        ExternalContentExhibitor externalContentExhibitor = new ExternalContentExhibitor("cv", ConfigManager.getInstance().getCVFilePath(), ConfigManager.getInstance().getHomePageTitle());
        this.add(externalContentExhibitor);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        Bootstrap.renderHead(response);
    }

}
