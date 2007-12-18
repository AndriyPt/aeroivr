/*
 * PageRenderer.java
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

package org.aeroivr.rsmc.web.render;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.aeroivr.rsmc.web.view.AbstractView;
import org.aeroivr.rsmc.web.view.MasterPageView;

/**
 * Render view and insert its content into master page view. 
 *
 * @author Andriy Petlyovanyy
 */
public class PageRenderer {
    
    private MasterPageView masterPageView;
    private AbstractView innerView;
    
    public PageRenderer(final MasterPageView mstrPageView, 
            final AbstractView innrView) {
        
        this.masterPageView = mstrPageView;
        this.innerView = innrView;
    }

    public String renderContent() throws FileNotFoundException, IOException {
        masterPageView.setInnerContent(innerView.getContent());
        return masterPageView.getContent();
    }
    
}
