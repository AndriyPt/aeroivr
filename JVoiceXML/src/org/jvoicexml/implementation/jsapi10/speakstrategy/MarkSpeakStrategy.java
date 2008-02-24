/*
 * File:    $RCSfile: MarkSpeakStrategy.java,v $
 * Version: $Revision: 154 $
 * Date:    $Date: 2006-11-29 09:46:31 +0100 (Mi, 29 Nov 2006) $
 * Author:  $Author: schnelle $
 * State:   $State: Exp $
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2006 JVoiceXML group - http://jvoicexml.sourceforge.net
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Library General Public
 *  License as published by the Free Software Foundation; either
 *  version 2 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Library General Public License for more details.
 *
 *  You should have received a copy of the GNU Library General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.jvoicexml.implementation.jsapi10.speakstrategy;

import org.jvoicexml.DocumentServer;
import org.jvoicexml.Session;
import org.jvoicexml.event.error.BadFetchError;
import org.jvoicexml.event.error.NoresourceError;
import org.jvoicexml.implementation.jsapi10.AudioOutput;
import org.jvoicexml.logging.Logger;
import org.jvoicexml.logging.LoggerFactory;
import org.jvoicexml.xml.SsmlNode;
import org.jvoicexml.xml.ssml.Mark;

/**
 * SSML strategy to play back a <code>&lt;mark&gt;</code> node.
 *
 * @author Dirk Schnelle
 * @version $Revision: 154 $
 *
 * <p>
 * Copyright &copy; 2006 JVoiceXML group - <a
 * href="http://jvoicexml.sourceforge.net"> http://jvoicexml.sourceforge.net/
 * </a>
 * </p>
 *
 * @since 0.5
 */
public final class MarkSpeakStrategy
        extends AbstractSpeakStrategy {
    /** Logger for this class. */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(MarkSpeakStrategy.class);

    /**
     * Creates a new object.
     */
    public MarkSpeakStrategy() {
    }

    /**
     * {@inheritDoc}
     */
    public void speak(final Session session, final AudioOutput audioOutput,
                      final DocumentServer documentServer, final SsmlNode node)
            throws NoresourceError, BadFetchError {
        final Mark markNode = (Mark) node;
        final String mark = markNode.getName();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("waiting for mark '" + mark + "'...");
        }

        audioOutput.waitQueueEmpty();

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("reached mark '" + mark + "'");
        }

        audioOutput.reachedMark(mark);
    }
}
