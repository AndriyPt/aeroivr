/*
 * WebSecurityManager.java
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

package org.aeroivr.rsmc.web.security;

import javax.servlet.http.HttpSession;

/**
 * Main security manager.
 *
 * @author Andriy Petlyovanyy
 */
public class WebSecurityManager {

    private final HttpSession httpSession;

    public static final String USERNAME = "username";

    public WebSecurityManager(final HttpSession session) {
        httpSession = session;
    }

    public void setLoggedInUsername(final String username) {
        httpSession.setAttribute(USERNAME, username);
    }

    public boolean isLoggedIn() {
        return (null != httpSession.getAttribute(USERNAME));
    }

    public String getLoggedInUsername() {
        return (String) httpSession.getAttribute(USERNAME);
    }

}
