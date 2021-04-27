package src.main.java.sorting.objectsorting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class RapotCompareable extends Rapot implements Comparable<RapotCompareable> {

	public RapotCompareable(Rapot rapot) {
		this.nama = rapot.nama;
		this.nilai = rapot.nilai;
		this.tanggalUjian = rapot.tanggalUjian;
	}
	
	@Override
	public int compareTo(RapotCompareable o) {
		return Comparator.comparing(RapotCompareable::getTanggalUjian).reversed()
				.thenComparing(RapotCompareable::getNilai).reversed()
				.thenComparing(RapotCompareable::getNama)
				.compare(this, o);
	}

}

class SortingByImplementsCompareableDemo {
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
		
		List<RapotCompareable> pengumuman = new ArrayList<RapotCompareable>();
		pengumuman.add(new RapotCompareable(rapot1));
		pengumuman.add(new RapotCompareable(rapot2));
		pengumuman.add(new RapotCompareable(rapot3));
		pengumuman.add(new RapotCompareable(rapot4));
		
		System.out.println("pengumuman:");
		pengumuman.forEach(rapot -> System.out.println(rapot.toString()));
		
		
		List<RapotCompareable> pengumumanRapih = new ArrayList<RapotCompareable>(pengumuman);
		Collections.sort(pengumumanRapih);
		
		System.out.println("pengumumanRapih:");
		pengumumanRapih.forEach(rapot -> System.out.println(rapot.toString()));
	}
}