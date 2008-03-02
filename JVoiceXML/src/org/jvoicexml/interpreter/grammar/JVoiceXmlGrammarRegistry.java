/*
 * File:    $HeadURL: https://svn.sourceforge.net/svnroot/jvoicexml/trunk/src/org/jvoicexml/interpreter/grammar/JVoiceXmlGrammarRegistry.java $
 * Version: $LastChangedRevision: 234 $
 * Date:    $Date $
 * Author:  $LastChangedBy: schnelle $
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2005-2007 JVoiceXML group - http://jvoicexml.sourceforge.net
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

package org.jvoicexml.interpreter.grammar;

import java.util.Collection;

import org.jvoicexml.GrammarImplementation;
import org.jvoicexml.interpreter.GrammarRegistry;
import org.jvoicexml.interpreter.VoiceXmlInterpreterContext;
import org.jvoicexml.interpreter.scope.ScopeObserver;
import org.jvoicexml.interpreter.scope.ScopedMap;
import org.jvoicexml.logging.Logger;
import org.jvoicexml.logging.LoggerFactory;

/**
 * Implementation of a <code>GrammarRegistry</code>.
 *
 * @author Dirk Schnelle
 * @version $Revision: 234 $
 *
 * @since 0.3
 *
 * <p>
 * Copyright &copy; 2005-2007 JVoiceXML group -
 * <a href="http://jvoicexml.sourceforge.net">
 * http://jvoicexml.sourceforge.net/</a>
 * </p>
 */
public final class JVoiceXmlGrammarRegistry
        implements GrammarRegistry {
    /** Logger for this class. */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(JVoiceXmlGrammarRegistry.class);

    /** The scope aware map of all grammars. */
    private ScopedMap<String, GrammarImplementation<? extends Object>> grammars;

    /**
     * Constructs a new object.
     *
     * @since 0.5.5
     */
    JVoiceXmlGrammarRegistry() {
        grammars = new ScopedMap<String,
        GrammarImplementation<? extends Object>>(null);
    }

    /**
     * Constructs a new object.
     * @param context
     *        The current VoiceXML interpreter context.
     */
    public JVoiceXmlGrammarRegistry(final VoiceXmlInterpreterContext context) {
        final ScopeObserver observer = context.getScopeObserver();
        grammars = new ScopedMap<String,
                GrammarImplementation<? extends Object>>(observer);
    }

    /**
     * {@inheritDoc}
     */
    public void addGrammar(
            final GrammarImplementation<? extends Object> grammar) {
        if (grammar == null) {
            LOGGER.warn("cannot add a null grammar");

            return;
        }

        final String name = grammar.getName();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("adding grammar '" + name + "'");
        }

        grammars.put(name, grammar);
    }

    /**
     * {@inheritDoc}
     */
    public Collection<GrammarImplementation<? extends Object>> getGrammars() {
        return grammars.values();
    }
}