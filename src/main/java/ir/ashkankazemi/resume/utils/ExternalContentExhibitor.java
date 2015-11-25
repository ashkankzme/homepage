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
package ir.ashkankazemi.resume.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.ByteArrayResource;
import org.apache.wicket.request.resource.ContextRelativeResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

/**
 *
 * @author ashkan
 */
public class ExternalContentExhibitor extends Panel{

    public ExternalContentExhibitor(String id, final String resourcePath, String pageTitle) {
        super(id);
        this.add(new Label("pageTitle", pageTitle));
        ResourceReference contentRef = new ResourceReference("cv") {
            
            @Override
            public IResource getResource() {
                return new ContextRelativeResource(resourcePath);
            }
        };
        if (contentRef.canBeRegistered()){
            getApplication().getResourceReferenceRegistry().registerResourceReference(contentRef);
        }
        WebMarkupContainer content = new WebMarkupContainer("content");
        content.add(new AttributeModifier("src", (String) urlFor(contentRef, null)));
        this.add(content);
    }
    
}
