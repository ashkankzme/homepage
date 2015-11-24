package ir.ashkankazemi.resume.pages;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.block.Jumbotron;
import de.agilecoders.wicket.core.markup.html.bootstrap.heading.Heading;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.ImageBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;
import ir.ashkankazemi.resume.configmanager.ConfigManager;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.ContextRelativeResource;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);
        this.add(new Label("pageTitle", ConfigManager.getInstance().getHomePageTitle()));
        this.add(getMainNavBar("navigation"));
        Jumbotron jumbotron = new Jumbotron("container", Model.of("Hello, I'm ashkan Kazemi!"));
        Label intro = new Label("intro", ConfigManager.getInstance().getHomeIntro());
        jumbotron.add(intro);
        jumbotron.add(new Heading("intro-header", ConfigManager.getInstance().getHomeIntroTitle()));
        jumbotron.add(new Image("photo", new ContextRelativeResource(ConfigManager.getInstance().getHomePhotoPath())).add(new ImageBehavior(ImageBehavior.Type.Rounded)));
        this.add(jumbotron);
    }

    public static Navbar getMainNavBar(String wicketId) {
        Navbar navbar = new Navbar(wicketId);
        navbar.fluid();
        navbar.setBrandName(Model.of(ConfigManager.getInstance().getBrandName()));
        navbar.setPosition(Navbar.Position.DEFAULT);
        navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT,
                new NavbarButton(HomePage.class, Model.of("Home")),
                new NavbarButton(CurriculumVitae.class, Model.of("Curriculum Vitae")),
                new NavbarButton(Contact.class, Model.of("Contact Info"))));
        return navbar;
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        Bootstrap.renderHead(response);
    }
}
