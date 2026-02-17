package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output;


public record TokenOutputDTO(String token) {

    @Override
    public String toString() {
        return token;
    }
}
