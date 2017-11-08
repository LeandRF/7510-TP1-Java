package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuleTest {

    @Test
    public void testCreateRule01() {
        Rule rule = new Rule("abuelo(X,Y):-padre(X),madre(Y)");
        List<Fact> facts = rule.getFacts();

        Assert.assertTrue(rule.getNombre().equals("abuelo"));
        Assert.assertTrue(rule.getArgs() == 2);
        Assert.assertTrue(facts.get(0).getName().equals("padre"));
        Assert.assertTrue(facts.get(1).getName().equals("madre"));        
    }

    
    @Test
    public void testCreateRule02() {
        Rule rule = new Rule("tio(X,Y,Z):-varon(X),hermano(X,Z),padre(Z,Y)");
        List<String> parameters = new ArrayList<String>();
        
        parameters.add("a");
        parameters.add("b");
        parameters.add("c");
        
        List<Fact> facts = rule.findFacts(parameters);

        Assert.assertTrue(rule.getNombre().equals("tio"));
        
        Assert.assertFalse(rule.getArgs() == 2);
        Assert.assertTrue(rule.getArgs() == 3);
        
        Assert.assertTrue(facts.get(0).getName().equals("varon"));
        Assert.assertTrue(facts.get(0).getArgs().get(0).equals("a"));
        Assert.assertTrue(facts.get(1).getName().equals("hermano"));
        Assert.assertTrue(facts.get(1).getArgs().get(0).equals("a"));
        Assert.assertTrue(facts.get(1).getArgs().get(1).equals("c"));              

    }
}
