/**
 * Computational Intelligence Library (CIlib)
 * Copyright (C) 2003 - 2010
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science
 * University of Pretoria
 * South Africa
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.cilib.functions.clustering.validityindices;


/**
 * This is the Dunn Validity Index.
 *
 * This implementation is as given in:<br/>
 * @Article{ dunn1974vi, title = "Well Separated Clusters and Optimal Fuzzy Partitions", author =
 *           "J. C. Dunn", journal = "Journal of Cybernetics", pages = "95--104", volume = "4", year =
 *           "1974" }
 */
public class DunnIndex extends GeneralisedDunnIndex {
    private static final long serialVersionUID = -7440453719679272149L;

    /**
     * Create an instance of this index.
     */
    public DunnIndex() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected double calculateWithinClusterScatter(int k) {
        return calculateClusterDiameter(k);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected double calculateBetweenClusterSeperation(int i, int j) {
        return calculateMinimumSetDistance(i, j);
    }
}
