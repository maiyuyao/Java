package com.demo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.demo.bean.Message;
import com.demo.db.DBAccess;

public class MessageDao {

	public List<Message> queryMessageList(String command, String description) {

		DBAccess dbAccess = new DBAccess();
		List<Message> messagelist = new ArrayList<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			// 执行 sqlSession的SQL语句
			messagelist = sqlSession.selectList("Message.queryMessageList", message);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messagelist;
	}

    //单条删除
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行 sqlSession的SQL语句
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

    //批量删除
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行 sqlSession的SQL语句
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
