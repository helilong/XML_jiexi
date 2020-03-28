package com.xml.SAX2;

import java.util.HashSet;
import java.util.Set;
/**
 * mapping����
 * @author С��
 *
 */
public class Mapping {
	private String name;
	private Set<String> patterns;
	public Mapping() {
		patterns = new HashSet<String>();
	}
	public Mapping(String name, Set<String> patterns) {
		super();
		this.name = name;
		this.patterns = patterns;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getPatterns() {
		return patterns;
	}
	public void setPatterns(Set<String> patterns) {
		this.patterns = patterns;
	}
	public void addPattern(String patten) {
		this.patterns.add(patten);
	}
}
