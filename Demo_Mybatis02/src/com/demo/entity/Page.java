package com.demo.entity;

/**
 * 分页对应的实体类
 */
public class Page {
	private int totalNumber; // 总条数
	private int currentPage;// 当前第几页
	private int totalPage;// 总页数
	private int pageNumber = 5;// 每页显示条数
	private int mysqlIndex;// Mysql中limit的参数，从第几条开始取
	private int mysqlNumber;// Mysql中limit的参数，一共取多少条
	private int oracleStart;// Oracle中limit的参数，从第几条开始取
	private int oracleEnd;// Oracle中limit的参数，一共取多少条

	// 根据当前对象中属性值计算并设置相关属性值
	public void count() {
		// 计算总页数
		int totalPageTemp = this.totalNumber / this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;

		// 设置当前页数
		// 总页数小于当前页数，应将当前页数设置为总页数
		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		// 当前页数小于1设置为1
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}

		// Mysql limit 语法: LIMIT [offset,] rows
		this.mysqlIndex = (this.currentPage - 1) * this.pageNumber;
		this.mysqlNumber = this.pageNumber;

		// Oracle ROWNUM语法: ...ROWNUM <= 10 ) AND ROWNUM > 1
		this.oracleStart = (this.currentPage - 1) * this.pageNumber + 1;
		this.oracleEnd = this.currentPage * this.pageNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		// 当调用setTotalNumber，自动调用count()方法，计算总页数
		this.count();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		this.count();
	}

	public int getMysqlIndex() {
		return mysqlIndex;
	}

	public void setMysqlIndex(int mysqlIndex) {
		this.mysqlIndex = mysqlIndex;
	}

	public int getMysqlNumber() {
		return mysqlNumber;
	}

	public void setMysqlNumber(int mysqlNumber) {
		this.mysqlNumber = mysqlNumber;
	}

	public int getOracleStart() {
		return oracleStart;
	}

	public void setOracleStart(int oracleStart) {
		this.oracleStart = oracleStart;
	}

	public int getOracleEnd() {
		return oracleEnd;
	}

	public void setOracleEnd(int oracleEnd) {
		this.oracleEnd = oracleEnd;
	}

 

}
