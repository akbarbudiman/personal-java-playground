package other.objectsorting;

import java.time.LocalDate;

public class Rapot {

	private Double nilai;
	private String nama;
	private LocalDate tanggalUjian;
	
	@Override
	public String toString() {
		return "tanggalUjian:".concat(this.tanggalUjian.toString())
				.concat(" nilai:").concat(this.nilai.toString())
				.concat(" nama:").concat(this.nama);
	}
	
	public Double getNilai() {
		return nilai;
	}
	public void setNilai(Double nilai) {
		this.nilai = nilai;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public LocalDate getTanggalUjian() {
		return tanggalUjian;
	}
	public void setTanggalUjian(LocalDate tanggalUjian) {
		this.tanggalUjian = tanggalUjian;
	}
	
}
