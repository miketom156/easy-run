<meta charset="utf-8" />
<style>
a{
	text-decoration: none;
}
a:hover{
	text-decoration: underline;
}
</style>
<table bgcolor="#2f7bb3" width="660" style="padding:0 14px;" border="0" align="center" cellpadding="0" cellspacing="0">
    <!--top begin-->
    <tr>
        <td height="15"></td>
    </tr>
    <tr>
        <td align="right" height="30" style="color:#fff;font-size:12px;">此邮件来自<a href="http://www.job5156.com?et=9f025812" target="_blank" style="color:#fff; font-size:12px; text-decoration:underline">智通人才网</a>&nbsp;若不希望再收到此类邮件<a href="${visit_domain}${unsubscribeLink}" target="_blank" style="color:#f87e01">点此退订</a></td>
    </tr>
    <tr>
        <td align="left" style="padding-left: 10px;" valign="middle" bgcolor="#FFFFFF" height="72"><a href="http://www.job5156.com" target="_blank"><img src="${visit_domain}/static/img/mail/third/logo.png" width="273" height="45"></a></td>
    </tr>
    <tr>
        <td bgcolor="#2F7BB3" height="5"></td>
    </tr>
    <!--top end-->
    <!--content begin-->
    <tr>
        <td bgcolor="#ffffff">
            <div style="padding:17px; font-size:14px; line-height:14px;">
                <p><strong style="font-size:16px;color:#ff6600;">亲爱的${perUser.userName?default(perUser.account)}：</strong></p>
                <p style="text-indent:2em;font-size:14px; line-height:30px;">最近工作顺利吗？<#if dateInterval gt 1>我们注意到你已经有<span style="color:#f87e01">${dateInterval}天</span>没有登录人才网了，</#if>智通人才网最近一周发布了数十万的新职位，相信总有适合你的。</p>
                <p align="right"><a href="${search_domain}${morePosLink}&et=8a02ca11" target="_blank" style="color:#f87e01;font-size:12px">还有1000+个职位&gt;&gt;</a></p>
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
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
                                <a href="${search_domain}/jobs/${comPos.posNo?c}?et=8a02ca11" target="_blank" style="color:#0075c7">
                                    <#if comPos.position.posName?trim?length gt 10>
                                    ${comPos.position.posName?trim?substring(0, 10) }.
                                    <#else>
                                    ${comPos.position.posName?trim}
                                    </#if>
                                </a>
                            </td>
                            <td style="border-bottom: 1px solid #dadada;font-size:12px">
                                <a href="${search_domain}/corp/${comPos.company.id?c}?et=8a02ca11" target="_blank" style="color:#343434">
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
                    <tr><td colspan="6" bgcolor="#dadada" height="1"></td></tr>
                </table>
                <p align="center" style="padding:20px 0 50px 0;"><strong><a href="${search_domain}${morePosLink}&et=8a02ca11" target="_blank" style="color:#f87e01;font-size:12px">还有1000+个职位&gt;&gt;</a></strong></p>
            </div>
        </td>
    </tr>
    <!--content end-->
    <!--footer begin-->
<#--    <tr>
        <td background="${visit_domain}/static/img/mail/third/footer_bg.png" height="110" align="center" valign="top"><a href="http://app.job5156.com/?et=9f025812" target="_blank"><img src="${visit_domain}/static/img/mail/third/banner_2.png" width="599" height="99"></a></td>
    </tr>-->
    <td style="BACKGROUND: #FFFFFF;height: 150"  align="center" ><a href="http://app.job5156.com/weixin_service.html?et=8a02ca11" target="_blank"><img src="${visit_domain}/static/img/mail/weixin.jpg" width="580" height="149" alt="智通人才网微信号" border=0 /></a></td>
    <tr>
        <td height="70" align="center" style="color:#fff;">Copyright 1999-2014 job5156.com 智通人才网 版权所有</td>
    </tr>
    <!--footer end-->
</table>