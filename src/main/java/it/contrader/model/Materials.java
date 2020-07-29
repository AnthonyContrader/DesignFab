package it.contrader.model;

import static org.mockito.Mockito.validateMockitoUsage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Materials {

	public enum Materialtype {

		GENERIC, GLASS, PAPER, PLASTIC, INDIFFERENZIATA;

//		private static Map<String, Materialtype> materialMap = new HashMap<String, Materialtype>(5);
//
//		static {
//			materialMap.put("GENERIC", GENERIC);
//			materialMap.put("GLASS", GLASS);
//			materialMap.put("PAPER", PAPER);
//			materialMap.put("PLASTIC", PLASTIC);
//			materialMap.put("INDIFFERENZIATA", INDIFFERENZIATA);
//
//		}
//
//		@JsonCreator
//		public static Materialtype forValue(String value) {
//			return materialMap.get(value.toLowerCase());
//		}
//
//		@JsonValue
//		public String toValue() {
//			for (Entry<String, Materialtype> entry : materialMap.entrySet()) {
//				if (entry.getValue() == this)
//					return entry.getKey();
//			}
//
//			return null; // or fail
//		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMaterial;

	@Column(unique = true)
	private String materialName;

	private Double materialsQuantity;

	private Materialtype materialType;

}
