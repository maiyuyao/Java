package com.demo.service;

import java.util.List;
import java.util.Random;

import com.demo.bean.Command;
import com.demo.bean.CommandContent;
import com.demo.bean.Message;
import com.demo.dao.CommandDao;
import com.demo.dao.MessageDao;
import com.demo.util.Iconst;

public class QueryService {
    //后台页面维护信息
	public List<Message> queryMessageList(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}

	//前台交互信息
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> CommandList;
        //显示帮助页面
		if (Iconst.HELP_COMMAND.equals(command)) {
			CommandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < CommandList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + CommandList.get(i).getName() + "]可以查看"
						+ CommandList.get(i).getDescription());
			}
			return result.toString();
		}

		CommandList = commandDao.queryCommandList(command, null);
		if (CommandList.size() > 0) {
			List<CommandContent> contentList = CommandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
