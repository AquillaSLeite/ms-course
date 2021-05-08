package leite.aquilla.hrpayroll.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Payment {

	private String name;
	private Double dailyIncome;
	private Integer days;

	public Double getTotal() {
		return this.days * this.dailyIncome;
	}
}
