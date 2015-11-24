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
import de.agilecoders.wicket.core.markup.html.bootstrap.block.Jumbotron;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.LabelBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.LabelType;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.Icon;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.IconType;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeIconType;
import ir.ashkankazemi.resume.configmanager.ConfigManager;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author ashkan
 */
public class Contact extends WebPage {

    public Contact(PageParameters params) {
        super(params);
        this.add(new Label("pageTitle", ConfigManager.getInstance().getHomePageTitle()));
        this.add(HomePage.getMainNavBar("navigation"));
        Jumbotron container = new Jumbotron("container");
        container.add(new Label("ci-header", ConfigManager.getInstance().getContactInfoTitle()));
        this.add(container);
        WebMarkupContainer ci = new WebMarkupContainer("ci");
        ci.add(getPhoneNo(), getEMailAddress(), getLinkedIn(), getTwitter(), 
                new Icon("phoneIcon", FontAwesomeIconType.phone_square),
                new Icon("mailIcon", FontAwesomeIconType.envelope),
                new Icon("linkedInIcon", FontAwesomeIconType.linkedin_square),
                new Icon("twitterIcon", FontAwesomeIconType.twitter_square));
        container.add(ci);
    }

    protected Component getPhoneNo() {
        Component phoneNumber;
        if (ConfigManager.getInstance().getPhoneNoVisibility()) {
            phoneNumber = new Label("phoneNo", ConfigManager.getInstance().getPhoneNo());
            phoneNumber.add(new LabelBehavior(LabelType.Info));
        } else {
            phoneNumber = new EmptyPanel("phoneNo");
        }
        return phoneNumber;
    }

    protected Component getEMailAddress() {
        Label mail = new Label("mail", ConfigManager.getInstance().getEMailAddress());
        mail.add(new LabelBehavior(LabelType.Info));
        return mail;
    }

    protected Component getLinkedIn() {
        BootstrapLink<String> linkedIn = new BootstrapLink("linkedIn", Model.of("LinkedIn"), Buttons.Type.Info) {
            
            @Override
            public void onClick() {
                
            }
        };
//        Label linkedI2n = new Label("linkedIn", ConfigManager.getInstance().getLinkedIn());
//        linkedIn.add(new LabelBehavior(LabelType.Info));
        return linkedIn;
    }

    protected Component getTwitter() {
        Label twitter = new Label("twitter", ConfigManager.getInstance().getTwitter());
        twitter.add(new LabelBehavior(LabelType.Info));
        return twitter;
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        Bootstrap.renderHead(response);
    }
}
