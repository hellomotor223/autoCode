package com.h2h.tool.db;

import com.h2h.model.FieldBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DbService {
	
	/**根据表名获取所有的列信息
	 * @param tableName
	 * @return
	 */
	public List<FieldBean> getAllColums(String tableName);
	public List<FieldBean> getAllColums(String tableName, String Owner, String dataBase) throws SQLException;
	public List<Map> getAllTablenames();
}
