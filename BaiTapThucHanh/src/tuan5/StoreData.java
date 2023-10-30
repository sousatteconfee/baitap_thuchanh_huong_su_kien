package tuan5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StoreData {

	public static boolean saveFile(Object obj, String path) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			 e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Object loadFile(String path) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			Object obj = ois.readObject();
			ois.close();
			return obj;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static boolean saveFileText(NhanVienList list, String path) {
		try {			
			FileWriter fw = new FileWriter(path);
			fw.write("MaNV;HoNV;TenNV;Tuoi;GioiTinh;TienLuong");
			for (int i = 0; i < list.getSize(); i++) {
				NhanVien temp = list.getByIndex(i);
				fw.write("\n" +
			    		temp.getMaNV()
			    		+ ";" + temp.getTenNV()
			    		+ ";" + temp.getHoNV()
			    		+ ";" + temp.getTuoi()
			    		+ ";" + temp.getPhai()
			    		+ ";" + temp.getTienLuong()
			    );
			}
			fw.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static NhanVienList loadFileText(String path) {
		NhanVienList temp = new NhanVienList();
		FileReader fr = null;
		Scanner scn = null;
		try {
			fr = new FileReader(path);
			scn = new Scanner(fr);
			String line = "";
			line = scn.nextLine(); // Bỏ qua đoạn đầu (title) "MaNV;LastName;FirstName;Tuoi;GioiTinh;TienLuong"
			while (scn.hasNextLine()) {
				line = scn.nextLine();
				String[] data = line.split(";");
				temp.themNhanVien(new NhanVien(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4].equals("true"), Double.parseDouble(data[5])));
			}
		} catch (Exception e) {
			return null;
		}
		return temp;
		
	}
}
