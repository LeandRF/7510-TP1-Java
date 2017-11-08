package ar.uba.fi.tdd.rulogic.utils;

import java.io.File;

public class Util {
	
	private String pathDB;
	private String regexRule = "^[a-zA-Z]*\\([a-zA-Z]+(,[a-zA-Z]*)*\\):-[a-zA-Z]*\\([a-zA-Z]+(,[a-zA-Z]*)*\\)(,[a-zA-Z]*\\([a-zA-Z]+(,[a-zA-Z]*)*\\))*";
	private String regexFact = "^[a-zA-Z]*\\([a-zA-Z]+(,[a-zA-Z]*)*\\)";
	private String regexQuery ="^[a-zA-Z]+\\([a-zA-Z]+(,[a-zA-Z]+)*\\)$";
	
	public String getPathDB(){
		return this.pathDB;
	}
	
	public String getRegexRule(){
		return this.regexRule;
	}
	
	public String getRegexQuery(){
		return this.regexQuery;
	}
	
	public String getRegexFact(){
		return this.regexFact;
	}	
	
	public Util(){
		this.pathDB = 	new  File("").getAbsolutePath().concat(File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "rules.db");
	}

}
