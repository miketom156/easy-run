<meta charset="utf-8" />
您好：<br/>
&nbsp;&nbsp;后台检查广告LOGO、企业和职位三天内即将过期的邮件提醒，请您关注跟进：<br/>
<table border="1">
<#list map?keys as key>
	<tr>
        <th colspan="3">
        	${key}
        </th>
    </tr>
    <tr style="background-color:#ACE4FF;">
    	<td>模块名称</td>
    	<td>状态</td>
    	<td>描述</td>
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