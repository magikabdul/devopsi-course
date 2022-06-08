package cloud.cholewa.photographs.adapters.rest;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PhotoDtoRequest {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String address;


    private String tags;

    @NotNull
    private String location;
}
