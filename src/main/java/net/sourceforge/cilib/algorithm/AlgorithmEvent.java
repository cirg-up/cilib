/*
 * ProgressEvent.java
 *
 * Created on January 26, 2003, 11:02 AM
 *
 * 
 * Copyright (C) 2003 - 2006 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA 
 *   
 */

package net.sourceforge.cilib.algorithm;

/**
 * This is the event raised by algorithms after iterations and completion.
 *
 * See {@see AlgorithmListener}
 *
 * @author  Edwin Peer
 */
public class AlgorithmEvent {
    
    /** 
     * Creates a new instance of <code>AlgorithmEvent</code> with a given source algorithm.
     * 
     * @param source The source {@link Algorithm}.
     */
    public AlgorithmEvent(Algorithm source) {
        this.source = source;
    }
    
    /** 
     * Accessor for the source algorithm.
     *
     * @return The {@link Algorithm} that raised this event.
     */
    public Algorithm getSource() {
        return source;
    }
    
    private Algorithm source;
}