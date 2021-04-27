package src.main.java.sorting.objectsorting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class RapotPojo {
	BigDecimal nilai;
	String nama;
	LocalDate tanggalUjian;
	
	@Override
	public String toString() {
		return "tanggalUjian:".concat(this.tanggalUjian.toString())
				.concat(" nilai:").concat(this.nilai.toString())
				.concat(" nama:").concat(this.nama);
	}
}

class MyDefaultRapotComparator implements Comparator<RapotPojo> {
	@Override
	public int compare(RapotPojo obj1, RapotPojo obj2) {
		int comparingTanggalUjianResult = obj1.tanggalUjian.compareTo(obj2.tanggalUjian);
		boolean tanggalUjianSama = comparingTanggalUjianResult == 0;
		
		if (tanggalUjianSama) {
			int comparingNilaiResult = obj1.nilai.compareTo(obj2.nilai) * -1;
			boolean nilaiSama = comparingNilaiResult == 0;
			if (nilaiSama) {
				int comparingNama = obj1.nama.compareTo(obj2.nama);
				return comparingNama;
			}
			else {
				return comparingNilaiResult;
			}
		
		}
		else {
			return comparingTanggalUjianResult;
		}

	}
}

class SortingByComparatorClassDemo {
	public static void main(String[] args) {
		RapotPojo rapot1 = new RapotPojo();
		rapot1.nama = "moya";
		rapot1.nilai = new BigDecimal(100);
		rapot1.tanggalUjian = LocalDate.parse("2020-12-31");
		
		RapotPojo rapot2 = new RapotPojo();
		rapot2.nama = "baya";
		rapot2.nilai = new BigDecimal(95);
		rapot2.tanggalUjian = LocalDate.parse("2020-12-31");
		
		RapotPojo rapot3 = new RapotPojo();
		rapot3.nama = "ana";
		rapot3.nilai = new BigDecimal(100);
		rapot3.tanggalUjian = LocalDate.parse("2020-12-24");
		
		RapotPojo rapot4 = new RapotPojo();
		rapot4.nama = "ani";
		rapot4.nilai = new BigDecimal(100);
		rapot4.tanggalUjian = LocalDate.parse("2020-12-24");
		
		List<RapotPojo> pengumuman = new ArrayList<RapotPojo>();
		pengumuman.add(rapot1);
		pengumuman.add(rapot2);
		pengumuman.add(rapot3);
		pengumuman.add(rapot4);
		
		System.out.println("pengumuman:");
		pengumuman.forEach(rapot -> System.out.println(rapot.toString()));
		
		
		List<RapotPojo> pengumumanRapih = new ArrayList<RapotPojo>(pengumuman);
		Collections.sort(pengumumanRapih, new MyDefaultRapotComparator());
		
		System.out.println("pengumumanRapih:");
		pengumumanRapih.forEach(rapot -> System.out.println(rapot.toString()));
	}
}

