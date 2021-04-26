package other.objectsorting;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rapot {

	private BigDecimal nilai;
	private String nama;
	private LocalDate tanggalUjian;
	
	@Override
	public String toString() {
		return "tanggalUjian:".concat(this.tanggalUjian.toString())
				.concat(" nilai:").concat(this.nilai.toString())
				.concat(" nama:").concat(this.nama);
	}
	
	public BigDecimal getNilai() {
		return nilai;
	}
	public void setNilai(BigDecimal nilai) {
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
