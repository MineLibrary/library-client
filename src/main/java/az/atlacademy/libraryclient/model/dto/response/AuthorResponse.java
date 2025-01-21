package az.atlacademy.libraryclient.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse 
{
    private long id;
    private String firstName; 
    private String lastName;
}
