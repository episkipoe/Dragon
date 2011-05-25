package com.episkipoe.dragon.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import android.os.Environment;

public class FileUtils {
	
	static public File getFile(String name) {
		File root = Environment.getExternalStoragePublicDirectory("dragon1.0"); 
		return new File(root, name);
	}
	
	static public void writeToFile(File fileName, List<Serializable> objects) throws Exception {
		fileName.getParentFile().mkdirs();
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objects);
		} finally {
			if(oos!=null) oos.close();
		} 
	}
	static public void writeToFile(File fileName, Serializable object) throws Exception {
		fileName.getParentFile().mkdirs();
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
		} finally {
			if(oos!=null) oos.close();
		} 
	}
	
	public static <T>Object readFromFile(File fileName) throws Exception {
		if(!fileName.exists()) {
			System.out.println("read from failed, file does not exist:" + fileName);
			return null;
		}
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		fis = new FileInputStream(fileName);
		ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		T readObjects = (T) ois.readObject();
		if(ois!=null) ois.close();
		return readObjects;
	}

}
