package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import ar.uba.fi.tdd.rulogic.exception.InvalidDataBaseException;
import ar.uba.fi.tdd.rulogic.utils.Util;

import java.io.File;
import java.util.List;

public class DataBaseCreatorTest {
        
    @Test
    public void testDataBase() throws InvalidDataBaseException {
    	DataBaseCreator dbCreator = new DataBaseCreator();
    	Util utl = new Util();
        KnowledgeBase knowledgeBase = dbCreator.create(utl.getPathDB());
        
        List<Fact> facts = knowledgeBase.getFacts();
        List<Rule> rules = knowledgeBase.getRules();

        Assert.assertTrue(facts.get(0).getName().equals("varon"));
        Assert.assertTrue(facts.get(0).getArgs().get(0).equals("juan"));
        Assert.assertTrue(facts.get(1).getName().equals("varon"));
        Assert.assertTrue(facts.get(1).getArgs().get(0).equals("pepe"));

        Assert.assertTrue(rules.get(0).getNombre().equals("hijo"));        
        Assert.assertTrue(rules.get(0).getFacts().get(0).getName().equals("varon"));        
        Assert.assertTrue(rules.get(0).getFacts().get(1).getName().equals("padre"));        
        
    }
    
    @Test
    public void testInvalidDataBase() {
    	DataBaseCreator dbCreator = new DataBaseCreator();
        try {
        	dbCreator.create(new  File("").getAbsolutePath().concat(File.separator + "src" + File.separator + "test"
                    + File.separator + "resources" + File.separator + "invalid.db"));
        	
            Assert.assertTrue(false);
        } catch (InvalidDataBaseException e) {
            Assert.assertTrue(e.getMessage().equals(""));
        }
    }

}
