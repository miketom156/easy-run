<meta charset="utf-8" />
<style>
a{
	text-decoration: none;
}
a:hover{
	text-decoration: underline;
}
</style>
<table width="650" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td style="padding:8px"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="273"><a href="${visit_domain}?et=99020f12" target="_blank"><img src="${visit_domain}/static/img/mail/third/logo.png" width="273" height="45" alt="智通人才网" border=0 /></a></td>
        <td align="right" style="font-size:12px;line-height:21px;color:#8c8b8b">此邮件来自<a href="${visit_domain}?et=99020f12" target="_blank" style="color:#0075c7;text-decoration: underline">智通人才网</a><br />
          若不希望再收到此类邮件<a href="${visit_domain}${unsubscribeLink}" target="_blank" style="color:#0075c7;text-decoration: underline">点此退订</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td background="${visit_domain}/static/img/mail/third/di_2.png" style="border-top: 3px solid #0076c7;padding:17px"><table width="100%" border="0" cellspacing="0" cellpadding="5">
      <tr>
        <td style="font-size:14px;line-height:28px"><span style="color:#f87e01"><b>亲爱的${perUser.userName?default(perUser.account)}：</b></span><br />
          　　今天有${comNum}家企业查看了你的简历或联系方式：</td>
      </tr>
      <tr>
        <td align="right"><a href="${visit_domain}${lookMoreComLink}&et=99020f12" target="_blank" style="color:#f87e01;font-size:12px">查看更多求职动态&gt;&gt;</a></td>
      </tr>
      <tr>
        <td><div style="border:2px solid #dfdfdf"><table width="100%" border="0" cellspacing="0" cellpadding="12" bgcolor="#FFFFFF">
          <tr style="color:#8b8b8b">
            <td style="border-bottom: 1px solid #eee;font-size:12px">企业名</td>
            <td style="border-bottom: 1px solid #eee;font-size:12px">是否查看联系方式</td>
          </tr>
          <#list viewLogList as vLogList>
	          <tr style="color:#343434">
	            <td style="border-bottom: 1px dashed #eee;font-size:12px"><a href="${visit_domain}/corp/${vLogList.comId?c}?et=99020f12" target="_blank" style="color:#0075c7">${vLogList.comName}</a></td>
	            <td style="border-bottom: 1px dashed #eee;font-size:12px">
					<#if vLogList.lookStatus == 0>
		          		未查看
		          	<#else>
		          		已查看
		          	</#if>
				</td>
	          </tr>
          </#list>
          </table>
        </div></td>
      </tr>
      <tr>
        <td align="center" style="padding:20px"><a href="${visit_domain}${whoLookMeResumeLink}&et=99020f12" target="_blank" style="color:#0075c7;font-size:14px;text-decoration: underline"><b>查看所有&ldquo;谁看过我的简历&rdquo;&gt;&gt;</b></a></td>
      </tr>
      <tr>
        <td style="padding:18px;font-size:16px;font-family:'微软雅黑';color:#343434">找到好工作的<span style="font-size:22px;color:#f87e01">3</span>个秘密！！</td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="70" style="padding:12px"><img src="${visit_domain}/static/img/mail/third/mm_01.png" width="70" height="70" alt="更新"></td>
            <td style="line-height:24px;font-size:14px"><span style="color:#0075c7"><b>保持你的简历每天新鲜欲滴，HR是喜欢新简历呢还是新简历呢？</b></span><br>
              简历更新日期影响在简历库中排序，<br>
              是否明白了HR容易找到最近更新的简历来面试呢？</td>
          </tr>
          <tr>
            <td style="padding:12px"><img src="${visit_domain}/static/img/mail/third/mm_02.png" width="70" height="70" alt="投递"></td>
            <td style="line-height:24px;font-size:14px"><span style="color:#0075c7"><b>数据显示：申请职位越多，面试机会越大。</b></span><br>
              &ldquo;砖家&rdquo;建议：平均每天申请10个以上职位</td>
            </tr>
          <tr>
            <td style="padding:12px"><img src="${visit_domain}/static/img/mail/third/mm_03.png" width="70" height="70" alt="完整"></td>
            <td style="line-height:24px;font-size:14px"><span style="color:#0075c7"><b>HR更亲睐完整度高的简历</b></span><br>
              完整度越高的简历，在简历库中排序越靠前，HR很容易搜到！</td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
<#-- 手机广告条
  <tr>
    <td><a href="http://app.job5156.com?et=99020f12" target="_blank"><img src="${visit_domain}/static/img/mail/third/banner_2.png" width="650" height="107" alt="好工作，尽在手中" border=0 /></a></td>
  </tr>-->
    <tr>
        <td align="center" ><a href="http://app.job5156.com/weixin_service.html?et=99020f12" target="_blank"><img src="${visit_domain}/static/img/mail/weixin.jpg" width="580" height="149" alt="智通人才网微信号" border=0 /></a></td>
    </tr>
  <tr>
    <td align="center" style="padding:16px;color:#a9a9a9;font-size:12px;font-family:Verdana">Copyright 1999-2014 <a href="${visit_domain}?et=99020f12" target="_blank" style="color:#a9a9a9">job5156.com</a> 智通人才网 版权所有</td>
  </tr>
</table>