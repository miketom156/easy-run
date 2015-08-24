package com.job5156.vo.cms;

/**
 *CMS导入对应的OBJECT，及显示用到的属性
 */
public class Article {

/*  art:dede_arctype文章类别表
    arc:dede_archives具体的文章表
    aac:dede_addonarticle
    */
    private Integer arcId;
    private Integer arcTypeid;
    private Integer arcChannel;
    private String  arcTitle;
    private String  arcShorttitle;
    private String  arcLitpic;
    private Integer arcSenddate;
    private Integer arcPubdate;
    private String  arcDescription;
    private String  arcTypeid2;
    private String  arcNamerule;
    private Integer  arcArcrank;
    private String  arcFilename;
    private Integer arcIspart;
    private Integer arcIsmake;
    private Integer arcClick;
    private String arcFlag;

    private Integer  artId;
    private String  artTypename;
    private Integer  artTopid;
    private Integer  artReid;
    private String  artTypedir;
    private String  artSitepath;
    private String  artSiteurl;
    private String  artNamerule;
    private String  artNamerule2;
    private Integer  artIspart;
    private Integer  artIsdefault;
    private String  artDefaultname;

    private Integer  aacId;
    private Integer aacTypeid;
    private String  aacBody;
    private String arcSourceurl;
    private String arcJobpicurl ;//坚形的文章缩小图

    // 以下是只供显示用的属性
    private Integer id;
    private String title;
    private String url;
    private String site;
    private String thumbnail;  //小图
    private Integer sortNum;
    private Integer top;     //置顶
    private String newsType; //spec,common 专题，普通
    private String desc; //简单描述
    private String category; //所属栏目名称
    private String categoryUrl;//栏目URL


    public Integer getArcId() {
        return arcId;
    }

    public void setArcId(Integer arcId) {
        this.arcId = arcId;
    }

    public Integer getArcTypeid() {
        return arcTypeid;
    }

    public void setArcTypeid(Integer arcTypeid) {
        this.arcTypeid = arcTypeid;
    }

    public Integer getArcChannel() {
        return arcChannel;
    }

    public void setArcChannel(Integer arcChannel) {
        this.arcChannel = arcChannel;
    }

    public String getArcTitle() {
        return arcTitle;
    }

    public void setArcTitle(String arcTitle) {
        this.arcTitle = arcTitle;
    }

    public String getArcShorttitle() {
        return arcShorttitle;
    }

    public void setArcShorttitle(String arcShorttitle) {
        this.arcShorttitle = arcShorttitle;
    }

    public String getArcLitpic() {
        return arcLitpic;
    }

    public void setArcLitpic(String arcLitpic) {
        this.arcLitpic = arcLitpic;
    }

    public Integer getArcSenddate() {
        return arcSenddate;
    }

    public void setArcSenddate(Integer arcSenddate) {
        this.arcSenddate = arcSenddate;
    }

    public Integer getArcPubdate() {
        return arcPubdate;
    }

    public void setArcPubdate(Integer arcPubdate) {
        this.arcPubdate = arcPubdate;
    }

    public String getArcDescription() {
        return arcDescription;
    }

    public void setArcDescription(String arcDescription) {
        this.arcDescription = arcDescription;
    }

    public String getArcTypeid2() {
        return arcTypeid2;
    }

    public void setArcTypeid2(String arcTypeid2) {
        this.arcTypeid2 = arcTypeid2;
    }

    public String getArcNamerule() {
        return arcNamerule;
    }

    public void setArcNamerule(String arcNamerule) {
        this.arcNamerule = arcNamerule;
    }

    public Integer getArcArcrank() {
        return arcArcrank;
    }

    public void setArcArcrank(Integer arcArcrank) {
        this.arcArcrank = arcArcrank;
    }

    public String getArcFilename() {
        return arcFilename;
    }

    public void setArcFilename(String arcFilename) {
        this.arcFilename = arcFilename;
    }

    public Integer getArcIspart() {
        return arcIspart;
    }

    public void setArcIspart(Integer arcIspart) {
        this.arcIspart = arcIspart;
    }

    public Integer getArcIsmake() {
        return arcIsmake;
    }

    public void setArcIsmake(Integer arcIsmake) {
        this.arcIsmake = arcIsmake;
    }

    public Integer getArcClick() {
        return arcClick;
    }

    public void setArcClick(Integer arcClick) {
        this.arcClick = arcClick;
    }

    public String getArcFlag() {
        return arcFlag;
    }

    public void setArcFlag(String arcFlag) {
        this.arcFlag = arcFlag;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtTypename() {
        return artTypename;
    }

    public void setArtTypename(String artTypename) {
        this.artTypename = artTypename;
    }

    public Integer getArtTopid() {
        return artTopid;
    }

    public void setArtTopid(Integer artTopid) {
        this.artTopid = artTopid;
    }

    public Integer getArtReid() {
        return artReid;
    }

    public void setArtReid(Integer artReid) {
        this.artReid = artReid;
    }

    public String getArtTypedir() {
        return artTypedir;
    }

    public void setArtTypedir(String artTypedir) {
        this.artTypedir = artTypedir;
    }

    public String getArtSitepath() {
        return artSitepath;
    }

    public void setArtSitepath(String artSitepath) {
        this.artSitepath = artSitepath;
    }

    public String getArtSiteurl() {
        return artSiteurl;
    }

    public void setArtSiteurl(String artSiteurl) {
        this.artSiteurl = artSiteurl;
    }

    public String getArtNamerule() {
        return artNamerule;
    }

    public void setArtNamerule(String artNamerule) {
        this.artNamerule = artNamerule;
    }

    public String getArtNamerule2() {
        return artNamerule2;
    }

    public void setArtNamerule2(String artNamerule2) {
        this.artNamerule2 = artNamerule2;
    }

    public Integer getArtIspart() {
        return artIspart;
    }

    public void setArtIspart(Integer artIspart) {
        this.artIspart = artIspart;
    }

    public Integer getArtIsdefault() {
        return artIsdefault;
    }

    public void setArtIsdefault(Integer artIsdefault) {
        this.artIsdefault = artIsdefault;
    }

    public String getArtDefaultname() {
        return artDefaultname;
    }

    public void setArtDefaultname(String artDefaultname) {
        this.artDefaultname = artDefaultname;
    }

    public Integer getAacId() {
        return aacId;
    }

    public void setAacId(Integer aacId) {
        this.aacId = aacId;
    }

    public Integer getAacTypeid() {
        return aacTypeid;
    }

    public void setAacTypeid(Integer aacTypeid) {
        this.aacTypeid = aacTypeid;
    }

    public String getAacBody() {
        return aacBody;
    }

    public void setAacBody(String aacBody) {
        this.aacBody = aacBody;
    }

    public String getArcSourceurl() {
        return arcSourceurl;
    }

    public void setArcSourceurl(String arcSourceurl) {
        this.arcSourceurl = arcSourceurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getArcJobpicurl() {
        return arcJobpicurl;
    }

    public void setArcJobpicurl(String arcJobpicurl) {
        this.arcJobpicurl = arcJobpicurl;
    }
}
