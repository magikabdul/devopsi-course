package cloud.cholewa.photographs.adapters.rest;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommentCreateRequest {

    @NotNull
    private String body;
}
