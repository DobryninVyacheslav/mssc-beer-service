package guru.springframework.msscbeerservice.services.order;

import guru.sfg.brewery.model.BeerOrderDto;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@RequiredArgsConstructor
public class BeerOrderValidator {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto dto) {
        AtomicInteger beersNotFound = new AtomicInteger();

        dto.getBeerOrderLines().forEach(orderLine -> {
            if (beerRepository.findByUpc(orderLine.getUpc()).isEmpty()) {
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }

}
