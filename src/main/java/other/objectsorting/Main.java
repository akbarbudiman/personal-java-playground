package other.objectsorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Rapot rapot1 = new Rapot();
		rapot1.setNama("moya");
		rapot1.setNilai((double) 100);
		rapot1.setTanggalUjian(LocalDate.parse("2020-12-31"));
		
		Rapot rapot2 = new Rapot();
		rapot2.setNama("baya");
		rapot2.setNilai((double) 95);
		rapot2.setTanggalUjian(LocalDate.parse("2020-12-31"));
		
		Rapot rapot3 = new Rapot();
		rapot3.setNama("uyung");
		rapot3.setNilai((double) 100);
		rapot3.setTanggalUjian(LocalDate.parse("2020-12-24"));
		
		Rapot rapot4 = new Rapot();
		rapot4.setNama("eyeng");
		rapot4.setNilai((double) 100);
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
		List<Rapot> pengumumanRapih1 = new ArrayList<Rapot>();
		pengumumanRapih1.addAll(pengumuman);
		Collections.sort(pengumumanRapih1, new RapotComparator());
		
		System.out.println("pengumumanRapih1:");
		pengumumanRapih1.forEach(rapot -> System.out.println(rapot.toString()));
		
		
//		CARA 2
		List<Rapot> pengumumanRapih2 = new ArrayList<Rapot>();
		pengumumanRapih2.addAll(pengumuman);
		pengumumanRapih2.sort(
				Comparator.comparing(Rapot::getTanggalUjian).reversed()
				.thenComparing(Rapot::getNilai).reversed()
				.thenComparing(Rapot::getNama));
		
		System.out.println("pengumumanRapih2:");
		pengumumanRapih2.forEach(rapot -> System.out.println(rapot.toString()));
		
		
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
		System.out.println("pengumumanRapotComparable:");
		pengumumanRapotComparable.forEach(rapot -> System.out.println(rapot.toString()));
	}
}
