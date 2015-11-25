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
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.Jumbotron;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.LabelBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.LabelType;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.Icon;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeIconType;
import ir.ashkankazemi.resume.configmanager.ConfigManager;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
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
            phoneNumber.add(new LabelBehavior(LabelType.Success));
        } else {
            phoneNumber = new EmptyPanel("phoneNo");
        }
        return phoneNumber;
    }

    protected Component getEMailAddress() {
        ExternalLink email = new ExternalLink("mail", ConfigManager.getInstance().getEMailAddress(), ConfigManager.getInstance().getEMailAddress());
        email.add(new BootstrapBaseBehavior());
        return email;
    }

    protected Component getLinkedIn() {
        ExternalLink linkedIn = new ExternalLink("linkedIn", ConfigManager.getInstance().getLinkedIn(), "linkedIn");
        linkedIn.add(new BootstrapBaseBehavior());
        return linkedIn;
    }

    protected Component getTwitter() {
        ExternalLink twitter = new ExternalLink("twitter", ConfigManager.getInstance().getTwitter(), "twitter");
        twitter.add(new BootstrapBaseBehavior());
        return twitter;
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        Bootstrap.renderHead(response);
    }
}
