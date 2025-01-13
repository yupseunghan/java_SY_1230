package Homwork.ex2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
	private int grade,semester,score;
	private String name;
}
