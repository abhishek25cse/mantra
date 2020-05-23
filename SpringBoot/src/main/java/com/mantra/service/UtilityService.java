package com.mantra.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {

	public void stepOne(String src, String target) throws IOException {
		HashMap<String, List<String>> yearMonthMap = new HashMap<String, List<String>>();

		File dir = new File(src);

		String year = null;
		String month = null;
		if (dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				StringBuffer targetPath = new StringBuffer(target);
				String fName = f.getName();
				year = fName.substring(fName.indexOf("-") + 1, fName.indexOf("-") + 5);
				month = fName.substring(fName.indexOf("-") + 5, fName.indexOf("-") + 7);
				if (yearMonthMap.containsKey(year)) {
					if (!yearMonthMap.get(year).contains(month)) {
						yearMonthMap.get(year).add(month);
					}
				} else {
					yearMonthMap.put(year, new ArrayList<String>());
				}

				targetPath.append("/");
				targetPath.append(year);
				createDir(targetPath.toString());
				targetPath.append("/");
				String mon = null;
				try {
					mon = Months.valueOf("_" + month).value;
				} catch (Exception ex) {
					mon = "MISC";
				}

				targetPath.append(mon);
				createDir(targetPath.toString());
				targetPath.append("/");
				targetPath.append(f.getName());
				File trgtPath = new File(targetPath.toString());
				if (!trgtPath.exists())
					Files.move(f.toPath(), trgtPath.toPath());

			}

		}

	}

	private void createDir(String path) throws IOException {
		File fN = new File(path);
		if (!fN.exists()) {
			fN.mkdirs();
		}

	}

}

enum Months {
	_01("JANUARY"), _02("FEBRUARY"), _03("MARCH"), _04("APRIL"), _05("MAY"), _06("JUNE"), _07("JULY"), _08(
			"AUGUST"), _09("SEPTEMBER"), _10("OCTOBER"), _11("NOVEMBER"), _12("DECEMBER");
	String value;

	Months(String n) {
		value = n;
	}
}
