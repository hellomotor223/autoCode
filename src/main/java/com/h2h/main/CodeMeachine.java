package com.h2h.main;

import com.h2h.tool.data.DataService;
import com.h2h.tool.data.DataServiceImpl;
import com.h2h.tool.freeMaker.FreeMakerUtil;
import com.h2h.tool.util.ConvertUtil;

import java.sql.SQLException;
import java.util.Map;

public class CodeMeachine {
	
	//默认生成文件的路径
	private static String generatePath = "D:\\";
	private static String packageName = "com.ddbes";
	
	private static FreeMakerUtil freeMakerUtil = new FreeMakerUtil();
	private static DataService dataService = new DataServiceImpl();
	
	/**生成VO文件
	 * @param tableName
	 * @param packageName
	 * @param classPre
	 * @throws SQLException 
	 */
	public static void generateVoFile(String tableName,String packageName,String classPre,String fileName) throws SQLException{
		generateFileWithDb("voModel.ftl", tableName, packageName, classPre,fileName);
	}
	
	/**生成Dao文件
	 * @param tableName
	 * @param packageName
	 * @param classPre
	 */
	public static void generateDaoFile(String tableName,String packageName,String classPre,String fileName){
		generateFileWithOutDb("daoModel.ftl", tableName, packageName, classPre,fileName);
	}
	
	/**根据不同模板生成文件
	 * （无需操作数据库，没有列数据）
	 * @param templateName
	 * @param tableName
	 * @param packageName
	 * @param classPre
	 */
	public static void generateFileWithOutDb(String templateName,String tableName,String packageName,String classPre,String fileName){
		Map<String, Object> templateData = dataService.getTemplateDataWithOutDb(tableName, packageName, classPre);
		freeMakerUtil.generateFile(templateName, templateData, generatePath+fileName);
	}
	
	/**根据不同模板生成文件
	 * （包含列数据）
	 * @param templateName
	 * @param tableName
	 * @param packageName
	 * @param classPre
	 * @throws SQLException 
	 */
	public static void generateFileWithDb(String templateName,String tableName,String packageName,String classPre,String fileName) throws SQLException{
		Map<String, Object> templateData = dataService.getDbTemplateData(tableName, packageName, classPre);
		freeMakerUtil.generateFile(templateName, templateData, generatePath+fileName);
	}
	
	/**
	 * 
	 * @param templateName
	 * @param map
	 * @param fileNameSuffix
	 * @param i entity 传入1 
	 * 			repository 下传入2
	 * 			service 传入3
	 * 			serviceImpl 传入 4
	 * 			controller 传入 5
	 * @throws SQLException
	 */
	public static void generateFileWithDb(String templateName,Map map,String fileNameSuffix,int i) throws SQLException{
		String tableName = map.get("tableName").toString();
		String comment = map.get("comment").toString();
		String className = ConvertUtil.getClassName(tableName);
		
		Map<String, Object> templateData = dataService.getDbTemplateData(tableName, packageName, className);
		templateData.put("comment", comment);
		String fileNamePrefix = ConvertUtil.formatAaa(className.replaceAll("Ddbes", ""));
		if(fileNameSuffix.endsWith(".jsp")){
			fileNamePrefix = "j" + fileNamePrefix;		//如果是jsp文件按 jModelList.jsp命名规则
		}
		
		switch(i){
			case 1 :
				generatePath=generatePath.substring(0,27)+"/entity/";
				break;
			case 2 :
				generatePath=generatePath.substring(0,27)+"/repository/";
				break;
			case 3 :
				generatePath=generatePath.substring(0,27)+"/service/";
				break;
			case 4 :
				generatePath=generatePath.substring(0,27)+"/service/impl/";
				break;
			case 5 :
				generatePath=generatePath.substring(0,27)+"/controller/";
				break;
			default:
				break;
		}
		freeMakerUtil.generateFile(templateName, templateData, generatePath+fileNamePrefix+fileNameSuffix);
	}
	
	/**
	 *设置文件生成目录
	 * @param generatePath
	 */
	public static void setGeneratePath(String generatePath) {
		CodeMeachine.generatePath = generatePath;
	}
	
	//设置包路径
	public static void setPackageName(String packageName) {
		CodeMeachine.packageName = packageName;
	}
	
	public static void replaceAll(){
		generatePath.substring(0,27);
	}

}
