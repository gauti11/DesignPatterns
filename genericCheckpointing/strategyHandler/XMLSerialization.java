package genericCheckpointing.strategyHandler;

import java.lang.reflect.Field;


import genericCheckpointing.fileProcessor.Results;
import genericCheckpointing.util.SerializableObject;

public class XMLSerialization implements SerStrategy {

	private Results resIn;
	
	public XMLSerialization(Results resultIn) {
		resIn = resultIn;
	}


	@Override
	public void processInput(SerializableObject sObject) {
		// TODO Auto-generated method stub
		//System.out.println(sObject);
		Class<? extends SerializableObject> cls = sObject.getClass();
		String newOutput;
		String fieldType;
		Field[] fieldList;
		fieldList = cls.getDeclaredFields();
		//System.out.println("<DPSerialization>");
		resIn.getConcatData().add("<DPSerialization>");
		//System.out.println("\t<complexType xsi:type=\"" + cls.getCanonicalName() + "\">");
		//resIn.writeFile("\t<complexType xsi:type=\"" + cls.getCanonicalName() + "\">");
		resIn.getConcatData().add("\t<complexType xsi:type=\"" + cls.getCanonicalName() + "\">");
		for(Field field: fieldList)
		{
			field.setAccessible(true);
			//System.out.println(field.toString());
			fieldType = field.getType().getTypeName();
			//System.out.println(fieldType);
			try {
				switch(fieldType) {
				case "int":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:int\">" + field.get(sObject) + "</" + field.getName() + ">";
					int x= (int) field.get(sObject);
					if(x<10)
					{
						break;
					}
					//System.out.println(newOutput);
					resIn.getConcatData().add(newOutput);
					break;
				case "float":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:float\">" + field.get(sObject) + "</" + field.getName() + ">";
					float y= (float) field.get(sObject);
					if(y<10)
					{
						break;
					}
					//System.out.println(newOutput);
					resIn.getConcatData().add(newOutput);
					break;
				case "boolean":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:boolean\">" + field.get(sObject) + "</" + field.getName() + ">";
					//System.out.println(newOutput);
					//boolean z = (boolean)field.get(sObject);
					resIn.getConcatData().add(newOutput);
					break;
				case "long":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:long\">" + field.get(sObject) + "</" + field.getName() + ">";
					//System.out.println(newOutput);
					long a= (long) field.get(sObject);
					if(a<10)
					{
						break;
					}
					resIn.getConcatData().add(newOutput);
					break;
				case "java.lang.String":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:string\">" + field.get(sObject) + "</" + field.getName() + ">";
					//System.out.println(newOutput);
					resIn.getConcatData().add(newOutput);
					break;
				case "short":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:short\">" + field.get(sObject) + "</" + field.getName() + ">";
					//System.out.println(newOutput);
					resIn.getConcatData().add(newOutput);
					break;
				case "char":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:char\">" + field.get(sObject) + "</" + field.getName() + ">";
					//System.out.println(newOutput);
					resIn.getConcatData().add(newOutput);
					break;
				case "double":
					newOutput = "\t\t<" + field.getName() + " xsi:type=\"xsd:double\">" + field.get(sObject) + "</" + field.getName() + ">";
					//System.out.println(newOutput);
					double c= (double) field.get(sObject);
					if(c<10)
					{
						break;
					}
					resIn.getConcatData().add(newOutput);
					break;
				default:
					//System.out.println("No FieldType Found");
					break;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//System.out.println("\t</complexType>");
		//System.out.println("</DPSerialization>");
		resIn.getConcatData().add("\t</complexType>");
		resIn.getConcatData().add("</DPSerialization>");
		//resIn.writeFile("SerializeData");
	}
}