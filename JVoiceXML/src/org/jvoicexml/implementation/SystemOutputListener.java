/*
 * File:    $RCSfile: SystemOutputListener.java,v $
 * Version: $Revision: 206 $
 * Date:    $Date: 2007-02-01 20:05:29 +0100 (Do, 01 Feb 2007) $
 * Author:  $Author: schnelle $
 * State:   $State: Exp $
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2006 JVoiceXML group - http://jvoicexml.sourceforge.net
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.jvoicexml.implementation;


/**
 * Listener for events from the <code>SystemOutput</code> implementation.
 *
 * @author Dirk Schnelle
 * @version $Revision: 206 $
 *
 * <p>
 * Copyright &copy; 2006 JVoiceXML group -
 * <a href="http://jvoicexml.sourceforge.net">
 * http://jvoicexml.sourceforge.net/</a>
 * </p>
 *
 * @see org.jvoicexml.SystemOutput
 * @since 0.5
 */
public interface SystemOutputListener {
    /**
     * Notification that the system output has started.
     * @since 0.5.5
     */
    void outputStarted();

    /**
     * Notification that the system output has ended.
     */
    void outputEnded();

    /**
     * Notification that a <code>&lt;mark&gt;</code> element has been reached.
     * @param mark Name of the mark.
     */
    void markerReached(final String mark);
}
