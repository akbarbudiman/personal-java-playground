package other.objectsorting;

import java.util.Comparator;

public class RapotComparator implements Comparator<Rapot> {

	@Override
	public int compare(Rapot obj1, Rapot obj2) {
		int comparingTanggalUjianResult = obj1.getTanggalUjian().compareTo(obj2.getTanggalUjian());
		boolean tanggalUjianSama = comparingTanggalUjianResult == 0;
		
		if (tanggalUjianSama) {
			int comparingNilaiResult = obj1.getNilai().compareTo(obj2.getNilai()) * -1;
			boolean nilaiSama = comparingNilaiResult == 0;
			if (nilaiSama) {
				int comparingNama = obj1.getNama().compareTo(obj2.getNama());
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
