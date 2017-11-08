package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.uba.fi.tdd.rulogic.exception.InvalidQueryException;
import ar.uba.fi.tdd.rulogic.utils.Util;

public class KnowledgeBase {
	private List<Fact> facts;
	private List<Rule> rules;

	public KnowledgeBase() {
	    this.facts = new ArrayList<Fact>();
	    this.rules = new ArrayList<Rule>();
    }

    public void addFact(Fact fact) {
	    this.facts.add(fact);
    }

    public void addRule(Rule rule) {
	    this.rules.add(rule);
    }

    public List<Fact> getFacts() {
	    return facts;
    }

    public List<Rule> getRules() {
	    return rules;
    }

    public boolean answer(String query) throws InvalidQueryException {
    	query = query.replace(" ","").replace("\t","").replace("\n","").replace(".","");
    	validQuery(query);
    	
        String[] parsed = query.replace(")","").split("\\(");
        String nombre = parsed[0];
        List<String> values = new ArrayList<String>(Arrays.asList(parsed[1].split(",")));
        Fact fact = new Fact(nombre, values);
        if (isFact(fact)) 
        		return true;
        return isRule(nombre, values);
    }
    
    private void validQuery(String query) throws InvalidQueryException {
    	Util utl = new Util();        
        if (!query.matches(utl.getRegexQuery())) {
            throw new InvalidQueryException("Ivalid query");
        }
    }

    private Boolean isFact(Fact query) {
        Boolean equal = false;
        for (Fact fact : this.facts) {
            if (!query.equals(fact)) 
            		continue;
            equal=true;
            }
            if (equal) {return true;}
        return false;
    }  
    
    private Boolean isRule(String name, List<String> values) {
	    for (Rule rule : this.rules) {
	        if (!name.equals(rule.getNombre())) 
	        		continue;
	        if (values.size() != rule.getArgs()) 
	        		continue;
	        List<Fact> facts = rule.findFacts(values);
	        Boolean equal = true;
	        for (Fact fact : facts) {
	            if (!this.isFact(fact)) {
	                return false;
                }
            }
            if (equal) {
	            return true;
	        }
        }
        return false;
    }
    
}
