package com.h2h.main;

import com.h2h.tool.db.DbService;
import com.h2h.tool.db.DbServiceImpl;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class RunEntrance {
	
	static String GENERATEPATH = "生成路径";
	
	static String PACKAGENAME = "Base包名";
	
	public static void main(String[] args) throws SQLException {
//		String tableName = "DDBES_COMPANY_POSITION";
		//扩展  查询到所有表名，然后一个个处理
		DbService dbService = new DbServiceImpl();
		String generatepath = GENERATEPATH+"/"+PACKAGENAME.replaceAll("[.{1}]","/");
		initDirs(generatepath);
		
		CodeMeachine.setGeneratePath(generatepath+"/");
		CodeMeachine.setPackageName(PACKAGENAME);
		
		List<Map> allTablenames = dbService.getAllTablenames();
		for (Map map : allTablenames) {
			CodeMeachine.generateFileWithDb("poModel.ftl", map, ".java",1);
			CodeMeachine.generateFileWithDb("repository.ftl", map, "Repository.java",2);
			CodeMeachine.generateFileWithDb("IService.ftl", map, "Service.java",3);
			CodeMeachine.generateFileWithDb("ServiceImpl.ftl", map, "ServiceImpl.java",4);
		}
		
		
		//CodeMeachine.generateFileWithDb("demo.ftl", tableName, "Demo.java");
//		CodeMeachine.generateFileWithDb("config.ftl", tableName, "Config.txt");
		
//		CodeMeachine.generateFileWithDb("mapper.hbm.ftl", tableName, ".hbm.xml");
//		CodeMeachine.generateFileWithDb("ServiceInterface.ftl", tableName, "Service.java");
//		CodeMeachine.generateFileWithDb("ServiceImpl.ftl", tableName, "ServiceImpl.java");
//		CodeMeachine.generateFileWithDb("Action.ftl", tableName, "Action.java");
		
	
//		CodeMeachine.generateFileWithDb("jDeptListPage.jsp", tableName, "ListPage.jsp");
		//CodeMeachine.generateFileWithDb("jRole.jsp", tableName, "List.jsp");
//		CodeMeachine.generateFileWithDb("jDeptCreate.jsp", tableName, "Create.jsp");
//		CodeMeachine.generateFileWithDb("jDeptUpdate.jsp", tableName, "Update.jsp");
//		CodeMeachine.generateFileWithDb("jDeptView.jsp", tableName, "View.jsp");
		
		
		
		System.out.println("Generate success.");
	}

	private static void initDirs(String generatepath) {
		List<File> files = new ArrayList<File>();
		File f = new File(generatepath);
		File entity = new File(generatepath+"/entity");
		File repository = new File(generatepath+"/repository");
		File service = new File(generatepath+"/service");
		File serviceImpl = new File(generatepath+"/service/impl");
		File controller = new File(generatepath+"/controller");
		files.add(f);
		files.add(entity);
		files.add(service);
		files.add(repository);
		files.add(serviceImpl);
		files.add(controller);
		mkDir(files);
	}
	
	public static void mkDir(List<File> files){
		for (File file : files) {
			if(!file.exists()){
				file.mkdirs();
			}
		}
	}
	
}
