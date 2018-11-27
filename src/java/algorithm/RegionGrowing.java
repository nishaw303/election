/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.PriorityQueue;

import mapObjects.District;
import mapObjects.Precinct;
import seeding.SeedStrategy;

/**
 *
 * @author spitlord
 */
public class RegionGrowing extends Algorithm {
    
   private SeedStrategy seedStrategy;

    public RegionGrowing(SeedStrategy seedStrategy) {
       super();
       this.seedStrategy = seedStrategy;
    }

    @Override
    public void run() {
    	this.seedStrategy.seed(super.currentState);
    	District unassigned = super.currentState.getUnassignedDistrict();
    	while (unassigned.precincts.size() > numPrecincts / 2) {
    		District d = this.selectDistrictToGrow();
    		PriorityQueue<Precinct> candidates = d.getCandidates();
    		Precinct precinctToMove = candidates.pop();
    		Move move = new Move(precinctToMove, unassigned, d);
    		moves.push(move);
    		d.addPrecinct(precinctToMove);
    		unassigned.removePrecinct(precinctToMove);
    	}
    	while (unassigned.precincts.size() > 0) {
    		District d = this.selectDistrictToGrow();
    		Precinct precinctToMove = this.findBestMovablePrecinct(d);
    		Move move = new Move(precinctToMove, unassigned, d);
    		moves.push(move);
    		d.addPrecinct(precinctToMove);
    		unassigned.removePrecinct(precinctToMove);
    	}
    }

    @Override
    public boolean checkTerimanationConditions() {
        return true;
    }
    
    private Precinct findBestMovablePrecinct(District d) {
    	PriorityQueue<Precinct> candidates = d.getCandidates();
    	//for (Precinct p: candidates) {
    		
    	//}
    	return null;
    }
    
    public District selectDistrictToGrow() {
        return null;
    }
    
    public void setSeedStrategy(SeedStrategy seedStrategy) {
        this.seedStrategy = seedStrategy;
    }
    
    
    
    
    

    
   
    
    
    
}
