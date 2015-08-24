<meta charset="utf-8" />
您好：<br/>
&nbsp;&nbsp;网站首页URL链接失效或企业、职位已经过期，请您关注跟进：<br/>
<table border="1">
<#list map?keys as key>
	<tr>
        <th colspan="3">
        	${key}：
        	<#assign item = map[key]>   
		     <#list item as itemValue>
			     <#if itemValue_index == 0>
			      ${itemValue.mainUrl}
			     </#if>
		     </#list>
        </th>
    </tr>
    <#assign item = map[key]>   
	<#list item as itemValue>
	     <tr>
		   <td>${itemValue.urlOrType}</td>
		   <td>${itemValue.infoName?if_exists}&nbsp;</td>
		   <td>${itemValue.mesage}</td>
		 </tr>
	</#list>
</#list>
</table>