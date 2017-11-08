package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import ar.uba.fi.tdd.rulogic.exception.InvalidDataBaseException;
import ar.uba.fi.tdd.rulogic.exception.InvalidQueryException;
import ar.uba.fi.tdd.rulogic.utils.Util;

public class KnowledgeBaseTest {

	 
       @Test
    public void testValidRuleQueries() throws InvalidDataBaseException, InvalidQueryException {
    	DataBaseCreator dbCreator = new DataBaseCreator();
    	Util utl = new Util();
        KnowledgeBase knowledgebase = dbCreator.create(utl.getPathDB());
 
        Assert.assertTrue(knowledgebase.answer("varon(hector)."));        
        Assert.assertTrue(knowledgebase.answer("hermano(roberto, nicolas)."));         
        Assert.assertTrue(knowledgebase.answer("hijo(pepe,juan)."));     
        

        Assert.assertFalse(knowledgebase.answer("mujer(leandro)."));
        Assert.assertFalse(knowledgebase.answer("varon(ana)."));

    }
}
