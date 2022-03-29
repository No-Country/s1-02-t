package consultation.by.video.call.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionRequest {
    private String title;
    private String description;
    private String imageUrl;
}
