package genericCheckpointing.strategyHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.fileProcessor.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class XMLDeserialization implements DeserStrategy {

	private FileProcessor fpIn;

	public XMLDeserialization(FileProcessor fileProcessor) {
		// TODO Auto-generated constructor stub
		fpIn = fileProcessor;
	}

	@Override
	public SerializableObject processInput() {
		// TODO Auto-generated method stub
		String line;
		String fieldName;
		String fieldType;
		String fieldValue;
		Object obj = null;
		Class<?> cls = null;
		// Class<? extends SerializableObject> cls = sObject.getClass();
		while ((line = fpIn.readLine()) != null) {
			//System.out.println(line);
			line = line.trim();
			if (line.trim().contains("<DPSerialization>") || line.trim().contains("</DPSerialization>")) {
				continue;
			} else if (line.contains("<complexType ")) {
				String[] myStrings = line.split("\"");
				try {
					cls = Class.forName(myStrings[1]);
					// System.out.println(Class.forName(myStrings[1]));
					Constructor<?> constructor = cls.getConstructor();
					obj = constructor.newInstance();
					// System.out.println(obj.toString());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (line.contains("</complexType>")) {
				break;
			} else {
				fieldName = line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);
				//System.out.println(fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));
				fieldType = line.substring(line.lastIndexOf(':') + 1, line.lastIndexOf('"'));
				fieldValue = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));
				//System.out.println(fieldValue);
				Method methodInt = null;
				// Method methodInteger = null;
				// System.out.println(fieldType);

				try {
					switch (fieldType) {
					case "int":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), Integer.TYPE);
						methodInt.invoke(obj, Integer.parseInt(fieldValue));
						// System.out.println(obj);
						break;
					case "float":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), Float.TYPE);
						methodInt.invoke(obj, Float.parseFloat(fieldValue));
						// System.out.println(obj);
						break;

					case "double":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), Double.TYPE);
						methodInt.invoke(obj, Double.parseDouble(fieldValue));
						// System.out.println(obj);
						break;

					case "long":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), Long.TYPE);
						methodInt.invoke(obj,  Long.parseLong(fieldValue));
						// System.out.println(obj);
						break;
					case "short":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), Short.TYPE);
						methodInt.invoke(obj, Short.parseShort(fieldValue));
						// System.out.println(obj);
						break;
					case "string":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), java.lang.String.class);
						methodInt.invoke(obj,(fieldValue));
						// System.out.println(obj);
						break;
					case "char":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), Character.TYPE);
						methodInt.invoke(obj, (fieldValue).charAt(0));
						// System.out.println(obj);
						break;

					case "boolean":
						methodInt = cls.getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1), Boolean.TYPE);
						methodInt.invoke(obj, Boolean.parseBoolean(fieldValue));
						// System.out.println(obj);
						break;	
					}

				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		//System.out.println(obj);
		return (SerializableObject)obj;
	}
}