/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author spitlord
 */
public class District {
    
    private int ID;
    private int stateID;
    private Set<Precinct> precincts;
    private int population;
    private PriorityQueue<Precinct> candidates;
    
    public District(State s, int ID) {
    	this.stateID = s.getID();
    	this.ID = ID;
    	this.precincts = new HashSet<Precinct>();
    	this.population = 0;
    	this.candidates = new PriorityQueue<Precinct>();
    }
    
    public Precinct getPrecinctById(int id) {
        return null;
    }
    
    // Add logic to update candidates
    public boolean addPrecinct(Precinct precinct) {
        if (precincts.add(precinct)) {
            updatePopulation(population + precinct.getPopulation());
            return true;
        }
        return false;
    }
    
    // Add logic to update candidates
    public boolean removePrecinct(Precinct precinct) {
        if (precincts.remove(precinct)) {
            updatePopulation(population - precinct.getPopulation());
            return true;
        }
        return false;
    }

    // done
    public PriorityQueue<Precinct> getCandidates() {
        return candidates;
    }

    // done
    public Set<Precinct> getPrecincts() {
        return precincts;
    }
    
    // done
    public void updatePopulation(int population) {
        this.population = population;
    }
    
    
    public double getPerimeter() {
        return 0;
    }
    
    public double getArea() {
        return 0;
    }
    
    public int getID() {
        return ID;
    }

    public int getStateID() {
        return stateID;
    }

    public int getPopulation() {
        return population;
    }
    
    public Precinct getRandomCandidate(){
    	ArrayList<Precinct> cache = new ArrayList<Precinct>();
    	int rand = ThreadLocalRandom.current().nextInt(this.candidates.size());
    	for (int i = 0; i < rand; i++) {
    		cache.add(this.candidates.poll());
    	}
    	Precinct p = this.candidates.poll();
    	this.candidates.addAll(cache);
    	return p;
    }
    
    public int getNumPrecincts() {
    	return precincts.size();
    }
}
