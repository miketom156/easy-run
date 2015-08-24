<meta charset="utf-8" />
<div align="center" style="background:#f1f1f1;">
    <div style="width:600px;margin:0 auto;font-family:'Microsoft YaHei', '宋体';font-size:12px;color:#333;line-height:22px;text-align:left;">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td bgcolor="#FFFFFF">
		      <table width="540" border="0" align="center" cellpadding="0" cellspacing="0">
		        <tr>
		          <td height="44">&nbsp;</td>
		        </tr>
		        <tr>
		          <td><a href="${visit_domain}" target="_blank"><img src="${visit_domain}/static/img/mail/logo.png" width="265" height="39"></a></td>
		        </tr>
		        <tr>
		          <td height="10">&nbsp;</td>
		        </tr>
		      </table>
		      <table width="540" height="140" border="0" align="center" cellpadding="0" cellspacing="0" background="${visit_domain}/static/img/mail/index_1.png">
		        <tr>
		          <td><h2 style="padding:0;margin:0;font-size:16px;">亲爱的${perUser.userName}：</h2></td>
		        </tr>
		        <tr>
		          <td><p style="height:80px;padding:0;margin:0;text-indent:2em;font-size:12px;"> 根据你订阅的职位内容，为你推荐以下新鲜出炉的工作岗位，希望有你喜欢<br />的！衷心祝福你：早日找到合适的工作，幸福快乐每一天！ </p></td>
		        </tr>
		      </table>
		      <table width="540" border="0" align="center" cellpadding="0" cellspacing="0">
		      	<tr>
		          <td height="10" colspan="3">&nbsp;</td>
		          </tr>
		        <tr>
		          <td width="47"><img src="${visit_domain}/static/img/mail/index_2.png" width="47" height="41"></td>
		          <td style="font-size:20px;padding:5px 0 5px 0;font-weight:bold;">“我”来了，请君过目</td>
		          <td style="text-align:right;"><a href="${search_domain}${morePosLink}" target="_blank" style="color:#37c;font-size:14px; text-decoration:none; display:block;">还有1000+个职位&gt;&gt;</a></td>
		        </tr>
		      </table>
		      <table width="540" border="0" align="center" cellpadding="0" cellspacing="0" style="background:url(${visit_domain}/static/img/mail/ttBg.png) 0 0 no-repeat;font-size:14px;font-weight:bold;height:34px;line-height:34px;">
		        <tr>
		          <td style="padding-left:15px;">推荐职位</td>
		          <td style="width:100px;text-align:center;">更新时间</td>
		        </tr>
		      </table>
		      <#list comPosList as comPos>
		      	<div style="width:520px;margin:0 auto;padding:15px 10px;<#if (comPos_index+1) % 2 == 0>background-color:#F7F7F7;border-top:1px solid #eee;border-bottom:1px solid #eee;</#if>">
			      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="table-layout:fixed;font-size:12px;">
			        <tr>
			          <td><a href="${search_domain}/jobs/${comPos.posNo?c}" target="_blank" style="font-size:16px;font-weight:bold;color:#37c;text-decoration:none;padding-right:10px;">${comPos.position.posName}</a>${comPos.position.workLocationStr} | ${comPos.position.salaryStr} | ${comPos.position.reqDegreeStr} | ${comPos.position.reqWorkYearStr}
			          <td width="15%" valign="top" align="center">${comPos.position.refreshDate?date}</td>
			        </tr>
			        <tr>
			          <td colspan="2">
			          	<a href="${search_domain}/corp/${comPos.company.id?c}" target="_blank" style="font-size:14px;font-weight:bold;color:#37c;text-decoration:none;padding-right:10px;">${comPos.company.comName}</a>| ${comPos.company.industryStr} | ${comPos.company.propertyStr} 
			          </td>
			        </tr>
			        <#if comPos.position.taoLabelList?exists>
			        <tr>
			          <td colspan="2" style="padding:5px 0;">
			          	淘职位标签：<#list comPos.position.taoLabelList as taoLabel><span style="background-color:#EFEFEF;border:1px solid #E1E1E1;padding:2px 5px;margin-right:5px;">${taoLabel}</span></#list>
			          </td>
			        </tr>
			        </#if>
			        <tr>
			          <td colspan="2" style="color:#888;">
			          	<#if comPos.position.description?trim?length gt 90>
			          		${comPos.position.description?trim?substring(0, 90) }...
			          	<#else>
			          		${comPos.position.description?trim}
			          	</#if>
			          </td>
			        </tr>
			      </table>
		      	</div>
		      </#list>
		      <table width="540" border="0" align="center" cellpadding="0" cellspacing="0">
		      	<tr>
		        	<td height="40" align="right" valign="bottom"><a href="${visit_domain}${unsubscribeLink}" target="_blank" style="color:#888;font-size:12px;">[退订]</a></td>
		        </tr>
		        <tr>
		          <td><a href="${search_domain}${morePosLink}" target="_blank"><img src="${visit_domain}/static/img/mail/banner.gif" width="540" height="52" style="padding:10px 0 20px 0;"></a></td>
		        </tr>
		      </table>
		    </td>
		  </tr>
		  <tr>
		    <td height="30" align="center" valign="middle" style="color:#888;font-size:12px;">求职　招聘　智通人才网版权所有&copy;1999-2014</td>
		  </tr>
		</table>
	</div>
</div>