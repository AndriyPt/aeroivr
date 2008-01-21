/*
 * File:    $RCSfile: Emphasis.java,v $
 * Version: $Revision: 154 $
 * Date:    $Date: 2006-11-29 09:46:31 +0100 (Mi, 29 Nov 2006) $
 * Author:  $Author: schnelle $
 * State:   $State: Exp $
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2005-2006 JVoiceXML group - http://jvoicexml.sourceforge.net
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

package org.jvoicexml.xml.ssml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.jvoicexml.xml.VoiceXmlNode;
import org.jvoicexml.xml.XmlNode;
import org.jvoicexml.xml.vxml.Enumerate;
import org.jvoicexml.xml.vxml.Value;
import org.w3c.dom.Node;

/**
 * The emphasis element requests that the contained text be spoken with
 * emphasis (also referred to as prominence or stress). The synthesis
 * processor determines how to render emphasis since the nature of emphasis
 * differs between languages, dialects or even voices.
 *
 * @author Steve Doyle
 * @version $Revision: 154 $
 *
 * <p>
 * Copyright &copy; 2005-2006 JVoiceXML group -
 * <a href="http://jvoicexml.sourceforge.net">http://jvoicexml.sourceforge.net/
 * </a>
 * </p>
 */
public final class Emphasis
        extends AbstractSsmlNode implements VoiceXmlNode {

    /** Name of the tag. */
    public static final String TAG_NAME = "emphasis";

    /**
     * The optional level attribute indicates the strength of emphasis to be
     * applied. Defined values are "strong", "moderate", "none" and "reduced".
     * The default level is "moderate". The meaning of "strong" and "moderate"
     * emphasis is interpreted according to the language being spoken
     * (languages indicate emphasis using a possible combination of pitch
     * change, timing changes, loudness and other acoustic differences). The
     * "reduced" level is effectively the opposite of emphasizing a word. For
     * example, when the phrase "going to" is reduced it may be spoken as
     * "gonna". The "none" level is used to prevent the synthesis processor
     * from emphasizing words that it might typically emphasize. The values
     * "none", "moderate", and "strong" are monotonically non-decreasing in
     * strength.
     */
    public static final String ATTRIBUTE_LEVEL = "level";

    /**
     * Supported attribute names for this node.
     */
    protected static final ArrayList<String> ATTRIBUTE_NAMES;

    /**
     * Set the valid attributes for this node.
     */
    static {
        ATTRIBUTE_NAMES = new java.util.ArrayList<String>();

        ATTRIBUTE_NAMES.add(ATTRIBUTE_LEVEL);
    }

    /**
     * Valid child tags for this node.
     */
    private static final Set<String> CHILD_TAGS;

    /**
     * Set the valid child tags for this node.
     */
    static {
        CHILD_TAGS = new java.util.HashSet<String>();

        CHILD_TAGS.add(Audio.TAG_NAME);
        CHILD_TAGS.add(Enumerate.TAG_NAME);
        CHILD_TAGS.add(Value.TAG_NAME);
        CHILD_TAGS.add(Break.TAG_NAME);
        CHILD_TAGS.add(Emphasis.TAG_NAME);
        CHILD_TAGS.add(Mark.TAG_NAME);
        CHILD_TAGS.add(Phoneme.TAG_NAME);
        CHILD_TAGS.add(Prosody.TAG_NAME);
        CHILD_TAGS.add(SayAs.TAG_NAME);
        CHILD_TAGS.add(Voice.TAG_NAME);
        CHILD_TAGS.add(Sub.TAG_NAME);
    }

    /**
     * Construct a new emphasis object without a node.
     * <p>
     * This is necessary for the node factory.
     * </p>
     *
     * @see org.jvoicexml.xml.vxml.VoiceXmlNodeFactory
     */
    public Emphasis() {
        super(null);
    }

    /**
     * Construct a new emphasis object.
     * @param node The encapsulated node.
     */
    Emphasis(final Node node) {
        super(node);
    }

    /**
     * Get the name of the tag for the derived node.
     *
     * @return name of the tag.
     */
    public String getTagName() {
        return TAG_NAME;
    }

    /**
     * {@inheritDoc}
     */
    public XmlNode newInstance(final Node n) {
        return new Emphasis(n);
    }

    /**
     * Retrieve the level attribute.
     * @return Value of the level attribute.
     * @see #ATTRIBUTE_LEVEL
     */
    public String getLevel() {
        return getAttribute(ATTRIBUTE_LEVEL);
    }

    /**
     * Set the level attribute.
     * @param level Value of the level attribute.
     * @see #ATTRIBUTE_LEVEL
     */
    public void setLevel(final String level) {
        setAttribute(ATTRIBUTE_LEVEL, level);
    }

    /**
     * {@inheritDoc}
     */
    protected boolean canContainChild(final String tagName) {
        return CHILD_TAGS.contains(tagName);
    }

    /**
     * {@inheritDoc}
     */
    public Collection<String> getAttributeNames() {
        return ATTRIBUTE_NAMES;
    }
}
