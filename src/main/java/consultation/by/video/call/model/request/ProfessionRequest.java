package consultation.by.video.call.model.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionRequest {

    @NotEmpty(message = "Debe ingresar un Titulo.")
    private String title;

    private String description;

    private String imageUrl;
}
