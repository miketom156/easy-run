package com.job5156.vo.per;

public class PerLanguageInfoVo {
	private Long id;                   //id编号
	private Integer skill;             //技能类别
	private Integer level;             //技能水平
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSkill() {
		return skill;
	}
	public void setSkill(Integer skill) {
		this.skill = skill;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
}