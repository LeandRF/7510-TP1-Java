package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test
    public void testCreateFact() {
    	
        Fact fact = new Fact("valor(uno)");
        
        Assert.assertTrue(fact.getName().equals("valor"));    
        Assert.assertTrue(fact.getArgs().get(0).equals("uno"));
    }

    @Test
    public void testCreateFactTwoArgs() {
        Fact fact = new Fact("valor(uno,dos)");
        
        Assert.assertTrue(fact.getName().equals("valor"));
        Assert.assertTrue(fact.getArgs().get(0).equals("uno"));        
        Assert.assertTrue(fact.getArgs().get(1).equals("dos"));

    }

    @Test
    public void testEqualsFacts() {
    	List<String> args = new ArrayList<String>();
    	args.add("uno");
        Fact fact = new Fact("valor", args);
        Fact fact2 = new Fact("valor", args);               

        Assert.assertTrue(fact.equals(fact2));        
        
    }

}
