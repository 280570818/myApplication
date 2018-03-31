package swing.test;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class MapperCoder {
	String className = "swing.ywl.info.model.Info";
	String[] columns = null;
	String[] fields = null;
	String[] types = null;
	String tableName = null;
	
	@Test
	public void getResultMap() {
		for (int i = 0; i < columns.length; i++) {
			System.out.println("<result property=\""+fields[i]+"\" column=\""+columns[i]+"\"/>");
		}
	}
	@Test
	public void getUpdate() {
		for (int i = 0; i < columns.length; i++) {
			System.out.println("<if test=\""+fields[i]+" != null\">"+columns[i]+"=#{"+fields[i]+"},</if>");
		}
	}
	
	@Test
	public void getInsertSql(){
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
		for (int i = 0; i < columns.length; i++) {
			sql.append(columns[i]).append(",");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(") VALUES (");
		for (int i = 0; i < fields.length; i++) {
			sql.append("#{").append(fields[i]).append("},");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(")");
		System.out.println(sql);
	}
	
	@Test
	public void getCreateSql(){
		StringBuilder sql = new StringBuilder("CREATE TABLE ").append(tableName).append(" (");
		for (int i = 0; i < columns.length; i++) {
			sql.append(columns[i]);
			if("String".equals(types[i])){
				sql.append(" VARCHAR(20)");
			}else if("Long".equals(types[i])){
				sql.append(" bigint(20)");
			}else if("Date".equals(types[i])){
				sql.append(" datetime");
			}else if("Integer".equals(types[i])){
				sql.append(" int(11)");
			}
			sql.append(" DEFAULT NULL,");
		}
		sql.append("KEY ID (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
		System.out.println(sql);
	}
	
	@Before
	public void before() throws ClassNotFoundException{
		Class<?> clas = Class.forName(className);
		Field[] f = clas.getDeclaredFields();
		String[] fieldArr = new String[f.length];
		String[] columnArr = new String[f.length];
		String[] typeArr = new String[f.length];
		String tmp = null;
		StringBuilder column = null;
		for (int i = 0; i < columnArr.length; i++) {
			column = new StringBuilder();
			tmp = f[i].getName();
			typeArr[i] = f[i].getType().toString();
			typeArr[i] = typeArr[i].substring(typeArr[i].lastIndexOf(".")+1, typeArr[i].length());
			String[] split = tmp.split("");
			for (String s : split) {
				if(s.toUpperCase().equals(s)){
					column.append("_");
				}
				column.append(s.toUpperCase());
			}
			fieldArr[i] = tmp;
			columnArr[i] = column.toString();
		}
		columns = columnArr;
		fields = fieldArr;
		types = typeArr;
		tableName = clas.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".")+1, tableName.length()).toUpperCase();
	}
}
