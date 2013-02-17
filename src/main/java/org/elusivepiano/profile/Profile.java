package org.elusivepiano.profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Profile {
	static Logger log = Logger.getLogger(Profile.class.getName());

	private static File applicationFolder;
	public static File profilesFolder;
	static {
		applicationFolder = new File(System.getProperty("user.home")
				+ System.getProperty("file.separator") + ".elusivepiano");
		if (!applicationFolder.exists()) {
			boolean created = applicationFolder.mkdir();
			if (!created) {
				log.error("Could not create application folder");
			}
		}
		profilesFolder = new File(applicationFolder, "profiles");
		if (!profilesFolder.exists()) {
			boolean created = profilesFolder.mkdir();
			if (!created) {
				log.error("Could not create profiles folder");
			}
		}
	}

	public static Profile loadOrCreate(String name) {
		File file = new File(profilesFolder, name);
		if( !file.exists() ){ //TODO extract this logic in a IOUtils
			try {
				boolean created = new File(profilesFolder, name).createNewFile();
				if( !created ){
					log.error("Could not create profile "+name+", File.createNewFile() return false");
					return null;
				}
			} catch (IOException e) {
				log.error("Could not create profile "+name, e);
				return null;
			}
		}
		try {
			InputStream input = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(input);
			return new Profile(name, properties);
		} catch (IOException e) {
			log.error("Could not load profile", e);
			return null;
		}
	}

	private String name;
	private Properties properties;

	public Profile(String name, Properties properties) {
		super();
		this.name = name;
		this.properties = properties;
	}

	public String getName() {
		return name;
	}

	public void put(String key, String value) {
		properties.put(key, value);
		try {
			properties.store(new FileOutputStream(new File(profilesFolder, name)), name);
		} catch (IOException e) {
			log.error("Could not store profile " + name, e);
		}
	}

	public String get(String key) {
		return properties.getProperty(key);
	}

	public void append(String key, String value) {
		String existingValue = properties.getProperty(key);
		String prepend = existingValue==null ? "" : existingValue+" ";
		put(key, prepend+value);
	}

	public List<Integer> getInts(String key) {
		List<Integer> ints = new ArrayList<Integer>();
		String value = properties.getProperty(key);
		if( value == null ) return ints;
		
		Scanner scanner = new Scanner(properties.getProperty(key));
		while( scanner.hasNext() ){
			ints.add( scanner.nextInt() );
		}
		return ints;
	}
	
}
