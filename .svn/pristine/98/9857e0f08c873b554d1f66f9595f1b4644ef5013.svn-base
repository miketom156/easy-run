package com.job5156.task.cms;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.google.common.collect.Lists;
import com.job5156.vo.cms.Article;
import com.job5156.vo.cms.PosArticleVo;
import com.job5156.common.Constants;
import com.job5156.common.jedis.JedisFactory;
import com.job5156.common.jedis.JedisTemplate;
import com.job5156.common.util.HibernateCmsUtil;
import com.job5156.common.util.HibernateCountUtil;

/**
 * 用于一次性缓存所有不同职位文章咨询链接
 *
 * Date:2015-5-8 下午5:16:06
 * @author xiatao
 * @version 1.0
 */

public class PosArticleConsultationData {

	//PosArticleConsultationData.class的日志
	private static Logger LOG = Logger.getLogger(PosArticleConsultationData.class);
	
	//Cms主URL
	private final String CMSPATH = "http://article.job5156.com";  
	
	//Count的JdbcTemplate
	private  JdbcTemplate jdbcTemplateCount = HibernateCountUtil.getJdbcTemplate();
	
	//Cms的JdbcTemplate
	private  JdbcTemplate jdbcTemplateCms = HibernateCmsUtil.getJdbcTemplate();
	
	//缓存客户端的工厂
	private JedisFactory jedisFactory = JedisFactory.getInstance();	
	
	/**
	 * 打印日志INFO信息
	 * 
	 * @param log
	 * @param e
	 * @return
	 */
    private void log(String log) {
        LOG.info("[PosArticleConsultationData INFO]: " + log);
    }
    
	/**
	 * 打印日志ERROR信息
	 * 
	 * @param log
	 * @param e
	 * @return
	 */    
    private void logError(String log, Exception e) {
        LOG.error("[PosArticleConsultationData ERROR]: " + log);
    }
        
