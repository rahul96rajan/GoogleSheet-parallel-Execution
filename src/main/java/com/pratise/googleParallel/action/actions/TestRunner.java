package com.pratise.googleParallel.action.actions;

import java.util.ArrayList;
import java.util.List;

import com.pratise.googleParallel.base.TestBase;
import com.pratise.googleParallel.utils.GoogleSheetReadAndWrite;

public class TestRunner extends TestBase {

	public static void main(String[] args) {
		initProp();
//		ArrayList<Object> rowDivisions = new ArrayList<Object>();
		GoogleSheetReadAndWrite sheetReadWriteToFile = new GoogleSheetReadAndWrite();
		List<List<Object>> values = sheetReadWriteToFile.getAllDataAsList();
		ArrayList<Object> rows = getColumnElem(values, 0);
		System.out.println(rows);
		int parallel_count = Integer.parseInt(prop.getProperty("parallel_flag"));
		int startIndex = 0, endIndex = 0, size = rows.size();
		int gap = size/parallel_count; endIndex = gap;
		int num = parallel_count-(size%parallel_count);

		if (parallel_count >= 1 && parallel_count <= rows.size()) {
			for (int i = 0; i < parallel_count; i++) {
				endIndex = startIndex + gap;
				
				if (i >=num) {
//					Thread(rows.subList(startIndex,rows.size()+1));
					System.out.println("Thread " + i + " : " + rows.subList(startIndex, endIndex+1));
					startIndex = endIndex+1;
//					endIndex = startIndex+gap;

				} else {
//					Thread(rows.subList(startIndex,endIndex));
					System.out.println("Thread " + i + " : " + rows.subList(startIndex, endIndex));
					startIndex = endIndex;
//					endIndex += gap;
				}
				
			}
		} else {
			System.out.println("Parallel count not in limit.");
		}
	}

	public static void printOnlyFName(List<List<Object>> values) {
		for (int i = 1; i < values.size(); i++) {
			System.out.println(values.get(i).get(0));
		}
	}

	public static ArrayList<Object> getColumnElem(List<List<Object>> values, int columnNumber) {
		ArrayList<Object> rowList = new ArrayList<Object>();
		for (int i = 1; i < values.size(); i++) {
			rowList.add(values.get(i).get(columnNumber));
//			System.out.println(values.get(i).get(0));
		}
		return rowList;

	}
}
