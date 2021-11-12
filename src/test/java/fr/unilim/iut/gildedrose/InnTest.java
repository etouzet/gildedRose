package fr.unilim.iut.gildedrose;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InnTest {
  
	@Test
  public void should_list_items() {
	  assertThat(new Inn().getItems()).extracting("name").containsExactly("???");
  }
}
