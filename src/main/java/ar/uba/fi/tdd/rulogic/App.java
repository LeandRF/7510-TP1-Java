package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.exception.InvalidDataBaseException;
import ar.uba.fi.tdd.rulogic.exception.InvalidQueryException;
import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;
import ar.uba.fi.tdd.rulogic.model.DataBaseCreator;
import ar.uba.fi.tdd.rulogic.utils.Util;

import java.util.Scanner;

public class App{
	
	public static void main(String[] args) {
		Util utl = new Util();
	    App app = new App();	    

	    DataBaseCreator dbCreator = new DataBaseCreator();
        KnowledgeBase knowledgeBase = null;
        try {
        	 knowledgeBase = dbCreator.create(utl.getPathDB());            
        } catch (InvalidDataBaseException e) {
            System.out.println("Invalid database");
            System.exit(1);
        }

        app.answerquery(knowledgeBase);
    }

    public void answerquery(KnowledgeBase knowledgeBase) {	    
	    
        System.out.println("I shall answer all your questions!");
        System.out.println("Type 'q' to exit");
        
        Scanner reader = new Scanner(System.in);
	    while (true) {
			System.out.println("Enter your query: ");
			String queryString = reader.nextLine();
			
	        if (queryString.equals("q")) break;

            try {
                if (knowledgeBase.answer(queryString)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
            catch (InvalidQueryException e) {
                System.out.println(e.getMessage());
            }
        }
	    reader.close();
    }
}
