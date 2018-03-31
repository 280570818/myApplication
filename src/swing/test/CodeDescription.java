package swing.test;

import org.junit.Test;

public class CodeDescription {
	String[] infoColumns = {"ID","COLUMNNAME","COLUMNDESC"};
	String[] infoFields = {"id","columnName","columnDesc"};
	@Test
	public void test() {
		for (int i = 0; i < infoColumns.length; i++) {
			System.out.println("<result property=\""+infoFields[i]+"\" column=\""+infoColumns[i]+"\"/>");
		}
	}
	@Test
	public void test2() {
		for (int i = 0; i < infoColumns.length; i++) {
			System.out.println("<if test=\""+infoFields[i]+" != null\">"+infoColumns[i]+"="+infoFields[i]+",</if>");
		}
	}

}
