package kiemTraTK2;

import java.util.Objects;

public class SinhVien {
	private String id;
	private String hoten;
	private String lop;
	private String noisinh;
	private String monhoc;
	public SinhVien(String id, String hoten, String lop, String noisinh, String monhoc) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.lop = lop;
		this.noisinh = noisinh;
		this.monhoc = monhoc;
	}
	public SinhVien() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getNoisinh() {
		return noisinh;
	}
	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}
	public String getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
