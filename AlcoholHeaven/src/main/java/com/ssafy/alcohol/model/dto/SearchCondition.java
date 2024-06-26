package com.ssafy.alcohol.model.dto;

public class SearchCondition {
	private String key = "none";
	private String word;
	

	public SearchCondition() {
	}
	

	public SearchCondition(String key, String word) {
		super();
		this.key = key;
		this.word = word;
	}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}



	@Override
	public String toString() {
		return "SearchCondition [key=" + key + ", word=" + word + "]";
	}
}
