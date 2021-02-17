package guru.springframework.msscbeerservice.events;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -8063133939587132163L;

    private final BeerDto beerDto;

}
