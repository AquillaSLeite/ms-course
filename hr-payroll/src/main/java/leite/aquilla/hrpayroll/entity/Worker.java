package leite.aquilla.hrpayroll.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Worker {
	private Long id;
	private String name;
	private Double dailyIncome;
}
