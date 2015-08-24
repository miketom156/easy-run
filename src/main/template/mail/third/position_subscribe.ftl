<meta charset="utf-8" />
<style>
a{
	text-decoration: none;
}
a:hover{
	text-decoration: underline;
}
</style>
<table width="660" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="${visit_domain}/static/img/mail/third/di.png" bgcolor="#3383BE"><table width="632" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="right" style="padding:14px;font-size:12px;line-height:21px;color:#e1f0f8">此邮件来自<a href="${visit_domain}?et=9102f011" target="_blank" style="color:#fff;text-decoration: underline">智通人才网</a> 若不希望再收到此类邮件<a href="${visit_domain}${unsubscribeLink}" target="_blank" style="color:#fff;text-decoration: underline">点此退订</a></td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="padding:20px"><a href="${visit_domain}?et=9102f011" target="_blank"><img src="${visit_domain}/static/img/mail/third/logo.png" width="273" height="45" alt="智通人才网" border=0 /></a></td>
      </tr>
      <tr>
        <td><img src="${visit_domain}/static/img/mail/third/line.png" width="632" height="18" /></td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF" style="padding:28px"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td style="font-size:14px;line-height:28px;padding:0px 0px 26px 0px"><span style="color:#f87e01"><b>亲爱的${(perUser.userName)!"${(email)!}"}：</b></span><br />
　　根据你订阅的职位内容，为你推荐以下新鲜出炉的工作岗位，希望有你喜欢的！衷心祝福你：早日找到合适的工作，幸福快乐每一天！</td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td style="font-size:14px;line-height:28px"><span style="color:#f87e01">&ldquo;我&rdquo;来了，请君过目</span>　<span style="font-style: italic">根据订阅条件为你推荐<#if perUser??>（<a href="${person_domain}${editSearcherLink}?et=9102f011" target="_blank" style="color:#0075c7;text-decoration: underline">修改订阅内容</a>）</#if></span></td>
                <td align="right"><a href="${search_domain}${morePosLink}&et=9102f011" target="_blank" style="color:#f87e01;font-size:12px">还有1000+个职位&gt;&gt;</a></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr bgcolor="#f2f2f2" style="color:#888">
                <td style="border-bottom: 1px solid #dadada;font-size:12px;padding:8px">职位名</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">企业名</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">工作地区</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">工作经验</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px;padding-right:12px">学历</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">更新时间</td>
              </tr>
              <#list comPosList as comPos>
              <tr style="color:#343434">
                <td style="border-bottom: 1px solid #dadada;font-size:12px;padding:16px 8px">
					<a href="${search_domain}/jobs/${comPos.posNo?c}?et=9102f011" target="_blank" style="color:#0075c7">
                	<#if comPos.position.posName?trim?length gt 10>
		          		${comPos.position.posName?trim?substring(0, 10) }.
		          	<#else>
		          		${comPos.position.posName?trim}
		          	</#if>
                	</a>
				</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">
					<a href="${search_domain}/corp/${comPos.company.id?c}?et=9102f011" target="_blank" style="color:#343434">
                	<#if comPos.company.comName?trim?length gt 14>
		          		${comPos.company.comName?trim?substring(0, 14) }.
		          	<#else>
		          		${comPos.company.comName?trim}
		          	</#if>
                	</a>
				</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">${comPos.position.workLocationStr}</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">${comPos.position.reqWorkYearStr}</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px">${comPos.position.reqDegreeStr}</td>
                <td style="border-bottom: 1px solid #dadada;font-size:12px;color:#888">${comPos.position.refreshDate?date}</td>
              </tr>
              </#list>
              </table></td>
          </tr>
          <tr>
            <td align="center" style="padding:20px"><a href="${search_domain}${morePosLink}&et=9102f011" target="_blank" style="font-size:16px;font-family:'微软雅黑';color:#f87e01"><b>还有1000+个职位&gt;&gt;</b></a></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
<#--
  手机广告条
<tr>
    <td bgcolor="#3382BD"><a href="http://app.job5156.com" target="_blank"><img src="${visit_domain}/static/img/mail/third/banner.png" width="660" height="130" alt="好工作，尽在手中" border=0 /></a></td>
  </tr>-->
    <tr>
        <td align="center" ><a href="${visit_domain}/?et=9102f011" target="_blank"><img src="${visit_domain}/static/img/mail/weixin.jpg" width="580" height="149" alt="智通人才网微信号" border=0 /></a></td>
    </tr>
  <tr>
    <td align="center" bgcolor="#3382BD" style="padding:16px;font-size:12px;color:#FFF;font-family:Verdana">Copyright 1999-2014 <a href="${visit_domain}?et=9102f011" target="_blank" style="color:#FFF">www.job5156.com</a> 智通人才网 版权所有</td>
  </tr>
</table>