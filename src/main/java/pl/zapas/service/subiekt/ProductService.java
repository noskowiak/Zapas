package pl.zapas.service.subiekt;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import pl.zapas.dtos.subiekt.MonthlySaleDto;
import pl.zapas.dtos.subiekt.ProductDto;
import pl.zapas.entity.subiekt.Product;
import pl.zapas.mapper.subiekt.ProductMapper;
import pl.zapas.repository.subiekt.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDto(
                        product.getName(),
                        product.getSymbol()))
                .collect(Collectors.toList());
    }

    public Product loadProductBySymbol(final String symbol) {
        return productRepository.findProductBySymbol(symbol);
    }

    public ProductDto[] retreiveProducts() {
        return WebClient
                .builder().exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(16 * 1024 * 1024))
                        .build()).build()
                .get()
                .uri("http://localhost:8080/products")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ProductDto[].class).block();
    }

    public ProductDto[] save() {
        ProductDto[] productDtos = retreiveProducts();
        for (ProductDto productDto : productDtos) {
            productRepository.save(productMapper.toEntity(productDto));
        }

        return productDtos;
    }

}
