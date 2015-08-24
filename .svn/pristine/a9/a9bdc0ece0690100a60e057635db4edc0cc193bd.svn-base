<meta charset="utf-8" />
<div align="center">
    <div style="width:620px;height:580px;background:#fff; margin:0 auto;">
        <div style="height:60px;background:#f48000;position:relative;">
            <div style="width:274px;height:39px; position:absolute; top:10px;left:30px;"><img src="${image_domain}/static/img/mail/logo2.png" alt=""></div>
            <div style="width:230px;height:20px; position:absolute; top:20px; right:20px;font-size:12px; color:#fff;">
                <span>若不希望再收到此类邮件，可点击<a href="${visit_domain}${unsubscribeLink}" style="width:40px;height:20px;color:#fff;line-height:20px; text-align:center; display:inline-block; background:#2483dc;margin-left:5px;">退订</a></span>
            </div>
        </div>
        <p style="color:#5b5b5b; font-size:14px; line-height:25px; padding-left:40px; padding-top:20px; text-align:left";>尊敬的<span style="color:#f48000; margin:0 8px">${comInfo.comName}HR</span>，您好！<br>根据您在<span style="color:#f48000;  margin:0 8px">智通人才网</span>发布的职位，匹配到以下简历，希望对您的招聘工作有帮助！
        </p>
        <div style="width:620px;height:450px;background:#f0f0f0; padding-top:15px; text-align:center;">
            <div style="padding:10px;width:540px;height:350px;background:#fff;margin:0 auto;text-align:center;">
                <table style="width:100%;height:100%;border-collapse:collapse;">
                    <tbody>
                    <tr style="overflow:hidden;">
                        <td colspan="7" style="overflow:hidden;padding-bottom:15px;"><span style="float:left;display:block; width:7px; height:17px; background:#f48000;margin-right:5px;"></span><span style="float:left;font-size:16px; font-weight:bold">职位：<span style="color:#f48000;">${comPosition.posName}</span></span></td>
                    </tr>
                    <tr style=" background:#fff5e8;">
                        <td style="padding:10px 8px;text-align:center">姓名</td>
                        <td style="padding:10px 8px;text-align:center">年龄</td>
                        <td style="padding:10px 8px;text-align:center">性别</td>
                        <td style="padding:10px 8px;text-align:center">工作经验</td>
                        <td style="padding:10px 8px;text-align:center">学历</td>
                        <td style="padding:10px 8px;text-align:center">现所在地</td>
                        <td style="padding:10px 8px;text-align:center">专业</td>
                    </tr>
                    <#list userList as perResume>
	                    <tr style="border-bottom:1px solid #f0f0f0;">
	                        <td style="padding:10px 8px;text-align:center"><a href="${search_domain}/resume/view/${perResume.id?c}?et=9c026512" style="color:#2483dc;">${perResume.basicInfoVo.userName}</a></td>
	                        <td style="padding:10px 8px;text-align:center">${perResume.basicInfoVo.ageStr}</td>
	                        <td style="padding:10px 8px;text-align:center">${perResume.basicInfoVo.ganderStr}</td>
	                        <td style="padding:10px 8px;text-align:center">${perResume.basicInfoVo.jobYear}</td>
	                        <td style="padding:10px 8px;text-align:center">${perResume.maxDegree.degreeStr}</td>
	                        <td style="padding:10px 8px;text-align:center">${perResume.basicInfoVo.locationStr}</td>
	                        <td style="padding:10px 8px;text-align:center">
	                        	<#if perResume.maxDegree.speciality?length lt 8>
	                        		${perResume.maxDegree.speciality}
	                        	<#else>
	                        		${perResume.maxDegree.speciality[0..7]}..
	                        	</#if>
	                        </td>
	                    </tr>
                    </#list>
                    <tr style="text-align:right;">
                        <td colspan="7" style="padding-top:10px;">
                            <a href="${search_domain}${moreResLink}" style="color:#f48000; margin-right:12px;">查看更多推荐</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <span style="line-height:70px;">Copyright©1999-2015 job5156.com 版权所有</span>
        </div>
    </div>
</div>