	/**
	 * 通过SQL返回Article
	 * 
	 * @param sql
	 * @return
	 */
    private List<Article> transferArticle(String sql) {
		List<Article> list = jdbcTemplateCms.query(sql,
				new RowMapper<Article>() {
					@Override
					public Article mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Article article = new Article();
                        article.setArcId(NumberUtils.toInt(rs.getString("arcId"), 0));
                        article.setArcArcrank(NumberUtils.toInt(rs.getString("arcrank"), 0));
                        article.setArcShorttitle(ObjectUtils.toString( rs.getString("shorttitle"), ""));
                        article.setArcTitle(ObjectUtils.toString(rs.getString("title"), ""));
                        article.setArcDescription(ObjectUtils.toString(rs.getString("Description"), ""));
                        article.setArcFilename(ObjectUtils.toString(rs.getString("filename"), ""));
                        article.setArcIsmake(NumberUtils.toInt( rs.getString("ismake"), 0));
                        if (StringUtils.isNotBlank(ObjectUtils.toString(rs.getString("litpic"), ""))) {
                            article.setArcLitpic(CMSPATH + ObjectUtils.toString(rs.getString("litpic"), ""));
                        }
                        article.setArcSenddate(NumberUtils.toInt(rs.getString("senddate"), 0));
                        article.setArcPubdate(NumberUtils.toInt(rs.getString("pubdate"), 0));
                        article.setArcTypeid(NumberUtils.toInt(rs.getString("arcTypeid"), 0));
                        article.setArtId(NumberUtils.toInt(rs.getString("artId"), 0));
                        article.setArtDefaultname(ObjectUtils.toString(rs.getString("defaultname"), ""));
                        article.setArtIsdefault(NumberUtils.toInt( rs.getString("isdefault"), 0));
                        article.setArtIspart(NumberUtils.toInt(rs.getString("ispart"), 0));
                        article.setArtNamerule(ObjectUtils.toString(rs.getString("namerule"), ""));
                        article.setArtNamerule2(ObjectUtils.toString(rs.getString("namerule2"), ""));
                        article.setArtSitepath(ObjectUtils.toString(rs.getString("sitepath"), ""));
                        article.setArtSiteurl(ObjectUtils.toString(rs.getString("siteurl"), ""));
                        article.setArtTypedir(ObjectUtils.toString(rs.getString("typedir"), ""));
                        article.setArtTypename(ObjectUtils.toString(rs.getString("typename"), ""));
                        article.setArcSourceurl(ObjectUtils.toString(rs.getString("arcSourceurl"), ""));
                        return article;
                    }
                });
		return list;

	}
    
    /**
     * 得到文章的真实链接地址
     * 
     * @param aid
     * 					 	文章id
     * @param ismake
     * 						文章是否动态
     * @param typedir
     * 						文章目录
     * @param namerule
     * 					 	文章命名规则
     * @param sitepath
     * 					 	文章地址路径
     * @param siteurl
     * 						文章局部url
     * @param senddate
     * 						文章更新时间
     * @param arcrank
     * 					 	文章审核状态
     * @param arcrank
     * 					 	文章名称 
     * @return 
     */
    private String getArcUrl(int aid, int ismake, String typedir, String namerule, String sitepath, String siteurl, long senddate, int arcrank, String filename) {    	
       StringBuilder arcUrl = new StringBuilder();
       if (-1 == ismake || 0 != arcrank) {   //文章类型是动态浏览的
           arcUrl.append(CMSPATH).append("/plus/view.php?aid=").append(aid);
       } else {
           if(StringUtils.isNotBlank(siteurl) && !StringUtils.equalsIgnoreCase(CMSPATH,siteurl)){
               typedir = siteurl;//siteurl为分站域名,例:http://article.nb.job5156.com/2013/0823/104494.html
           }else{
               if (typedir.indexOf("{cmspath}") != -1) {
                   typedir = typedir.replace("{cmspath}", CMSPATH);
               } else {
                   typedir = CMSPATH + typedir;
               }
           }
           //部分域名不规则"/{cmspath}..."
           typedir = typedir.indexOf("/http:")!=-1 ? typedir.replace("/http:","http:") : typedir;
           long a = senddate * 1000;
           String dateStr = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(a));
           
           if (dateStr.length() < 10) return "";
           String year = dateStr.substring(6, 10);
           String month = dateStr.substring(3, 5);
           String day = dateStr.substring(0, 2);
           namerule = namerule.replace("{Y}", year);
           namerule = namerule.replace("{M}", month);
           namerule = namerule.replace("{D}", day);

           if (StringUtils.isNotEmpty(filename)) {
               namerule = namerule.replace("{aid}", filename);
           } else {
               namerule = namerule.replace("{aid}", aid + "");
           }
           namerule = namerule.replace("{typedir}", typedir);
           arcUrl.append(namerule);
       }
       return arcUrl.toString();
   }
	
    /**
     * 一次性将所有职位对应的文章链接查询
     * 
     * @return 
     */
    public void runPosData() throws UnsupportedEncodingException {    	
        log("START runPosData()");      
        //控制每50个职位
        int count = 0;        
       //查询所有职位名称,条件要有英文，中文，长度为1到20
        String posListSql = "select distinct(pos_segword) from pos_word_lib where pos_segword REGEXP '[a-zA-Z]' or not(pos_segword REGEXP '[\u0391-\uFFE5]') and (length(pos_segword) between 1 and 20)";        
		List<String> posList = jdbcTemplateCount.queryForList(posListSql, String.class);
		
		for(String posArticle : posList){
			++count;			
			//每50个不同职位查询延时3秒
			if(count%50==0){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
	        String posArticleConsultationSql = " SELECT arc.id as arcId,arc.arcrank, arc.filename, arc.title, arc.shorttitle, arc.litpic," +
	                " arc.ismake, arc.senddate,arc.pubdate,arc.sourceurl as arcSourceurl, arc.description, " +
	                " arc.jobpicurl as jobpicurl, arc.typeid as arcTypeid, art.typedir, art.namerule, art.sitepath, art.siteurl,  " +
	                " art.typename, art.id as artId, art.isdefault,  art.ispart, art.defaultname, art.namerule2 " +
	                " FROM dede_archives AS arc " +
	                " LEFT JOIN dede_arctype AS art ON art.id = arc.typeid " +
	                " WHERE arc.channel =1"+
	                " AND arc.arcrank =0"+
	                " AND arc.title like '%"+posArticle+"%'" +
	                " ORDER BY arc.senddate DESC" +
	                " LIMIT 0 , 5";	        
			List<Article> tempArticleList = transferArticle(posArticleConsultationSql);	        		
			
	        //数据封装
		    for (Article article : tempArticleList) {  
		        int aid = NumberUtils.toInt(ObjectUtils.toString(article.getArcId(), ""), 0);
		        String title =article.getArcTitle();		
		        int ismake = article.getArcIsmake();
		        long senddate = article.getArcSenddate();		
		        String desc =ObjectUtils.toString(article.getArcDescription(), "");
		        
		        if(StringUtils.isBlank(desc)){
		            desc = StringUtils.left(ObjectUtils.toString(article.getAacBody(), ""), 100);
		        }
		
		        String typedir = ObjectUtils.toString(article.getArtTypedir(), "");
		        String namerule = ObjectUtils.toString(article.getArtNamerule(), "");
		        String sitepath = ObjectUtils.toString(article.getArtSitepath(), "");
		        String siteurl = ObjectUtils.toString(article.getArtSiteurl(), "");
		
		        int arcrank = NumberUtils.toInt(ObjectUtils.toString(article.getArcArcrank(), ""), 0);
		        String filename = ObjectUtils.toString(article.getArcFilename(), "");
		        String arcurl = getArcUrl(aid, ismake, typedir, namerule, sitepath, siteurl, senddate, arcrank, filename);
		
		        //保存到显示属性
		        article.setTitle(title);
		        article.setArtId(aid);
		        article.setDesc(desc);
		        article.setNewsType("common");
		        article.setSortNum(arcrank);
		        article.setUrl(arcurl);
		    }
    
		    if(CollectionUtils.isNotEmpty(tempArticleList)){
		    	List<PosArticleVo> posArticleVoList = Lists.newArrayList();
		    	
		    	for(Article article : tempArticleList){		    		
		    		PosArticleVo posArticleVo = new PosArticleVo();
		    		posArticleVo.setTitle(article.getTitle().trim());
		    		posArticleVo.setUrl(article.getUrl().replaceAll("(?i)http://", ""));
		    		posArticleVoList.add(posArticleVo);
		    	}	    	
		    	//在写入生成文件的时候直接更新Redis的内容
		    	saveToRedis(posArticle.toLowerCase(), posArticleVoList);
		    }		    
		}
        log("END runPosData().生成文章成功咨询链接成功！");
    }
    

    /**
     * 生成List并保存到REDIS
     *
     * @param fileName
     * @param content
     */
    public void saveToRedis(String posArticle, List<PosArticleVo> posArticleVoList) {    	        
        try {
        	//在写入生成文件的时候直接更新Redis的内容
            String redisKey = Constants.FILE_POS_AREICLE_CONSULATION+posArticle;
            JedisTemplate jedisTemplate = jedisFactory.getJedisTemplate(Constants.POS_AREICLE_CONSULATION_REDISKEY);
            jedisTemplate.writeObjectToList(redisKey, posArticleVoList);
            log( "Build success : " + posArticle );
        } catch (Exception e) {
        	logError("生成职位CRM文章咨询出错[职位名称:" + posArticle+ "],异常信息如下: " + e.getMessage(), e);
        }    	
    }    
  }
