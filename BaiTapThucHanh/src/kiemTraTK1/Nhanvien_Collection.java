package kiemTraTK1;

import java.util.ArrayList;

public class Nhanvien_Collection {
	private ArrayList<NhanVien> dsnv;
	public Nhanvien_Collection() {
		dsnv=new ArrayList<>();
	}
	public boolean Themnhanvien(NhanVien nv) {
		if(dsnv.contains(nv)) {
			return false;
		}
		dsnv.add(nv);
		
		return true;
	}
	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}
	public void setDsnv(ArrayList<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}
	
}
