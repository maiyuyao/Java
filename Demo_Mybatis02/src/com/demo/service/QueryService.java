package com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.demo.bean.Command;
import com.demo.bean.CommandContent;
import com.demo.bean.Message;
import com.demo.dao.CommandDao;
import com.demo.dao.MessageDao;
import com.demo.entity.Page;
import com.demo.util.Iconst;

/**
 * 查询相关的业务功能
 */
public class QueryService {

	/**
	 * 简单分页查询功能
	 */
	public List<Message> queryMessageList(String command, String description, Page page) {
		// 组织消息对象
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		MessageDao messageDao = new MessageDao();
		// 根据条件查询条数
		int totalNumber = messageDao.count(message);
		// 组织分页查询参数
		page.setTotalNumber(totalNumber);
		// 因为SQL配置的XML，parameterType输入参数只能接收一个参数，把message，page两个参数放入map中。
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("message", message);
		parameter.put("page", page);
		// 分页查询并返回结果
		return messageDao.queryMessageList(parameter);
	}

	/**
	 * 拦截器查询分页查询功能，具体分页的功能在拦截器中实现
	 */
	public List<Message> queryMessageListByPage(String command, String description, Page page) {
		// 因为SQL配置的XML，parameterType输入参数只能接收一个参数，把message，page两个参数放入map中。
		Map<String, Object> parameter = new HashMap<String, Object>();
		// 组织消息对象
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		// 后续DAO层查询的参数
		parameter.put("message", message);
		parameter.put("page", page);
		MessageDao messageDao = new MessageDao();
		// 分页查询并返回结果
		return messageDao.queryMessageListByPage(parameter);
	}

	/**
	 * 通过指令查询自动回复的内容
	 */
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		if (Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < commandList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看"
						+ commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);
		if (commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
