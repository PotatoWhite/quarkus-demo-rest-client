package me.potato.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Country {
  private String         name;
  private String         alpha2Code;
  private String         capital;
  private List<Currency> currencies;

  @Getter
  @Setter
  public static class Currency {
    private String code;
    private String name;
    private String symbol;
  }

}
