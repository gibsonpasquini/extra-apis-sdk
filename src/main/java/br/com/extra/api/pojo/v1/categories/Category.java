package br.com.extra.api.pojo.v1.categories;

import java.util.List;

import br.com.extra.api.pojo.Pojos;

public class Category extends Pojos {

	private static final long serialVersionUID = -1950672530490512663L;

	private Integer levelId;
	private String levelName;
	private Integer levelFatherId;
	private List<CategoryUda> udaList;

	public Integer getLevelFatherId() {
		return levelFatherId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public List<CategoryUda> getUdaList() {
		return udaList;
	}

	public void setLevelFatherId(Integer levelFatherId) {
		this.levelFatherId = levelFatherId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public void setUdaList(List<CategoryUda> udaList) {
		this.udaList = udaList;
	}

}
