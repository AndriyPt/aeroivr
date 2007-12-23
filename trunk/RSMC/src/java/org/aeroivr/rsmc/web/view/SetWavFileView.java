/*
 * SetWavFileView.java
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

package org.aeroivr.rsmc.web.view;

import java.util.Map;

/**
 * View representation for upload WAV file page.
 *
 * @author Andriy Petlyovanyy
 */
public class SetWavFileView extends AbstractView {
    
    public SetWavFileView(final String viewsFolder) {
        super(viewsFolder);
    }

    protected SetWavFileView(final String vwsFolder, final Map parameters) {
        super(vwsFolder, parameters);
    }

    protected String getHtmlFileName() {
        return "setWavFile.html";
    }
}