package ar.uba.fi.tdd.rulogic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import ar.uba.fi.tdd.rulogic.exception.InvalidDataBaseException;
import ar.uba.fi.tdd.rulogic.utils.Util;

public class DataBaseCreator {

    public KnowledgeBase create(String dbPath) throws InvalidDataBaseException {        
        List<String> dbList =  Arrays.asList(getDbString(dbPath).split("\n"));
        isvalidDB(dbList);

        return getDatabase(dbList);
    }
    

    private String getDbString(String dbPath) {
        String dbString = null;
        try {
        	dbString = this.dbToString(dbPath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return dbString.replace(".","").replace("\t","").replace(" ", "");
    }
    

    private String dbToString(String path) throws IOException {
        BufferedReader  buffReader= new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        String line = buffReader.readLine();

        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = buffReader.readLine();
        }
        
        buffReader.close();
        return stringBuilder.toString();
    }



   private void isvalidDB(List<String> databaseStringList) throws InvalidDataBaseException {
        for (String linea : databaseStringList) {
            if (!(isValidFact(linea) || isValidRule(linea))) {
            	 throw new InvalidDataBaseException(""); 
           }
        }
    }
    private Boolean isValidFact(String linea) {
    	Util utl = new Util();        
        return linea.matches(utl.getRegexFact());
    }

    private Boolean isValidRule(String linea) {
    	Util utl = new Util();
        return linea.matches(utl.getRegexRule());
    }
    
    private KnowledgeBase getDatabase(List<String> databaseStringList) {
        KnowledgeBase knowledgeBase = new KnowledgeBase();
         for (String line : databaseStringList) {
             if (!line.contains(":-")) {
                 Fact fact = new Fact(line);
                 knowledgeBase.addFact(fact);
             }

             else {
                 Rule rule = new Rule(line);
                 knowledgeBase.addRule(rule);
             }
         }

         return knowledgeBase;
    }

}
