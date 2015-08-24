package com.job5156.run.backup;

import org.apache.log4j.Logger;

import com.job5156.common.util.HibernateActionUtil;
import com.job5156.common.util.HibernateBackupActionUtil;
import com.job5156.task.backup.BackComReceive;
import com.job5156.task.backup.BackPerInviteLog;
import com.job5156.task.backup.BackPerPosApply;
import com.job5156.task.backup.BackPerViewLog;
import com.job5156.task.backup.BackSiteMessage;

/**
 * <p>备份清理5156Action库数据</p>
 *
 * Date:2015-5-30 上午9:44:55
 * @author leo
 * @version 1.0
 */
public class RunBackupActionData {
	private static Logger logger = Logger.getLogger(RunBackupActionData.class);

	public static void main(String[] args) {
		//-备份及清理5156action库com_receive表，保留近1年数据
		try{
			BackComReceive backComReceive = new BackComReceive();
			//backComReceive.setDeleteSourceFlag(true);
			backComReceive.run();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("备份清理com_receive异常：" + e.getMessage());
		}
		
		//-备份及清理5156action库per_invite_log表，保留近半年数据
		try{
			BackPerInviteLog backPerInviteLog = new BackPerInviteLog();
			//backPerInviteLog.setDeleteSourceFlag(true);
			backPerInviteLog.run();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("备份清理per_invite_log异常：" + e.getMessage());
		}
		
		//-备份及清理5156action库per_pos_apply表，保留近半年数据
		try{
			BackPerPosApply backPerPosApply = new BackPerPosApply();
			//backPerPosApply.setDeleteSourceFlag(true);
			backPerPosApply.run();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("备份清理per_pos_apply异常：" + e.getMessage());
		}
		
		//-备份及清理5156action库per_view_log表，保留近半年数据
		try{
			BackPerViewLog backPerViewLog = new BackPerViewLog();
			//backPerViewLog.setDeleteSourceFlag(true);
			backPerViewLog.run();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("备份清理per_view_log异常：" + e.getMessage());
		}
		
		//-备份及清理5156action库site_message表，保留近半年数据
		try{
			BackSiteMessage backSiteMessage = new BackSiteMessage();
			//backSiteMessage.setDeleteSourceFlag(true);
			backSiteMessage.run();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("备份清理site_message异常：" + e.getMessage());
		}
		
		HibernateActionUtil.closeSession();
		HibernateBackupActionUtil.closeSession();
	}

}
