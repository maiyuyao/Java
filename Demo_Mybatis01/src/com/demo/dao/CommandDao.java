package com.demo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.demo.bean.Command;
import com.demo.db.DBAccess;

public class CommandDao {
	
	public List<Command> queryCommandList(String name, String description) {

		DBAccess dbAccess = new DBAccess();
		List<Command> comandlist = new ArrayList<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			// 执行 sqlSession的SQL语句
			comandlist = sqlSession.selectList("Command.queryCommandList",command);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return comandlist;
	}
	

}
