package com.digi.xbee.api.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogRecord {

	static BufferedWriter bufferedWriter;

	public LogRecord() {

		File file = new File("LogRecord.txt");

		try {
			FileWriter fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void insertLog(String logEntry) {
		try {
			bufferedWriter.append(logEntry);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			// bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
