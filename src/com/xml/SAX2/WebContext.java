package com.xml.SAX2;

import java.util.List;

public class WebContext {
	private List<Entity> listPerson = null;
	private List<Mapping> listMapping = null;
	public WebContext(List<Entity> listPerson, List<Mapping> listMapping) {
		super();
		this.listPerson = listPerson;
		this.listMapping = listMapping;
	}
	public String getClz(String patten) {
		return null;
	}
	
}
