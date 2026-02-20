package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.response;


public record TokenOutputDTO(String token) {

    @Override
    public String toString() {
        return token;
    }
}
