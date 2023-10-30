package tuan5;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{

	private String maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private String phai;
	private double tienLuong;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) throws Exception {
		if(maNV.isEmpty()) //isEmpty: kiểm tra đối tượng có rỗng không
			throw new Exception("Mã nhân viên bắt buộc nhập!");
		else
		this.maNV = maNV;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) throws Exception {
		if(hoNV.isEmpty() || hoNV.trim() == "")
			throw new Exception("Họ không được bỏ trống!");
		else
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) throws Exception {
		if(tenNV.isEmpty() || tenNV.trim() == "")
			throw new Exception("Tên không được bỏ trống!");
		else
		this.tenNV = tenNV;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) throws Exception {
		if (tuoi < 18 || tuoi > 65)
			throw new Exception("Độ tuổi không phù hợp để lao động!");
		else
		this.tuoi = tuoi;
	}
	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) throws Exception {
		if(tienLuong < 0)
			throw new Exception("Tiền lương không thể âm!");
		else
		this.tienLuong = tienLuong;
	}
	public NhanVien(String maNhanVien, String hoNhanVien, String tenNhanVien, int tuoi2, boolean gioi, double tien) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		this.phai = phai;
		this.tienLuong = tienLuong;
	}
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV2, String ho, String ten, boolean phai2, int tuoi2, double tienLuong2) {
		// TODO Auto-generated constructor stub
	}
	public Object[] getObjectNV() {
		Object[] obj = {getMaNV(), getHoNV(), getTenNV(), getPhai(), getTuoi(), getTienLuong()};
		return obj;
	}
 	
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return maNV + " ;" + hoNV + " ;" + tenNV + " ;" + phai +" ;" + tuoi + " ;" + tienLuong;
	}
}
	
	
	
	
	
	

