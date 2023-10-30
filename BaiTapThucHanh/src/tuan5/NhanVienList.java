package tuan5;

import java.util.ArrayList;

public class NhanVienList {
	private ArrayList<NhanVien> list;
	
	public NhanVienList() {
		this.list = new ArrayList<NhanVien>();
	}
	
	public NhanVienList(ArrayList<NhanVien> load) {
		super();
		this.list = load;
	}
	
	public boolean themNhanVien(NhanVien nv) {
		if(list.contains(nv)) //contains kiểm tra trùng mã
			return true;
		list.add(nv);
		return true;
	}
	
	public boolean xoaNhanVien(NhanVien x) {
		
		if(!list.contains(x))
			return false;
		return list.remove(x);
	}
	
	public NhanVienList timNhanVien(String x) {
		NhanVienList temp = new NhanVienList();
		int endPos = x.length();
		for (int i = 0; i < list.size(); i++) {
			if (x.equalsIgnoreCase(list.get(i).getMaNV().substring(0, endPos))){
				temp.themNhanVien(list.get(i));
			}
		}
		return temp;
	}
	
	//để truy xuất đối tượng NhanVien từ danh sách dựa trên chỉ mục (index) được cung cấp
	public NhanVien getByIndex(int i) {
		if (i < 0 || i > list.size() - 1)
			return null;
		return list.get(i);
	}
	
	public int getSize() {
		return list.size();
	}
	
	public void replaceID(NhanVien x) {
		list.set(list.indexOf(x), x);
	}
	
	public ArrayList<NhanVien> getList(){
		return list;
	}
	
	@Override
	public String toString() {
		return "Danh sách nhân viên[list =" + list +"]";
	}	
}
