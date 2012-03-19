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
package net.sourceforge.cilib.coevolution;

import net.sourceforge.cilib.algorithm.population.PopulationBasedAlgorithm;
import net.sourceforge.cilib.coevolution.competitors.CoevolutionCompetitorList;
import net.sourceforge.cilib.coevolution.selection.OpponentSelectionStrategy;
import net.sourceforge.cilib.coevolution.selection.SelectAllOpponentSelectionStrategy;
import net.sourceforge.cilib.entity.Entity;
import net.sourceforge.cilib.problem.boundaryconstraint.BoundaryConstraint;

/**
 * This iteration strategy defines methods to select opponents.
 * TODO: Refactor this code, it seems unnecesary
 */
public class CompetitiveCoevolutionIterationStrategy extends CoevolutionIterationStrategy {

    private static final long serialVersionUID = 1061304146851715740L;
    protected OpponentSelectionStrategy opponentSelectionStrategy;
    protected FitnessSharingStrategy fitnessSharingStrategy;

    public CompetitiveCoevolutionIterationStrategy() {
        super();
        opponentSelectionStrategy = new SelectAllOpponentSelectionStrategy();
        fitnessSharingStrategy = new StandardFitnessSharingStrategy();
    }

    @Override
    public CompetitiveCoevolutionIterationStrategy getClone() {
        return new CompetitiveCoevolutionIterationStrategy(this);
    }

    public CompetitiveCoevolutionIterationStrategy(CompetitiveCoevolutionIterationStrategy copy) {
        opponentSelectionStrategy = copy.opponentSelectionStrategy;
        fitnessSharingStrategy = copy.fitnessSharingStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void performIteration(CoevolutionAlgorithm ca) {

        for (PopulationBasedAlgorithm currentAlgorithm : ca.getPopulations()) {
            currentAlgorithm.performIteration();
        }
    }

    /**
     * Select opponents based on the current {@linkplain OpponentSelectionStrategy}
     * @param populationID the populationID of the {@linkplain Entity} for whom opponents are being selected
     * @param ca the Coevolution algorithm
     * @return the list of competitors
     */
    public CoevolutionCompetitorList selectOpponents(int populationID, CoevolutionAlgorithm ca) {
        return opponentSelectionStrategy.setCompetitors(populationID, ca.getPopulations());
    }

    public FitnessSharingStrategy getFitnessSharingStrategy() {
        return fitnessSharingStrategy;
    }

    public void setFitnessSharingStrategy(
            FitnessSharingStrategy fitnessSharingStrategy) {
        this.fitnessSharingStrategy = fitnessSharingStrategy;
    }

    public OpponentSelectionStrategy getOpponentSelectionStrategy() {
        return opponentSelectionStrategy;
    }

    public void setOpponentSelectionStrategy(OpponentSelectionStrategy opponentSelectionStrategy) {
        this.opponentSelectionStrategy = opponentSelectionStrategy;
    }

    @Override
    public BoundaryConstraint getBoundaryConstraint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBoundaryConstraint(BoundaryConstraint boundaryConstraint) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
