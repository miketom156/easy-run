<meta charset="utf-8" />
<div align="center" style="background:#f1f1f1;">
    <div style="width:600px;margin:0 auto;font-family:'Microsoft YaHei', '宋体';font-size:12px;color:#333;line-height:22px;text-align:left;">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td bgcolor="#FFFFFF">
		      <table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
		        <tr>
		          <td height="120" colspan="3" background="${visit_domain}/static/img/mail/top.jpg">
		          	<a href="${visit_domain}" target="_blank"><img src="${visit_domain}/static/img/mail/logo.png" width="265" height="39" style="padding-left:30px;"></a>
		          </td>
		        </tr>
		        <tr>
		          <td width="10" height="471" background="${visit_domain}/static/img/mail/left.gif">
		          </td>
		          <td width="580" valign="top">
		          	<table width="540" border="0" cellspacing="0" cellpadding="0" align="center">
		              <tr>
		                <td>
		                	<h2 style="padding:20px 0;margin:0;font-size:16px;">亲爱的${comUser.username}：</h2>
		                    <p style="text-indent:2em;font-size:12px;">根据您订阅的简历内容，为您推荐以下新鲜出炉的人才简历，希望有您喜欢的！</p>
		                </td>
		              </tr>
		            </table>
		            <table width="540" border="0" cellspacing="0" cellpadding="0" align="center">
		              <tr>
		              	<td width="386">&nbsp;</td>
		                <td style="text-align:right;"><a href="${search_domain}${moreResumeLink}" target="_blank" style="color:#37c;font-size:14px; text-decoration:none; display:block;padding-bottom:10px;">还有500+个简历&gt;&gt;</a></td>
		              </tr>
		            </table>
		            <table width="540" border="0" align="center" cellpadding="0" cellspacing="0" style="background:url(${visit_domain}/static/img/mail/ttBg.png) 0 0 no-repeat;font-size:14px;font-weight:bold;height:34px;line-height:34px;text-align:center;">
		               <tr>
		                  <td>姓名</td>
		                  <td width="180">性别|年龄|学历|经验</td>
		                  <td width="140">专业</td>
		                  <td width="128">期望地区</td>
		               </tr>
		             </table>
		             <table width="540" border="0" align="center" cellspacing="0" cellpadding="0" style="text-align:center;font-size:12px;">
		             <#list perResumeVoList as perResume>
		              <tr <#if (perResume_index+1) % 2 == 0>bgcolor="#F7F7F7"</#if>>
		                <td height="30"><a href="${visit_domain}/resume/view/${perResume.id?c}" target="_blank" style="color:#37c;text-decoration:none;">${perResume.basicInfoVo.userName}</a></td>
		                <td width="180">${perResume.basicInfoVo.ganderStr}|${perResume.basicInfoVo.ageStr}岁|${perResume.highDegreeStr}|${perResume.basicInfoVo.jobYear}</td>
		                <td width="140">${perResume.highSpecial}</td>
		                <td width="128">${perResume.intentInfoVo.jobLocationStr}</td>
		              </tr>
		             </#list>
		             </table>
					<table width="540" border="0" align="center" cellpadding="0" cellspacing="0">
					  <tr>
		        		 <td height="40" align="right" valign="bottom"><a href="${visit_domain}${unsubscribeLink}" target="_blank" style="color:#888;font-size:12px;">[退订]</a></td>
		        	  </tr>
		              <tr>
		                 <td><a href="${search_domain}${moreResumeLink}" target="_blank"><img src="${visit_domain}/static/img/mail/banner3.gif" width="540" height="52" style="padding:20px 0;"></a></td>
		              </tr>
		            </table> 
		          </td>
		          <td width="10" background="${visit_domain}/static/img/mail/right.gif">
		          </td>
		        </tr>
		         <tr>
		          <td height="10" colspan="3" background="${visit_domain}/static/img/mail/bottom.gif"></td>
		        </tr>
		      </table>
		    </td>
		  </tr>
		  <tr>
		    <td height="30" align="center" valign="middle" style="font-size:12px;">求职　招聘　智通人才网版权所有&copy;1999-2014</td>
		  </tr>
		</table>
	</div>
</div>