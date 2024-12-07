package tests.petStore.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetFull {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public static PetFull getPetData(){
        return PetFull
                .builder()
                .id(357)
                .category(new Category(1, "Dogs"))
                .name("Sharik")
                .photoUrls(Arrays.asList("example.com", "https://lh5.googleusercontent.com/PbUbeBc3dfS2ne0KrXJD6_4JFI6T_Pl4me1bwHF1r3vIrd664XlRAIQDW_dGfIl9TMAgDLhxEAaj5IsSRi6FhSmqRws5zmYiTstxnRLAmtY9wGswZzBoAan227yLceM4cVnYl7GE"))
                .tags(Arrays.asList(new Tag(1, "Black dog"), new Tag(2, "Kind dog")))
                .status("available")
                .build();
    }
}