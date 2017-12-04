package com.mouchoapps.mouchoone.web.presentation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class HelloWorldPresentation {

    private Integer routeOrigin;

    private Integer routeDestination;

    private List<Integer> firstColor;

    private List<Integer> secondColor;

    private List<Integer> thirdColor;

    private Integer assigned;

    private Integer capacity;

}
