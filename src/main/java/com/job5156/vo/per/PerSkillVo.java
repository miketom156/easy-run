package com.job5156.vo.per;

import com.job5156.common.option.OptionMap;
import com.job5156.common.option.OptionMap.OptionType;

/**
 * 专业技能
 */
public class PerSkillVo{

    private Long id;           //序号
    private String  name;      //技能名称
    private Integer level;     //掌握程度（等级）
    private Integer duration;  //使用时长(年）
    private Boolean isTransform ; //是否完成了数据的转换

    public String getLevelStr(){ //掌握程度（等级）字串格式
        if (level != null) {
            return OptionMap.getValue(OptionType.OPT_LANGUAGE, level);
        }
        return "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getIsTransform() {
        return isTransform;
    }

    public void setIsTransform(Boolean isTransform) {
        this.isTransform = isTransform;
    }
}