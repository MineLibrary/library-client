package az.atlacademy.libraryclient.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookImageResponse 
{
    private byte[] imageData; 
    private String fileKey;     
}
