package other.objectsorting;

import java.util.Comparator;

public class RapotCompareable extends Rapot implements Comparable<RapotCompareable> {

	public RapotCompareable(Rapot rapot) {
		setNama(rapot.getNama());
		setNilai(rapot.getNilai());
		setTanggalUjian(rapot.getTanggalUjian());
	}
	
	@Override
	public int compareTo(RapotCompareable o) {
		return Comparator.comparing(RapotCompareable::getTanggalUjian).reversed()
				.thenComparing(RapotCompareable::getNilai).reversed()
				.thenComparing(RapotCompareable::getNama)
				.compare(this, o);
	}

}
