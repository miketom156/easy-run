<meta charset="utf-8" />
<table width="580" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td style="padding:8px 0px"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="273"><a href="${visit_domain}?et=9c020f12" target="_blank"><img src="${visit_domain}/static/img/mail/third/logo.png" width="273" height="45" alt="智通人才网" /></a></td>
        <td align="right" style="font-size:12px;line-height:21px;color:#8c8b8b">此邮件来自<a href="${visit_domain}?et=9c020f12" target="_blank" style="color:#0075c7">智通人才网</a><br />
          若不希望再收到此类邮件<a href="${visit_domain}${unsubscribeLink}" target="_blank" style="color:#0075c7">点此退订</a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td style="padding:13px 0px 13px 2px"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="550" style="font-size:12px;line-height:24px;color:#000019">亲爱的${comUser.username}：<br />
          　　根据您订阅的简历内容，为您推荐以下新鲜出炉的人才简历，希望有您喜欢的！</td>
        <td width="131"><a href="${company_domain}${editSearcherLink}&et=9c020f12" target="_blank"><img src="${visit_domain}/static/img/mail/third/tiaojian.png" alt="重新设置订阅条件" width="131" height="38" border=0 /></a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td style="padding:0px 0px 14px 0px"><table width="100%" border="0" cellspacing="0" cellpadding="6" style="color:#000019;font-size:12px;line-height:21px">
      <tr bgcolor="#aaaaaa" style="color:#FFF;font-weight: bold;line-height:14px">
        <td>姓名</td>
        <td>性别|年龄|学历|经验</td>
        <td>专业</td>
        <td>期望地区</td>
      </tr>
      <#list perResumeVoList as perResume>
      <tr>
        <td style="border-bottom: 1px dashed #c8c8c8;font-size:12px"><a href="${visit_domain}/resume/view/${perResume.id?c}?et=9c020f12" target="_blank" style="color:#000019;text-decoration: underline;">${perResume.basicInfoVo.userName}</a></td>
        <td style="border-bottom: 1px dashed #c8c8c8;font-size:12px">${perResume.basicInfoVo.ganderStr}|${perResume.basicInfoVo.ageStr}岁|${perResume.maxDegree.degreeStr}|${perResume.basicInfoVo.jobYear}</td>
        <td style="border-bottom: 1px dashed #c8c8c8;font-size:12px">${perResume.maxDegree.speciality}</td>
        <td style="border-bottom: 1px dashed #c8c8c8;font-size:12px">${perResume.intentInfoVo.jobLocationStr} </td>
      </tr>
      </#list>
    </table></td>
  </tr>
  <tr>
    <td height="39" align="center" bgcolor="#1881bd" style="font-size:12px;color:#FFF"><b>&gt;&gt; <a href="${search_domain}${moreResumeLink}?et=9c020f12" target="_blank" style="color:#FFF">还有500+个简历</a></b></td>
  </tr>
  <tr>
    <td align="center" style="padding:16px;color:#a9a9a9;font-size:12px;font-family:Verdana">Copyright 1999-2014 <a href="${visit_domain}?et=9c020f12" target="_blank" style="color:#a9a9a9">www.job5156.com</a> 智通人才网 版权所有</td>
  </tr>
</table>
