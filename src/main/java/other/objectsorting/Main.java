package other.objectsorting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Rapot rapot1 = new Rapot();
		rapot1.setNama("moya");
		rapot1.setNilai(new BigDecimal(100));
		rapot1.setTanggalUjian(LocalDate.parse("2020-12-31"));
		
		Rapot rapot2 = new Rapot();
		rapot2.setNama("baya");
		rapot2.setNilai(new BigDecimal(95));
		rapot2.setTanggalUjian(LocalDate.parse("2020-12-31"));
		
		Rapot rapot3 = new Rapot();
		rapot3.setNama("uyung");
		rapot3.setNilai(new BigDecimal(100));
		rapot3.setTanggalUjian(LocalDate.parse("2020-12-24"));
		
		Rapot rapot4 = new Rapot();
		rapot4.setNama("eyeng");
		rapot4.setNilai(new BigDecimal(100));
		rapot4.setTanggalUjian(LocalDate.parse("2020-12-24"));
		
//		Sebelum diurutkan
		List<Rapot> pengumuman = new ArrayList<Rapot>();
		pengumuman.add(rapot1);
		pengumuman.add(rapot2);
		pengumuman.add(rapot3);
		pengumuman.add(rapot4);
		
		System.out.println("pengumuman:");
		pengumuman.forEach(rapot -> System.out.println(rapot.toString()));
		
		
//		CARA 1
		List<Rapot> pengumumanRapih1 = new ArrayList<Rapot>(pengumuman);
		Collections.sort(pengumumanRapih1, new RapotComparator());
		
		System.out.println("\npengumumanRapih1:");
		pengumumanRapih1.forEach(rapot -> System.out.println(rapot.toString()));
		
		
//		CARA 2
		List<Rapot> pengumumanRapih2 = new ArrayList<Rapot>(pengumuman);
		pengumumanRapih2.sort(
				Comparator.comparing(Rapot::getTanggalUjian).reversed()
				.thenComparing(Rapot::getNilai).reversed()
				.thenComparing(Rapot::getNama));
		
		System.out.println("\npengumumanRapih2:");
		pengumumanRapih2.forEach(rapot -> System.out.println(rapot.toString()));
		
		System.out.println(pengumumanRapih2.get(0) == pengumuman.get(3));
		System.out.println(pengumumanRapih2.get(1) == pengumuman.get(2));
		System.out.println(pengumumanRapih2.get(2) == pengumuman.get(0));
		System.out.println(pengumumanRapih2.get(3) == pengumuman.get(1));
		
//		CARA 3 (implements Comparable<>)
		RapotCompareable rapotComparable1 = new RapotCompareable(rapot1);
		RapotCompareable rapotComparable2 = new RapotCompareable(rapot2);
		RapotCompareable rapotComparable3 = new RapotCompareable(rapot3);
		RapotCompareable rapotComparable4 = new RapotCompareable(rapot4);
		
		List<RapotCompareable> pengumumanRapotComparable = new ArrayList<RapotCompareable>();
		pengumumanRapotComparable.add(rapotComparable1);
		pengumumanRapotComparable.add(rapotComparable2);
		pengumumanRapotComparable.add(rapotComparable3);
		pengumumanRapotComparable.add(rapotComparable4);
		Collections.sort(pengumumanRapotComparable);
		System.out.println("\npengumumanRapotComparable:");
		pengumumanRapotComparable.forEach(rapot -> System.out.println(rapot.toString()));
	}
}
