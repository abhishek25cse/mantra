package com.mantra.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {

	private static final String FILEPATH_DELIMETER = "/";
	private static final String DATE_FORMAT = "yyyy-MMM";
	private static final String DATE_FORMAT_1 = "yyyyMMdd";
	private static final String DASH= "-";
	private static final String MISC = "MISC";
	private static final String UNDER_SCORE= "_";
	
	public void stepOneByProperties(String src, String target) throws Exception {
		HashMap<String, List<String>> yearMonthMap = new HashMap<String, List<String>>();
		File srcDir = new File(src);
		if (srcDir.isDirectory()) {
			iterateOverFiles(srcDir, target, yearMonthMap);
		} else {
			System.out.println("Exception stepOne  No source directory found");
			throw new Exception("No source directory found ");
		}
	}
	
	public void stepOneByName(String src, String target) throws Exception {
		HashMap<String, List<String>> yearMonthMap = new HashMap<String, List<String>>();
		File srcDir = new File(src);
		if (srcDir.isDirectory()) {
			iterateOverFilesSeggregateByFileName(srcDir, target, yearMonthMap);
		} else {
			System.out.println("Exception stepOne  No source directory found");
			throw new Exception("No source directory found ");
		}
	}
	
// segregate via the date in the file properties. But this changes as the file is copied from one sysytem to another
	private void iterateOverFiles(File srcDir, String target, HashMap<String, List<String>> yearMonthMap)
			throws IOException {
		String year = null;
		String month = null;
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		for (File f : srcDir.listFiles()) {
			if (f.isDirectory()) {
				iterateOverFiles(f, target, yearMonthMap);
			} else {
				
				StringBuffer targetPath = new StringBuffer(target);
				String fileModDdate = df.format(Files.getLastModifiedTime(Paths.get(f.getPath())).toMillis());
				year = fileModDdate.substring(0, fileModDdate.indexOf(DASH));
				month = fileModDdate.substring(fileModDdate.lastIndexOf(DASH)+1, fileModDdate.length());
				if (yearMonthMap.containsKey(year)) {
					if (!yearMonthMap.get(year).contains(month)) {
						yearMonthMap.get(year).add(month);
					}
				} else {
					yearMonthMap.put(year, new ArrayList<String>());
				}

				targetPath.append(FILEPATH_DELIMETER);
				targetPath.append(year);
				createDir(targetPath.toString());
				targetPath.append(FILEPATH_DELIMETER);
				targetPath.append(month);
				createDir(targetPath.toString());
				targetPath.append(FILEPATH_DELIMETER);
				targetPath.append(f.getName());
				File trgtPath = new File(targetPath.toString());
				if (!trgtPath.exists())
					Files.copy(f.toPath(), trgtPath.toPath());

			}
		}
	}

	private void createDir(String path) throws IOException {
		File fN = new File(path);
		if (!fN.exists()) {
			fN.mkdirs();
		}
	}
	
	private HashSet<String> vedioFormat = new HashSet<String>();
	private HashSet<String> imageFormat = new HashSet<String>();
	
	
	// Segregate file by file name 
	// handing video image format separatly
		private void iterateOverFilesSeggregateByFileName(File srcDir, String target, HashMap<String, List<String>> yearMonthMap)
				throws IOException {
			String year = null;
			String month = null;
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			for (File f : srcDir.listFiles()) {
				if (f.isDirectory()) {
					iterateOverFilesSeggregateByFileName(f, target, yearMonthMap);
				} else {
					StringBuffer targetPath = new StringBuffer(target);
					String[] fileExt = f.getName().split(".");
					/*if(fileExt.length>1 && fileExt[1].contains(s))*/
					String[] fileName = f.getName().split(UNDER_SCORE);
					String date = null;
					String dayOfPic = null;
					String monthFolder  = null;
					if(fileName.length>1) {
						date = fileName[1].substring(0, 8);
						//dayOfPic = df.format(date);
					} else {
						date = MISC;
					}
					
					
				/*	StringBuffer targetPath = new StringBuffer(target);
					String fileModDdate = df.format(Files.getLastModifiedTime(Paths.get(f.getPath())).toMillis());
					year = fileModDdate.substring(0, fileModDdate.indexOf(DASH));
					month = fileModDdate.substring(fileModDdate.lastIndexOf(DASH)+1, fileModDdate.length());*/
					if(date.equals(MISC)) {
						year =  MISC;
						monthFolder =  MISC;
					}
					if(date.length()==8) {
						year = date.substring(0, 4);
						month = date.substring(4, 6);
						monthFolder =  Months.valueOf(UNDER_SCORE+month).value;
					} else {
						year =  MISC;
						monthFolder =  MISC;
					}
				
				/*	
					if (yearMonthMap.containsKey(year)) {
						if (!yearMonthMap.get(year).contains(DASH+month)) {
							yearMonthMap.get(year).add(month);
						}
					} else {
						new ArrayList<String>();
						yearMonthMap.put(year, new ArrayList<String>());
					}*/

					targetPath.append(FILEPATH_DELIMETER);
					targetPath.append(year);
					createDir(targetPath.toString());
					targetPath.append(FILEPATH_DELIMETER);
					targetPath.append(monthFolder);
					createDir(targetPath.toString());
					targetPath.append(FILEPATH_DELIMETER);
					targetPath.append(f.getName());
					File trgtPath = new File(targetPath.toString());
					while (trgtPath.exists()) {
						String folderPath = targetPath
								.substring(0, targetPath.lastIndexOf(FILEPATH_DELIMETER));
						String newFfileName = FILEPATH_DELIMETER+"DUPLICATE_"+Math.random()+f.getName();
						trgtPath = new File(folderPath+newFfileName);
					} 
					Files.copy(f.toPath(), trgtPath.toPath());
				}
			}
		}
		
		
		
		public static void main(String[] a) {
			String mon =  Months.valueOf("_01").value;
			System.out.println(mon); // JANUARY
		}
}

// The below enum is now not used. Kept it just for reference
enum Months {
	_01("JANUARY"), _02("FEBRUARY"), _03("MARCH"), _04("APRIL"), _05("MAY"), _06("JUNE"), _07("JULY"), _08(
			"AUGUST"), _09("SEPTEMBER"), _10("OCTOBER"), _11("NOVEMBER"), _12("DECEMBER");
	String value;

	Months(String n) {
		value = n;
	}
	
}
