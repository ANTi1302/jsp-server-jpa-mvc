package iuh.src.main.model;

public class LopHoc {

	private int maLop;
	private String tenLop;
	private String soPhong;
	private int soTiet;
	public int getMaLop() {
		return maLop;
	}
	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public String getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}
	public int getSoTiet() {
		return soTiet;
	}
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
	public LopHoc(int maLop, String tenLop, String soPhong, int soTiet) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.soPhong = soPhong;
		this.soTiet = soTiet;
	}
	
	public LopHoc(String tenLop, String soPhong, int soTiet) {
		super();
		this.tenLop = tenLop;
		this.soPhong = soPhong;
		this.soTiet = soTiet;
	}
	public LopHoc() {
		super();
	}
	public LopHoc(int maLop) {
		super();
		this.maLop = maLop;
	}
	@Override
	public String toString() {
		return "Class [maLop=" + maLop + ", tenLop=" + tenLop + ", soPhong=" + soPhong + ", soTiet=" + soTiet + "]";
	}
	
	
}
