<meta charset="utf-8" />
${salerName}您好：<br/>
		&nbsp;&nbsp;您的以下客户有一周内收到的简历少于2份的职位，请关注跟进：<br/>
		<table>
			<tr>
			 <th>企业名称</th><th></th><th>职位</th>
			</tr>
		<#list receiveLogList?sort_by(["comId"]) as receiveLog>
			<tr>
				<td>${receiveLog.comName}[公司ID:${receiveLog.comId?c}]</td>
				<td></td>
				<td>${receiveLog.posName}</td>
			</tr>
		</#list>
		</table>