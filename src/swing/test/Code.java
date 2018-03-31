package swing.test;

import org.junit.Test;

public class Code {
	String[] infoColumns = {"field_string1","field_string2","field_string3","field_string4","field_string5","field_string6","field_string7","field_string8","field_string9","field_string10","field_string11","field_string12","field_string13","field_string14","field_string15","field_string16","field_string17","field_string18","field_string19","field_string20","field_string21","field_string22","field_int1","field_int2","field_int3","field_int4","field_int5","field_int6","field_int7","field_int8","field_int9","field_date1","field_date2","field_date3","field_date4","field_date5","field_date6","field_date7","field_date8","field_date9","field_date10"};
	String[] infoFields = {"fieldStr1","fieldStr2","fieldStr3","fieldStr4","fieldStr5","fieldStr6","fieldStr7","fieldStr8","fieldStr9","fieldStr10","fieldStr11","fieldStr12","fieldStr13","fieldStr14","fieldStr15","fieldStr16","fieldStr17","fieldStr18","fieldStr19","fieldStr20","fieldStr21","fieldStr22","fieldInt1","fieldInt2","fieldInt3","fieldInt4","fieldInt5","fieldInt6","fieldInt7","fieldInt8","fieldInt9","fieldDate1","fieldDate2","fieldDate3","fieldDate4","fieldDate5","fieldDate6","fieldDate7","fieldDate8","fieldDate9","fieldDate10"};
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

	@Test
	public void generate(){
//		Field[] fields = Info.class.getDeclaredFields();
//		for (Field field : fields) {
//			System.out.println(field.getName());
//		}
	}
}
