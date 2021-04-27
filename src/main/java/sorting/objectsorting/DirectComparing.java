package src.main.java.sorting.objectsorting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Rapot {
	BigDecimal nilai;
	String nama;
	LocalDate tanggalUjian;
	
	@Override
	public String toString() {
		return "tanggalUjian:".concat(this.tanggalUjian.toString())
				.concat(" nilai:").concat(this.nilai.toString())
				.concat(" nama:").concat(this.nama);
	}
	
	BigDecimal getNilai() {
		return nilai;
	}
	
	String getNama() {
		return nama;
	}
	
	LocalDate getTanggalUjian() {
		return tanggalUjian;
	}
}

class SortingByDirectComparingDemo {
	public static void main(String[] args) {
		Rapot rapot1 = new Rapot();
		rapot1.nama = "moya";
		rapot1.nilai = new BigDecimal(100);
		rapot1.tanggalUjian = LocalDate.parse("2020-12-31");
		
		Rapot rapot2 = new Rapot();
		rapot2.nama = "baya";
		rapot2.nilai = new BigDecimal(95);
		rapot2.tanggalUjian = LocalDate.parse("2020-12-31");
		
		Rapot rapot3 = new Rapot();
		rapot3.nama = "ana";
		rapot3.nilai = new BigDecimal(100);
		rapot3.tanggalUjian = LocalDate.parse("2020-12-24");
		
		Rapot rapot4 = new Rapot();
		rapot4.nama = "ani";
		rapot4.nilai = new BigDecimal(100);
		rapot4.tanggalUjian = LocalDate.parse("2020-12-24");
		
		List<Rapot> pengumuman = new ArrayList<Rapot>();
		pengumuman.add(rapot1);
		pengumuman.add(rapot2);
		pengumuman.add(rapot3);
		pengumuman.add(rapot4);
		
		System.out.println("pengumuman:");
		pengumuman.forEach(rapot -> System.out.println(rapot.toString()));
		
		
		List<Rapot> pengumumanRapih = new ArrayList<Rapot>(pengumuman);
		pengumumanRapih.sort(
				Comparator.comparing(Rapot::getTanggalUjian).reversed()
				.thenComparing(Rapot::getNilai).reversed()
				.thenComparing(Rapot::getNama));
		
		System.out.println("pengumumanRapih:");
		pengumumanRapih.forEach(rapot -> System.out.println(rapot.toString()));
	}
}